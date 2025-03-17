package com.teaCloud.controllers;

import com.teaCloud.dtos.LogInDTO;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/")

public class LogInController {
    private static final Logger logger = LoggerFactory.getLogger(LogInController.class);

    @PostMapping("pages/validate-login")
    public String login(@ModelAttribute LogInDTO logInDTO){
        logger.trace("Received details are userID {} password {}", logInDTO.getMemberID(), logInDTO.getPassword() );
        return "pages/sign-up";
    }
}
