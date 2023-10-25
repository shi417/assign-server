package com.assign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableFeignClients
@EnableOpenApi
public class AssignOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignOrderApplication.class, args);
	}

}
