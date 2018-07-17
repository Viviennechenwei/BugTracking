package com.vivi.bugTracking.model;

public class Employee {

    private String loginId;
    private String firstName;
    private String lastNam;
    private String passworod;

    public Employee() {
    }

    public Employee(String loginId, String passworod) {
        this.loginId = loginId;
        this.passworod = passworod;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNam() {
        return lastNam;
    }

    public void setLastNam(String lastNam) {
        this.lastNam = lastNam;
    }

    public String getPassworod() {
        return passworod;
    }

    public void setPassworod(String passworod) {
        this.passworod = passworod;
    }
}
