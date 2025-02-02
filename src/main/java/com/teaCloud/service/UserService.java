package com.teaCloud.service;

import com.teaCloud.dtos.SignUpDTO;
import com.teaCloud.entity.UserEntity;
import com.teaCloud.repos.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper){
        this.userRepository=userRepository;
        this.modelMapper = modelMapper;
    }

    public UserEntity validateUser(Long id, String password) {
        return userRepository.findByMemberIDAndPassword(id, password);
    }

    public UserEntity saveUser(SignUpDTO signUpDTO){
        UserEntity userEntity = modelMapper.map(signUpDTO, UserEntity.class);
        System.out.println("namefor in service layer "+userEntity.getName());
       return userRepository.save(userEntity);
    }
}
