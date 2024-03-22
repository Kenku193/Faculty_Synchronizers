package org.example.reentrant_lock;

import java.util.concurrent.locks.ReentrantLock;

public class CountTask implements Runnable {

    CommonResource res;
    ReentrantLock lock;
    public CountTask(CommonResource r, ReentrantLock l) {
        this.res = r;
        this.lock = l;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        finally {
            lock.unlock();
        }
    }
}
