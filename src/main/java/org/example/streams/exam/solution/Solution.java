package org.example.streams.exam.solution;

import java.io.IOError;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Solution {


    // Task 1
    public static void taskOne() {
        OptionalDouble average = Stream.of(0,1,2,3,4)
                .mapToInt(x -> x)
                .average();
        System.out.println("Average: " + average.getAsDouble());
    }


    // Task 2
    public static void taskTwo() {
        List<Item> list = Arrays.asList(
                new Item(1,"Screw"),
                new Item(2,"Nail"),
                new Item(3,"Bolt")
        );
        list.stream()
                .sorted(Comparator.comparing(Item::getName))
                .forEach(x -> System.out.print(x.getName()));
    }


    // Task 3
    public static void taskThree() {
        Stream<List<String>> listStream = Stream.of(
                Arrays.asList("a","b"),
                Arrays.asList("a","c")
        );
        listStream
                .filter(x -> x.contains("c"))
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    }


    // Task 4

    public static void taskFourPartOne() {
        // calculating sum
        int sum = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum is: " + sum);

        // Calculating max
        OptionalInt max = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .mapToInt(Integer::intValue)
                .max();
        System.out.println("Max is: " + max.getAsInt());
    }

    public static void taskFourPartTwo() {
        // Calculate the oldest person in the list
        List<Person> personList = Arrays.asList(
                new Person("Alan","Burke",22),
                new Person("Zoe","Peters",20),
                new Person("Peter","Castle",29)
        );
        personList.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
    }

    public static void taskFourPartThree() {
        List<Integer> list = Arrays.asList(10,47,33,23);
        // First Part
        Optional<Integer> maxOptional = list.stream()
                .reduce((x,y) -> {
                    if (x > y) return x;
                    return y;
                });

        int maxDefault = list.stream()
                .reduce(Integer.MIN_VALUE,(x,y) -> {
                    if (x > y) return x;
                    return y;
                });
        System.out.println("Using Optional max is: " + maxOptional.get());
        System.out.println("Using Default max is: " + maxDefault);
    }

    // Task 5

    public static Optional<String> getGrade(int marks) {
        Optional<String> grade;
        if (marks > 50) {
            grade = Optional.of("PASS");
        } else {
            grade = Optional.of("FAIL");
        }
        return grade;
    }

    public static void alternativeMain() {
        Optional<String> grade1 = getGrade(50);
        Optional<String> grade2 = getGrade(55);
        System.out.println("Result of grade 1: " + grade1.orElse("UNKNOWN"));

        if (grade2.isPresent()) {
            grade2.ifPresent(s -> System.out.println("Result: " + s));
        } else {
            System.out.println("Result of grade2: " + grade2.orElse("EMPTY"));
        }

    }


    // task 6
    public static void taskSixth() {
        List<Book > bookList = Arrays.asList(
                new Book("Thinking in Java",30.0),
                new Book("java in 24 hrs",20.0),
                new Book("Java Recipes",10.0)
        );

        // first part
        bookList.stream()
                .map(Book::getPrice)
                .filter(x -> x > 10)
                .mapToDouble(Double::doubleValue)
                .average()
                .ifPresent(System.out::println);

        // Second part
        bookList.stream()
                .map(Book::getPrice)
                .filter(x -> x > 90)
                .mapToDouble(Double::doubleValue)
                .average()
                .ifPresentOrElse(System.out::println, new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Not Present");
                    }
                });
    }

    // Task 7
    public static void taskSeven() {
        List<Book> bookList = Arrays.asList(
                new Book("Atlas Shrugged",10.0),
                new Book("Freedom at Midnight",5.0),
                new Book("Gone with the wind",5.0)
        );

        bookList.stream()
                .collect(
                        Collectors.toMap(
                                Book::getTitle,
                                Book::getPrice
                        )
                )
                .forEach((x,y) -> {
                    if (x.startsWith("A")) {
                        System.out.println(y);
                    }
                });
    }

    // Task 8

    public static void taskEight() {
        List<Book> bookList = Arrays.asList(
                new Book("Gone with the wind",5.0),
                new Book("Gone with the wind",10.0),
                new Book("Atlas shrugged",15.0)
        );
        bookList.stream()
                .collect(
                        Collectors.toMap(
                                Book::getPrice,
                                Book::getTitle
                        )
                )
                .forEach((x,y) -> System.out.println(x + " : " + y));

    }

    // task 9
    public static void taskNine() {
        List<Person> personList = Arrays.asList(
                new Person("Bob","",31),
                new Person("Paul","",32),
                new Person("John","",33)
        );
        personList.stream()
                .mapToInt(Person::getAge)
                .filter(x -> x < 30)
                .average()
                .ifPresentOrElse(s -> System.out.println("Average: " + s), new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Average: " + 0.0);
                    }
                });
    }

    // task 10
    public static void taskTenPartOne() {
        Optional<Double> price = Optional.of(20.0);
        System.out.println("Using ifPresent(Consumer): ");
        price.ifPresent(System.out::println);
        System.out.println("Using orElse(T): " + price.orElse(0.0));
        System.out.println("Using orElseGetSupplier: " + price.orElseGet(() -> 0.0));
    }

    public static void taskTenPartTwo() {
        Optional<Double> price2 = Optional.empty();
        System.out.println(price2);
        if (price2.isEmpty()) {
            System.out.println("empty");
        }
        price2.ifPresent(s -> System.out.println(s));
        System.out.println(price2.orElse(44.0));
    }

    public static void taskTenPartThree() {
        Optional<Double> price3 = Optional.empty();
        Double z = price3.orElseThrow(() -> new RuntimeException("Bad Cde"));
        System.out.println(z);
    }

    // Task 11

    public static void taskEleven() {
        List<AnotherBook> anotherBooks = List.of(
                new AnotherBook("Gone with the wind","Fiction"),
                new AnotherBook("Bourne Ultimatium","Thriller"),
                new AnotherBook("The Client","Thriller")
        );

        List<String > genreList = new ArrayList<>();
        anotherBooks.stream()
                .map(AnotherBook::getGenre)
                .distinct()
                .forEach(genreList::add);
        System.out.println(genreList);
    }

    // Task 12

    public static void taskTwelvePartOne() {
        double sum = Stream.of(0,2,4,7)
                .mapToDouble(x -> x)
                .filter(x -> x % 2 != 0)
                .sum();
        System.out.println("Sum of odd numbers: " + sum);
    }

    public static void taskTwelvePartTwo() {
        Stream.of(1.0,3.0,2.0,6.0,8.0)
                .mapToDouble(x -> x)
                .filter(x -> x % 2 == 0)
                .average().ifPresentOrElse(
                        s -> System.out.println("Average of even numbers: " + Math.floor(s)),
                        new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("Average of even numbers: " + 0.0);
                            }
                        }
                );
    }

    // Task 13

    public static void taskThirteen() {
        // Part a
        List<Integer> ls = Arrays.asList(11,11,22,33,33,55,66);
        boolean check = ls.stream()
                .distinct()
                .anyMatch(x -> x == 11);
        System.out.println(check);

        // Part b

       boolean checkTwo = ls.stream()
                .distinct()
                .noneMatch(x -> x % 11 > 0);
        System.out.println(checkTwo);
    }

    // Task 14
    public static void taskFourteenPartOne() {
        AtomicInteger ai = new AtomicInteger();
        Stream.of(11,11,22,33)
                .parallel()
                .filter(n -> {
                    ai.incrementAndGet();
                    return n % 2 == 0;
                })
                .forEach(System.out::println);
        System.out.println(ai);
    }

    public static void taskFourteenPartTwo() {
        AtomicInteger ai = new AtomicInteger();
        Stream<Integer> stream = Stream.of(11,11,22,33).parallel();
        stream.filter(e -> {
            ai.incrementAndGet();
            return e % 2 == 0;
        });
        // Reason this gives error is that
        // Stream may be already got operated on or it is closed
        // So we cannot attach terminal operation on that stream
        stream.forEach(System.out::println);
        System.out.println(ai);
    }

    public static void main(String[] args) {
        taskFourteenPartTwo();

    }


}
