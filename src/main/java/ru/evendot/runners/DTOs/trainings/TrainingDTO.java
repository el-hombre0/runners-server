package ru.evendot.runners.DTOs.trainings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.evendot.runners.DTOs.positioning.RouteDTO;
import ru.evendot.runners.DTOs.users.UserDTO;
import ru.evendot.runners.entities.positioning.Route;
import ru.evendot.runners.entities.users.User;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingDTO {
    private Long id;
    private Set<UserDTO> users;
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
