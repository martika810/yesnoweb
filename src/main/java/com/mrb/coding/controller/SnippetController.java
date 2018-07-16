package com.mrb.coding.controller;

import com.mrb.coding.model.domain.City;
import com.mrb.coding.model.domain.Snippet;
import com.mrb.coding.service.CityService;
import com.mrb.coding.service.SnippetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get/{id}")
    public ResponseEntity<Snippet> getById(@PathVariable String id) {
        Snippet snippet = snippetService.selectByPk(id);
        return ResponseEntity.ok(snippet);
    }

    @GetMapping("/list/{ids}")
    public ResponseEntity<List<Snippet>> getByIds(@PathVariable List<String> ids) {
        List<Snippet> list = snippetService.selectByPks(ids);
        return ResponseEntity.ok(list);
    }

}