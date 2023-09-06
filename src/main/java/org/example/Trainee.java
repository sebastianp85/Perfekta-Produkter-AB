package org.example;

import java.util.List;
import java.util.Scanner;

public class Trainee extends Staff{
    private String endDate;
    private String evaluation;

    public String getEndDate() {
        return endDate;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public Trainee(String firstName, String lastName, String gender, int id, String endDate, String evaluation) {
        super(firstName, lastName, gender, id);
        this.endDate = endDate;
        this.evaluation = evaluation;
    }

    public static void addTrainee(List<Staff> staffList, Scanner scanner) {
        System.out.println("Du valde att lägga till en praktikant, skriv in följande:");

        System.out.println("Förnamn");
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

        System.out.print("Du har nu lagt till följande praktikant: " + newTrainee);
        System.out.println("Din personallista är:");
        printStaffList(staffList);
    }

    public static void traineeList(List<Staff> staffList, Scanner scanner){
        for (Staff staff : staffList) {
            if (staff instanceof Trainee) {
                Trainee trainee = (Trainee) staff;

                System.out.println("Namn:" + trainee.getFirstName() + " " + trainee.getLastName() + ", ID, " + trainee.getId());
            }
        }
    }

    public static void updateTraineeEvaluation(List<Staff> staffList, Scanner scanner) {
        int updateEvaluationId = scanner.nextInt();
        scanner.nextLine();

        for (Staff staff : staffList) {
            if (staff instanceof Trainee) {
                Trainee trainee = (Trainee) staff;
                if (trainee.getId() == updateEvaluationId) {

                    System.out.println("Skriv ett kortfattat omdöme om praktikantens insats:");
                    String evaluationStatement = scanner.nextLine();
                    trainee.setEvaluation(evaluationStatement);
                    System.out.println("Omdömet för " + trainee.getFirstName() + " " + trainee.getLastName() + " har uppdaterats till följande: " + trainee.getEvaluation());
                }
            }
        }
    }
    @Override
    public String toString(){
        return "Namn: " + getFirstName() + " " + getLastName() + ", Kön: " + getGender() + ", ID: " + getId() + ", Slutdatum: " + endDate + ", Omdöme: " + " Läggs in när praktiken slutar ";
    }
}
