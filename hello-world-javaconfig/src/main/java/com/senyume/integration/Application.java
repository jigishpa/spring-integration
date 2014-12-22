package com.senyume.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

/**
 * @author Jigish Patel
 */

@Configuration
@EnableAutoConfiguration
@IntegrationComponentScan
@ComponentScan
public class Application {
	
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args){
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		
		// application loads Spring Integration components from resources/hello-world.xml and configures them
		// obtain the 'inputChannel' MessageChannel bean
		MessageChannel inputChannel = applicationContext.getBean("inputChannel", MessageChannel.class);
		// obtain the 'outputChannel' PollableChannel bean (PollableChannel is a specialized MessageChannel with polling behavior)
		PollableChannel outputChannel = applicationContext.getBean("outputChannel", PollableChannel.class);

		// send a message to inputChannel
		inputChannel.send(new GenericMessage<String>("World"));

		// receive a message from the outputChannel
		logger.info("\n\nFROM OUTPUT CHANNEL: " + outputChannel.receive(0).getPayload() + "\n");		// parameter 0 for receive() method means no blocking/waiting for a message
	}
}
