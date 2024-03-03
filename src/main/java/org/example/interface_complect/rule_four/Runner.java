package org.example.interface_complect.rule_four;

interface Runnable {
    void run();
}

public class Runner implements Runnable {
    @Override
    public void run() {

    }

    // if we uncomment this we would get an error
//    @Override
//    private void run() {
//
//    }
}
