package com.senyume.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.PollableChannel;

/**
 * @author Jigish Patel
 */

@Configuration
@EnableIntegration
public class IntegrationConfig {
	
	@Bean
	public DirectChannel inputChannel(){
		return new DirectChannel();
	}
	
	@Bean
	public PollableChannel outputChannel(){
		return new QueueChannel(10);
	}

	
	// the inputChannel and outputChannel are used by HelloService using ActivatorService
	// sayHello() method in HelloService has been annotated with @ServiceActivator annotation to configure this
	
	// if using Java DSL, we can configure this way
//	@Bean
//	public IntegrationFlow helloWorldFlow(){
//		return IntegrationFlows.from(inputChannel())
//								.handle("helloService", "sayHello")
//								.channel(outputChannel())
//								.get();
//
//	}
	
}
