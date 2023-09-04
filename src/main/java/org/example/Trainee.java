package org.example;

public class Trainee extends Staff{
    private String endDate;
    private String evaluation;

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
    @Override
    public String toString(){
        return "Namn: " + getFirstName() + " " + getLastName() + ", Kön: " + getGender() + ", ID: " + getId() + ", Slutdatum: " + endDate + ", Omdöme: " + " Läggs in när praktiken slutar ";
    }
}
