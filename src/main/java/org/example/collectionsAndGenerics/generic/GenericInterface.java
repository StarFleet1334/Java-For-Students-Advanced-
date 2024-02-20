package org.example.collectionsAndGenerics.generic;


class A{}
class B{}

interface Moveable<T> {
    void move(T t);
}

class MoveFeline implements Moveable<A>{

    @Override
    public void move(A a) {

    }
}

class SomeMoveable<U> implements Moveable<U> {
    public void move(U u) {}
}

class MoveCanine implements Moveable<B> {
    @Override
    public void move(B dog) {}
}

public class GenericInterface {
    public static void main(String[] args) {
        // One way of declaring
        new MoveFeline().move(new A());
        // Second way of declaring
        new SomeMoveable<B>().move(new B());
    }
}
