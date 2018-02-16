package com.mateusz.learnspring.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mateusz.learnspring.dto.TraineeDTO;
import com.mateusz.learnspring.mapper.TraineeMapper;
import com.mateusz.learnspring.model.Trainee;
import com.mateusz.learnspring.repository.TraineeRepository;
import com.mateusz.learnspring.services.TraineeService;

@Service
public class TraineeServiceImpl implements TraineeService {

	private final Logger logger = LoggerFactory.getLogger(TraineeServiceImpl.class);

	@Autowired
	TraineeRepository traineeRepository;

	@Autowired
	TraineeMapper traineeMapper;

	@Override
	@Transactional(readOnly = true)
	public int sumNumbers(int a, int b) {
		logger.debug("Enjoy sum in TrainneService");
		return a + b;
	}

	@Override
	public TraineeDTO save(TraineeDTO dto) {
		final Trainee savedEntity = traineeRepository.save(traineeMapper.toEntity(dto));
		return traineeMapper.toDTO(savedEntity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TraineeDTO> getAll() {
		return traineeRepository.getTraineeByIdNotNull().stream()
			.map(traineeMapper::toDTO) //
			.collect(Collectors.toList());
	}
}
