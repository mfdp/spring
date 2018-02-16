package com.mateusz.learnspring.services;

import org.springframework.transaction.annotation.Transactional;
import com.mateusz.learnspring.model.Trainee;

public interface TraineeService {

	int sumNumbers(int a, int b);

	@Transactional(readOnly = true)
	Trainee getAll();
}
