package ru.evendot.runners.repositories.positioning;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evendot.runners.entities.positioning.Point;

public interface PointRepository extends JpaRepository<Point, Long> {
}
