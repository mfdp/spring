package com.mateusz.learnspring.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mateusz.learnspring.configuration.ApplicationProperties;

@RestController
@RequestMapping("/")
public class HelloWorldController {

	private final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

	@Autowired
	ApplicationProperties applicationProperties;

	@GetMapping("/")
	public String helloWorldS() {
		return applicationProperties.getProperty();
	}


}
