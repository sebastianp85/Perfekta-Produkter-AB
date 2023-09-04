package org.example;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Staff {
    public String firstName;
    public String lastName;
    public String gender;

    public int id;


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
                System.out.println("Anställd: " + employee.firstName + " " + employee.lastName);
                System.out.println("Kön: " + employee.gender);
                System.out.println("ID: " + employee.id);
                System.out.println("Lön: " + employee.salary);
                System.out.println("Anställningsdatum: " + employee.hireDate);
                System.out.println();
            } else if (staff instanceof Trainee) {
                Trainee trainee = (Trainee) staff;
                System.out.println("Praktikant: " + trainee.firstName + " " + trainee.lastName);
                System.out.println("Kön: " + trainee.gender);
                System.out.println("ID: " + trainee.id);
                System.out.println("Slutdatum: " + trainee.endDate);
                System.out.println("Omdöme: " + trainee.evaluation);
                System.out.println();
            }
        }
    }

    public static void sortStaffListByHireDate(List<Staff> staffList) {
        Comparator<Staff> hireDateComparator = Comparator.comparing(staff -> staff instanceof Employee ? ((Employee) staff).hireDate : "");

        Collections.sort(staffList, hireDateComparator);
    }
};
