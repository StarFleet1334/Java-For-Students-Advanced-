package org.example.collectionsAndGenerics.generic;



/**
 *
 *  Comparing two object references using the == operator evaluates to true
 *  only when both references refer to the same object i.e. == compares the bites
 *  in the references variables themselves, and they are either equal or they are not.
 *
 *  The equals() in Object behaves in the same way i.e. equals() in Object uses only the
 *  == operator for comparisons
 *
 *  When you need to know if two references are identical use ==
 *  When you need to know if two objects themselves are equal use the equals() method
 *
 *
 * If you want objects of your class to be used as elements in any data structure that
 * uses equivalency for searching for and / or retrieving an object, then you must override
 * equals() so that two different instances can be considered the same.
 *  That way, you can use one instance when you add it to a collection and essentially re-create
 *  and identical instance when you want to do a search based on that object as the key.
 *
 *
 *  Also remember that toString(), equals() and hashCode() are all public
 *  so remember to place public at the beginning or it will give error
 *
 *
 */

class Foo {
    private int fooValue;
    Foo(int val) {
        this.fooValue = val;
    }

    public int getFooValue() {
        return fooValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foo foo = (Foo) o;
        return fooValue == foo.fooValue;
    }

    @Override
    public int hashCode() {
        return fooValue * 17;
    }
}


public class Equals {

    public static void main(String[] args) {
        Foo f1 = new Foo(2);
        Foo f2 = new Foo(2);
        System.out.println(f1.equals(f2)); // true
        System.out.println(f1.equals("A")); // false
    }
}
