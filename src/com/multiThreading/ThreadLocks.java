package com.multiThreading;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocks {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Set<Integer> uniqueSequences = new HashSet<>();
        SequenceGenerator sequenceGenerator = new SequenceGeneratorUsingSemaphores();
        List<Future<Integer>> futures = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            futures.add(executor.submit(sequenceGenerator::incrementCount));
        }
        for (Future<Integer> future : futures) {
            uniqueSequences.add(future.get());
        }

        awaitTerminationForShutdown(executor);

        System.out.println(uniqueSequences.size());
    }

    public static void awaitTerminationForShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                if (!executor.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private static class SequenceGenerator {
        private int count;

        public int incrementCount(){

            this.count = this.count + 1;

            return this.count;
        }
    }

    private static class SequenceGeneratorUsingIntrinsicLocks extends SequenceGenerator {
        private final Object mutex = new Object();

        @Override
        public int incrementCount() {
            synchronized (mutex) {
                return super.incrementCount();
            }
        }
    }

    private static class SequenceGeneratorUsingReentrantLock extends SequenceGenerator {
        private final ReentrantLock reentrantLock = new ReentrantLock();

        @Override
        public int incrementCount() {
            try {
                reentrantLock.lock(); // Now everything from next line is Critical section
                return super.incrementCount();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private static class SequenceGeneratorUsingSemaphores extends SequenceGenerator {

        /**
         * here one in the constructor indicates no of threads that can get into Critical Section
         * parallely
         */
        private final Semaphore semaphore = new Semaphore(1);

        @Override
        public int incrementCount() {
            try {
                semaphore.acquire(); // Now everything from next line is Critical section
                return super.incrementCount();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
            return -1;
        }

    }
}

