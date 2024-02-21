package org.example.concurrency;


// Here we create thread using one of the 3 ways
// Using Runnable functional interface
class CountDown implements Runnable {
    private String[] nums = {"Nine","Eight","Seven","Sixth",
                            "Five","Four","Three","Two","One"};

    @Override
    public void run() {
        for (String num : nums) {
            try {
                System.out.println(num);
                // Here we print element from nums array
                // After every 1 second. 1000 milliseconds translates to 1sec
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class SleepAndJoin {
    public static void main(String[] args) {
        Thread t = new Thread(new CountDown());
        System.out.println("Starting countdown....");
        t.start();
        // Here we stop main thread until
        // CountDown thread finished
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // After countDown thread finished we print : Finished!!
        System.out.println("Finished!!");
    }
}
