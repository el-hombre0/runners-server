package ru.evendot.runners.DTOs.positioning;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.evendot.runners.DTOs.trainings.TrainingDTO;
import ru.evendot.runners.entities.positioning.Point;
import ru.evendot.runners.entities.trainings.Training;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDTO {
    private Long id;
    private String name;
    private String description;
    private List<PointDTO> points;
    @JsonIgnore
    private TrainingDTO training;
}
