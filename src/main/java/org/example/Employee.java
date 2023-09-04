package org.example;

import java.util.List;

public class Employee extends Staff {
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    private String hireDate;
    public Employee(String firstName, String lastName, String gender, int id, int salary, String hireDate) {
        super(firstName, lastName, gender, id);
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public static double getAvgSalaryMen(List<Staff> staffList) {
        int totalSalary = 0;
        int count = 0;

        for (Staff staff : staffList) {
            if (staff instanceof Employee) {
                Employee employee = (Employee) staff;
                if (employee.getGender() == "male") {
                    totalSalary += employee.salary;
                    count++;
                }
            }
        }
        return totalSalary / count;
    }

    public static double getAvgSalaryWomen(List<Staff> staffList) {
        int totalSalary = 0;
        int count = 0;

        for (Staff staff : staffList) {
            if (staff instanceof Employee) {
                Employee employee = (Employee) staff;
                if (employee.getGender() == "female") {
                    totalSalary += employee.salary;
                    count++;
                }
            }
        }
        return totalSalary / count;
    }

    //Override toString används för att kunna skriva ut info om en anställd.
    @Override
    public String toString(){
        return "Namn: " + getFirstName() + " " + getLastName() + ", Kön: " + getGender() + ", ID: " + getId() + ", Lön: " + salary + ", Anställningsdatum: " + hireDate;
    }
};


