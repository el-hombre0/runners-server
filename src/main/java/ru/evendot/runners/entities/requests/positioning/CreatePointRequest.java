package ru.evendot.runners.entities.requests.positioning;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePointRequest {
    private float longitude;
    private float latitude;
    private float altitude;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss")
    private LocalTime timestamp;
//    private CreateRouteRequest track;
}
