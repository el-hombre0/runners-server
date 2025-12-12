package ru.evendot.runners.services.users;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.evendot.runners.entities.requests.users.CreateUserRequest;
import ru.evendot.runners.entities.requests.users.UserUpdateRequest;
import ru.evendot.runners.entities.users.User;

public interface IUserService extends UserDetailsService {
    User createUser(UserDTO userDTO);
    User getUserById(Long id);
    User updateUser(Long id, UserUpdateRequest userUpdateReq);
    void deleteUser(Long id);
    void blockUser(Long id);
}
