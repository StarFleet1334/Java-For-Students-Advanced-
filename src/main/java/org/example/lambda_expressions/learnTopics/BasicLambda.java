package org.example.lambda_expressions.learnTopics;



// This is Functional interface
interface I {
    void m();
}

public class BasicLambda {

    public static void main(String[] args) {
        // before Java 8
        I i = new I() {
            @Override
            public void m() {
                System.out.println("I::m()");
            }
        };
        i.m();

        // After java 8

        I lambda_expression = () -> {
            System.out.println("After Java 8 - I::m()");
        };
        lambda_expression.m();
    }

}
