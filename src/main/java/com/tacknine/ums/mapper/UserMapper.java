package com.tacknine.ums.mapper;

import com.tacknine.ums.dto.UserRequestDto;
import com.tacknine.ums.dto.UserResponseDto;
import com.tacknine.ums.entity.User;

public class UserMapper {
    public static User toEntity(UserRequestDto dto){
        User user = new User();
        user.setId(dto.getId());
        user.setSalary(dto.getSalary());
        user.setRole(dto.getRole());
        user.setAge(dto.getAge());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;

    }


    public static UserResponseDto toDto(User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setAge(user.getAge());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setSalary(user.getSalary());
        userResponseDto.setRole(user.getRole());
        return userResponseDto;

    }



}
