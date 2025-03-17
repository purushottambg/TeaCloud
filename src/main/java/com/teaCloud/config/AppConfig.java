package com.teaCloud.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "AuditorAwareImp")
public class AppConfig {

    @Bean
    ModelMapper getmodelMapper(){
        return new ModelMapper();
    }

    @Bean
    AuditorAware<String> getAuditAwareImpl(){
        return new AuditorAwareImp();
    }
}
