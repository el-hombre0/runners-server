package ru.evendot.runners.entities.requests.training;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.evendot.runners.entities.positioning.Route;
import ru.evendot.runners.entities.users.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTrainingRequest {
    private Long id;
    private Set<User> users;
    private Route route;

    private LocalDate creationDate;
    private LocalTime creationTime;
    private LocalDate endingDate;
    private LocalTime endingTime;

    private String notes;
    private Double distance;
    private LocalTime timeInMotion;
    private Integer climbing;
    private Integer maxHeight;
    private Double averagePace;
}
