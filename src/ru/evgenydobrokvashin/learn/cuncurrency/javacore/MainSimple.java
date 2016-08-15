package ru.evgenydobrokvashin.learn.cuncurrency.javacore;

import java.util.Arrays;

public class MainSimple {

    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world! from " + Thread.currentThread().getName());
            }
        });
        printThreadInfo(Thread.currentThread());

        thread.setName("John thread");
        printThreadInfo(thread);

        thread.start();
        printThreadInfo(thread);
        thread.join();

        System.out.println("Hello world! " + Thread.currentThread().getName());
    }

    private static void printThreadInfo(Thread thread) {
        if (null != thread) {
            System.out.println("name: " + thread.getName() +
                    "\tId: " + thread.getId() +
                    "\tPriority: " + thread.getPriority() +
                    "\tState: " + thread.getState() +
                    "\tThreadGroup: " + thread.getThreadGroup() +
                    "\tStackTrace: " + Arrays.toString(thread.getStackTrace())
            );
        }
    }
}