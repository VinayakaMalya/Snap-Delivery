package com.snapdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.snapdelivery")
@EnableJpaRepositories("com.snapdelivery.repository")
@EntityScan("com.snapdelivery.model")
@EnableJpaAuditing
public class SnapDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnapDeliveryApplication.class, args);
	}

}
