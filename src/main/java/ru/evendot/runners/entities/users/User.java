package ru.evendot.runners.entities.users;

import jakarta.persistence.*;
import lombok.Data;
import ru.evendot.runners.entities.entertainment.Club;
import ru.evendot.runners.entities.entertainment.Post;

import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<User> friends;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Club> clubsParticipation;

    private String bio;

    @OneToMany(mappedBy = "user")
    private List<Image> images;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    private Boolean isActive;

    private Role role;

}

