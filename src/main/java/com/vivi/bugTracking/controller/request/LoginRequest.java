package com.vivi.bugTracking.controller.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String loginId;

    private String password;
}
