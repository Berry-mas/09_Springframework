package com.ohgiraffers.practice.employee.model.dto;

import java.time.LocalDateTime;

public class EmployeeDTO {
    private int empId;
    private String empName;
    private String email;
    private String phone;
    private LocalDateTime hireDate;
    private LocalDateTime quitDate;
    private char quitYN;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int empId, String empName, String email, String phone,
                       LocalDateTime hireDate, LocalDateTime quitDate, char quitYN) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.phone = phone;
        this.hireDate = hireDate;
        this.quitDate = quitDate;
        this.quitYN = quitYN;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDateTime getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(LocalDateTime quitDate) {
        this.quitDate = quitDate;
    }

    public char getQuitYN() {
        return quitYN;
    }

    public void setQuitYN(char quitYN) {
        this.quitYN = quitYN;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", hireDate=" + hireDate +
                ", quitDate=" + quitDate +
                ", quitYN=" + quitYN +
                '}';
    }
}
