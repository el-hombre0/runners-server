package ru.evendot.runners.entities.positioning;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;


@Data
@Entity
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float longitude;
    private float latitude;
    private float altitude;
    private LocalTime timestamp;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
}
