package org.example;

public class Trainee extends Staff{
    public String endDate;
    public String evaluation;

    public Trainee(String firstName, String lastName, String gender, int id, String endDate, String evaluation) {
        super(firstName, lastName, gender, id);
        this.endDate = endDate;
        this.evaluation = evaluation;
    }
    @Override
    public String toString(){
        return "Namn: " + firstName + " " + lastName + ", Kön: " + gender + ", ID: " + id + ", Slutdatum: " + endDate + ", Omdöme: " + " Läggs in när praktiken slutar ";
    }
}
