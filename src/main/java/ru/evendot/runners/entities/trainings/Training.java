package ru.evendot.runners.entities.trainings;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import ru.evendot.runners.entities.positioning.Route;
import ru.evendot.runners.entities.users.User;

import java.time.LocalDate;
import java.time.LocalTime;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy:mm:dd")
    private LocalDate creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss")
    private LocalTime creationTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy:mm:dd")
    private LocalDate endingDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss")
    private LocalTime endingTime;

    private String notes;
    private Float distance;

    private Float climbing;
    private Float maxHeight;
    private Float averagePace;
}
