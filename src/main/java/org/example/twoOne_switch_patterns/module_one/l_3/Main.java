package org.example.twoOne_switch_patterns.module_one.l_3;


/**
 *          Exhaustiveness of switch expressions and statements
 *
 *   A switch expression requires that all possible values of the selector expression be handled
 *   in the switch block; in other words, it must be exhaustive.
 *
 *   For normal switch expressions this property enforced by a straightforward set of
 *   extra conditions on the switch block.
 *
 *   For pattern switch expressions and statements, we achieve this by defining a notion
 *   of type coverage of switch labels in a switch block. The type coverage of all the switch
 *   labels in the switch block is then combined to determine if the switch block exhausts
 *   all the possibilities of the selector expression.
 *
 *
 *
 *
 *
 *
 */
public class Main {
    /**
     * Uncommented and see that it gives error
     * (Not exhaustive)
     */
//    static int coverage(Object obj) {
//        return switch (obj) { // Error - not exhaustive
//            case String s -> s.length();
//        };
//    }


    /**
     *  This is exhaustive, cause it covers all possibilities
     * @param o
     * @return
     */
    static int coverage(Object o) {
        return switch (o) {
            case String s -> s.length();
            case Integer i -> i;
            default -> 0;
        };
    }
}
