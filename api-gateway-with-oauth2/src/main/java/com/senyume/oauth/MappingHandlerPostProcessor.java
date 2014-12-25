package com.senyume.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.PostConstruct;

/**
 * @author Jigish Patel
 */

// This is specifically for Spring Integration. We'll attempt to extract access token so that we can return it back to the user
// Don't confuse this with the Spring Security token service (that's different from this class)
@Service("oauth2TokenService")
public class MappingHandlerPostProcessor {

	private static Logger logger = LoggerFactory.getLogger(MappingHandlerPostProcessor.class);
	
	@Autowired
	@Qualifier ("oauth2EndpointHandlerMapping")
	private RequestMappingHandlerMapping oauth2EndpointHandlerMapping;

	@Autowired
	@Qualifier ("requestMappingHandlerMapping")
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	@Autowired
	@Qualifier ("integrationRequestMappingHandlerMapping")
	private RequestMappingHandlerMapping integrationRequestMappingHandlerMapping;

	// we want to give OAuth2 EndpointHandler higher precedence over Spring Integration MappingHandler so that 
	// all security related handlers fire first. lower order handler fires first
	// without this ordering, Spring Integration Mapping Handler was firing before OAuth2 Handler and hence the
	// security MappingHandler didn't get a chance to process /oauth/token or other /oauth/** urls.
	@PostConstruct								// gets called once all beans have been configured and injected
	public void setMappingHandlerOrder(){
		this.oauth2EndpointHandlerMapping.setOrder(0);
		this.integrationRequestMappingHandlerMapping.setOrder(1);
		this.requestMappingHandlerMapping.setOrder(2);
	}

}
