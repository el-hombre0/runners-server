package ru.evendot.runners.repositories.positioning;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evendot.runners.entities.positioning.Route;

public interface TrackRepository extends JpaRepository<Route, Long> {
}
