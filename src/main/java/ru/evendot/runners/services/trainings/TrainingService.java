package ru.evendot.runners.services.trainings;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.evendot.runners.DTOs.trainings.TrainingDTO;
import ru.evendot.runners.entities.trainings.Training;
import ru.evendot.runners.exceptions.ResourceNotFoundException;
import ru.evendot.runners.repositories.training.TrainingRepository;


@Service
@RequiredArgsConstructor
public class TrainingService implements ITrainingService{

    private final TrainingRepository trainingRepo;
    private final ModelMapper modelMapper;

    public Training saveTraining(TrainingDTO trainingDTO){
        Training training = createComplexTrainingObject(trainingDTO);
        trainingRepo.save(training);
        return training;
    }

    public Training getTraining(Long id) {
        return trainingRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Training with id " + id + " not found!")
        );
    }

    public Training updateTraining(TrainingDTO trainingDTO){
        return trainingRepo.findById(trainingDTO.getId()).map(existingTraining -> {
            existingTraining = createComplexTrainingObject(trainingDTO);
            return trainingRepo.save(existingTraining);
        }).orElseThrow(
                () -> new ResourceNotFoundException("Training with id " + trainingDTO.getId() + "not found!"));
    }

    public void deleteTraining(Long id){
        try {
            trainingRepo.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Training with id " + id + " not found!");
        }
    }

    public TrainingDTO convertToTrainingDTO(Training training){
        return modelMapper.map(training, TrainingDTO.class);
    }

    private Training createComplexTrainingObject(TrainingDTO sourceTraining){
        Training training = new Training();
        training.setUsers(sourceTraining.getUsers());
        training.setCreationDate(sourceTraining.getCreationDate());
        training.setCreationTime(sourceTraining.getCreationTime());
        training.setEndingDate(sourceTraining.getEndingDate());
        training.setEndingTime(sourceTraining.getEndingTime());
        training.setNotes(sourceTraining.getNotes());
        training.setDistance(sourceTraining.getDistance());
        training.setTimeInMotion(sourceTraining.getTimeInMotion());
        training.setClimbing(sourceTraining.getClimbing());
        training.setMaxHeight(sourceTraining.getMaxHeight());
        training.setAveragePace(sourceTraining.getAveragePace());
        return training;
    }
}
