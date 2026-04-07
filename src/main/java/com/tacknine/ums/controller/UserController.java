package com.tacknine.ums.controller;

import com.tacknine.ums.dto.UserRequestDto;
import com.tacknine.ums.dto.UserResponseDto;
import com.tacknine.ums.Response.ApiResponse;
import com.tacknine.ums.Response.ApiResponseBuilder;
import com.tacknine.ums.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE USER
    @PostMapping
    public ApiResponse<UserResponseDto> createUser(@RequestBody UserRequestDto request) {
        UserResponseDto user = userService.createUser(request);
        return ApiResponseBuilder.success("User created successfully", user, HttpStatus.CREATED);
    }

    // GET ALL USERS
    @GetMapping
    public ApiResponse<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = userService.getAllUsers();
        if (users != null && !users.isEmpty()) {
            return ApiResponseBuilder.success("Users fetched successfully", users, HttpStatus.OK);
        } else {
            return ApiResponseBuilder.success("No users found", users, HttpStatus.OK);
        }
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public ApiResponse<UserResponseDto> getUserById(@PathVariable Long id) {
        UserResponseDto user = userService.getUserById(id);
        if (user != null) {
            return ApiResponseBuilder.success("User fetched successfully", user, HttpStatus.OK);
        } else {
            // Custom code 4040
            return ApiResponseBuilder.error("User not found", 4040, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/age")
    public ApiResponse<UserResponseDto> getUserByAge(@PathVariable Integer age) {
        UserResponseDto user = userService.getUserByAge(age);
        if (user != null) {
            return ApiResponseBuilder.success("User fetched successfully", user, HttpStatus.OK);
        }
        else {
            return ApiResponseBuilder.error("User not found", 4040, HttpStatus.NOT_FOUND);
        }
    }


    // DELETE USER
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUserById(id);
        if (deleted) {
            return ApiResponseBuilder.success("User deleted successfully", null, HttpStatus.OK);
        } else {
            // Custom code 4040
            return ApiResponseBuilder.error("User not found", 4040, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponseDto> updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDto request) {

        UserResponseDto updatedUser = userService.updateUser(id, request);

        return ApiResponseBuilder.success("User updated successfully", updatedUser, HttpStatus.OK);
    }
}