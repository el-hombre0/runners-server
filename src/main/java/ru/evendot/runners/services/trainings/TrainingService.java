package ru.evendot.runners.services.trainings;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.evendot.runners.DTOs.trainings.TrainingDTO;
import ru.evendot.runners.entities.requests.training.CreateTrainingRequest;
import ru.evendot.runners.entities.requests.training.UpdateTrainingRequest;
import ru.evendot.runners.entities.trainings.Training;
import ru.evendot.runners.exceptions.ResourceNotFoundException;
import ru.evendot.runners.repositories.training.TrainingRepository;


@Service
@RequiredArgsConstructor
public class TrainingService implements ITrainingService {

    private final TrainingRepository trainingRepo;
    private final ModelMapper modelMapper;

    public Training saveTraining(CreateTrainingRequest req) {
//        Training training = createComplexTrainingObject(trainingDTO);
        Training training = new Training();
        training.setUsers(req.getUsers());
        training.setRoute(req.getRoute());

        training.setCreationDate(req.getCreationDate());
        training.setCreationTime(req.getCreationTime());
        training.setEndingDate(req.getEndingDate());
        training.setEndingTime(req.getEndingTime());

        training.setNotes(req.getNotes());
        training.setDistance(req.getDistance());
        training.setTimeInMotion(req.getTimeInMotion());
        training.setClimbing(req.getClimbing());
        training.setMaxHeight(req.getMaxHeight());
        training.setAveragePace(req.getAveragePace());
        trainingRepo.save(training);
        return training;
    }

    public Training getTraining(Long id) {
        return trainingRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Training with id " + id + " not found!"));
    }

    public Training updateTraining(UpdateTrainingRequest req) {
        return trainingRepo.findById(req.getId()).map(existingTraining -> {
//            existingTraining = createComplexTrainingObject(trainingDTO);
            existingTraining.setUsers(req.getUsers());
            existingTraining.setRoute(req.getRoute());

            existingTraining.setCreationDate(req.getCreationDate());
            existingTraining.setCreationTime(req.getCreationTime());
            existingTraining.setEndingDate(req.getEndingDate());
            existingTraining.setEndingTime(req.getEndingTime());

            existingTraining.setNotes(req.getNotes());
            existingTraining.setDistance(req.getDistance());
            existingTraining.setTimeInMotion(req.getTimeInMotion());
            existingTraining.setClimbing(req.getClimbing());
            existingTraining.setMaxHeight(req.getMaxHeight());
            existingTraining.setAveragePace(req.getAveragePace());
            return trainingRepo.save(existingTraining);
        }).orElseThrow(() -> new ResourceNotFoundException("Training with id " + req.getId() + "not found!"));
    }

    public void deleteTraining(Long id) {
        try {
            trainingRepo.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("Training with id " + id + " not found!");
        }
    }

    public TrainingDTO convertToTrainingDTO(Training training) {
        return modelMapper.map(training, TrainingDTO.class);
    }

//    private Training createComplexTrainingObject(TrainingDTO sourceTraining){
//        Training training = new Training();
//        training.setUsers(sourceTraining.getUsers());
//        training.setCreationDate(sourceTraining.getCreationDate());
//        training.setCreationTime(sourceTraining.getCreationTime());
//        training.setEndingDate(sourceTraining.getEndingDate());
//        training.setEndingTime(sourceTraining.getEndingTime());
//        training.setNotes(sourceTraining.getNotes());
//        training.setDistance(sourceTraining.getDistance());
//        training.setTimeInMotion(sourceTraining.getTimeInMotion());
//        training.setClimbing(sourceTraining.getClimbing());
//        training.setMaxHeight(sourceTraining.getMaxHeight());
//        training.setAveragePace(sourceTraining.getAveragePace());
//        return training;
//    }
}
