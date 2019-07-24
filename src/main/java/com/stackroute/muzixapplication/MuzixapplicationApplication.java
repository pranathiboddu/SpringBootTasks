package com.stackroute.muzixapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.stackroute.muzixapplication.repository")
public class MuzixapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuzixapplicationApplication.class, args);
	}

}
