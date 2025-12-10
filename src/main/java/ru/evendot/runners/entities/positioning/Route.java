package ru.evendot.runners.entities.positioning;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "route")
    private List<Checkpoint> checkpoints;


}
