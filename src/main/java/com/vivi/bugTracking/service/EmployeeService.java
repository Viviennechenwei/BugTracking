package com.vivi.bugTracking.service;

import com.vivi.bugTracking.dao.LoginVerfication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    LoginVerfication loginVerfication;

    public boolean employeeVerfication(String loginId, String password) {

        return loginVerfication.verfication(loginId, password);
    }
}
