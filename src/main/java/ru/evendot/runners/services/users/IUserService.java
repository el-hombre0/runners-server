package ru.evendot.runners.services.users;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.evendot.runners.DTOs.users.UserDTO;
import ru.evendot.runners.entities.users.Role;
import ru.evendot.runners.entities.users.User;

public interface IUserService extends UserDetailsService {
    User createUser(UserDTO userDTO);
    User getUserById(Long id);
    User updateUser(UserDTO userDTO);
    void deleteUser(Long id);
    void blockUser(Long id);
    User updateUserRole(Long id, Role role);
    UserDTO convertToUserDTO(User user);
}
