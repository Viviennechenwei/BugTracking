package com.vivi.bugTracking.shiro;

import com.vivi.bugTracking.util.JWTUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.naming.AuthenticationException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
public class JwtFilter extends AccessControlFilter {

    private static String HEADER_PREFIX = "Bearer ";
    private static String JWT_TOKEN_HEADER_PARAM = "Authorization";

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader(JWT_TOKEN_HEADER_PARAM);
        log.info("auth: {}", authorization);
        if (StringUtils.isNotBlank(authorization) && authorization.length() > HEADER_PREFIX.length()) {
            String token = authorization.substring(HEADER_PREFIX.length());
            Claims claims = JWTUtil.parseToken(token);
            LocalDateTime expireTime = LocalDateTime.ofInstant(claims.getExpiration().toInstant(), ZoneId.systemDefault());
            if (claims.getExpiration() != null && LocalDateTime.now().isAfter(expireTime)) {
                throw new AuthenticationException("Token expired");
            }
            StatelessToken statelessToken = new StatelessToken(claims.getSubject(), token);
            try {
                getSubject(request, response).login(statelessToken);
                return true;
            } catch (Exception e) {
                log.error("Failed to login", e);
                loginFail(response);
                return false;
            }
        }
        return true;
    }


    private void loginFail(ServletResponse response) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }
}
