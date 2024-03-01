package org.example.patter_matching_switch;

import java.util.Collection;
import java.util.Stack;

public class GuardedPattern {

    static Object get(Collection c) {
        return switch (c) {
            case Stack s when s.empty() -> s.push("first");
            case Stack s2 -> s2.push("second");
            default -> c;
        };
    }

    public static void main(String[] args) {
        Stack<String> def = new Stack<>();
        System.out.println("Item pushed in test stack: " + get(def));;
        System.out.println("Stack: " + def);

        Stack<String> test = new Stack<>();
        test.push("first");
        System.out.println("Item pushed in test stack: " + get(test));;
        System.out.println("Stack: " + test);
    }
}
