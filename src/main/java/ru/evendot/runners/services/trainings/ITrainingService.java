package ru.evendot.runners.services.trainings;

import ru.evendot.runners.DTOs.trainings.TrainingDTO;
import ru.evendot.runners.entities.positioning.Route;
import ru.evendot.runners.entities.requests.training.CreateTrainingRequest;
import ru.evendot.runners.entities.requests.training.UpdateTrainingRequest;
import ru.evendot.runners.entities.trainings.Training;

import java.util.Set;

public interface ITrainingService {
    Training saveTraining(CreateTrainingRequest req, Route route);
    Training getTraining(Long id);
    Set<Training> getAllUserTrainings(Long userId);
    Training updateTraining(UpdateTrainingRequest req);
    void deleteTraining(Long id);
    TrainingDTO convertToTrainingDTO(Training training);
}
