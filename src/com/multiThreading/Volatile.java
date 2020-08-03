package com.multiThreading;

/**
 * Possible outputs without volatile keyword are
 * Infinite loop without ever printing the "number" value
 * "42" -> printed once which is also expected
 * "0" -> Predicate is written back but the number is not written
 * so to overcome these abnormal behaviour use volatile on predicate
 * number does not read volatile because ("All writes for a volatile field happens first before read")
 * this will write all the other class fields
 * <a>https://www.baeldung.com/java-volatile</a>
 */
public class Volatile {
    private static int number;
    private static volatile boolean predicate; // not having a volatile keyword here might cause an infinite loop

    static class Reader extends Thread{

        @Override
        public void run(){
            readFrom();
        }
        void readFrom(){
            while (!predicate);
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        Reader reader = new Reader();
        reader.start();

        number = 42;
        predicate = true;

    }

}
