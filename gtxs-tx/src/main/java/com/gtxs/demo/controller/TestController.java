package com.gtxs.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("zhj")
    public String zhj(){
        return "zhj";
    }
}
