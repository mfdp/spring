package com.mateusz.learnspring.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.mateusz.learnspring.dto.TraineeDTO;
import com.mateusz.learnspring.model.Trainee;

public interface TraineeService {

	int sumNumbers(int a, int b);

	TraineeDTO save(TraineeDTO dto);

	@Transactional(readOnly = true)
	List<TraineeDTO> getAll();
}
