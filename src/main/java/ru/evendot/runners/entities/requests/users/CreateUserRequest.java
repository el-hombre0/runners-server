package ru.evendot.runners.entities.requests.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.evendot.runners.entities.users.Image;

import java.util.List;

@Data
@AllArgsConstructor
public class CreateUserRequest {
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String password;
    private String bio;
    private List<Image> images;
}
