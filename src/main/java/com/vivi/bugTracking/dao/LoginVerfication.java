package com.vivi.bugTracking.dao;

import com.vivi.bugTracking.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginVerfication {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public boolean verfication(String loginId, String password) {
        Map<String, Object> params = new HashMap<String, Object>();
        String queryEmp = "select 1 from employee where login_id = :loginId and password = :password";
        params.put("loginId", loginId);
        params.put("password", password);
        List<Employee> emps = namedParameterJdbcTemplate.query(queryEmp, params, new BeanPropertyRowMapper<Employee>(Employee.class));
        return emps.isEmpty();
    }
}
