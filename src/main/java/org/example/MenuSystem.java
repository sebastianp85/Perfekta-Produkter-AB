package org.example;

public class MenuSystem {

    public static void displayAndSelectFromMainMenu(){
        System.out.println("Välj ett av följande alternativ genom att skriva siffran för menyn.");
        System.out.println("1: Personal: Lägg till / Ändra / Radera.");
        System.out.println("2: Personallista:");
        System.out.println("3: Snittlöner.");
        System.out.println("4: Anställningsdatum.");
        System.out.println("0: Avsluta programmet.");
    }

    public static void displayAndSelectFromStaffMenu(){
        System.out.println("Du valde kategorin Personal");
        System.out.println("Gör nu följande val:");
        System.out.println("1: Lägg till personal");
        System.out.println("2: Ändra befintlig personal");
        System.out.println("3: Radera befintlig personal");
    }

    public static void updateStaffMenu() {
        System.out.println("Här kan du uppdatera data för personal");
        System.out.println("Gör nu följande val:");
        System.out.println("1: Ändra lön för en anställd");
        System.out.println("2: Lämna omdöme för en praktikant");
    }
}
