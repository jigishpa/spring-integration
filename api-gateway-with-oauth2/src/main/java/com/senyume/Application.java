package com.senyume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Jigish Patel
 */

@Configuration
@EnableAutoConfiguration
@ImportResource("api-gateway.xml")		// @ImportResource for importing XML config file and @Import for importing JavaConfig file
@ComponentScan
public class Application {
	
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args){
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
	}
}
