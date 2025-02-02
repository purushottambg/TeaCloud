package com.teaCloud.service;

import com.teaCloud.entity.UserEntity;
import com.teaCloud.repos.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public UserEntity validateUser(Long id, String password) {
        return userRepository.findByMemberIDAndPassword(id, password);
    }
}
