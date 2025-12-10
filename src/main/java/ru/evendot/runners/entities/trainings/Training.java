package ru.evendot.runners.entities.trainings;

import jakarta.persistence.*;
import lombok.Data;
import ru.evendot.runners.entities.users.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "training_id")
    private List<User> users;

    private LocalDate creationDate;
    private LocalTime creationTime;
    private LocalDate endingDate;
    private LocalTime endingTime;

    private String notes;
    private Double distance;
    private LocalTime timeInMotion;
    private Integer climbing;
    private Integer maxHeight;
    private LocalTime averagePace;
}
