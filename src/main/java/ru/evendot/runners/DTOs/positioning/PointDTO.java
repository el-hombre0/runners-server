package ru.evendot.runners.DTOs.positioning;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointDTO {
    private Long id;
    private float longitude;
    private float latitude;
    private float altitude;
    private LocalTime timestamp;
    @JsonIgnore
    private RouteDTO route;
}
