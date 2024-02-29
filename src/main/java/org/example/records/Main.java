package org.example.records;

public class Main {
    public static void main(String[] args) {
//        EmpRecord empRecord = new EmpRecord(-10,"Pankaj",10000,null);
        // here if uncommented above we would get error as we custom defined

        Point p = new Point(5,10);
        System.out.println(p.x()); // 5
        // Once record is created, its state can not be changed.
        // if you try to modify a field of a record, you'll get a compile-time error.
//        p.x() = 22;


    }
}
