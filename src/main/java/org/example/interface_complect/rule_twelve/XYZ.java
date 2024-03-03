package org.example.interface_complect.rule_twelve;

public interface XYZ {
    void boom(); //abstract method

//    static final void coed() {} -> Error
    static void codel() {
        // shared code
    }

    default void foo() {
        codel();
    }

    default void bar() {
        codel();
    }
}
