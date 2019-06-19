package com.vivi.bugTracking.dao.mapper;

import com.vivi.bugTracking.model.Department;
import com.vivi.bugTracking.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface DeptMapper {
    Set<Department> selectAll();
}
