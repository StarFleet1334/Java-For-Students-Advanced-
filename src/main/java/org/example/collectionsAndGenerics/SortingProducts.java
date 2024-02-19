package org.example.collectionsAndGenerics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingProducts {

    public static void main(String[] args) {
        comparable();
    }

    public static void comparable() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(99));
        list.add(new Product(9));
        list.add(new Product(19));
        Collections.sort(list);
        System.out.println(list);
    }


}
