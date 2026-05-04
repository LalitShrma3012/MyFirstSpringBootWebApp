package com.TheLash.MySpringBootLearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// @SpringBootApplication consist of three different annotations -
// 1. @Configuration
// 2. @EnableAutoConfiguration
// 3. @ComponentScan - Scan IOC container and add beans (Objects) into IOC container.
@SpringBootApplication
public class MySpringBootLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootLearningApplication.class, args);
	}

}
