package ru.evendot.runners.services.positioning;

import ru.evendot.runners.DTOs.positioning.RouteDTO;
import ru.evendot.runners.entities.positioning.Route;
import ru.evendot.runners.entities.requests.positioning.CreateRouteRequest;


public interface IRouteService {
    Route initializeNewRoute(CreateRouteRequest createTrackReq);
    Route getRoute(Long id);
    Route addPointsToRoute(CreateRouteRequest createRouteRequest, Route route);
    RouteDTO convertToRouteDTO(Route route);
}
