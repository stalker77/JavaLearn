package ru.evgenydobrokvashin.learn.cuncurrency.javacore.accordion;

import ru.evgenydobrokvashin.learn.cuncurrency.javacore.PrintRunnable;

import java.util.Arrays;

public class MainPlayTheAccordion {

    public static void main(String[] args) throws InterruptedException {
        for (int k = 0; k < 10; k++) {
            Runnable printerA = new PrintRunnable("A  .", 100);
            Thread threadA = new Thread(printerA);
            threadA.start();
            Runnable printerB = new PrintRunnable(".  B", 99);
            Thread threadB = new Thread(printerB);
            threadB.start();
            threadA.join();
            threadB.join();

            System.out.println("-----");
            Runnable printerC = new PrintRunnable("  C", 100);
            printerC.run();
            System.out.println("-----");
        }
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

