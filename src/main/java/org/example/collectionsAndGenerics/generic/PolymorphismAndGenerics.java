package org.example.collectionsAndGenerics.generic;

/*

    Polymorphism applies to the base type:
        -> List<Integer> lst = new ArrayList<>();
    Polymorphism does not apply to the generic types:
        -> List<Numbers> lst = new ArrayList<Integer>();

    To resolve the polymorphism issue for generics, we issue the wildcard question mark symbol ?

    -> Unbound wildcard: ?  | Add items ? - No - readonly
        Example: List<?> lst = new LinkedList<Integer>();

    -> Upper Bounded wildcard: ? extends type | Add items ? - No - readonly
        Example: List<? extends Numbers> lst = new LinkedList<Integer>();

    -> Lower Bounded wildcard: ? super type | Add items ? - YES
        Example: List<? super Number> lst = new LinkedList<Object>();

 */

import java.util.ArrayList;
import java.util.List;

public class PolymorphismAndGenerics {

    public static void showList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
        // list.add("Test") // Unbounded wildcard says that it is read only
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Sean");
//        showList(names); // This gives error cause polymorphism does not apply to
        // generic types
        // Since we use wildcard we now run function
        showList(names);
    }
}
