package com.vivi.bugTracking.dao;

import com.vivi.bugTracking.model.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpDao {

    public Employee getEmployeebyUserCode(@Param("userCode") String userCode);
}
