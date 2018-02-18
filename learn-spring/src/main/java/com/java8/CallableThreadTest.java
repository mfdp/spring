package com.java8;

import java.util.concurrent.*;

public class CallableThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = () -> 123;

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> submit = executorService.submit(callable);

        System.out.println(submit.isDone());

        System.out.println(submit.get());

        System.out.println(submit.isDone());

        executorService.shutdown();
    }

}
