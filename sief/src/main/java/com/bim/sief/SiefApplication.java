package com.bim.sief;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "com.bim.sief")
public class SiefApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiefApplication.class, args);
	}

}
