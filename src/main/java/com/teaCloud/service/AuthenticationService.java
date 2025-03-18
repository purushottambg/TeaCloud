package com.teaCloud.service;

import com.teaCloud.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public String login(String username, String password){
        Authentication authentication  = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        UserEntity userEntity = (UserEntity) authentication.getPrincipal();
        String generatedToken = jwtService.generateToken(userEntity);
        logger.info("JWT Token in user Service is: {}", generatedToken);
        return generatedToken;
    }

}
