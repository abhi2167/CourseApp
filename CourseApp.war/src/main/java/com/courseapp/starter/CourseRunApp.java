package com.courseapp.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @ImportResource({"classpath:applicationContext.xml"})
@EnableJpaRepositories("com.courseapp.dao")
@EntityScan("com.courseapp.service.types")
@ComponentScan(basePackages = { "com.courseapp" })
public class CourseRunApp extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CourseRunApp.class);
	}

	public static void main(String[] args) {
		System.out.println("===============================================");
		System.out.println("========= Initializing Spring Boot Course Application ==============");
		System.out.println("=================================================");
		SpringApplication.run(CourseRunApp.class, args);
		System.out.println("============= Spring Boot Course Application Started ===================");
	}
}
