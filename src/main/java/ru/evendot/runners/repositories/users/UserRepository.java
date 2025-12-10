package ru.evendot.runners.repositories.users;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.evendot.runners.entities.users.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
