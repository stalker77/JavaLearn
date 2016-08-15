package ru.evgenydobrokvashin.learn.cuncurrency.javacore.accordion;

import ru.evgenydobrokvashin.learn.cuncurrency.javacore.PrintRunnable;

public class MainPlayTheAccordionNew {

    public static void main(String[] args) throws InterruptedException {

            Thread threadCoordinator = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int k = 0; k < 10; k++) {
                        try {
                            Thread threadA = new Thread(new PrintRunnable("A  .", 100));
                            threadA.start();
                            Thread threadB = new Thread(new PrintRunnable(".  B", 99));
                            threadB.start();
                            threadA.join();
                            threadB.join();

                            System.out.println("-----");
                            Thread threadC = new Thread(new PrintRunnable("  C", 100));
                            threadC.start();
                            threadC.join();
                            System.out.println("-----");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });

            threadCoordinator.start();
            threadCoordinator.join();
    }
}

