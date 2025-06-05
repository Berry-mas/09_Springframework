package com.ohgiraffers.practice.employee.model.dto;

public class EmployeeDTO {

    private int empId;
    private String empName;
    private String empNo;
    private String email;
    private String quitYn;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int empId, String empName, String empNo, String email, String quitYn) {
        this.empId = empId;
        this.empName = empName;
        this.empNo = empNo;
        this.email = email;
        this.quitYn = quitYn;
    }

    public String getQuitYn() {
        return quitYn;
    }

    public void setQuitYn(String quitYn) {
        this.quitYn = quitYn;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empNo='" + empNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
