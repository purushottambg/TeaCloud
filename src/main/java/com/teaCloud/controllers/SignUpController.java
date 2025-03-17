package com.teaCloud.controllers;

import com.teaCloud.dtos.LogInDTO;
import com.teaCloud.dtos.SignUpDTO;
import com.teaCloud.entity.UserEntity;
import com.teaCloud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class SignUpController {

    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(SignUpController.class);

    @GetMapping("pages/sign-up")
    public String register(Model model){
        model.addAttribute("signup",new SignUpDTO());
        logger.info("getting the signup DTO ready for the new User!");
        return "/pages/sign-up";
    }

    @PostMapping("pages/save-request")
    public String signup(Model model, @ModelAttribute("signup") SignUpDTO signUpDTO){
        UserEntity savedEntity = userService.saveUser(signUpDTO);
        logger.info("Here are the new Users received details: ");
        logger.trace("Name : {}",signUpDTO.getName());
        logger.trace("Age: {}",signUpDTO.getAge());
        logger.trace("E-mail: {}",signUpDTO.getEmail());
        logger.trace("Department: {}",signUpDTO.getDepartment());
        logger.trace("Password: {}",signUpDTO.getPassword());
        if(savedEntity!=null){
            model.addAttribute("loginDTO", new LogInDTO());
            model.addAttribute("True", "signedUp");
            model.addAttribute("your id is "+savedEntity.getMemberID(), "success");
        }else {
            model.addAttribute("failed", "failed");
        }
        return "index";
    }
}
