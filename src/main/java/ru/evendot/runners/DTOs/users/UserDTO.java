package ru.evendot.runners.DTOs.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.evendot.runners.entities.entertainment.Club;
import ru.evendot.runners.entities.entertainment.Post;
import ru.evendot.runners.entities.users.Image;
import ru.evendot.runners.entities.users.User;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String password;
    private List<User> friends;
    private List<Club> clubsParticipation;
    private String bio;
    private List<Image> images;
    private List<Post> posts;
    private boolean isActive;
}
