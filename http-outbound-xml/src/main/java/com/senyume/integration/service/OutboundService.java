package com.senyume.integration.service;

/**
 * @author Jigish Patel
 */

public class OutboundService {
	
	// this method's return value doesn't matter since we've hard-coded Http Outbound Gateway to call bookstore-rest-api
	public String triggerHttpOutboundGateway(String payload){
		return "OutboundService detected this API call: GET " + payload;
	}
}
