package com.senyume.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Jigish Patel
 */

@Configuration
@EnableAutoConfiguration
@ImportResource("http-inbound.xml")		// @ImportResource for importing XML config file and @Import for importing JavaConfig file
public class Application {
	
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args){
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		
		// application loads Spring Integration components from resources/hello-world.xml and configures them
		// obtain the 'inputChannel' MessageChannel bean

		// obtain the 'outputChannel' PollableChannel bean (PollableChannel is a specialized MessageChannel with polling behavior)

		
		// send a message to inputChannel

		
		// receive a message from the outputChannel
	}
}
