package com.teaCloud.controllers;

import com.teaCloud.dtos.SignUpDTO;
import com.teaCloud.entity.UserEntity;
import com.teaCloud.service.UserService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("pages/sign-up")
    public String register(Model model){
        model.addAttribute("signup",new SignUpDTO());
        return "/pages/sign-up";
    }
    @PostMapping("pages/save-request")
    public String signup(Model model, @ModelAttribute("signup") SignUpDTO signUpDTO){
        UserEntity savedEntity = userService.saveUser(signUpDTO);
        if(savedEntity!=null){
            model.addAttribute("your id is "+savedEntity.getMemberID(), "success");
        }
        return "index";
    }
}
