package com.senyume.integration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author Jigish Patel
 */

public class InboundService {
	
	private static Logger logger = LoggerFactory.getLogger(InboundService.class);
	private int counter = 0;
	
	public String handleIncomingRequest(Map<String,Object> headers, String payload) throws Exception{
		String restServiceUrl = (String) headers.get("http_requestUrl");
		String restRequestMethod = (String) headers.get("http_requestMethod");
		logger.info("counter=" + ++counter);
		Thread.sleep(5000);
		return "REST API method: " + restServiceUrl
				+ "\nrequest verb: " + restRequestMethod
				+ "\nrequest body (if any): " + payload;
	}
}
