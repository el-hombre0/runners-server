package ru.evendot.runners.services.positioning;

import org.springframework.stereotype.Service;
import ru.evendot.runners.entities.positioning.Point;
import ru.evendot.runners.entities.positioning.Route;
import ru.evendot.runners.entities.requests.positioning.CreatePointRequest;


@Service
public interface IPointService {
//    List<Point> savePoints(List<CreatePointRequest> points, Route route);
    Point savePoint(CreatePointRequest req, Route route);
}
