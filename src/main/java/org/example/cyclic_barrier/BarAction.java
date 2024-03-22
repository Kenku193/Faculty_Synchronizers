package org.example.cyclic_barrier;

public class BarAction implements Runnable {
    @Override
    public void run() {
        System.out.println("Барьер достигнут");
    }
}
