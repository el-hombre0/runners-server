package ru.evendot.runners.DTOs.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.evendot.runners.entities.entertainment.Club;
import ru.evendot.runners.entities.entertainment.Post;
import ru.evendot.runners.entities.users.Image;
import ru.evendot.runners.entities.users.Role;
import ru.evendot.runners.entities.users.User;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String password;
    private Set<User> friends;
    private Set<Club> clubsParticipation;
    private String bio;
    private List<Image> images;
    private List<Post> posts;
    private Boolean isActive;
    private Role role;
}
