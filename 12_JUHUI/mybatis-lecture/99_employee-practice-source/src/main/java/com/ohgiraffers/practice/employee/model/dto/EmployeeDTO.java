package com.ohgiraffers.practice.employee.model.dto;

import java.time.LocalDateTime;

public class EmployeeDTO {
    private int emp_id;
    private String emp_name;
    private String emp_no;
    private String emp_email;// 내가 한 건 여기까지였음
    private String phone;
    private String deptCode;
    private String jobCode;
    private String salLevel;
    private double salary;
    private double bonus;
    private String managerId;
    private LocalDateTime hireDate;
    private LocalDateTime quitDate;
    private String quitYn;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int emp_id, String emp_name, String emp_no, String emp_email, String phone, String deptCode, String jobCode, String salLevel, double salary, double bonus, String managerId, LocalDateTime hireDate, LocalDateTime quitDate, String quitYn) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_no = emp_no;
        this.emp_email = emp_email;
        this.phone = phone;
        this.deptCode = deptCode;
        this.jobCode = jobCode;
        this.salLevel = salLevel;
        this.salary = salary;
        this.bonus = bonus;
        this.managerId = managerId;
        this.hireDate = hireDate;
        this.quitDate = quitDate;
        this.quitYn = quitYn;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getSalLevel() {
        return salLevel;
    }

    public void setSalLevel(String salLevel) {
        this.salLevel = salLevel;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
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

    public String getQuitYn() {
        return quitYn;
    }

    public void setQuitYn(String quitYn) {
        this.quitYn = quitYn;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_no='" + emp_no + '\'' +
                ", emp_email='" + emp_email + '\'' +
                ", phone='" + phone + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", jobCode='" + jobCode + '\'' +
                ", salLevel='" + salLevel + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", managerId='" + managerId + '\'' +
                ", hireDate=" + hireDate +
                ", quitDate=" + quitDate +
                ", quitYn='" + quitYn + '\'' +
                '}';
    }
}
