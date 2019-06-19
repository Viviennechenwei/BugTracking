package com.vivi.bugTracking.exception;

import lombok.Data;

@Data
public class ApiResponseMessage {
    private String code;
    private String message;

    public ApiResponseMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
