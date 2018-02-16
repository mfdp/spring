package com.mateusz.learnspring.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mateusz.learnspring.model.Trainee;
import com.mateusz.learnspring.repository.TraineeRepository;
import com.mateusz.learnspring.services.TraineeService;

@Service
public class TraineeServiceImpl implements TraineeService {

	private final Logger logger = LoggerFactory.getLogger(TraineeServiceImpl.class);

	@Autowired
	TraineeRepository traineeRepository;

	@Override
	@Transactional(readOnly = true)
	public int sumNumbers(int a, int b) {
		logger.debug("Enjoy sum in TrainneService");
		return a + b;
	}

	@Override
	@Transactional(readOnly = true)
	public Trainee getAll() {
		return traineeRepository.getAll();
	}
}
