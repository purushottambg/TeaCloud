package com.teaCloud.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    ModelMapper getmodelMapper(){
        return new ModelMapper();
    }
}
