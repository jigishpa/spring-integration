package com.senyume.integration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jigish Patel
 */

@RestController
@RequestMapping("/tasks-rest-api")
public class TaskController {
	
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public String getAllTasks(){
		return "{'tasks': 'list of all tasks go here'}";
	}
}
