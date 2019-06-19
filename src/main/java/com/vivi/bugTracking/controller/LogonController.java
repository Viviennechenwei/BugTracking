package com.vivi.bugTracking.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class LogonController {

    @GetMapping
    public String loginPage() {
        return "login";
    }

    @PostMapping("loginSubmit")
    public String login(@RequestParam(value = "loginId") String loginId,
                        @RequestParam(value = "password") String password) {
        log.info("log on user: {}", loginId);
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(loginId, password);
            subject.login(token);
        }
        return "home";
    }
}
