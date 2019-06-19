package com.vivi.bugTracking.controller;

import com.vivi.bugTracking.controller.request.LoginRequest;
import com.vivi.bugTracking.service.EmployeeService;
import com.vivi.bugTracking.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/auth/")
public class AuthController {
    private EmployeeService employeeService;

    @Autowired
    public AuthController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        log.info("auth with login: {}", loginRequest.getLoginId());
        return employeeService.getUserByLoginId(loginRequest.getLoginId())
                .map(employee -> {
                    if (Objects.equals(loginRequest.getPassword(), employee.getPassword())) {
                        Set<String> permissions = employee.getRole().getPermissions().stream().map(
                                p -> String.join(":", p.getResourceName(), p.getActionName())
                        ).collect(Collectors.toSet());
                        return ResponseEntity.ok(JWTUtil.createToken(loginRequest.getLoginId(), employee.getRole().getName(), permissions));
                    }
                    return ResponseEntity.status(401).body("");
                }).orElse(ResponseEntity.status(401).body(""));
    }

    @PostMapping("token")//??oldToken
    public Response refresh(@RequestParam(value = "oldToken") String oldToken) {
        return null;
    }
}
