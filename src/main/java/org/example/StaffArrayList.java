package org.example;

import java.util.ArrayList;
import java.util.List;

public class StaffArrayList {
    public static List<Staff> initializeStaffList(){
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

        return staffList;
    }
}
