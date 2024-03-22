package org.example.cyclic_barrier;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());

        System.out.println("Запуск потоков");

        new MyThread(cb, "A");
        new MyThread(cb, "B");

        Thread.sleep(2000);

        new MyThread(cb, "C");
        Thread.sleep(3000);

        new MyThread(cb, "X");
        Thread.sleep(2000);

        new MyThread(cb, "Y");
        new MyThread(cb, "Z");

    }
}
