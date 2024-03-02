int x = 5;
//
//
void showX() {
    System.out.println(x);
}

//import org.example.unnamedClasses_and_InstanceMainMethods.Test;

void main() {
    showX();
    System.out.println("Hello World from unnamed class");
//    new Test().test();
}


// This is interpreted as inner class
class A {
    int y = 10;
}