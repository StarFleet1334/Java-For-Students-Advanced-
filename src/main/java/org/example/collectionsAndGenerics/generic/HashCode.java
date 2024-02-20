package org.example.collectionsAndGenerics.generic;

import org.example.collectionsAndGenerics.collections.Contact;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/***
 *
 *
 *  If two objects are considered equal using the equals() method, then
 *  they must have identical hashcode values. if you override equals(),
 *  override hashCode() as well.
 *
 *  Hashcodes are used for improving performance in hash based collections:
 *  hashmap,hashTable,HashSet. The hashcode value is used to determine how the object
 *  should be stored in the collection and the hashcode is used again to help locate
 *  the object in the collection
 *
 *  Hashing is similar to putting items in buckets:
 *      -> The hashcode value determines which bucket the object is stored in
 *          and later on, the hashcode value determines which bucket is searched to locate the object
 *      -> hashcodes are necessarily unique so several objects can land in the same bucket; this is
 *          where equals comes into play - the correct object is the located by using the equals()
 *          method,
 *
 *  Note: do not use transient instance variables in the hashcode calculation as these
 *      are not serialised.
 *
 *  Contract says that two equal objects must have the same hashcode
 *
 */

class Contract {
    private int age;
    private String name;

    public Contract(String name,int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return age == contract.age && Objects.equals(name, contract.name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.age;
        hash = 89 * hash + this.name.length();
        return hash;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


public class HashCode {

    private static Map<Contract,String> map = new HashMap<>();

    public static void main(String[] args) {
        Foo f1 = new Foo(2);
        Foo f2 = new Foo(2);
        Foo f3 = new Foo(3);
        System.out.println(f1.hashCode()); // 34
        System.out.println(f2.hashCode()); // 34
        System.out.println(f3.hashCode()); // 51

        Contract john = new Contract("John",33);
        Contract peter = new Contract("Peter",34);
        System.out.println("John Hashcode: " + john.hashCode());
        System.out.println("Peter Hashcode: " + peter.hashCode());

        map.put(john,"Irish");
        map.put(peter,"American");

        Contract mary = new Contract("Mary",21);
        System.out.println("Mary HashCode: " + mary.hashCode());
        map.put(mary,"Engineer");
        otherScope();
        System.out.println("After otherscope(): " + map.get(mary));
        testJane();
        System.out.println(map);


    }

    private static void testJane() {
        Contract jane = new Contract("Jane",21);
        System.out.println("Jane hashCode(): " + jane.hashCode());
        map.put(jane,"nurse");
        System.out.println(map.get(jane));
    }

    private static void otherScope() {
        Contract anotherMary = new Contract("Mary",21);
        System.out.println("Another mary hashcode(): " + anotherMary.hashCode());
        System.out.println("In otherscope: " + map.get(anotherMary));
        
        /*
        This lines overwrites mary with anotherMary as a key because:
            a) their hashcodes are the same
            b) they are both equal according to equals()
        
         */
        map.put(anotherMary,"accountant");
    }

}
