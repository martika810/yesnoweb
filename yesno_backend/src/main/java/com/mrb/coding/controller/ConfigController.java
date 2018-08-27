package com.mrb.coding.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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