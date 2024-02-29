package org.example.annotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  1. With no annotations.
 *  2. Deprecate "print()"
 *      a) show cmdline compiler error
 *      b) uncomment @SuppressWarnings("deprecation") - error SHOULd disappear but does not
 *  3. Uncomment "unchecked()" method
 *      a) show cmdline compiler error
 *      b) uncomment @SuppressWarnings("unchecked"0 - error gone
 *  4. @SafeVarargs
 *      a) The rules around public/static/final and varargs
 *      b) uncomment "abuseVarargs()" method and its method call
 *          1. do it first without @SafeVarargs and observe the compiler error (s)
 *          2. insert @SafeVarargs and note the errors go away.
 */


class Book {
    @Deprecated(since = "2.0",forRemoval = true)
    public static void print(){}
    public static void readOnline(){}
    public static Integer preview(List<String> pages) {
        return pages.size();
    }
}


public class CommonBuiltInAnnotationsExtra {
    public static void main(String[] args) {
        CommonBuiltInAnnotationsExtra cm = new CommonBuiltInAnnotationsExtra();
        cm.testDeprecated();
        cm.testUnchecked();

        abuseVarargs(new ArrayList<Integer>());
    }


    @SafeVarargs
    static int abuseVarargs(ArrayList<Integer>... list) {
        // must have varargs and be private,static or final
        Object[] oa = list;
        oa[0] = Arrays.asList("uh-oh!");
        return list[0].get(0);

    }

    //    @SuppressWarnings("deprecation")
    public void testDeprecated() {
        // if we have Deprecated uncommented this gives error here
        Book.print();
    }


    @SuppressWarnings("unchecked") // ignore warnings relating to the use of 'raw types'
    public void testUnchecked() {
//        Book.preview(new ArrayList<>());
        Book.preview(new ArrayList()); // This is a raw type
    }
}
