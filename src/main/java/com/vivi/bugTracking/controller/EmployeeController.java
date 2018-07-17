package com.vivi.bugTracking.controller;

import com.vivi.bugTracking.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping(value = "/getEmpCode", method = RequestMethod.GET)
    public ModelAndView getEmpNumber() {
        //1. call service
        List<String> empList = employeeDao.getEmpNumber();
        //2. prepare model(data to display on page) and view (where the data will be displayed)
        ModelAndView modelAndView = new ModelAndView();
        //2.1 set page name (hello.jsp)
        modelAndView.setViewName("hello");
        //2.2 set data to display  (hello.jsp: ${employees})
        modelAndView.addObject("employees", empList);
        //3. return to viewresolver(springmvc-servlet.xml/internalResourceViewResolver)  to resolve page
        return modelAndView;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        System.out.println("hello-----------------");
        return "hello";
    }

}
