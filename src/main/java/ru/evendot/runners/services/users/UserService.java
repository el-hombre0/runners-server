package ru.evendot.runners.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.evendot.runners.entities.requests.users.CreateUserRequest;
import ru.evendot.runners.entities.requests.users.UserUpdateRequest;
import ru.evendot.runners.entities.users.User;
import ru.evendot.runners.repositories.users.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public User createUser(CreateUserRequest userDTO) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User updateUser(Long id, UserUpdateRequest userUpdateReq) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public void blockUser(Long id) {

    }
}
