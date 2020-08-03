package com.multiThreading;

/**
 * If you want to store a data specific to a thread
 * we can store it in ThreadLocal
 * mainly used to avoid sync. issues for a stored Object
 * https://www.baeldung.com/java-threadlocal
 */
public class ThreadLocalExample {
    enum bolExp {
        t(true), f(false);
        boolean value;

        bolExp(boolean value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final UserRepository userRepository = new UserRepository();
        Thread thread = new Thread(() -> {
            ThreadLocal<UserContext> threadLocal = new ThreadLocal<>();
            threadLocal.set(new UserContext(userRepository.getUserId()));
            System.out.println(threadLocal.get());

        });
        thread.start();
        thread.join();
    }

    private static class UserContext {
        String userId;

        UserContext(String userId) {
            this.userId = userId;
        }

        @Override
        public String toString() {
            return "UserContext{" +
                    "userId='" + userId + '\'' +
                    '}';
        }
    }

    private static class UserRepository {

        String getUserId() {
            return "User_IN_1562";
        }
    }
}




