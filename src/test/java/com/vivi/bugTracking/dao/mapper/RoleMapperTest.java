package com.vivi.bugTracking.dao.mapper;

import com.vivi.bugTracking.model.Department;
import com.vivi.bugTracking.model.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:db-test-unit.xml"
})
public class RoleMapperTest {

    @Autowired
    RoleMapper roleMapper;

    @Test
    public void testSelectByLoginId() {
        assertNotNull(roleMapper);
        Set<Role> roles = roleMapper.selectAll();
        assertNotNull(roles);
    }
}