package com.teaCloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LogInController {

    @GetMapping("pages/validate-login")
    public String login(){

        return "pages/sign-up";
    }
}
