package com.mateusz.learnspring.mapper;

import org.springframework.stereotype.Service;
import com.mateusz.learnspring.dto.TraineeDTO;
import com.mateusz.learnspring.model.Trainee;

@Service
public class TraineeMapper {

	public TraineeDTO toDTO(Trainee trainee) {
		return new TraineeDTO(trainee.getId(), trainee.getName());
	}

	public Trainee toEntity(TraineeDTO trainee) {
		Trainee entity = new Trainee();
		entity.setId(trainee.getId());
		entity.setName(trainee.getName());
		return entity;
	}

}
