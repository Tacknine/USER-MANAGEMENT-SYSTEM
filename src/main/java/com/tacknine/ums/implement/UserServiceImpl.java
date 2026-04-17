package com.tacknine.ums.implement;

import com.tacknine.ums.dto.UserRequestDto;
import com.tacknine.ums.dto.UserResponseDto;
import com.tacknine.ums.entity.User;
import com.tacknine.ums.exception.ResourceNotFoundException;
import com.tacknine.ums.mapper.UserMapper;
import com.tacknine.ums.repository.UserRepository;
import com.tacknine.ums.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper userMapper; // inject UserMapper

    public UserServiceImpl(UserRepository repository, UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    // Tafuta watu wote
    public List<UserResponseDto> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(userMapper::toDto) // use instance method
                .toList();
    }

    // Create user
    public UserResponseDto createUser(UserRequestDto request) {
        User user = userMapper.toEntity(request); // use injected mapper
        User savedUser = repository.save(user);
        return userMapper.toDto(savedUser);
    }


    @Override
    public UserResponseDto updateUserRole(Long id, String role) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        user.setRole(role); // admin anaweza kuweka ADMIN au USER
        repository.save(user);

        return userMapper.toDto(user);
    }


    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto request) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        // Sasisha taarifa za entity
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setAge(request.getAge());
        user.setSalary(request.getSalary());
        user.setRole(request.getRole());
        user.setPassword(userMapper.toEntity(request).getPassword());

        User savedUser = repository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return userMapper.toDto(user);
    }

    @Override
    public boolean deleteUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        repository.delete(user);
        return true;
    }

    @Override
    public void DeleteUserById(Long id) {
        //  optional duplicate, can remove
    }

    @Override
    public UserResponseDto getUserByAge(Integer age) {
        User user = repository.findByAge(age)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with age: " + age));
        return userMapper.toDto(user);
    }
}