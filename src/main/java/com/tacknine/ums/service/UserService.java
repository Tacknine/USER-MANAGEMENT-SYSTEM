package com.tacknine.ums.service;

import com.tacknine.ums.dto.UserRequestDto;
import com.tacknine.ums.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto createUser(UserRequestDto request);
    UserResponseDto updateUser(Long id, UserRequestDto request);
    UserResponseDto getUserById(Long id);
    boolean deleteUserById(Long id);
    UserResponseDto getUserByAge(Integer age);
}
