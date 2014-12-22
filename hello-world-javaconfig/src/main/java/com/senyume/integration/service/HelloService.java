package com.senyume.integration.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * @author Jigish Patel
 */

@MessageEndpoint
public class HelloService {

	@ServiceActivator(inputChannel = "inputChannel", outputChannel = "outputChannel")
	public String sayHello(String name){
		return "Hello " + name + " from Spring Integration HelloService!";
	}
}
