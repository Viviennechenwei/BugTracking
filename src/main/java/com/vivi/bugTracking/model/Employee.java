package com.vivi.bugTracking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Employee {
    private int id;
    private String loginId;
    private String firstName;
    private String lastName;
    private char gender;
    private LocalDate birthDate;
    @JsonIgnore
    private String password;
    private String email;
    private Role role;
    private int deptId;

//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDateTime hireDate;

    public Employee() {
    }

    public Employee(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}

