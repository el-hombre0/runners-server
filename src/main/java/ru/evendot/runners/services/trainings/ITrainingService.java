package ru.evendot.runners.services.trainings;

import ru.evendot.runners.DTOs.trainings.TrainingDTO;
import ru.evendot.runners.entities.requests.training.CreateTrainingRequest;
import ru.evendot.runners.entities.requests.training.UpdateTrainingRequest;
import ru.evendot.runners.entities.trainings.Training;

public interface ITrainingService {
    Training saveTraining(CreateTrainingRequest req);
    Training getTraining(Long id);
    Training updateTraining(UpdateTrainingRequest req);
    void deleteTraining(Long id);
    TrainingDTO convertToTrainingDTO(Training training);
}
