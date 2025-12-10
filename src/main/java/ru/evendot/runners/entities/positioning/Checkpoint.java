package ru.evendot.runners.entities.positioning;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Checkpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    private double longitude;
    private double latitude;
}
