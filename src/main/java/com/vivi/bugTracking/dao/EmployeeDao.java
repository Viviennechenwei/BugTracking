package com.vivi.bugTracking.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<String> getEmpNumber() {
        String sql = "select emp_code from employee";
        List<String> res = jdbcTemplate.queryForList(sql, String.class);
        return res;
    }
}
