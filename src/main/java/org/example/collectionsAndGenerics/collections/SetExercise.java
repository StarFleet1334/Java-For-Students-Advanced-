package org.example.collectionsAndGenerics.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/***
 *
 *  Set - Collections with no duplicates
 *
 *  HashSet
 *      - > Unsorted, Unordered set. uses the hashcode of the object
 *          being inserted; the more efficient your hashcode() implementation,
 *          the better access performance you will get.
 *          So, use this class when you want a collection with no duplicates and
 *          you do not care about order when you iterate through it.
 *
 *  LinkedHashSet
 *      -> an Ordered version of set, it uses insertion Order;
 *          an elements are doubly-linked to each other and use this class instead of
 *          HashSet when you care about iteration order
 *
 *  TreeSet
 *      -> this is a sorted collection("Tree"); Elements can be sorted according to their
 *          "natural order" - for String's, the natural order is alphabetic; for Integer's
 *          the natural order is numeric;
 *          Elements can also be sorted according to a custom order by providing a comparator
 *          at creation time.
 *
 *  Popular Set Methods :
 *
 *     1. Set.of(E...elements) -> returns an immutable set containing the elements specified
 *     2. Set.copyOf(Collection<? extends E> coll) -> returns an immutable set containing the
 *                                              elements of the given collection
 *
 *
 */

public class SetExercise {


    public static void factoryMethods(){
        // unmodifiable sets returned
        Set<String> of     = Set.of("a", "b", "c");
        Set<String> copy   = Set.copyOf(of);

        of.add("d");    // UnsupportedOperationException
        copy.add("d");  // UnsupportedOperationException

        of.remove("a");    // UnsupportedOperationException
    }
    public static void hash() {
        Set<String> names = new HashSet<>();
        names.add("John");
        names.add("John");
        names.add("Helen");
        names.add("Anne");
        System.out.println(names);


        Set<Integer> numbers = new HashSet<>();
        numbers.add(23);
        numbers.add(21);
        numbers.add(11);
        System.out.println(numbers);
    }

    public static void hashSet(){
        // HashSet
        Set<Contact> contactsHS = new HashSet<>();
        contactsHS.add(new Contact("zoe", 45));
        contactsHS.add(new Contact("zoe", 45)); // "zoe" only added once (Set)
        contactsHS.add(new Contact("alice",34));
        contactsHS.add(new Contact("andrew",35));
        contactsHS.add(new Contact("brian",36));
        contactsHS.add(new Contact("carol",37));
        /* Output:
            brian, 36
            andrew, 35
            carol, 37
            alice, 34
            zoe, 45
        */
        for(Contact contact:contactsHS){
            System.out.println(contact);
        }
        System.out.println();
    }
    public static void linkedHashSet() {
        Set<Contact> contactsLHS = new LinkedHashSet();
        contactsLHS.add(new Contact("zoe", 45));
        contactsLHS.add(new Contact("zoe", 45)); // "zoe" only added once (Set)
        contactsLHS.add(new Contact("alice", 34));
        contactsLHS.add(new Contact("andrew", 35));
        contactsLHS.add(new Contact("brian", 36));
        contactsLHS.add(new Contact("carol", 37));
        /*
            zoe, 45
            alice, 34
            andrew, 35
            brian, 36
            carol, 37
        */
        for (Contact contact : contactsLHS) {
            System.out.println(contact);
        }
    }
}
