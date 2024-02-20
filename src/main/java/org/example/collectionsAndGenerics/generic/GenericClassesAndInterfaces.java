package org.example.collectionsAndGenerics.generic;


/*

    We can add generics to our own types (classes and interfaces)

    Naming Conventions:
        -> Can be anything but the convention is to use single uppercase letters

    E -> is for the element
    T -> is for a generic type
    K -> is a map key
    V -> is a map value
    N -> is a number
    S,U,V -> are for multiple generic values


 */

class MyGeneric<T> {
    T instance;

    MyGeneric(T instance) {
        this.instance = instance;
    }

    public T getInstance() {
        return instance;
    }
}

class Register<T,U,V> {
    private T type;
    private U name;
    private V age;

    public Register(T type, U name, V age) {
        this.type = type;
        this.name = name;
        this.age = age;
    }

    public T getType() {
        return type;
    }

    public U getName() {
        return name;
    }

    public V getAge() {
        return age;
    }
}

class Dog{}
class Elephant{}



public class GenericClassesAndInterfaces {

    public static void main(String[] args) {

        // Demonstration 1
        MyGeneric<String> myGeneric = new MyGeneric<>("Ball");
        System.out.println(myGeneric.instance);

        MyGeneric<Integer> myGeneric1 = new MyGeneric<>(21);
        System.out.println(myGeneric1.instance);

        // Demonstration 2 using multipl generic types

        Register<Dog,String,Integer> dogStringIntegerRegister = new Register<>(new Dog(),"Shep",3);
        Register<Elephant,String,Integer> elephantStringIntegerRegister = new Register<>(new Elephant(),"Whiskers",2);
    }
}
