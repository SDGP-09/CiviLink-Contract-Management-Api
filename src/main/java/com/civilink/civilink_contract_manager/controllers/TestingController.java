package com.civilink.civilink_contract_manager.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestingController {

    @GetMapping
    public String testMethodToApi(){
        System.out.println("testMethodToApi");
        return "Hello World!";
    }
}
