package com.senyume.integration.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import java.util.Map;

/**
 * @author Jigish Patel
 */

@MessageEndpoint
public class HelloService {

	@ServiceActivator
	public String sayHello(String payload, Map<String, Object> headers){
		return "Hello from Spring Integration (HTTP Inbound Gateway)!";
	}
}
