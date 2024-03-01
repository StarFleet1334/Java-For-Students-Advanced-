package org.example.patter_matching_switch;

enum Direction {NORTH,SOUTH,WEST,EAST}

public class SwitchExpressions {
    public static void main(String[] args) {
        Direction d= Direction.NORTH;

        int numLetters = 0;
        switch (d) { // fall-through => requires break
            case NORTH:
            case SOUTH:
                numLetters=5;
                break;
            case EAST:
            case WEST:
                numLetters = 4;
                break;
        }
        System.out.println(numLetters);


        /**
         *
         *
         * switch expressions came in java 14:
         *  - use of the '->' token
         *  - no fall-through logic
         *  - case labels must cover all values (insert 'default')
         *
         *  Labels with ':' such as above require break or yield to prevent fall-through.
         *  if you use '->' token then there is no fall-through
         *
         *
         */

        System.out.println(
                switch (d) {
//                    case NORTH,SOUTH -> 5;
//                    default -> 4;
                    case NORTH,SOUTH : yield  5;
                    default: yield  4;
                }
        );

    }
}
