package ru.evendot.runners.controllers.training;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evendot.runners.DTOs.trainings.TrainingDTO;
import ru.evendot.runners.entities.responses.DataResponse;
import ru.evendot.runners.entities.trainings.Training;
import ru.evendot.runners.exceptions.ResourceNotFoundException;
import ru.evendot.runners.services.trainings.TrainingService;


@RestController
@RequestMapping("/api/v1/training")
public class TrainingController {

    private TrainingService trainingService;

    @PostMapping("/")
    public ResponseEntity<DataResponse> addTraining(@RequestBody TrainingDTO trainingDTO){
        trainingService.saveTraining(trainingDTO);
        return ResponseEntity.ok(new DataResponse("Training successfully added!", trainingDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse> getTraining(@PathVariable Long id){
        try{
            Training training = trainingService.getTraining(id);
            TrainingDTO trainingDTO = trainingService.convertToTrainingDTO(training);
            return ResponseEntity.ok(new DataResponse("", trainingDTO));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new DataResponse(
                            "Training with id " + id + "not found!",
                            e.getMessage()));
        }
    }

    @PutMapping("/")
    public ResponseEntity<DataResponse> updateTraining(@RequestBody TrainingDTO trainingDTO){
        try{
            Training training = trainingService.updateTraining(trainingDTO);
            TrainingDTO updatedTrainingDTO = trainingService.convertToTrainingDTO(training);
            return ResponseEntity.ok(new DataResponse("Training successfully updated!", updatedTrainingDTO));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new DataResponse(
                            "Training with id " + trainingDTO.getId() + "not found!",
                            e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResponse> deleteTraining(@PathVariable Long id){
        try{
            trainingService.deleteTraining(id);
            return ResponseEntity.ok(new DataResponse("Training successfully deleted!", null));
        }
        catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DataResponse(
                    "Training with id " + id + "not found!",
                    e.getMessage()
            ));
        }
    }
}
