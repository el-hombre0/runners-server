package ru.evendot.runners.entities.requests.users;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import ru.evendot.runners.entities.entertainment.Club;
import ru.evendot.runners.entities.entertainment.Post;
import ru.evendot.runners.entities.users.Image;
import ru.evendot.runners.entities.users.User;

import java.util.List;

public class CreateUserRequest {
    private Long id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String password;

    @ManyToMany
    private List<User> friends;

    @ManyToMany
    private List<Club> clubsParticipation;

    private String bio;

    @OneToMany(mappedBy = "user")
    private List<Image> images;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    private boolean isActive;
}
