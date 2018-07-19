package com.vivi.bugTracking.dao;

import com.vivi.bugTracking.model.Employee;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;


public class EmployeeDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDao.class);

    public List<String> getEmpNumber() {
        String sql = "select emp_code from employee";
        List<String> res = jdbcTemplate.queryForList(sql, String.class);
        return res;
    }

    public boolean verfication(String userName, String password) {
        Map<String, Object> params = new HashMap<String, Object>();
        String queryEmp = "select f_name, l_name from employee where login_id = :userName and password = :password";
        params.put("userName", userName);
        params.put("password", password);
        try{
            Employee e = namedParameterJdbcTemplate.queryForObject(queryEmp, params,new RowMapper<Employee>() {
                public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Employee employee = new Employee();
                    employee.setFirstName(rs.getString("f_name"));
                    employee.setLastNam(rs.getString("l_name"));
                    return employee;
                }

            });
            return e!=null;
        }catch(IncorrectResultSizeDataAccessException e) {
            System.out.println("no employee or multi emplee" + e);
            return false;
        }
    }
}
