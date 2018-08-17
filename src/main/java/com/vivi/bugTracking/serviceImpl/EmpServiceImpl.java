package com.vivi.bugTracking.serviceImpl;

import com.vivi.bugTracking.dao.EmpDao;
import com.vivi.bugTracking.exception.EmployeeException;
import com.vivi.bugTracking.model.Employee;
import com.vivi.bugTracking.service.EmpService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    EmpDao empDao;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmpServiceImpl.class);

    public Employee authenticat(String userCode, String password) throws EmployeeException {

        Employee employee = getEmployeebyUserCode(userCode);
        if (employee == null) {
            try {
                throw new EmployeeException("No employee");
            } catch (EmployeeException e) {
                logger.warn("No employee" + e.getMessage());
            }
        }
        //DB password
        String password_db = employee.getPassword();
        if (!password.equals(password_db)) {
            logger.warn("password wrong!");
            throw new EmployeeException("password wrong!!!");


        }
        return employee;
    }

    public Employee getEmployeebyUserCode(String userCode) {
            return empDao.getEmployeebyUserCode(userCode);
    }
}
