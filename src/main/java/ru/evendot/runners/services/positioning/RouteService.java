package ru.evendot.runners.services.positioning;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.evendot.runners.DTOs.positioning.RouteDTO;
import ru.evendot.runners.entities.positioning.Point;
import ru.evendot.runners.entities.positioning.Route;
import ru.evendot.runners.entities.requests.positioning.CreatePointRequest;
import ru.evendot.runners.entities.requests.positioning.CreateRouteRequest;
import ru.evendot.runners.exceptions.ResourceNotFoundException;
import ru.evendot.runners.repositories.positioning.RouteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RouteService implements IRouteService {
    private final RouteRepository routeRepo;
    private final PointService pointService;
    private final ModelMapper modelMapper;


    public Route initializeNewRoute(CreateRouteRequest createRouteRequest){
        Route route = new Route();
        route.setName(createRouteRequest.getName());
        route.setDescription(createRouteRequest.getDescription());

        route.setPoints(null);
        return routeRepo.save(route);
//        Route filledPointsRoute = addPointsToRoute(points, savedRoute);
//        route.setPoints(points);
//        return routeRepo.save(route);
//        return filledPointsRoute;
    }

    public Route addPointsToRoute(CreateRouteRequest createRouteRequest, Route route){
        List<Point> points = new ArrayList<>();
        for (CreatePointRequest pointReq : createRouteRequest.getPoints()){
            Point point = pointService.savePoint(pointReq, route);
            points.add(point);
        }



        route.setPoints(points);
        return routeRepo.save(route);
    }


    public Route getRoute(Long id){
        return routeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Route with id " + id + "not found!"));
    }

    public RouteDTO convertToRouteDTO(Route route) {
        return modelMapper.map(route, RouteDTO.class);
    }
}
