package com.senyume.integration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jigish Patel
 */

@RestController
public class BookController {

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getAllBooks(){
		return "{'books':'list of all books goes here'}";
	}
}
