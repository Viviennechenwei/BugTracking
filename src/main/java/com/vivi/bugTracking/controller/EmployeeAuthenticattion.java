package com.vivi.bugTracking.controller;

import com.vivi.bugTracking.exception.EmployeeException;
import com.vivi.bugTracking.model.Employee;
import com.vivi.bugTracking.serviceImpl.EmpServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class EmployeeAuthenticattion {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeAuthenticattion.class);

    @Autowired
    EmpServiceImpl empServiceImpl;

    @RequestMapping("/")
    public ModelAndView GoToIndex(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("login");
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String userCode, String password) throws Exception {

        Employee employee = null;
        try {
            employee = empServiceImpl.authenticat(userCode, password);
        } catch (Exception e) {
            logger.error("password error!!!!");
            return "login";
        }

       // session.setAttribute("employee", employee);
        return "success";
    }
}
