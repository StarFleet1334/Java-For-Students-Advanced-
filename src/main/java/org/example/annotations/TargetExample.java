package org.example.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@Target({ElementType.CONSTRUCTOR}) // Only to constructor
//@Target({ElementType.FIELD,ElementType.PARAMETER}) // only to fields and parameter
//@Target({ElementType.TYPE_USE}) //all
@interface DataItem {}


@DataItem
class X {}

@DataItem
interface Y {}

class Z {
    @DataItem int a;
    @DataItem static int b;

    @DataItem Z () {}

    void m1(@DataItem int a) {}
}

@Target(ElementType.TYPE_USE)
@interface WildCard{}


class X1 {
    @WildCard int x; // instance variable
    @WildCard static int y; //class variable


    void m1(@WildCard int a) {
        @WildCard int z = 0; // local variable
        var x1 = new @WildCard X1(); // new instance
    }
}
public class TargetExample {
}
