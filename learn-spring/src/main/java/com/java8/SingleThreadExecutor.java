package com.java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutor {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("PROGRAM START");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                for( int i = 0; i < 10; i++ ) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(i + " secounds " + Thread.currentThread());
                }
            } catch (InterruptedException e) {
                System.out.println("task interrupted");
            }
        });
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }

}
