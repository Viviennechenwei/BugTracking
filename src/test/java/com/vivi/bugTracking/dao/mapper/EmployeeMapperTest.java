package com.vivi.bugTracking.dao.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
        "classpath*:db-test-unit.xml"
})
public class EmployeeMapperTest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void TestselectByLoginId() {
        assertNotNull(employeeMapper);
        assertNotNull(employeeMapper.selectAll());
        assertNotNull(employeeMapper.selectByLoginId("root"));
    }
}