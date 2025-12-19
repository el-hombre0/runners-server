package ru.evendot.runners.DTOs.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.evendot.runners.DTOs.entertainment.ClubDTO;
import ru.evendot.runners.DTOs.entertainment.PostDTO;
import ru.evendot.runners.entities.users.Role;

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
    private Set<UserDTO> friends;
    private Set<ClubDTO> clubsParticipation;
    private String bio;
    private List<ImageDTO> images;
    private List<PostDTO> posts;
    private Boolean isActive;
    private Role role;
//    @JsonIgnore
//    private Set<TrainingDTO> trainings;
}
