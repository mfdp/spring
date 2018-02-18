package com.java8;

import java.util.concurrent.*;

public class FixedThreadPool {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newWorkStealingPool();
        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        future.get(3, TimeUnit.SECONDS) ;
        executorService.shutdown();
    }

}
