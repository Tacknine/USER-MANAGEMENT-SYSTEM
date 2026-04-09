package com.tacknine.ums.service;

import com.tacknine.ums.dto.AuthResponseDto;
import com.tacknine.ums.dto.LoginRequestDto;
import com.tacknine.ums.dto.UserRequestDto;
import com.tacknine.ums.dto.UserResponseDto;

public interface AuthService {

    UserResponseDto register(UserRequestDto request);

    AuthResponseDto login(LoginRequestDto request);

}
