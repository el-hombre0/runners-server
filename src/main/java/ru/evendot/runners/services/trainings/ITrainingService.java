package ru.evendot.runners.services.trainings;

import ru.evendot.runners.DTOs.trainings.TrainingDTO;
import ru.evendot.runners.entities.trainings.Training;

public interface ITrainingService {
    Training saveTraining(TrainingDTO trainingDTO);
    Training getTraining(Long id);
    void deleteTraining();
}
