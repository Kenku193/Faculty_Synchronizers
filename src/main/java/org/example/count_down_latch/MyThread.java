package org.example.count_down_latch;

import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable{

    CountDownLatch latch;

    public MyThread(CountDownLatch c) {
        latch = c;
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println("Событие: " + i);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
        }
            latch.countDown();
        }
    }
}
