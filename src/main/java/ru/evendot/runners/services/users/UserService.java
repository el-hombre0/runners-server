package ru.evendot.runners.services.users;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.evendot.runners.DTOs.users.UserDTO;
import ru.evendot.runners.entities.users.Role;
import ru.evendot.runners.entities.users.User;
import ru.evendot.runners.exceptions.ResourceNotFoundException;
import ru.evendot.runners.repositories.users.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepo;
    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public User createUser(UserDTO userDTO) {
        User user = createComplexUserObject(userDTO);
        userRepo.save(user);
        return user;
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id " + id + "not found!"));
    }

    @Override
    public User updateUser(UserDTO userDTO) {
        return userRepo.findById(userDTO.getId()).map((existingUser) -> {
            existingUser = createComplexUserObject(userDTO);
            return existingUser;
        }).orElseThrow(() -> new ResourceNotFoundException("User with id " + userDTO.getId() + " not found!"));
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

    public User updateUserRole(Long id, Role role){
        return userRepo.findById(id).map(existingUser -> {
            existingUser.setRole(role);
            return existingUser;
        }).orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found!"));
    }

    public UserDTO convertToUserDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }

}
