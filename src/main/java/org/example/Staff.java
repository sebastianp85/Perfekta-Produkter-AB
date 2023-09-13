package org.example;

import java.util.Comparator;
import java.util.List;

public class Staff {
    private final String firstName;
    private final String lastName;
    private final String gender;

    private final int id;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public Staff(String firstName, String lastName, String gender, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.id = id;

    }
    public static void printStaffList(List<Staff> staffList) {
        for (Staff staff : staffList) {
            String title = (staff instanceof Employee) ? "Anställd" : "Praktikant";
            String firstName = staff.getFirstName();
            String lastName = staff.getLastName();
            String gender = staff.getGender();
            int id = staff.getId();

            System.out.println(title + ": " + firstName + " " + lastName);
            System.out.println("Kön: " + gender);
            System.out.println("ID: " + id);

            if (staff instanceof Employee employee) {
                int salary = employee.getSalary();
                String hireDate = employee.getHireDate();
                System.out.println("Lön: " + salary);
                System.out.println("Anställningsdatum: " + hireDate);
            } else if (staff instanceof Trainee trainee) {
                String endDate = trainee.getEndDate();
                String evaluation = trainee.getEvaluation();
                System.out.println("Slutdatum: " + endDate);
                System.out.println("Omdöme: " + evaluation);
            }

            System.out.println();
        }
    }

    public static void sortStaffListByHireDate(List<Staff> staffList) {
        Comparator<Staff> hireDateComparator = Comparator.comparing(staff -> staff instanceof Employee ? ((Employee) staff).getHireDate() : "");
        staffList.sort(hireDateComparator);

        for (Staff staff : staffList) {
            if (staff instanceof Employee employee) {
                System.out.println("Namn: " + employee.getFirstName() + " " + employee.getLastName() + ", Anställningsdatum: " + employee.getHireDate());
            }
        }
    }
}
