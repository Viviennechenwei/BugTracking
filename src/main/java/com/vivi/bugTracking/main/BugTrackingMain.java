package com.vivi.bugTracking.main;

import com.vivi.bugTracking.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BugTrackingMain {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("EmployeeController");
        boolean emps = employeeService.employeeVerfication("wc53057", "123456");
        System.out.println(emps);
    }

}
