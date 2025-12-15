package ru.evendot.runners.entities.trainings;

import jakarta.persistence.*;
import lombok.Data;
import ru.evendot.runners.entities.positioning.Route;
import ru.evendot.runners.entities.users.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
    @JoinTable(name = "training_user",
            joinColumns = @JoinColumn(name = "training_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;

    @OneToOne
    private Route route;

    private LocalDate creationDate;
    private LocalTime creationTime;
    private LocalDate endingDate;
    private LocalTime endingTime;

    private String notes;
    private Double distance;
    private LocalTime timeInMotion;
    private Integer climbing;
    private Integer maxHeight;
    private Double averagePace;
}
