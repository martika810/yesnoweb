package com.mrb.coding.controller;

import com.mrb.coding.model.domain.Group;
import com.mrb.coding.model.domain.HtmlSnippet;
import com.mrb.coding.model.domain.Snippet;
import com.mrb.coding.model.domain.Vote;
import com.mrb.coding.service.GroupService;
import com.mrb.coding.service.SnippetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping(path = "/config", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class ConfigController {

    //@Value( "${host}" )
    private String host;

    @GetMapping("/config")
    public ResponseEntity<String> getHost() {
        return ResponseEntity.ok(host);
    }

}