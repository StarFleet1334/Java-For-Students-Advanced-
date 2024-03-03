package org.example.interface_complect.rule_six;

interface Animal {
    void eat();
    void sleep();
}

abstract class Felidae implements Animal {
    @Override
    public void sleep() {
        System.out.println("sleeping");
    }
}


// In here we override remaining methods that are not overriden by Felidae abstract class
public class Cat extends Felidae{
    @Override
    public void eat() {

    }
}
