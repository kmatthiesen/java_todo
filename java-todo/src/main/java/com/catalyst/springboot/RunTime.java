package com.catalyst.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Handles the running of the To-Do List
 * @author kmatthiesen
 *
 */
@SpringBootApplication
public class RunTime {
	
	/**
	 * Runtime of the program through Spring.
	 * 
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(RunTime.class);
		
	}
	
	

}
