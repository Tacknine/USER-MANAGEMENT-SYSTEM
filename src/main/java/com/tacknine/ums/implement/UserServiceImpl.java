package com.tacknine.ums.implement;

import com.tacknine.ums.dto.UserRequestDto;
import com.tacknine.ums.dto.UserResponseDto;
import com.tacknine.ums.entity.User;
import com.tacknine.ums.repository.UserRepository;
import com.tacknine.ums.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user->{
            UserResponseDto dto = new UserResponseDto(user);
            return dto;
        }
        ).toList();

    }

    @Override
    public UserResponseDto CreateUser(UserRequestDto request) {
        return null;
    }

    @Override
    public UserResponseDto UpdateUser(UserRequestDto request) {
        return null;
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        return null;
    }


    @Override
    public void DeleteUserById(Long id) {

    }
    @Override
    public UserResponseDto createUser(UserRequestDto request) {
       User user= this.userRepository.save(request.toUser());
       return new UserResponseDto(user);


    }}
