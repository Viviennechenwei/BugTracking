package com.vivi.bugTracking.service;

import com.vivi.bugTracking.dao.mapper.RoleMapper;
import com.vivi.bugTracking.model.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class RoleService {

    private RoleMapper roleMapper;

    @Autowired
    public RoleService(RoleMapper roleMapper){
        this.roleMapper = roleMapper;
    }

    public Role getRoleForEmployee(String username) {
        return null;
    }

    public Set<Role> getAllRoles(){
        return roleMapper.selectAll();
    }
}
