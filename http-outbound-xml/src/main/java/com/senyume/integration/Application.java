package com.senyume.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

/**
 * @author Jigish Patel
 */

@Configuration
@EnableAutoConfiguration
@ImportResource( "http-outbound.xml" )		// @ImportResource for importing XML config file and @Import for importing JavaConfig file
public class Application {
	
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args){
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

		// obtain the 'inputChannel' MessageChannel bean
		MessageChannel inputChannel = applicationContext.getBean("inputChannel", MessageChannel.class);
		// obtain the 'bookstoreResponseChannel' channel (this is the last channel with response from the HttpOutboundGateway)
		PollableChannel bookstoreResponseChannel = applicationContext.getBean("bookstoreResponseChannel", PollableChannel.class);

		// send a message to inputChannel
		inputChannel.send(new GenericMessage<String>("http://localhost:11001/books"));

		// receive a message from the outputChannel
		logger.info("\n\nFROM OUTPUT CHANNEL: " + bookstoreResponseChannel.receive(0).getPayload() + "\n");		// parameter 0 for receive() method means no blocking/waiting for a message
	}
}
