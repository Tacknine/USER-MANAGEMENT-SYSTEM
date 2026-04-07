package com.tacknine.ums.Response;

import org.springframework.http.HttpStatus;

public class ApiResponseBuilder {

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("Success", data, true, 200, HttpStatus.OK.name());
    }

    public static <T> ApiResponse<T> success(String message, T data, HttpStatus status) {
        return new ApiResponse<>(message, data, true, status.value(), status.name());
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(message, null, false, 400, HttpStatus.BAD_REQUEST.name());
    }

    public static <T> ApiResponse<T> error(String message, HttpStatus status) {
        return new ApiResponse<>(message, null, false, status.value(), status.name());
    }

    public static <T> ApiResponse<T> error(String message, int customCode, HttpStatus status) {
        return new ApiResponse<>(message, null, false, customCode, status.name());
    }
}