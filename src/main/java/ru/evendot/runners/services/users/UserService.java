package ru.evendot.runners.services.users;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.evendot.runners.DTOs.users.UserDTO;
import ru.evendot.runners.entities.requests.users.CreateUserRequest;
import ru.evendot.runners.entities.requests.users.UserUpdateRequest;
import ru.evendot.runners.entities.users.Role;
import ru.evendot.runners.entities.users.User;
import ru.evendot.runners.exceptions.ResourceNotFoundException;
import ru.evendot.runners.repositories.users.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepo;
    private final ModelMapper modelMapper;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }

    @Override
    public User createUser(CreateUserRequest req) {
        User user = new User();
        user.setFirstname(req.getFirstname());
        user.setLastname(req.getLastname());
        user.setPhoneNumber(req.getPhoneNumber());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        user.setFriends(null);
        user.setClubsParticipation(null);
        user.setBio(req.getBio());
        user.setImages(req.getImages());
        user.setPosts(null);
        user.setIsActive(true);
        user.setRole(Role.USER);
        user.setTrainings(null);
        userRepo.save(user);
        return user;
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found!"));
    }

    @Override
    public User updateUser(UserUpdateRequest req) {
        return userRepo.findById(req.getId()).map((existingUser) -> {
            existingUser.setFirstname(req.getFirstname());
            existingUser.setLastname(req.getLastname());
            existingUser.setPhoneNumber(req.getPhoneNumber());
            existingUser.setEmail(req.getEmail());
            existingUser.setPassword(req.getPassword());
            existingUser.setBio(req.getBio());
            existingUser.setImages(req.getImages());
            return userRepo.save(existingUser);
        }).orElseThrow(() -> new ResourceNotFoundException("User with id " + req.getId() + " not found!"));
    }

    @Override
    public void deleteUser(Long id) {
        try {
            userRepo.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("User with id " + id + "not found!");
        }
    }

    @Override
    public void blockUser(Long id) {
        userRepo.findById(id).map((existingUser) -> {
            existingUser.setIsActive(false);
            return existingUser;
        }).orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found!"));
    }

    private User createComplexUserObject(UserDTO userDTO) {
        User user = new User();
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFriends(userDTO.getFriends());
        user.setClubsParticipation(userDTO.getClubsParticipation());
        user.setBio(userDTO.getBio());
        user.setImages(userDTO.getImages());
        user.setPosts(userDTO.getPosts());
        user.setIsActive(true);
        user.setRole(Role.USER);
        return user;
    }

    public User updateUserRole(Long id, Role role) {
        return userRepo.findById(id).map(existingUser -> {
            existingUser.setRole(role);
            return existingUser;
        }).orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found!"));
    }

    public UserDTO convertToUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

}
