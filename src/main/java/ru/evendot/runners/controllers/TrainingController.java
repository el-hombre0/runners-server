package ru.evendot.runners.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evendot.runners.DTOs.trainings.TrainingDTO;
import ru.evendot.runners.entities.responses.DataResponse;
import ru.evendot.runners.entities.trainings.Training;
import ru.evendot.runners.services.trainings.TrainingService;

@RestController
@RequestMapping("/api/v1/training")
public class TrainingController {

    private TrainingService trainingService;
    @PostMapping("/")
    public ResponseEntity<DataResponse> addTraining(@RequestBody TrainingDTO trainingDTO){
        Training createdTraining = trainingService.saveTraining()
        return ResponseEntity.ok(new DataResponse("Training successfully added!", trainingDTO));
    }
}
