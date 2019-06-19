package com.vivi.bugTracking.dao.mapper;

import com.vivi.bugTracking.model.Role;

import java.util.Set;

public interface RoleMapper {
    Set<Role> selectAll();
}
