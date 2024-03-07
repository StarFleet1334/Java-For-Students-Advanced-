package org.example.annotations;

@interface Team {
    String value() default "Soccer"; // required or optional
    int numPlayers() default 2; // Must be optional if we wish to use shorthand i.e. "value"
}

class Sport {
    @Team(numPlayers = 6,value = "Volleyball")
    void beach() {};
    @Team(value = "Tennis")
    void strawberriesAndCream() {}

    @Team("Curling")
    void slow() {}
}


// Example - shorthand for arrays with Only one element
@interface Quiz {
    String[] topics();
}

class Competitor {
    @Quiz(topics = {"General Knowledge","Music"})
    String favouriteTopic;
    @Quiz(topics = {"Sport"})
    String leastFavouriteTopic;
    @Quiz(topics = "Sport")
    String leastOtherFavouriteTopic; // compiler inserts {}

//    @Quiz(topics = "Sport","Jazz")
//    String topicOne;
    // this gives error {} missing cause shorthand works for one element
}

// Example - combining both shorthands
// - value()
// - arrays with only one element

@interface Colours {
    String[] value();
}

class TestRainbow {
    @Colours(value = {"Red"})
    String colour1;
    @Colours(value = "Red")
    String colour2;
    @Colours({"Red"})
    String colour3;
    @Colours("Red")
    String getColour4;
}

public class Shorthand {
}
