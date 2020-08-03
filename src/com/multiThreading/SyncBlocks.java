package com.multiThreading;

public class SyncBlocks {
    public static void main(String[] args) throws InterruptedException {

        Person person = new Person();
        Thread thread1 = new Thread(person::method1);
        thread1.setName("Thread 1");
        Thread thread2 = new Thread(person::method2);
        thread2.setName("Thread 2");
        thread1.start();
        thread2.start();


        thread1.join();
        thread2.join();
        System.out.println(person.size);

    }

    private static class Person {

        private final Object key1 = new Object();
        private final Object key2 = new Object();
        int size = 0;


        public void method1() {
            synchronized (key1) {
                System.out.println("Yeah hi there " + Thread.currentThread().getName());
                int T = 1000000000;
                int K = 1000000000;
                while (T-- > 0)
                    while (K-- > 0) ;
                method2();
                System.out.println("Yeah I have waited for " + Thread.currentThread().getName());
            }

        }

        public void method2() {
            synchronized (key2) {
                System.out.println("Yeah hi there in method2 " + Thread.currentThread().getName());
                int T = 1000000000;
                int K = 1000000000;
                while (T-- > 0)
                    while (K-- > 0) ;
                method1();
            }
        }
    }
}

