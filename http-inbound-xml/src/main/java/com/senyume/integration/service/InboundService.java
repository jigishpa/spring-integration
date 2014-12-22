package com.senyume.integration.service;

import java.util.Map;

/**
 * @author Jigish Patel
 */

public class InboundService {
	
	public String handleIncomingRequest(Map<String,Object> headers, String payload){
		String restServiceUrl = (String) headers.get("http_requestUrl");
		String restRequestMethod = (String) headers.get("http_requestMethod");
		return "REST API method: " + restServiceUrl
				+ "\nrequest verb: " + restRequestMethod
				+ "\nrequest body (if any): " + payload;
	}
}
