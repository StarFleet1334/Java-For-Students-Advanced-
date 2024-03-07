package org.example.annotations;

enum Device {
    LAPTOP,PHONE
}

@interface Human {} // Market annotation (no elements)

@interface OnWeb {

    // The elements are abstract and public by default
    // and can not be protected,private or final
    int startTime() default 9;
    int hoursPerDay();

    // As in interfaces values are public static and final by default
    // Constants are not considered elements => marker interfaces can have constants.

    int PEAK_TIME_START = 19;
    public static final int PEAK_TIME_END=22;

    String name() default "SK";
    Device consume() default Device.LAPTOP;
    Class humanOrBot() default Human.class;
    Human extractInfo() default @Human; // 'new' keyword never used for annotations

    String[] sites() default {"S","K"};


}

// 2. Apply the annotations
@OnWeb (hoursPerDay = 6)

@Human
class Student {}

@OnWeb(hoursPerDay = 3,startTime = 18)


@Human
class Worker {}

public class CustomAnnotations {

    public static void main(String[] args) {

    }
}
