package com.vivi.bugTracking.service;

import com.vivi.bugTracking.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    public boolean employeeVerfication(String loginId, String password) {

        return employeeDao.verfication(loginId, password);
    }
}
