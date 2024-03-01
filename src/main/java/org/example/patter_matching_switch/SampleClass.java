package org.example.patter_matching_switch;

import java.util.*;


record CollectionType(Stack s, Vector v, LinkedList l) {
}

public class SampleClass {

    static Object get(Collection c) {
        return switch (c) {
            case Stack s -> s.pop();
            case LinkedList l -> l.getFirst();
            case Vector v -> v.lastElement();
            default -> c;
        };
    }

    static Object get(Object c) {
        return switch (c) {
            case CollectionType r -> r.toString();
            case String[] arr -> arr.length;
            case Stack s -> s.pop();
            case LinkedList l -> l.getFirst();
            case Vector v -> v.lastElement();
            default -> c;
        };
    }

    public static void main(String[] args) {
//        var stack = new Stack<String>();
//        stack.push("firstStackItemAdded");
//        stack.push("secondStackItemAdded");
//        stack.push("thirdStackItemAdded");
//
//        var linkedList = new LinkedList<String>();
//        linkedList.add("firstLinkedListElementAdded");
//        linkedList.add("secondLinkedListElementAdded");
//        linkedList.add("thirdLinkedListElementAdded");
//
//        var vector = new Vector<String>();
//        vector.add("firstVectorItemAdded");
//        vector.add("secondVectorItemAdded");
//        vector.add("thirdVectorItemAdded");
//
//        System.out.println(get(stack));
//        System.out.println(get(linkedList));
//        System.out.println(get(vector));


        var stack = new Stack<String>();
        stack.push("firstStackItemAdded");
        stack.push("secondStackItemAdded");
        stack.push("thirdStackItemAdded");

        var linkedList = new LinkedList<String>();

        linkedList.add("firstLinkedListElementAdded");
        linkedList.add("secondLinkedListElementAdded");
        linkedList.add("thirdLinkedListElementAdded");

        var vector = new Vector<String>();

        vector.add("firstVectorElementAdded");
        vector.add("secondVectorElementAdded");
        vector.add("thirdVectorElementAdded");

        var r = new CollectionType(stack, vector, linkedList);
        System.out.println(get(r));
        String[] stringArray = {"a", "b", "c"};

        System.out.println(get(stringArray));
        System.out.println(get(stack));
        System.out.println(get(linkedList));
        System.out.println(get(vector));
    }
}
