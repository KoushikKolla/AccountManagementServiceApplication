package com.example.accountManagementService.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime timestamp;
    private String errorCode;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(LocalDateTime timestamp,
                         String errorCode,
                         String message) {
        this.timestamp = timestamp;
        this.errorCode = errorCode;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}