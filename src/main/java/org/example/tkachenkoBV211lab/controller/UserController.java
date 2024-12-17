package org.example.tkachenkoBV211lab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.tkachenkoBV211lab.dto.UserDto;
import org.example.tkachenkoBV211lab.entity.User;
import org.example.tkachenkoBV211lab.service.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // create User (C)
    @Operation(summary = "Create user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))})
    })

    @PostMapping
    public UserDto createUser(@RequestParam("fullName") String fullName,
                              @RequestParam("birthDate") LocalDate birthDate,
                              @RequestParam("workplace") String workplace) {
        return userService.createUser(fullName, birthDate, workplace);
    }

    // Find user by ID (R)
    @Operation(summary = "Find user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User founded",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))})
    })

    @GetMapping("/{id}")
    public UserDto getUserById(@Parameter(description = "user ID") @PathVariable("id") Long id) {
        return userService.getUserByIdDto(id);
    }

    // get all users
    @Operation(summary = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all users",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))})
    })
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // update user (U)
    @Operation(summary = "Update user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))})
    })

    @PatchMapping("/{id}")
    public UserDto updateUser(@PathVariable("id") Long id, @RequestParam("fullName") String fullName,
                              @RequestParam("workplace") String workplace) {
        return userService.updateUser(id, fullName, workplace);
    }

    // delete user (D)
    @Operation(summary = "Delete user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))})
    })

    @DeleteMapping("/{id}")
    public User deleteUser(@Parameter(description = "user ID") @PathVariable("id") Long id) {
        userService.deleteUser(id);
        return null;
    }
}
