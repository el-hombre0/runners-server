package ru.evendot.runners.repositories.training;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evendot.runners.entities.trainings.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {

}
