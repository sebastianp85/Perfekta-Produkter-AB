package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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

    private final String hireDate;
    public Employee(String firstName, String lastName, String gender, int id, int salary, String hireDate) {
        super(firstName, lastName, gender, id);
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public static double getAvgSalaryMen(List<Staff> staffList) {
        float totalSalary = 0;
        int count = 0;

        for (Staff staff : staffList) {
            if (staff instanceof Employee employee) {
                if (employee.getGender().equals("male")) {
                    totalSalary += employee.salary;
                    count++;
                }
            }
        }
        return totalSalary / count;
    }

    public static double getAvgSalaryWomen(List<Staff> staffList) {
        float totalSalary = 0;
        int count = 0;

        for (Staff staff : staffList) {
            if (staff instanceof Employee employee) {
                if (employee.getGender().equals("female")) {
                    totalSalary += employee.salary;
                    count++;
                }
            }
        }
        return totalSalary / count;
    }

    public static void addEmployee(List<Staff> staffList, Scanner scanner) {
        System.out.println("Lägger till en anställd. Ange följande information:");

        System.out.print("Förnamn: ");
        String firstName = scanner.nextLine();

        System.out.print("Efternamn: ");
        String lastName = scanner.nextLine();

        System.out.print("Kön: ");
        String gender = scanner.nextLine();

        System.out.print("ID: ");
        int id = scanner.nextInt();

        System.out.print("Lön: ");
        int salary = scanner.nextInt();

        System.out.print("Anställningsdatum: ");
        scanner.nextLine();
        String hireDate = scanner.nextLine();

        Staff newEmployee = new Employee(firstName, lastName, gender, id, salary, hireDate);
        staffList.add(newEmployee);

        System.out.println("Du har nu lagt till följande person: " + newEmployee);
        System.out.println("Din lista för anställda är:");
        printStaffList(staffList);
    }

    public static void deleteStaff(List<Staff> staffList, Scanner scanner) {
        int deleteStaffById = scanner.nextInt();

        Iterator<Staff> iterator = staffList.iterator();
        while (iterator.hasNext()) {
            Staff staff = iterator.next();

            if (staff.getId() == deleteStaffById) {
                iterator.remove();
                System.out.println(staff.getFirstName() + " " + staff.getLastName() + " med ID " + deleteStaffById + " har nu tagits bort från listan.");
                System.out.println("Din personallista har nu " + staffList.size() + " personer");
                break;
            }
        }
    }

    public static void salaryList(List<Staff> staffList ) {
        for (Staff staff : staffList) {
            if (staff instanceof Employee employee) {
                if (employee.getSalary() > 0) {
                    System.out.println("Namn: " + employee.getFirstName() + " " + employee.getLastName() + ", Lön: " + employee.getSalary() + ", ID " + employee.getId());
                }
            }
        }
    }

    public static void updateSalaryList(List<Staff> staffList, Scanner scanner){
        int updateSalaryId = scanner.nextInt();
        for (Staff staff : staffList) {
            if (staff instanceof Employee employee) {
                if (employee.getId() == updateSalaryId) {
                    System.out.println("Nuvarande lön för " + employee.getFirstName() + " " + employee.getLastName() + " är: " + employee.getSalary());
                    System.out.println("Ange den nya lönen:");
                    int newSalary = scanner.nextInt();
                    employee.setSalary(newSalary);
                    System.out.println("Den nya lönen för " + employee.getFirstName() + " " + employee.getLastName() + " är nu: " + employee.getSalary());
                }
            }
        }
    }

    @Override
    public String toString(){
        return "Namn: " + getFirstName() + " " + getLastName() + ", Kön: " + getGender() + ", ID: " + getId() + ", Lön: " + salary + ", Anställningsdatum: " + hireDate;
    }
}


