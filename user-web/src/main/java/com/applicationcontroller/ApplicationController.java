package com.applicationcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@EntityScan(basePackages = { "com.applicationcontroller.bean" })
@SpringBootApplication(scanBasePackages = { "com.applicationcontroller;" })
public class ApplicationController extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationController.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationController.class);
	}

}
