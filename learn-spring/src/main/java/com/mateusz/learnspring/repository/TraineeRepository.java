package com.mateusz.learnspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mateusz.learnspring.model.Trainee;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {

	List<Trainee> getTraineeByIdNotNull();

}
