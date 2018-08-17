package com.vivi.bugTracking.service;

import com.vivi.bugTracking.exception.EmployeeException;
import com.vivi.bugTracking.model.Employee;

public interface EmpService {
    public Employee authenticat(String userCode, String password) throws EmployeeException;

    public Employee getEmployeebyUserCode(String userCode);

}
