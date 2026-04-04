package com.tacknine.ums.service;

import com.tacknine.ums.dto.UserRequestDto;
import com.tacknine.ums.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();

    UserResponseDto CreateUser(UserRequestDto request);

    UserResponseDto UpdateUser(UserRequestDto  request);
    UserResponseDto getUserById(Long id);

    UserResponseDto GetUserById(Long id);

    void DeleteUserById(Long id);


    UserResponseDto createUser(UserRequestDto request);
}
