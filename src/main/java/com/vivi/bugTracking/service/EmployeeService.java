package com.vivi.bugTracking.service;

import com.vivi.bugTracking.dao.mapper.EmployeeMapper;
import com.vivi.bugTracking.model.Employee;
import com.vivi.bugTracking.model.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {

    private EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public Optional<Employee> getUserByLoginId(String loginId) {
        return Optional.ofNullable(employeeMapper.selectByLoginId(loginId));
    }

    public Optional<Employee> getUserById(int id) {
        return Optional.ofNullable(employeeMapper.selectById(id));
    }


    public PageBean<Employee> getEmployee(String nameFilter, int pageIndex, int pageSize, String sortOrder) {
        if(nameFilter==null){
            nameFilter="";
        }
        int total = count(nameFilter);
        pageSize = pageSize == 0 ? total : pageSize;//if not set, get all
        PageBean<Employee> employeePage = new PageBean<>(pageIndex, pageSize, total);
        if (total > 0) {
            List<Employee> employeeList = employeeMapper.selectRange(nameFilter, employeePage.startIndex(), employeePage.getPageSize(), sortOrder);
            employeePage.setData(employeeList);
        }
        return employeePage;
    }


    public int count(String nameFilter) {
        return employeeMapper.count(nameFilter);
    }

    public Employee addEmployee(Employee employee) {
        log.info("add employee");
        employeeMapper.createEmployee(employee);
        return employeeMapper.selectById(employee.getId());
    }

    public Employee updateEmployee(Employee employee) {
        Employee old = employeeMapper.selectById(employee.getId());
        if (old == null) {
            return addEmployee(employee);
        } else {
            employeeMapper.updateEmployee(employee);
            return employeeMapper.selectById(employee.getId());
        }
    }
}
