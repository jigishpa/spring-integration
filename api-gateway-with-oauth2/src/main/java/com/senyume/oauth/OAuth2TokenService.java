package com.senyume.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author Jigish Patel
 */

// This is specifically for Spring Integration. We'll attempt to extract access token so that we can return it back to the user
// Don't confuse this with the Spring Security token service (that's different from this class)
@Service("oauth2TokenService")
public class OAuth2TokenService {

	private static Logger logger = LoggerFactory.getLogger(OAuth2TokenService.class);
	
	@Autowired
	@Qualifier ("oauth2EndpointHandlerMapping")
	private RequestMappingHandlerMapping oauth2EndpointHandlerMapping;

	@Autowired
	@Qualifier ("requestMappingHandlerMapping")
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	@Autowired
	@Qualifier ("integrationRequestMappingHandlerMapping")
	private RequestMappingHandlerMapping integrationRequestMappingHandlerMapping;
	
	@PostConstruct
	public void setMappingHandlerOrder(){
		this.oauth2EndpointHandlerMapping.setOrder(0);
		this.integrationRequestMappingHandlerMapping.setOrder(1);
		this.requestMappingHandlerMapping.setOrder(2);
	}

	public String extractAndReturnToken(Map<String,Object> headers){
		oauth2EndpointHandlerMapping.getHandlerMethods().forEach((key,value) -> logger.info(key + " --> " + value));
		logger.info("oauth2EndpointHandlerMapping order=" + oauth2EndpointHandlerMapping.getOrder());
		logger.info("-------");
		requestMappingHandlerMapping.getHandlerMethods().forEach((key,value) -> logger.info(key + " --> " + value));
		logger.info("requestMappingHandlerMapping order=" + requestMappingHandlerMapping.getOrder());
		logger.info("-------");
		integrationRequestMappingHandlerMapping.getHandlerMethods().forEach((key,value) -> logger.info(key + " --> " + value));
		logger.info("integrationRequestMappingHandlerMapping order=" + integrationRequestMappingHandlerMapping.getOrder());
		//logger.info("handlerMapping=" + handlerMapping);
		return "empty";
		
	}
}
