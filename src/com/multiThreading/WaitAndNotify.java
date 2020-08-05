package com.multiThreading;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * wait, will pause the current executing thread
 * notify, randomly wakes up a thread which previously was paused by calling wait
 */
public class WaitAndNotify {
    private static final Logger Log = Logger.getLogger(WaitAndNotify.class.getName());

    private static class Data {
        private String packet;

        // True if receiver should wait
        // False if sender should wait
        private boolean transfer = true;

        public synchronized void send(String packet) {
            if (!transfer) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    Log.log(Level.SEVERE, "Thread interrupted " + e);
                }
            }
            transfer = false;

            this.packet = packet;
            notifyAll();
        }

        /**
         * here synchronized keyword is used because
         * If a thread calling wait() method does not own the inherent lock, an error will be thrown.
         */

        public synchronized String receive() {
            if (transfer) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    Log.log(Level.SEVERE, "Thread interrupted " + e);
                }
            }
            transfer = true;

            notifyAll();
            return packet;
        }
    }

    public static void main(String[] args) {
        final Data data =new Data();
        Thread sender = new Thread(()-> data.send("Sreekar Reddy"));
        Thread receiver = new Thread(()-> Log.info(data.receive()));
        sender.start();receiver.start();
    }
}
