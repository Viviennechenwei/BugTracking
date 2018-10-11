package com.vivi.bugTracking.controller;

import com.vivi.bugTracking.exception.DataException;
import com.vivi.bugTracking.model.Employee;
import com.vivi.bugTracking.model.PageBean;
import com.vivi.bugTracking.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//https://www.jianshu.com/p/f37f8c295057
@Slf4j
@Api(value = "Employee Service")
@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ApiOperation(value = "Get Employee", notes = "Get a list of employees", response = EmployeeController.class)
    @GetMapping()
    @RequiresPermissions(value = "employee:read")
    public ResponseEntity<PageBean<Employee>> getEmployees(@RequestParam(value = "filter", required = false) String filter, @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                                                           @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestParam(value = "sortOrder", required = false) String sortOrder) {
        log.info("get employee, filter: {}", filter);
        try {
            int pageIdx = pageIndex == null ? 1 : pageIndex;
            int size = pageSize == null ? 10 : pageSize;
            PageBean<Employee> employee = employeeService.getEmployee(filter, pageIdx, size, sortOrder);
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            throw new DataException("Can not get employee data", e, DataException.EMPLOYEE);
        }
    }

    @ApiOperation(value = "Create Employee", notes = "Creation of a new Employee", response = EmployeeController.class)
    @PostMapping
    @RequiresPermissions(value = "employee:create")
    public Employee addEmployee(@RequestBody @ModelAttribute("employee") Employee employee) {
        log.info("create employee id: {}", employee);
        try {
            return employeeService.addEmployee(employee);
        } catch (Exception e) {
            log.error("Failed to create new employee {}", employee, e);
            throw new DataException("Failed to create new employee", e, DataException.EMPLOYEE);
        }
    }

    @PutMapping("/{id}")
    @RequiresPermissions(value = "employee:update")
    public Employee updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        log.info("update employee id: {}, employee: {}", id, employee);
        employee.setPassword("123456");
        return employeeService.updateEmployee(employee);
    }
}
