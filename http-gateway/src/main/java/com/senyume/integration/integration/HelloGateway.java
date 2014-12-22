package com.senyume.integration.integration;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

/**
 * @author Jigish Patel
 */

@MessagingGateway (name = "helloGateway", defaultRequestChannel = "inputChannel",
					defaultReplyChannel = "outputChannel")
public interface HelloGateway {

	public String sayHello(@Payload String payload, @Headers Map<String, Object> headers);
}
