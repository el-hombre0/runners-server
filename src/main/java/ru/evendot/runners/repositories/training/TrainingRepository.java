package ru.evendot.runners.repositories.training;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evendot.runners.entities.trainings.Training;

import java.util.Set;

public interface TrainingRepository extends JpaRepository<Training, Long> {
    Set<Training> findByUser(Long userId);
}
