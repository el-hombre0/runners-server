package ru.evendot.runners.services.users;

//import org.springframework.security.core.userdetails.UserDetailsService;
import ru.evendot.runners.DTOs.users.UserDTO;
import ru.evendot.runners.entities.requests.users.CreateUserRequest;
import ru.evendot.runners.entities.requests.users.UserUpdateRequest;
import ru.evendot.runners.entities.users.Role;
import ru.evendot.runners.entities.users.User;

public interface IUserService {
    User createUser(CreateUserRequest req);
    User getUserById(Long id);
    User updateUser(UserUpdateRequest req);
    void deleteUser(Long id);
    void blockUser(Long id);
    User updateUserRole(Long id, Role role);
    UserDTO convertToUserDTO(User user);
}
