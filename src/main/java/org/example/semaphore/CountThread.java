package org.example.semaphore;

import java.util.concurrent.Semaphore;

public class CountThread implements Runnable {

    CommonResource resource;
    Semaphore semaphore;
    String name;

    public CountThread(CommonResource resource, Semaphore semaphore, String name) {
        this.resource = resource;
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " ожидает разрешение");
            semaphore.acquire();
            resource.a = 1;
            for (int i = 0; i < 5; i++) {
                System.out.println(this.name + " : " + resource.a);
                resource.a++;
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e) {e.getMessage();}
        System.out.println(name + " освобождает разрешение");
        semaphore.release();
    }
}
