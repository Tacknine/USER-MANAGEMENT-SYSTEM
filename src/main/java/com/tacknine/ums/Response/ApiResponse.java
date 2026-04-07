package com.tacknine.ums.Response;

public class ApiResponse<T> {

    private String message;
    private T data;
    private boolean success;
    private int statusCode;
    private String httpStatus; // Badala ya HttpStatus object

    public ApiResponse() {}

    public ApiResponse(String message, T data, boolean success, int statusCode, String httpStatus) {
        this.message = message;
        this.data = data;
        this.success = success;
        this.statusCode = statusCode;
        this.httpStatus = httpStatus;
    }

    // Getters & Setters
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public int getStatusCode() { return statusCode; }
    public void setStatusCode(int statusCode) { this.statusCode = statusCode; }

    public String getHttpStatus() { return httpStatus; }
    public void setHttpStatus(String httpStatus) { this.httpStatus = httpStatus; }
} 