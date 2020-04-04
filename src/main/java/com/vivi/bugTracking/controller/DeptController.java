package com.vivi.bugTracking.controller;

import com.vivi.bugTracking.model.Department;
import com.vivi.bugTracking.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@Api(value = "Department Service")
@RestController
@RequestMapping(path = "/api/departments")
public class DeptController {

    private DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @ApiOperation(value = "Get Department", notes = "Get a list of departments", response = DeptController.class)
    @GetMapping()
    public ResponseEntity<Set<Department>> getDepartments() {
        log.info("get departments");
        return ResponseEntity.ok(deptService.getAllDepts());
    }

}
