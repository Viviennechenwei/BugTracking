package com.vivi.bugTracking.dao.mapper;

import com.vivi.bugTracking.model.Permission;

import java.util.Set;

public interface PermissionMapper {
    public Set<Permission> selectPermissionByRoleId(int roleId);
}
