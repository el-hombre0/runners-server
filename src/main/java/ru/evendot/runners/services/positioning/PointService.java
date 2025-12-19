package ru.evendot.runners.services.positioning;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evendot.runners.entities.positioning.Point;
import ru.evendot.runners.entities.positioning.Route;
import ru.evendot.runners.entities.requests.positioning.CreatePointRequest;
import ru.evendot.runners.repositories.positioning.PointRepository;


@Service
@AllArgsConstructor
public class PointService implements IPointService{
    private final PointRepository pointRepo;

//    public List<Point> savePoints(List<CreatePointRequest> points, Route route){
//        List<Point> points1 = new ArrayList<>();
//        for (CreatePointRequest pointReq : points){
//            Point point = new Point();
//            point.setLatitude(pointReq.getLatitude());
//            point.setLongitude(pointReq.getLongitude());
//            point.setAltitude(pointReq.getAltitude());
//            point.setTimestamp(pointReq.getTimestamp());
//            point.setRoute(route);
//            points1.add(point);
//        }
//        return points1;
//    }
    public Point savePoint(CreatePointRequest req, Route route){
        Point point = new Point();
        point.setLatitude(req.getLatitude());
        point.setLongitude(req.getLongitude());
        point.setAltitude(req.getAltitude());
        point.setTimestamp(req.getTimestamp());
        point.setRoute(route);
        return pointRepo.save(point);
    }

}
