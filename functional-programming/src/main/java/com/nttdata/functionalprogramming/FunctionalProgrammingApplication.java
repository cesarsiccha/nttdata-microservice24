package com.nttdata.functionalprogramming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FunctionalProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionalProgrammingApplication.class, args);
	}

}
