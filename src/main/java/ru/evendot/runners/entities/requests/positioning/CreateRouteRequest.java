package ru.evendot.runners.entities.requests.positioning;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRouteRequest {
    private String name;
    private String description;
    private List<CreatePointRequest> points;
}
