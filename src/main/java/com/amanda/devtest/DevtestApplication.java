package com.amanda.devtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.amanda.devtest"})
@EntityScan(basePackages = "com.amanda.devtest.model")
@EnableTransactionManagement
@ConfigurationPropertiesScan
public class DevtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevtestApplication.class, args);
	}

}
