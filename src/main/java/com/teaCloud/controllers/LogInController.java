package com.teaCloud.controllers;

import com.teaCloud.dtos.LogInDTO;
import com.teaCloud.entity.UserEntity;
import com.teaCloud.repos.UserRepository;
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

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(LogInController.class);

    @PostMapping("pages/validate-login")
    public String login(@ModelAttribute LogInDTO logInDTO, Model model){
        logger.trace("Received details are userID {} password {}", logInDTO.getMemberID(), logInDTO.getPassword());
        logger.info("Received users exist in DB: {}", userRepository.existsById(logInDTO.getMemberID()));
        if(userRepository.existsById(logInDTO.getMemberID())){
            UserEntity userEntity = userRepository.findByMemberIDAndPassword(logInDTO.getMemberID(), logInDTO.getPassword());
            LogInDTO logInDTO1 = modelMapper.map(userEntity, LogInDTO.class);
            model.addAttribute("logInDTO1", logInDTO1);
            logger.info("userId is {} and routing to the home page", logInDTO1.getMemberID());
            return   "pages/student-home";
        }else {
            model.addAttribute("Failed to authenticate", "failed");
            logger.info("Something went wrong");
            return  "pages/student-home";
        }
    }
}
