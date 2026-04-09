package com.tacknine.ums.exception;

import com.tacknine.ums.Response.ApiResponse;
import com.tacknine.ums.Response.ApiResponseBuilder;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Hidden
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Resource not found with custom code 4040
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(
                ApiResponseBuilder.error(ex.getMessage(), 4040, HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND
        );
    }

    // Validation errors with custom code 4001
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse<?>> handleValidation(ValidationException ex) {
        return new ResponseEntity<>(
                ApiResponseBuilder.error(ex.getMessage(), 4001, HttpStatus.BAD_REQUEST),
                HttpStatus.BAD_REQUEST
        );
    }

    // All other exceptions with custom code 5000
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGeneral(Exception ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(
                ApiResponseBuilder.error("Internal server error", 5000, HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}