package org.example.interface_complect.rule_five;


interface Animal {
    void eat();
    void sleep();
}

public class Dog implements Animal{

    // This class if won't compile if we do not override all abstract methods
    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }


}
