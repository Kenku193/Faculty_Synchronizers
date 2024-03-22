package org.example.reentrant_lock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        CommonResource commonResource = new CommonResource();
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 6; i++) {
            Thread t = new Thread(new CountTask(commonResource, lock));
            t.setName("Thread " + i);
            t.start();
        }

    }
}
