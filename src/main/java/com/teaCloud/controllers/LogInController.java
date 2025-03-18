package com.teaCloud.controllers;

import com.teaCloud.dtos.LogInDTO;
import com.teaCloud.entity.UserEntity;
import com.teaCloud.repos.UserRepository;
import com.teaCloud.service.AuthenticationService;
import com.teaCloud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class LogInController {

    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(LogInController.class);

    @PostMapping("pages/validate-login")
    public String login(@ModelAttribute LogInDTO logInDTO, Model model){
        logger.trace("Received details are userID {} password {}", logInDTO.getMemberID(), logInDTO.getPassword());
        logger.info("Received users exist in DB: {}", userService.existsById(logInDTO.getMemberID()));
        if(userService.existsById(logInDTO.getMemberID())){
            logger.info("We are under log in controller");
            String Token = authenticationService.login(logInDTO.getMemberID().toString(),logInDTO.password);
            logger.info("Token generated in login Controller is: {}", Token);

            return   "pages/student-home";
        }else {
            model.addAttribute("Failed to authenticate", "failed");
            logger.info("Something went wrong");
            return  "pages/student-home";
        }
    }
}
