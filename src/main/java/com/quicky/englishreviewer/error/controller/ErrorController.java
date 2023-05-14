package com.quicky.englishreviewer.error.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController {
    @GetMapping("?continue")
    public String error() {
        return "error?";
    }
}
