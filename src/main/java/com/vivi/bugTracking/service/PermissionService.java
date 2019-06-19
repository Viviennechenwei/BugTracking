package com.vivi.bugTracking.service;

import com.vivi.bugTracking.model.Permission;
import com.vivi.bugTracking.model.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class PermissionService {
    public Set<Permission> getPermissionsForRole(Role roles) {
        return null;
    }
}
