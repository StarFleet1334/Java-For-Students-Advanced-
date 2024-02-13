package org.example.lambda_expressions.exam_one.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class BasicLambdas {


    public static void main(String[] args) {
        // Part 1

        // Task 1
        Printable<String> printable_lambda = s -> System.out.println(s);
        Consumer<String> consumer_lambda = (s) -> printable_lambda.print(s);

        Printable<String> printable_reference = System.out::println;
        Consumer<String> consumer_reference = printable_reference::print;

        System.out.println("Testing Consumer: ");
        consumer_lambda.accept("Printable lambda");
        consumer_reference.accept("Printable lambda");

        System.out.println();
        // Task 2
        Retrievable<Integer> retrievable_lambda = new Retrievable<Integer>() {
            @Override
            public Integer retrieve() {
                return 77;
            }
        };
        Supplier<Integer> supplier_lambda = () -> retrievable_lambda.retrieve();

        System.out.println("Testing Supplier: ");
        System.out.println(supplier_lambda.get());

        System.out.println();


        // Task 3

        Evaluate<Integer> evaluate = (x) -> x < 0;
        Predicate<Integer> predicate_lambda = evaluate::isNegative;
        System.out.println("Testing Predicate: ");
        System.out.println(predicate_lambda.test(-1));
        System.out.println(predicate_lambda.test(1));

        System.out.println();
        System.out.println("Checking if number is even: ");
        System.out.println("is 4 even - " + check(4,(x) -> x % 2 == 0));
        System.out.println("is 7 even - " + check(7,(x) -> x % 2 == 0));
        System.out.println();
        System.out.println("Checking if string begins with Mr.");
        System.out.println("Does Mr. Joe Bloggs starts with Mr. ? " + check("Mr. Joe Bloggs",(x) -> x.startsWith("Mr.")));
        System.out.println("Does Ms. Ann Bloggs starts with Mr. ? " + check("Ms. Ann Bloggs",(x) -> x.startsWith("Mr.")));
        System.out.println();
        System.out.println("Checking if person is an Adult: ");
        Person mike = new Person("Mike",33,1.8);
        Person ann = new Person("Ann",13,1.4);
        System.out.println("Is a mike an adult ?  " + check(mike,(x) -> x.getAge() >= 18));
        System.out.println("Is a ann an adult ?  " + check(ann,(x) -> x.getAge() >= 18));
        System.out.println();

        // Task 4

        Functionable<Integer,String> functionable = (x) -> "Number is: " + x;
        Function<Integer,String> function = (x) -> functionable.applyThis(x);
        System.out.println(function.apply(25));
        System.out.println();

        // Part 2

        // Task 5
        List<Person> listPeople = getPeople();

        // Task 6 ( With Lambda Expressions)
        sortAge(listPeople);
        listPeople.forEach(x -> System.out.println(x));
        System.out.println();

        // Task 7 (With Lambda Expressions )
        sortName(listPeople);
        listPeople.forEach(x -> System.out.println(x));
        System.out.println();

        // Task 8 (With lambda Expressions )
        sortHeight(listPeople);
        listPeople.forEach(x -> System.out.println(x));
        System.out.println();


        // Task 9 (With method references )
        sortAge(listPeople);
        listPeople.forEach(System.out::println);
        System.out.println();

        sortName(listPeople);
        listPeople.forEach(System.out::println);
        System.out.println();

        sortHeight(listPeople);
        listPeople.forEach(System.out::println);
        System.out.println();

    }

    public static <T> boolean check(T first, Predicate<T> predicate) {
        return predicate.test(first);
    }


    public static void sortAge(List<Person> list) {
        Comparator<Person> comparator = (o1, o2) -> {
            if (o1.getAge() > o2.getAge()) return 1;
            return -1;
        };
        list.sort(comparator);
    }

    public static void sortName(List<Person> list) {
        Comparator<Person> comparator = Comparator.comparing(Person::getName);
        list.sort(comparator);
    }

    public static void sortHeight(List<Person> list) {
        Comparator<Person> comparator = Comparator.comparing(Person::getHeight);
        list.sort(comparator);
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }
}
