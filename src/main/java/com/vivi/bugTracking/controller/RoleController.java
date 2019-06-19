package com.vivi.bugTracking.controller;

import com.vivi.bugTracking.model.Role;
import com.vivi.bugTracking.service.DeptService;
import com.vivi.bugTracking.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@Api(value = "Role Service")
@RestController
@RequestMapping(path = "/api/roles")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @ApiOperation(value = "Get Roles", notes = "Get a list of roles", response = RoleController.class)
    @GetMapping()
    public ResponseEntity<Set<Role>> getDepartments() {
        log.info("get role");
        return ResponseEntity.ok(roleService.getAllRoles());
    }

}
