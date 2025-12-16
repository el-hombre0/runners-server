package ru.evendot.runners.entities.positioning;

import jakarta.persistence.*;
import lombok.Data;
import ru.evendot.runners.entities.trainings.Training;

import java.util.List;

@Data
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "route")
    private List<Point> points;

    @OneToOne
    private Training training;
}
