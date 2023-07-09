package com.prtt.cornerbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CornerBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(CornerBotApplication.class, args);
	}

}
