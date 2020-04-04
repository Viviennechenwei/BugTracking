package com.vivi.bugTracking.shiro;

import com.vivi.bugTracking.service.EmployeeService;
import com.vivi.bugTracking.util.JWTUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class StatelessRealm extends AuthorizingRealm {

    private EmployeeService employeeService;

    @Autowired
    public StatelessRealm(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof StatelessToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String token = (String) principals.getPrimaryPrincipal();//get token again to extract permissions
        Claims claims = JWTUtil.parseToken(token);
        List<String> permissions = (List<String>) claims.get("permissions");
        String roleName = (String) claims.get("role");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole(roleName);
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        StatelessToken statelessToken = (StatelessToken) token;
        String loginId = (String) statelessToken.getLoginId();
        //check user exist
        return employeeService.getUserByLoginId(loginId)
                //pass token to extract permission from in later stage
                .map(employee -> new SimpleAuthenticationInfo(statelessToken.getToken(), statelessToken.getToken(), getName()))
                .orElseThrow(UnknownAccountException::new);
    }
}
