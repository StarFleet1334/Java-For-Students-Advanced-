package org.example.annotations;


@FunctionalInterface
interface Moveable {
    void move();
    // If we uncomment this we do not get error
//    boolean equals(Object o);
}

class Person implements Moveable {
    private String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void move() {
        System.out.println("Moving");
    }
}

public class CommonBuiltInAnnotations {
    public static void main(String[] args) {
        Person ps = new Person("Sean Kennedy");
        System.out.println(ps); // toString() is called in the background
//        ps.move();
    }

}
