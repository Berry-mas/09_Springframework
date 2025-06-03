package com.ohgiraffers.practice.employee.model.dto;

public class EmployeeDTO {
    private int empId;
    private String empName;
    private String empNo;
    private String email;
    private int phone;
    private String deptCode;
    private String jobCode;
    private String salLevel;
    private int salary;
    private float bonus;
    private String hireDate;
    private String quitDate;
    private boolean quitYn;
    private int managerId;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int empId, String empName, String empNo, String email, int phone,
                       String deptCode, String jobCode, String salLevel, int salary, float bonus,
                       String hireDate, String quitDate, boolean quitYn) {
        this.empId = empId;
        this.empName = empName;
        this.empNo = empNo;
        this.email = email;
        this.phone = phone;
        this.deptCode = deptCode;
        this.jobCode = jobCode;
        this.salLevel = salLevel;
        this.salary = salary;
        this.bonus = bonus;
        this.hireDate = hireDate;
        this.quitDate = quitDate;
        this.quitYn = quitYn;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public float getBouns() {
        return bonus;
    }

    public void setBouns(float bouns) {
        this.bonus = bouns;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(String quitDate) {
        this.quitDate = quitDate;
    }

    public boolean isQuitYn() {
        return quitYn;
    }

    public void setQuitYn(boolean quitYn) {
        this.quitYn = quitYn;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getSalLevel() {
        return salLevel;
    }

    public void setSalLevel(String salLevel) {
        this.salLevel = salLevel;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empNo='" + empNo + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", deptCode='" + deptCode + '\'' +
                ", jobCode='" + jobCode + '\'' +
                ", salLevel='" + salLevel + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", hireDate='" + hireDate + '\'' +
                ", quitDate='" + quitDate + '\'' +
                ", quitYn=" + quitYn +
                ", managerId=" + managerId +
                '}';
    }
}
