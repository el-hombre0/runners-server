package ru.evendot.runners.controllers.training;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evendot.runners.DTOs.trainings.TrainingDTO;
import ru.evendot.runners.entities.requests.training.CreateTrainingRequest;
import ru.evendot.runners.entities.requests.training.UpdateTrainingRequest;
import ru.evendot.runners.entities.responses.DataResponse;
import ru.evendot.runners.entities.trainings.Training;
import ru.evendot.runners.exceptions.ResourceNotFoundException;
import ru.evendot.runners.services.trainings.TrainingService;


@RestController
@RequestMapping("/api/v1/trainings")
public class TrainingController {

    private TrainingService trainingService;

    @PostMapping("/")
    public ResponseEntity<DataResponse> addTraining(@RequestBody CreateTrainingRequest req) {
        Training training = trainingService.saveTraining(req);
        TrainingDTO trainingDTO = trainingService.convertToTrainingDTO(training);
        return ResponseEntity.ok(new DataResponse("Training successfully added!", trainingDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse> getTraining(@PathVariable Long id) {
        try {
            Training training = trainingService.getTraining(id);
            TrainingDTO trainingDTO = trainingService.convertToTrainingDTO(training);
            return ResponseEntity.ok(new DataResponse("", trainingDTO));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DataResponse("Training with id " + id + "not found!", null));
        }
    }

    @PutMapping("/")
    public ResponseEntity<DataResponse> updateTraining(@RequestBody UpdateTrainingRequest req) {
        try {
            Training training = trainingService.updateTraining(req);
            TrainingDTO updatedTrainingDTO = trainingService.convertToTrainingDTO(training);
            return ResponseEntity.ok(new DataResponse("Training successfully updated!", updatedTrainingDTO));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DataResponse("Training with id " + req.getId() + "not found!", null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResponse> deleteTraining(@PathVariable Long id) {
        try {
            trainingService.deleteTraining(id);
            return ResponseEntity.ok(new DataResponse("Training successfully deleted!", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DataResponse("Training with id " + id + "not found!", null));
        }
    }
}
