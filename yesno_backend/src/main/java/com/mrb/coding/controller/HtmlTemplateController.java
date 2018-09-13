package com.mrb.coding.controller;

import com.mrb.coding.model.domain.Snippet;
import com.mrb.coding.service.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rsm095 on 01/09/2018.
 */
@RestController
@RequestMapping(path = "/html", produces = MediaType.TEXT_HTML_VALUE)
public class HtmlTemplateController {

    @Autowired
    private SnippetService snippetService;

    @GetMapping("/yesno/{snippetId}")
    public ResponseEntity getYesNoHtmlWidget(@PathVariable String snippetId) {
        Snippet selectedSnippet = snippetService.selectById(snippetId);
        String snippetHtml = snippetService.getHtmlInsideWidget(selectedSnippet);
        return ResponseEntity.ok(snippetHtml);
    }
}
