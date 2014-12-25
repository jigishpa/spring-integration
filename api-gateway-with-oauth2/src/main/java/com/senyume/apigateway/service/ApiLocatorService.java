package com.senyume.apigateway.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Jigish Patel
 */

@Service
public class ApiLocatorService {
	
	private static Logger logger = LoggerFactory.getLogger(ApiLocatorService.class);
	
	@Value("${api.bookstore.url}")
	private String bookstoreApiUrl;
	
	@Value("${api.tasks.url}")
	private String tasksApiUrl;

	public String getBookstoreApiUrl() {
		return bookstoreApiUrl;
	}

	public void setBookstoreApiUrl(String bookstoreApiUrl) {
		this.bookstoreApiUrl = bookstoreApiUrl;
	}

	public String getTasksApiUrl() {
		return tasksApiUrl;
	}

	public void setTasksApiUrl(String tasksApiUrl) {
		this.tasksApiUrl = tasksApiUrl;
	}

	public String getFinalApiUrl(Map<String,Object> headers){
		
		String api = (String) headers.get("api");
		String apiUrl = "";
		if(api.equalsIgnoreCase("bookstore-rest-api")){
			apiUrl = getBookstoreApiUrl();
		}else if(api.equalsIgnoreCase("tasks-rest-api")){
			apiUrl = getTasksApiUrl();
		}
		String apiPath = (String) headers.get("apiPath");

		return apiUrl + "/" + apiPath;
	}
}
