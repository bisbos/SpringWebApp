package com.quicken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan
@EnableConfigurationProperties
@ComponentScan
public class UrlserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlserviceApplication.class, args);
	}
}
