package com.teaCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.teaCloud")
public class TeaCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeaCloudApplication.class, args);
	}

}
