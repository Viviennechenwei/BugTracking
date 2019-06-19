package com.vivi.bugTracking.shiro;

import com.vivi.bugTracking.model.Employee;
import com.vivi.bugTracking.model.Permission;
import com.vivi.bugTracking.model.Role;
import com.vivi.bugTracking.service.EmployeeService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Getter
@Setter
@Component
public class EmployeeRealm extends AuthorizingRealm {

    public static final String SESSION_USER_KEY = "employee";

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRealm(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("do authorization [{}]", principals.toString());
//        String username = (String) getAvailablePrincipal(principals);
        Employee employee = (Employee) SecurityUtils.getSubject().getSession().getAttribute(SESSION_USER_KEY);
        Role role = employee.getRole();
        Set<Permission> permissions = role.getPermissions();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole(role.getName());
        authorizationInfo.addStringPermissions(permissions.stream()
                .map(permission -> permission.getResourceName() + ":" + permission.getActionName())
                .collect(Collectors.toSet()));
        return authorizationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("do authentication [{}]", token);
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        if (usernamePasswordToken.getUsername() == null) {
            throw new AccountException("Null user name are not allowed by this realm.");
        }
        Optional<Employee> employee = employeeService.getUserByLoginId(usernamePasswordToken.getUsername());
        return employee.map(e -> {
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute(SESSION_USER_KEY, e);
            session.setTimeout(30 * 60 * 1000);//30 minutes
//            return new SimpleAuthenticationInfo(token.getPrincipal(), e.getPassword(), getResourceName()); //???
            return new SimpleAuthenticationInfo(e.getLoginId(), e.getPassword(), getName());

        }).orElse(null);
    }
}
