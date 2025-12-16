package ru.evendot.runners.entities.requests.positioning;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.evendot.runners.entities.trainings.Training;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRouteRequest {
    private Long id;
    private String name;
    private String description;
    private List<UpdatePointRequest> points;
    private Training training;
}
