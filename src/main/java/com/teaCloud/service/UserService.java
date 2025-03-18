package com.teaCloud.service;

import com.teaCloud.dtos.SignUpDTO;
import com.teaCloud.entity.UserEntity;
import com.teaCloud.repos.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service

public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity saveUser(SignUpDTO signUpDTO){
        UserEntity userEntity = modelMapper.map(signUpDTO, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        System.out.println("name for in service layer "+userEntity.getName());
       return userRepository.save(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow( () ->new UsernameNotFoundException("there is no "+username+" such user") );
    }

    public boolean existsById(String email) {
        return userRepository.existsByEmail(email);
    }

//    public UserEntity findByMemberIDAndPassword(String email, String password) {
//        return userRepository.findByEmailAndPassword(email, password);
//    }
}
