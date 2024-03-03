package org.example.interface_complect.trick;

public interface Y {
    void doo();

    default void bar() {
        System.out.println("bar() from interface Y");
    }
}
