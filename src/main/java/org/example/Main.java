package org.example;

import java.util.*;

import static org.example.Employee.*;
import static org.example.Staff.printStaffList;
import static org.example.Trainee.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Staff> staffList = StaffArrayList.initializeStaffList();

        System.out.println("Välkommen till Perfekta Produkter AB AdminSystem");
        int firstChoice;
        do {
            MenuSystem.displayAndSelectFromMainMenu();

            firstChoice = scanner.nextInt();
            if (firstChoice == 1) {
                MenuSystem.displayAndSelectFromStaffMenu();

                int personalChoice = scanner.nextInt();
                if (personalChoice == 1) {

                    System.out.println("Vill du lägga till en Anställd tryck 1 eller vill du lägga till en Praktikant tryck 2");
                    int typeOfStaff = scanner.nextInt();
                    scanner.nextLine();
                    if (typeOfStaff == 1) {
                        addEmployee(staffList, scanner);

                    } else if (typeOfStaff == 2) {
                        addTrainee(staffList, scanner);
                    }

                } else if (personalChoice == 2) {
                    MenuSystem.updateStaffMenu();

                    int updateStaff = scanner.nextInt();
                    if (updateStaff == 1) {
                        System.out.println("De som finns på lönelistan är:");
                        salaryList(staffList);

                        System.out.println("Ange ID för den anställda du vill uppdatera lönen för");
                        updateSalaryList(staffList, scanner);

                    } else if (updateStaff == 2) {
                        System.out.println("Praktikanter som finns i systemet är:");
                        traineeList(staffList, scanner);

                        System.out.println("Ange ID för den person du vill lägga till ett omdöme för");
                        updateTraineeEvaluation(staffList, scanner);
                    }

                } else if (personalChoice == 3) {
                    System.out.println("Här tar du bort personal från listan");

                    printStaffList(staffList);

                    System.out.println("Ange ID för den person du vill ta bort från listan");
                    deleteStaff(staffList, scanner);
                }

            } else if (firstChoice == 2) {
                System.out.println("Du valde kategorin Personallista ");
                printStaffList(staffList);

                System.out.println("Du har " + staffList.size() + " personer på listan");

            } else if (firstChoice == 3) {
                System.out.println("Du valde kategorin Snittlöner");
                System.out.println("Välj 1 för snittlönen för män eller 2 för snittlönen för kvinnor");

                double avgSalaryMen = getAvgSalaryMen(staffList);
                double avgSalaryWomen = getAvgSalaryWomen(staffList);

                int genderChoice = scanner.nextInt();
                if (genderChoice == 1) {
                    System.out.println("Snittlön för män är " + avgSalaryMen + " kr.");
                } else if (genderChoice == 2) {
                    System.out.println("Snittlön för kvinnor är " + avgSalaryWomen + " kr.");
                }

            } else if (firstChoice == 4) {
                System.out.println("Du valde kategorin Anställningsdatum ");
                System.out.println("En lista från första anställda till senaste anställda");

                Staff.sortStaffListByHireDate(staffList);

            } else {
                if (firstChoice != 0) System.out.println("Felmeddelande: Det var inte ett giltigt val");
            }
        } while (firstChoice != 0);
        System.out.println("Programmet avslutas...");
    }
}

