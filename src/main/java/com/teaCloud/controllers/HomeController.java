package com.teaCloud.controllers;

import com.teaCloud.dtos.LogInDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/")
public class HomeController {

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("loginDTO", new LogInDTO());
        return "index";
    }

    @GetMapping("index")
    public String indexPage(Model model){
        model.addAttribute("loginDTO", new LogInDTO());
        return "index";
    }

}