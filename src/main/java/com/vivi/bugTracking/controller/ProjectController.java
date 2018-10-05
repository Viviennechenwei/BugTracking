package com.vivi.bugTracking.controller;

import com.vivi.bugTracking.model.Project;
import com.vivi.bugTracking.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//https://www.jianshu.com/p/f37f8c295057
@Slf4j
@RestController
@RequestMapping(path = "/api/projects")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @DeleteMapping("/{id}")
    @RequiresPermissions(value = "project:delete")
    public Project deleteProject(@PathVariable("id") int id) {
        log.info("delete project id: {}", id);
        return new Project();
    }
}
