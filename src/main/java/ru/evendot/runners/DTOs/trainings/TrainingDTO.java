package ru.evendot.runners.DTOs.trainings;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.evendot.runners.entities.users.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
public class TrainingDTO {
    private Long id;
    private List<User> users;

    private LocalDate creationDate;
    private LocalTime creationTime;
    private LocalDate endingDate;
    private LocalTime endingTime;

    private String notes;
    private Double distance;
    private LocalTime timeInMotion;
    private Integer climbing;
    private Integer maxHeight;
    private LocalTime averagePace;
}
