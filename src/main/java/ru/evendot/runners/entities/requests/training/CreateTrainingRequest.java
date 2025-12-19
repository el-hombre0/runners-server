package ru.evendot.runners.entities.requests.training;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.evendot.runners.entities.requests.positioning.CreateRouteRequest;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTrainingRequest {
//    private List<Long> userIds;
    private Long userId;

//    private List<Point> route;
    private CreateRouteRequest route;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy:mm:dd")
    private LocalDate creationDate;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime creationTime;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy:mm:dd")
    private LocalDate endingDate;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime endingTime;

    private String notes;
    private Float distance;
    private Float climbing;
    private Float maxHeight;
    private Float averagePace;
}
