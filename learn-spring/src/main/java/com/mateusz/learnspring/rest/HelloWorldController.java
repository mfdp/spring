package com.mateusz.learnspring.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mateusz.learnspring.configuration.ApplicationProperties;
import com.mateusz.learnspring.model.Trainee;
import com.mateusz.learnspring.services.TraineeService;

@RestController
@RequestMapping("/")
public class HelloWorldController {

	private final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

	@Autowired
	ApplicationProperties applicationProperties;

	@Autowired
	TraineeService traineeService;

	@GetMapping("/")
	public String helloWorldS() {
		return applicationProperties.getProperty();
	}

	@GetMapping("/sum")
	public String sumNumbers(@RequestParam int a, @RequestParam int b) {
		return String.valueOf(this.traineeService.sumNumbers(a, b));
	}

	@GetMapping("/all")
	public ResponseEntity<Trainee> getAllTrainees() {
		return ResponseEntity.ok(traineeService.getAll());
	}

}
