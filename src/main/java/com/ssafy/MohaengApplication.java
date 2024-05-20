package com.ssafy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MohaengApplication {

	public static void main(String[] args) {
		SpringApplication.run(MohaengApplication.class, args);
	}

}
