package org.example.collectionsAndGenerics.generic;


/***
 *
 *
 *  The generic Marker is declared just before the return type.
 *  Note that the return type can also incorporate the generic marker.
 *
 *
 *
 *
 *
 */


public class GenericMethods {

    public static <T> void genericMethod(T t) {
        MyGeneric<T> myGeneric = new MyGeneric<>(t);
        System.out.println(myGeneric.getInstance());
    }
    public static <T,U,V> void register(T t,U u,V v) {
        Register<T,U,V> register = new Register<>(t,u,v);
        System.out.println("Register: " + register.getName() + "; " + register.getAge());
    }

    public static <T> MyGeneric<T> createGeneric(T t) {
        return new MyGeneric<>(t);
    }

    public static void main(String[] args) {
        genericMethod("SK");
        genericMethod(1.1);

        register(new A(),"Shep",3);
        register(new B(),"Whiskers",2);

        MyGeneric<Integer> myGeneric = new MyGeneric<>(21);
        System.out.println(myGeneric.getInstance());
    }
}
