package com.tacknine.ums.controller;

import com.tacknine.ums.dto.UserRequestDto;
import com.tacknine.ums.dto.UserResponseDto;
import com.tacknine.ums.Response.ApiResponse;
import com.tacknine.ums.Response.ApiResponseBuilder;
import com.tacknine.ums.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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

    // CREATE USER → ADMIN ONLY
    @PostMapping
    public ApiResponse<UserResponseDto> createUser(@RequestBody UserRequestDto request,
                                                   Authentication auth) {
        if (!hasRole(auth, "ADMIN")) {
            return ApiResponseBuilder.error("Access denied", 403, HttpStatus.FORBIDDEN);
        }
        UserResponseDto user = userService.createUser(request);
        return ApiResponseBuilder.success("User created successfully", user, HttpStatus.CREATED);
    }

    // GET ALL USERS → ADMIN ONLY
    @GetMapping
    public ApiResponse<List<UserResponseDto>> getAllUsers(Authentication auth) {
        if (!hasRole(auth, "ADMIN")) {
            return ApiResponseBuilder.error("Access denied", 403, HttpStatus.FORBIDDEN);
        }
        List<UserResponseDto> users = userService.getAllUsers();
        return ApiResponseBuilder.success(
                users.isEmpty() ? "No users found" : "Users fetched successfully",
                users,
                HttpStatus.OK
        );
    }
    // GET USER BY ID → authenticated user can see their own profile or admin can see anyone
    @GetMapping("/{id}")
    public ApiResponse<UserResponseDto> getUserById(@PathVariable Long id, Authentication auth) {
        UserResponseDto user = userService.getUserById(id);
        String currentUserEmail = auth != null ? auth.getName() : null;

        if (!hasRole(auth, "ADMIN") && !user.getEmail().equals(currentUserEmail)) {
            return ApiResponseBuilder.error("Access denied", 403, HttpStatus.FORBIDDEN);
        }

        return ApiResponseBuilder.success("User fetched successfully", user, HttpStatus.OK);
    }



    @PutMapping("/{id}/role")
    @PreAuthorize("hasRole('ADMIN')") // ✅ Endpoint hii accessible tu kwa admin
    public ApiResponse<UserResponseDto> updateUserRole(
            @PathVariable Long id,
            @RequestParam String role) {

        UserResponseDto updatedUser = userService.updateUserRole(id, role);
        return ApiResponseBuilder.success(
                "User role updated successfully",
                updatedUser,
                HttpStatus.OK
        );
    }


        // GET USER BY AGE → ADMIN ONLY
    @GetMapping("/age")
    public ApiResponse<UserResponseDto> getUserByAge(@RequestParam Integer age, Authentication auth) {
        if (!hasRole(auth, "ADMIN")) {
            return ApiResponseBuilder.error("Access denied", 403, HttpStatus.FORBIDDEN);
        }

        UserResponseDto user = userService.getUserByAge(age);
        return ApiResponseBuilder.success("User fetched successfully", user, HttpStatus.OK);
    }

    // UPDATE USER → ADMIN ONLY
    @PutMapping("/{id}")
    public ApiResponse<UserResponseDto> updateUser(@PathVariable Long id,
                                                   @RequestBody UserRequestDto request,
                                                   Authentication auth) {
        if (!hasRole(auth, "ADMIN")) {
            return ApiResponseBuilder.error("Access denied", 403, HttpStatus.FORBIDDEN);
        }
        UserResponseDto updatedUser = userService.updateUser(id, request);
        return ApiResponseBuilder.success("User updated successfully", updatedUser, HttpStatus.OK);
    }

    // DELETE USER → ADMIN ONLY
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteUser(@PathVariable Long id, Authentication auth) {
        if (!hasRole(auth, "ADMIN")) {
            return ApiResponseBuilder.error("Access denied", 403, HttpStatus.FORBIDDEN);
        }
        userService.deleteUserById(id);
        return ApiResponseBuilder.success("User deleted successfully", null, HttpStatus.OK);
    }

    // Helper method to check user role
    private boolean hasRole(Authentication auth, String role) {
        if (auth == null || auth.getAuthorities() == null) return false;
        for (GrantedAuthority authority : auth.getAuthorities()) {
            if (authority.getAuthority().equals("ROLE"+ role)) return true;
        }
        return false;
    }
}