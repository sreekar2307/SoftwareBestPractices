package com.multiThreading;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SquareCalculator squareCalculator = new SquareCalculator();
        Future<Integer> future1 = squareCalculator.calculate(45);
        Future<Integer> future2 = squareCalculator.calculate(95);
        while (!(future1.isDone() && future2.isDone())) {
            System.out.printf(
                    "future1 is %s and future2 is %s%n",
                    future1.isDone() ? "done" : "not done",
                    future2.isDone() ? "done" : "not done"
            );
            Thread.sleep(300);
        }

        Integer result1 = future1.get();
        Integer result2 = future2.get();

        System.out.println(result1 + " and " + result2);


        squareCalculator.shutdown();
        long start1 = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        SumOfSquaresMulti calculator = new SumOfSquaresMulti(1500);

        forkJoinPool.execute(calculator);

        while (!calculator.isDone()) ;

        System.out.println(calculator.get());
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

        long start2 = System.currentTimeMillis();

        System.out.println(new SumOfSquaresSingle().sumOfSquares(1500));

        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);


    }

    private static class SumOfSquaresSingle {

        long sumOfSquares(long n) {
            if (n == 1L)
                return 1L;
            return n * n + sumOfSquares(n - 1);
        }
    }

    private static class SquareCalculator {

        private final ExecutorService executor = Executors.newSingleThreadExecutor();

        public Future<Integer> calculate(Integer input) {
            Callable<Integer> COMPUTE_SQUARE = () -> {
                Thread.sleep(1000);
                return input * input;
            };
            return executor.submit(COMPUTE_SQUARE);
        }

        public void shutdown() {
            executor.shutdown();
        }

    }

    private static class SumOfSquaresMulti extends RecursiveTask<Long> {
        private long n;

        public SumOfSquaresMulti(long n) {
            this.n = n;
        }

        @Override
        protected Long compute() {
            if (n == 1L)
                return n;
            SumOfSquaresMulti sumOfSquaresMulti = new SumOfSquaresMulti(n - 1);
            sumOfSquaresMulti.fork();
            return n * n + sumOfSquaresMulti.join();
        }
    }
}



