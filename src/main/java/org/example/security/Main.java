package org.example.security;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> employes = new ArrayList<>();
        employes.add("Liam");
        employes.add("Ann");
        Department department = Department.createNewInstance("argos","Athlone",2,employes);


        System.out.println("Created: " + department);

        String name = department.getName();
        String address = department.getAddress();
        int numEmployees = department.getNumEmployees();
        employes = department.getEmployees();

        System.out.println();

        name = "Boots"; // Strings are immutable so new objects are created in the background
        address = "Galway";
        numEmployees = 3;
        employes.add("Tom"); // as we only got a copy of the AL back, we are changing that copy

        System.out.println("Any Change? : " + department);
        System.out.println(employes);

        // try uncommenting in Department what is copied.
        // when we create new ArrayList<>(employees) this is called defensive-copying

    }
}
