package ru.evendot.runners.services.positioning;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evendot.runners.entities.positioning.Point;
import ru.evendot.runners.entities.positioning.Route;
import ru.evendot.runners.entities.requests.positioning.CreatePointRequest;
import ru.evendot.runners.entities.requests.positioning.CreateRouteRequest;
import ru.evendot.runners.exceptions.ResourceNotFoundException;
import ru.evendot.runners.repositories.positioning.TrackRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService implements IRouteService {
    private final TrackRepository trackRepo;

    public Route initializeNewRoute(CreateRouteRequest createRouteRequest){
        Route route = new Route();
        route.setName(createRouteRequest.getName());
        route.setDescription(createRouteRequest.getDescription());
        List<Point> points = new ArrayList<>();
        for (CreatePointRequest pointReq : createRouteRequest.getPoints()){
            Point point = new Point();
            point.setLatitude(pointReq.getLatitude());
            point.setLongitude(pointReq.getLongitude());
            point.setAltitude(pointReq.getAltitude());
            point.setTimestamp(pointReq.getTimestamp());
            point.setRoute(route);
            points.add(point);
        }

        route.setPoints(points);
        return trackRepo.save(route);
    }

    public Route getRoute(Long id){
        return trackRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Route with id " + id + "not found!"));
    }
}
