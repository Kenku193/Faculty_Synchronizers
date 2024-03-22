package org.example.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread implements Runnable{
    CyclicBarrier cbar;
    String name;
    public MyThread(CyclicBarrier c, String n) {
        cbar = c;
        name = n;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name);

        try{
            cbar.await();
        }
        catch (BrokenBarrierException e) {
            System.out.println(e);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }

        System.out.println(name + " is finished!");

    }

}
