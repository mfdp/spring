package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class MultiCallable {

    public static void main(String[] args) throws InterruptedException {
//        stringCallable();
        integerCallable();
    }

    private static void stringCallable() throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> {
                    TimeUnit.SECONDS.sleep(2);
                    return "task2";
                },
                () -> "task3");

        executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    }
                    catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);
    }

    private static void integerCallable() throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<Integer>> callables = Arrays.asList(
                () -> 111,
                () -> {
                    TimeUnit.SECONDS.sleep(2);
                    return 222;
                },
                () -> 333);

        System.out.println(
                executor.invokeAll(callables) ///
                        .stream() //
                        .map(getFutureBooleanFunction())
                        .mapToInt(MultiCallable::mapToIntFunction) //
                        .sum()
        );
    }

    private static Function<Future<Integer>, Boolean> getFutureBooleanFunction() {
        return future -> future.isDone();
    }

    private static ToIntFunction<Future<Integer>> mapToIntFunction() {
        return future -> {
            try {
                return future.get();
            } catch( Exception e ) {
                throw new IllegalStateException(e);
            }
        };
    }
}
