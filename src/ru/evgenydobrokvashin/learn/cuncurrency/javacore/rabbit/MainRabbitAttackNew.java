package ru.evgenydobrokvashin.learn.cuncurrency.javacore.rabbit;

public class MainRabbitAttackNew {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new RabbitPrinter()).start();
    }
}

class RabbitPrinter implements Runnable {
    @Override
    public void run() {
        System.out.println("New rabbit " + Thread.currentThread().getName() + " - born!");
        int k = 0;
        while(k < 10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            new Thread(new RabbitPrinter()).start();

            k++;
        }
        System.out.println("Rabbit " + Thread.currentThread().getName() + " - die!");
    }
}