package com.mrb.coding.controller;

import com.mrb.coding.model.domain.Group;
import com.mrb.coding.model.domain.HtmlSnippet;
import com.mrb.coding.model.domain.Snippet;
import com.mrb.coding.model.domain.Vote;
import com.mrb.coding.service.GroupService;
import com.mrb.coding.service.SnippetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

/**
 * CityController
 *
 * @author trang
 */
@RestController
@RequestMapping(path = "/snippet", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class SnippetController {

    @Autowired
    private SnippetService snippetService;

    @Autowired
    private GroupService groupService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Snippet> getById(@PathVariable String id) {
        Snippet snippet = snippetService.selectByPk(id);
        return ResponseEntity.ok(snippet);
    }

    @GetMapping("/listall")
    public ResponseEntity<List<Snippet>> getAll() {
        List<Snippet> list = snippetService.selectAllOrderByCreated();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/vote/{snippetId}")
    public ResponseEntity addVote(@PathVariable String snippetId,
                                              @RequestBody Vote vote){
        Snippet snippet = snippetService.selectByPk(snippetId);
        Snippet updatedSnippet = vote(snippet,vote);
        snippetService.update(updatedSnippet);
        return ResponseEntity.accepted().build();

    }

    @DeleteMapping("/{snippetId}")
    public ResponseEntity deleteSnippet(@PathVariable String snippetId){
        Snippet snippet = snippetService.selectByPk(snippetId);
        snippetService.delete(snippet);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/create")
    public ResponseEntity createSnippet(@RequestBody Snippet snippet){
        snippet.setId(UUID.randomUUID().toString().substring(0,15));
        snippetService.insert(snippet);
        return ResponseEntity.created(URI.create("")).build();
    }

    @GetMapping("/html/{snippetId}")
    public ResponseEntity<HtmlSnippet> getHtmlSnippet(@PathVariable String snippetId){
        HtmlSnippet html=new HtmlSnippet(snippetService.getHtmlSnippet(snippetId));
        return ResponseEntity.ok(html);
    }

    @GetMapping("/group/listall")
    public ResponseEntity<List<Group>> getGroups(){
        List<Group> groups=groupService.selectAllOrderByCreated();
        return ResponseEntity.ok(groups);
    }

    private Snippet vote(Snippet snippet, Vote vote){
        if(Vote.YES.equals(vote)){
            int totalVote = snippet.getYesAnswers()+1;
            snippet.setYesAnswers(totalVote);
            return Snippet.of(snippet);
        }
        if(Vote.NO.equals(vote)){
            int totalVote = snippet.getNoAnswers()+1;
            snippet.setNoAnswers(totalVote);
            return Snippet.of(snippet);
        }
        int totalVote = snippet.getNeutralAnswers()+1;
        snippet.setNeutralAnswers(totalVote);
        return Snippet.of(snippet);
    }
}