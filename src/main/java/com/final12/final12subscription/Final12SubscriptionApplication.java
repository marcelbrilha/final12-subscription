package com.final12.final12subscription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class Final12SubscriptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Final12SubscriptionApplication.class, args);
	}

}
