package ru.evendot.runners.entities.requests.positioning;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalTime;

@Data
public class UpdatePointRequest {
    private Long id;
    private float longitude;
    private float latitude;
    private float altitude;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss")
    private LocalTime timestamp;
}
