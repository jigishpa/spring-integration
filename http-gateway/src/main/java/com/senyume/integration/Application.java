package com.senyume.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;

/**
 * @author Jigish Patel
 */

@Configuration
@EnableAutoConfiguration
@EnableIntegration
@IntegrationComponentScan
@ComponentScan
public class Application {

	public static void main(String[] args){
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
	}
}
