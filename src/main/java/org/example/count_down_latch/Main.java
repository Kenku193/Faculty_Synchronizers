package org.example.count_down_latch;

import java.util.concurrent.CountDownLatch;
/*
* Иногда требуется, чтобы поток исполнения находился в режиме ожидания
* до того момента, пока не произойдут какие-то события
* То есть мы не даем запуститься потоку до какого-то момента.
*
* Объект класа CountDownLatch создается с кол-вом событий, которые
* долдны произойти до того момента, как будет снята самоблокировка.
*/

public class Main {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);
        System.out.println("Запуск потока исполнения");
        new Thread(new MyThread(cdl)).start();
        try {
            cdl.await();
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("Завершение потока исполнения");
    }
}
