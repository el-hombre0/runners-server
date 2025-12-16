package ru.evendot.runners.DTOs.positioning;

import ru.evendot.runners.entities.positioning.Point;
import ru.evendot.runners.entities.trainings.Training;

import java.util.List;

public class TrackDTO {
    private Long id;
    private String name;
    private String description;
    private List<Point> points;
    private Training training;
}
