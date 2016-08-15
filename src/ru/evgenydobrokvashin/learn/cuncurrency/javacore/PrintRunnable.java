/*
* This class...
*
* Created by Evgeny Dobrokvashin (aka Stalker) on 24.07.16 
*
* Copyright (c) 2016 MegaFon, All Rights Reserved.
*/

package ru.evgenydobrokvashin.learn.cuncurrency.javacore;

/**
 * @author Evgeny Dobrokvashin
 *         <p/>
 *         Created by Stalker on 24.07.16.
 * @version 1.0 Jul 2016
 */
public class PrintRunnable implements Runnable {
    private String msg;
    private long sleepMillis;

    public PrintRunnable(String msg, long sleepMillis) {
        this.msg = msg;
        this.sleepMillis = sleepMillis;
    }

    @Override
    public void run() {
        for (int k = 0; k < 10; k++) {
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(msg);
        }
    }
}
