package ru.evendot.runners.entities.entertainment;

import jakarta.persistence.*;
import lombok.Data;
import ru.evendot.runners.entities.users.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate creationDate;
    private LocalTime creationTime;

    @ManyToMany
    private List<User> participants;
}
