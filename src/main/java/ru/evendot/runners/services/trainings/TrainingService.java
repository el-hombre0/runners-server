package ru.evendot.runners.services.trainings;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.evendot.runners.DTOs.trainings.TrainingDTO;
import ru.evendot.runners.entities.positioning.Point;
import ru.evendot.runners.entities.positioning.Route;
import ru.evendot.runners.entities.requests.positioning.UpdatePointRequest;
import ru.evendot.runners.entities.requests.training.CreateTrainingRequest;
import ru.evendot.runners.entities.requests.training.UpdateTrainingRequest;
import ru.evendot.runners.entities.trainings.Training;
import ru.evendot.runners.entities.users.User;
import ru.evendot.runners.exceptions.ResourceNotFoundException;
import ru.evendot.runners.repositories.training.TrainingRepository;
import ru.evendot.runners.services.positioning.RouteService;
import ru.evendot.runners.services.users.UserService;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class TrainingService implements ITrainingService {

    private final TrainingRepository trainingRepo;
    private final ModelMapper modelMapper;

    private final UserService userService;
    private final RouteService routeService;

    public Training saveTraining(CreateTrainingRequest req, Route route) {
        Training training = new Training();

//        Set<User> users = new HashSet<>();
//        for (Long userId : req.getUserIds()){
//            users.add(userService.getUserById(userId));
//        }
//        training.setUsers(users);
        User user = userService.getUserById(req.getUserId());
        training.setUser(user);
        training.setRoute(route);

        training.setCreationDate(req.getCreationDate());
        training.setCreationTime(req.getCreationTime());
        training.setEndingDate(req.getEndingDate());
        training.setEndingTime(req.getEndingTime());

        training.setNotes(req.getNotes());
        training.setDistance(req.getDistance());
        training.setDuration(Duration.between(req.getEndingTime(), req.getEndingTime()));
        training.setClimbing(req.getClimbing());
        training.setMaxHeight(req.getMaxHeight());
        training.setAveragePace(req.getAveragePace());
        trainingRepo.save(training);
        return training;
    }

    public Training getTraining(Long id) {
        return trainingRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Training with id " + id + " not found!"));
    }

    public Set<Training> getAllUserTrainings(Long userId){
        try{
            return trainingRepo.findByUser(userId);
        } catch (RuntimeException e){
            throw new ResourceNotFoundException("User with id " + userId + " not found!");
        }
    }

    public Training updateTraining(UpdateTrainingRequest req) {
        return trainingRepo.findById(req.getId()).map(existingTraining -> {
//            Set<User> users = new HashSet<>();
//            for (Long userId : req.getUserIds()){
//                users.add(userService.getUserById(userId));
//            }
//            existingTraining.setUsers(users);
            User user = userService.getUserById(req.getUserId());
            existingTraining.setUser(user);
            Route route = routeService.getRoute(req.getRoute().getId());
            route.setDescription(req.getRoute().getDescription());
            route.setName(req.getRoute().getName());
            route.setTraining(req.getRoute().getTraining());

            List<Point> points = new ArrayList<>();
            for (UpdatePointRequest pointReq : req.getRoute().getPoints()){
                Point point = new Point();
                point.setLatitude(pointReq.getLatitude());
                point.setLongitude(pointReq.getLongitude());
                point.setAltitude(pointReq.getAltitude());
                point.setTimestamp(pointReq.getTimestamp());
                point.setRoute(route);
                points.add(point);
            }
            route.setPoints(points);

            existingTraining.setRoute(route);

            existingTraining.setCreationDate(req.getCreationDate());
            existingTraining.setCreationTime(req.getCreationTime());
            existingTraining.setEndingDate(req.getEndingDate());
            existingTraining.setEndingTime(req.getEndingTime());

            existingTraining.setNotes(req.getNotes());
            existingTraining.setDistance(req.getDistance());
            existingTraining.setClimbing(req.getClimbing());
            existingTraining.setMaxHeight(req.getMaxHeight());
            existingTraining.setAveragePace(req.getAveragePace());
            return trainingRepo.save(existingTraining);
        }).orElseThrow(() -> new ResourceNotFoundException("Training with id " + req.getId() + "not found!"));
    }

    public void deleteTraining(Long id) {
        try {
            trainingRepo.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("Training with id " + id + " not found!");
        }
    }

    public TrainingDTO convertToTrainingDTO(Training training) {
        return modelMapper.map(training, TrainingDTO.class);
    }
}
