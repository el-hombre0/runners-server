package ru.evendot.runners.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evendot.runners.entities.users.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
