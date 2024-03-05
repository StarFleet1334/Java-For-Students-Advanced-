package org.example.twoOne_switch_patterns.module_one.l_4;

// Dealing with null
public class Main {

    static void nullMatch(Object obj) {
        switch (obj) {
            case String s -> System.out.println("String");
            default -> System.out.println("Something else");
        }
    }

    // is equivalent to
    static void nullMatch2(Object obj) {
        switch (obj) {
            case null -> throw new NullPointerException();
            case String s -> System.out.println("String");
            default -> System.out.println("Something else");
        }
    }
}
