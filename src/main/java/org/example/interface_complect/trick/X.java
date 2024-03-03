package org.example.interface_complect.trick;

public interface X {
    void foo();

    default void bar() {
        System.out.println("Bar() from interface X");
    }
}
