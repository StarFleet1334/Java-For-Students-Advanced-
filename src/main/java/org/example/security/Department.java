package org.example.security;

import java.util.ArrayList;

public final class Department {
    private final String name,address;
    private final int numEmployees;
    private final ArrayList<String> employees; // mutable

    // private constructor - cannot subclass this class because this constructor
    // cannot be invoked from a subclass (it is hidden)

    private Department(String name, String address, int numEmployees, ArrayList<String> employees) {
        this.name = name;
        this.address = address;
        this.numEmployees = numEmployees;
        this.employees = new ArrayList<>(employees); // creates a new arraylist
//        this.employees = employees; this breaks encapsulation
    }

    // factory method to create a Department
    public static Department createNewInstance(String name,String address,
                                               int numEmployees,
                                               ArrayList<String> employees) {
        return new Department(name,address,numEmployees,employees);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public ArrayList<String> getEmployees() {
        return new ArrayList<>(employees);
//        return employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numEmployees=" + numEmployees +
                ", employees=" + employees +
                '}';
    }
}
