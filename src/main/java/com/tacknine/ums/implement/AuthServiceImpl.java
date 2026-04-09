package com.tacknine.ums.implement;

import com.tacknine.ums.dto.AuthResponseDto;
import com.tacknine.ums.dto.LoginRequestDto;
import com.tacknine.ums.dto.UserRequestDto;
import com.tacknine.ums.dto.UserResponseDto;
import com.tacknine.ums.entity.User;
import com.tacknine.ums.mapper.UserMapper;
import com.tacknine.ums.repository.UserRepository;
import com.tacknine.ums.security.JwtUtil;
import com.tacknine.ums.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired private UserRepository userRepository;
    @Autowired private UserMapper userMapper;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JwtUtil jwtUtil;

    @Override
    public UserResponseDto register(UserRequestDto request) {
        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public AuthResponseDto login(LoginRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // Generate JWT using username and roles
        String token = jwtUtil.generateToken(user.getEmail(), List.of(user.getRole()));

        AuthResponseDto response = new AuthResponseDto();
        response.setToken(token);
        response.setRole(user.getRole());
        response.setEmail(user.getEmail());
        return response;
    }
}