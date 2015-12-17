package com.catalyst.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controls the redirecting of the user on the website.
 * 
 * @author kmatthiesen
 *
 */
@Controller
public class HomeController {

	/**
	 * Redirects a / to the home page.
	 * 
	 * @return the URL of the home page.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(){
		return "webpages/home.html";
	}
	
	/**
	 * Redirects a /create to the task creation page.
	 * 
	 * @return the URL of the create page.
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(){
		return "webpages/create.html";
	}
	
	/**
	 * Redirects a /update to the task update page.
	 * 
	 * @return the URL of the update page.
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(){
		return "webpages/update.html";
	}

	/**
	 * Redirects a /create to the task deletion page.
	 * 
	 * @return the URL of the delete page.
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(){
		return "webpages/delete.html";
	}
	
	
	
	
	
}
