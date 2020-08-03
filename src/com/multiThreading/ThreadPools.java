package com.multiThreading;

import java.util.concurrent.*;

public class ThreadPools {
    public static void main(String[] args) throws InterruptedException {
        // Best for implementation of Event loop
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit(() -> System.out.println("Hello There"));

        /**
         *  there are three types thread pool thresholds
         *  1) CorePoolSize --> No of Treads that will be instantiated and kept in pool
         *  2) MaximumPoolSize --> If all the threads in core pool are exhausted then grow
         *    thread pool size to this parameter
         *  3) keepAliveTime --> interval until which the access threads created (after the core pool size is reached)
         *    should be allowed to exist
         *  the below static method will return ThreadPoolExecutor with CorePoolSize = MaximumPoolSize = 2
         *  and keepAliveTime = 0;
         */

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        threadPoolExecutor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        threadPoolExecutor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        threadPoolExecutor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });


        // here task1 and task2 will be executed parallely and task3 will be waiting in the queue;
        System.out.println(threadPoolExecutor.getPoolSize());
        System.out.println(threadPoolExecutor.getQueue().size());
        /**
         * this static method will return instance of ThreadPoolExecutor
         * CorePoolSize = 0 (default)
         * MaximumPoolSize = Integer.MAX_VALUE (default)
         * ActiveTime = 60secs (default)
         * useful for multiple shortLived tasks
         */
        ThreadPoolExecutor cachedThreadPool =(ThreadPoolExecutor) Executors.newCachedThreadPool();


        /**
         * this static method will return instance of ScheduledExecutorService
         * CorePoolSize = 5
         * MaximumPoolSize = Integer.MAX_VALUE (default)
         * ActiveTime = 0 (default)
         */

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.schedule(() -> {
            System.out.println("Hello World");
        }, 500, TimeUnit.MILLISECONDS);

        // the above task will execute after 500 milli secs of delay

        CountDownLatch lock = new CountDownLatch(3);

        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("executes every 100ms with initial delay of 500ms for three times");
            lock.countDown();
        }, 500, 100, TimeUnit.MILLISECONDS);

        lock.await(1000, TimeUnit.SECONDS);
        scheduledFuture.cancel(true);


        executor.shutdown();
        threadPoolExecutor.shutdown();
        cachedThreadPool.shutdown();
        scheduledExecutorService.shutdown();

    }
}
