package org.example;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Staff {
    private String firstName;
    private String lastName;
    private String gender;

    private int id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Staff(String firstName, String lastName, String gender, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.id = id;

    }
    public static void printStaffList(List<Staff> staffList) {
        for (Staff staff : staffList) {
            if (staff instanceof Employee) {
                Employee employee = (Employee) staff;
                System.out.println("Anställd: " + employee.getFirstName() + " " + employee.getLastName());
                System.out.println("Kön: " + employee.getGender());
                System.out.println("ID: " + employee.getId());
                System.out.println("Lön: " + employee.getSalary());
                System.out.println("Anställningsdatum: " + employee.getHireDate());
                System.out.println();
            } else if (staff instanceof Trainee) {
                Trainee trainee = (Trainee) staff;
                System.out.println("Praktikant: " + trainee.getFirstName() + " " + trainee.getLastName());
                System.out.println("Kön: " + trainee.getGender());
                System.out.println("ID: " + trainee.getId());
                System.out.println("Slutdatum: " + trainee.getEndDate());
                System.out.println("Omdöme: " + trainee.getEvaluation());
                System.out.println();
            }
        }
    }

    public static void sortStaffListByHireDate(List<Staff> staffList) {
        Comparator<Staff> hireDateComparator = Comparator.comparing(staff -> staff instanceof Employee ? ((Employee) staff).getHireDate() : "");

        Collections.sort(staffList, hireDateComparator);
    }
};
