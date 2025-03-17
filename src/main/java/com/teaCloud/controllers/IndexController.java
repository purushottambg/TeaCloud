package com.teaCloud.controllers;

import com.teaCloud.dtos.LogInDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/")
public class IndexController {

    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("loginDTO", new LogInDTO());
        logger.info("Redirecting the user to the Index Page: ");
        return "index";
    }

    @GetMapping("index")
    public String indexPage(Model model){
        model.addAttribute("loginDTO", new LogInDTO());
        logger.info("Redirecting the user to the /Index Page: ");
        return "index";
    }

}