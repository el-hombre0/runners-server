package ru.evendot.runners.controllers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evendot.runners.DTOs.users.UserDTO;
import ru.evendot.runners.entities.responses.DataResponse;
import ru.evendot.runners.entities.users.Role;
import ru.evendot.runners.entities.users.User;
import ru.evendot.runners.exceptions.ResourceNotFoundException;
import ru.evendot.runners.services.users.UserService;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<DataResponse> createUser(@RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO);
        UserDTO createdUserDTO = userService.convertToUserDTO(user);
        return ResponseEntity.ok().body(new DataResponse("User created successfully!", userDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse> getUser(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);
            UserDTO userDTO = userService.convertToUserDTO(user);
            return ResponseEntity.ok().body(new DataResponse("User found successfully!", userDTO));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DataResponse("User not found!", e.getMessage()));
        }
    }

    @PutMapping("/")
    public ResponseEntity<DataResponse> updateUser(@RequestBody UserDTO userDTO) {
        try {
            User user = userService.updateUser(userDTO);
            UserDTO updatedUserDTO = userService.convertToUserDTO(user);
            return ResponseEntity.ok().body(new DataResponse("User updated successfully!", updatedUserDTO));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DataResponse("User with id " + userDTO.getId() + " not found!", e.getMessage()));
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<DataResponse> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok().body(new DataResponse("User deleted successfully!", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DataResponse("User with id " + id + " not found!", e.getMessage()));
        }
    }

    @PatchMapping("/update-role/{id}")
    public ResponseEntity<DataResponse> updateUserRole(@PathVariable Long id, @RequestParam Role role) {
        try {
            userService.updateUserRole(id, role);
            User user = userService.getUserById(id);
            UserDTO userDTO = userService.convertToUserDTO(user);
            return ResponseEntity.ok().body(new DataResponse("User role updated successfully!", userDTO));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DataResponse("User with id " + id + " not found!", e.getMessage()));
        }
    }

}
