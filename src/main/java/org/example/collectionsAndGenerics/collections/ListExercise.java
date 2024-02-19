package org.example.collectionsAndGenerics.collections;

import java.util.*;

/***
 *
 *
 * Popular Factory Methods
 *
 * 1. Arrays.asList(T...a) -> returns a fixed-size list; cannot add/delete elements but can
 *                            replace elements
 * 2. List.of(T...elements) -> returns an immutable list containing elements specified
 * 3. List.copyOf(Collection<? extends E> coll) -> returns an immutable list containing the
 *                         elements of the given Collection
 *
 *
 *
 *
 *
 */

public class ListExercise {
    // An Ordered Collection (Sequence) - Duplicate elements are allowed

    public static void main(String[] args) {
//        factoryMethods();
//        arrayList();
//        stack();
        linkedList();
    }


    public static void factoryMethods() {
        String[] array = new String[]{"alpha","beta","omega"};
        List<String> asList = Arrays.asList(array);// 'array' and 'asList' are backed
        // SO changes to one of them reflects each other
        List<String> of = List.of(array);
        List<String> copy = List.copyOf(asList);


        array[0] = "Candy";
        System.out.println(Arrays.toString(array));
        System.out.println(asList);

        asList.set(1,"Flower");
        System.out.println(Arrays.toString(array));
        System.out.println(asList);


        // of.add("One"); // UnSupported exception
        // copy.add("One"); // UnSupported exception
        // asList.add("One"); // UnSupported exception
    }

    public static void arrayList() {
        List<String> list = new ArrayList<>();
        list.add("Alan");
        list.add("Alan");
        list.add(1,"Sean");
        list.add("Mary");
        list.add("Mary");
        // Since ArrayList supports duplicates
        System.out.println(list);
        System.out.println(list.get(1));
        list.remove(0);
        list.remove("Mary");
        System.out.println(list);
        list.set(0,"Jack");
        list.replaceAll(name -> name + " Washington");
        System.out.println(list);
    }

    public static void stack() {
        Stack<String> stack = new Stack<>();
        stack.push("Andrea");
        stack.push("Barbara");
        stack.push("Caroline");
        System.out.println(stack);

        System.out.println("Top of the stack: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        stack.push("Helen");
        System.out.println(stack);
    }

    public static void linkedList() {
        LinkedList<String> names = new LinkedList<>();
        names.add("Colin");
        names.add("David");
        names.addFirst("Brian");
        names.addFirst("Edward");
        // This method is equivalent to add
        names.addLast("Zoe");
        System.out.println(names);

        names.remove("David");
        names.removeFirst();
        names.removeLast();
        System.out.println(names);
    }
}
