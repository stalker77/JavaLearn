package ru.evgenydobrokvashin.learn.cuncurrency.javacore.rabbit;

import ru.evgenydobrokvashin.learn.cuncurrency.javacore.PrintRunnable;

public class MainRabbitAttack {

    public static void main(String[] args) throws InterruptedException {
        for (int k = 1; k < 100; k++) {
            String spaces = spaces(k);
            Runnable printer = new PrintRunnable(spaces + k, 100);
            Thread thread = new Thread(printer);
            thread.start();
            Thread.sleep(100);
        }
    }

    private static String spaces(int k) {
        String result = "";
        if (k > 0) {
            result =  String.format("%1$" + k + "s", "");
        }

        return result;
    }
}