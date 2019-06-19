package com.vivi.bugTracking.service;

import com.vivi.bugTracking.dao.mapper.DeptMapper;
import com.vivi.bugTracking.dao.mapper.EmployeeMapper;
import com.vivi.bugTracking.model.Department;
import com.vivi.bugTracking.model.Employee;
import com.vivi.bugTracking.model.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class DeptService {

    private DeptMapper deptMapper;

    @Autowired
    public DeptService(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    public Set<Department> getAllDepts() {
        return this.deptMapper.selectAll();
    }
}
