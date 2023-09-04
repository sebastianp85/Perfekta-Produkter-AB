package org.example;

import java.util.*;

import static org.example.Employee.getAvgSalaryMen;
import static org.example.Employee.getAvgSalaryWomen;
import static org.example.Staff.printStaffList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Staff> staffList = new ArrayList<>();
        Staff employee1 = new Employee("Anna", "Nilsson","female", 1,20000,  "2020-01-22");
        Staff employee2 = new Employee("Karin", "Karlsson","female", 2,30000,"2019-07-28");
        Staff employee3 = new Employee("John", "Johnsson","male", 3,20000,"2017-03-08");
        Staff employee4 = new Employee("Joe", "Smith","male", 4,10000,"2022-09-14");

        Staff trainee1 = new Trainee("Emma","Smith","female",5,"2023-10-12","");
        Staff trainee2 = new Trainee("Gunnar","Gunnarsson","male",6,"2023-09-02","");

        staffList.add(employee1);
        staffList.add(employee2);
        staffList.add(employee3);
        staffList.add(employee4);

        staffList.add(trainee1);
        staffList.add(trainee2);

        System.out.println("Välkommen till Perfekta Produkter AB AdminSystem");
        System.out.println("Välj ett av följande alternativ genom att skriva: 1, 2, 3 eller 4. ");
        System.out.println("1: Personal: Lägg till / Ändra / Radera.");
        System.out.println("2: Personallista:");
        System.out.println("3: Snittlöner.");
        System.out.println("4: Anställningsdatum.");

        int firstChoice = scanner.nextInt();
        if (firstChoice == 1) {
            System.out.println("Du valde kategorin Personal");
            System.out.println("Gör nu följande val:");
            System.out.println("1: Lägg till personal");
            System.out.println("2: Ändra befintlig personal");
            System.out.println("3: Radera befintlig personal");

            int personalChoice = scanner.nextInt();
            if (personalChoice == 1) {

                System.out.println("Vill du lägga till en Anställd tryck 1 eller vill du lägga till en Praktikant tryck 2");
                int typeOfStaff = scanner.nextInt();
                if (typeOfStaff == 1){
                    System.out.println("Du valde att lägga till en anställd, skriv in följande");
                    System.out.println("Förnamn");
                    scanner.nextLine();
                    String firstName = scanner.nextLine();

                    System.out.println("Efternamn");
                    String lastName = scanner.nextLine();

                    System.out.println("Kön");
                    String gender = scanner.nextLine();

                    System.out.println("ID");
                    int id = scanner.nextInt();

                    System.out.println("Lön");
                    scanner.nextLine();
                    int salary = scanner.nextInt();

                    System.out.println("Anställningsdatum");
                    scanner.nextLine();
                    String hireDate = scanner.nextLine();

                    Staff newEmployee = new Employee(firstName, lastName, gender, id, salary, hireDate);
                    staffList.add(newEmployee);

                    System.out.print("Du har nu lagt till följande person: " + newEmployee);
                    System.out.println();
                    System.out.println("Din lista för anställa är:");
                    printStaffList(staffList);

                } else if (typeOfStaff ==2){
                    System.out.println("Du valde att lägga till en praktikant, skriv in följande:");

                    System.out.println("Förnamn");
                    scanner.nextLine();
                    String firstName = scanner.nextLine();

                    System.out.println("Efternamn");
                    String lastName = scanner.nextLine();

                    System.out.println("Kön");
                    String gender = scanner.nextLine();

                    System.out.println("ID");
                    int id = scanner.nextInt();

                    System.out.println("Vilket datum slutar praktiken:");
                    scanner.nextLine();
                    String endDate = scanner.nextLine();

                    Staff newTrainee = new Trainee(firstName, lastName, gender, id, endDate, "");
                    staffList.add(newTrainee);

                    System.out.print("Du har nu lagt till följande person: " + newTrainee);
                    System.out.println("Din personallista är:");
                    printStaffList(staffList);
                }


            } else if (personalChoice == 2) {
                System.out.println("Här kan du uppdatera data för personal");
                System.out.println("Gör nu följande val:");
                System.out.println("1: Ändra lön för en anställd");
                System.out.println("2: Lämna omdöme för en praktikant");
                int updateStaff = scanner.nextInt();

                if (updateStaff == 1) {
                    System.out.println("De som finns på personallistan med lön är:");
                    for (Staff staff : staffList) {
                        if (staff instanceof Employee) {
                            Employee employee = (Employee) staff;
                            if (employee.salary >0) {
                                System.out.println("Namn: " + employee.firstName + " " + employee.lastName + ", Lön: " + employee.salary + ", ID " + employee.id);
                            }
                        }
                    }

                    System.out.println("Ange ID för den anställda du vill uppdatera lönen för");
                    int updateSalaryId = scanner.nextInt();

                    for (Staff staff : staffList) {
                        if (staff instanceof Employee) {
                            Employee employee = (Employee) staff;
                            if (employee.id == updateSalaryId){
                                System.out.println("Nuvarande lön för " + employee.firstName + " " + employee.lastName + " är: " + employee.salary);
                                System.out.println("Ange den nya lönen:");
                                int newSalary = scanner.nextInt();
                                employee.salary = newSalary;
                                System.out.println("Den nya lönen för " + employee.firstName + " " + employee.lastName +  " är nu: " + employee.salary);
                            }
                        }
                    }

                } else if (updateStaff == 2){
                    System.out.println("Praktikanter som finns i systemet är:");
                    for (Staff staff : staffList) {
                        if (staff instanceof Trainee) {
                            Trainee trainee = (Trainee) staff;

                            System.out.println("Namn:" + trainee.firstName + " " + trainee.lastName   + ", ID, " + trainee.id);
                        }
                    }
                    System.out.println("Ange ID för den person du vill lägga till ett omdöme för");
                    int updateEvaluationId = scanner.nextInt();
                    scanner.nextLine();

                    for (Staff staff : staffList) {
                        if (staff instanceof Trainee) {
                            Trainee trainee = (Trainee) staff;
                            if (trainee.id == updateEvaluationId){

                                System.out.println("Skriv ett kortfattat omdöme om praktikantens insats:");
                                String evaluationStatement = scanner.nextLine();
                                trainee.evaluation = evaluationStatement;
                                System.out.println("Omdömet för " + trainee.firstName + " " + trainee.lastName +  " har uppdaterats till följande: " + trainee.evaluation);
                            }
                        }
                    }
                }

            } else if (personalChoice == 3) {
                System.out.println("Här tar du bort personal från listan");

                printStaffList(staffList);

                System.out.println("Ange ID för den person du vill ta bort från listan");
                int deleteStaffById = scanner.nextInt();

                Iterator<Staff> iterator = staffList.iterator();
                while (iterator.hasNext()) {
                    Staff staff = iterator.next();

                    if (staff.id == deleteStaffById) {
                        iterator.remove();
                        System.out.println(staff.firstName + " " + staff.lastName  + " med ID " + deleteStaffById + " har nu tagits bort från listan.");
                        System.out.println("Din personallista har nu " + staffList.size() + " personer");
                        break;
                    }
                }
            }

        } else if (firstChoice == 2) {
            System.out.println("Du valde kategorin Personallista ");
            printStaffList(staffList);

            System.out.println("Du har " +  staffList.size() + " personer på listan");

        } else if (firstChoice == 3) {
            System.out.println("Du valde kategorin Snittlöner");
            System.out.println("Välj 1 för snittlönen för män eller 2 för snittlönen för kvinnor");

            double avgSalaryMen = getAvgSalaryMen(staffList);
            double avgSalaryWomen = getAvgSalaryWomen(staffList);

            int genderChoice = scanner.nextInt();
                    if (genderChoice == 1){
                        System.out.println("Snittlön för män är " + avgSalaryMen + " kr.");
                    } else if (genderChoice == 2) {
                        System.out.println("Snittlön för kvinnor är " + avgSalaryWomen + " kr.");
                    }

        } else if (firstChoice == 4) {
            System.out.println("Du valde kategorin Anställningsdatum ");
            System.out.println("En lista från första anställda till senaste anställda");

            Staff.sortStaffListByHireDate(staffList);

            for (Staff staff : staffList) {
                if (staff instanceof Employee) {
                    Employee employee = (Employee) staff;
                    System.out.println("Namn: " + employee.firstName + " " + employee.lastName + ", Anställningsdatum: " + employee.hireDate);
                }
            }

        } else {
            System.out.println("Felmeddelande: Du valde inte ett giltigt alternativ. Programmet avslutas...");
        }
    }
}
