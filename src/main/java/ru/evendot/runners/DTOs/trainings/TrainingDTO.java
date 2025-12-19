package ru.evendot.runners.DTOs.trainings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.evendot.runners.DTOs.positioning.RouteDTO;
import ru.evendot.runners.DTOs.users.UserDTO;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingDTO {
    private Long id;
    private UserDTO user;
    private RouteDTO route;

    private LocalDate creationDate;
    private LocalTime creationTime;
    private LocalDate endingDate;
    private LocalTime endingTime;

    private String notes;
    private Float distance;
    private Duration duration;
    private Float climbing;
    private Float maxHeight;
    private Float averagePace;
}
