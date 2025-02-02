package com.teaCloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class SignUpController {


    @GetMapping("pages/sign-up")
    public String register(){
        return "/pages/sign-up";
    }
}
