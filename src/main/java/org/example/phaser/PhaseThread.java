package org.example.phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadLocalRandom;

public class PhaseThread implements Runnable {

    Phaser phaser;
    String name;
    public PhaseThread(Phaser phaser, String n) {
        this.phaser = phaser;
        this.name = n;
        phaser.register();
    }

    @Override
    public void run() {

        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 6000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(name + " выполняем фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // СООБЩАЕМ, ЧТО ПЕРВАЯ ФАЗА ДОСТИГУНТА

        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 4000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(name + " выполняем фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // СООБЩАЕМ, ЧТО ВТОРАЯ ФАЗА ДОСТИГУНТА

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(name + " выполняем фазу " + phaser.getPhase());
        phaser.arriveAndDeregister(); // СООБЩАЕМ О ЗАВРШЕНИИ ФАЗ И УДАЛЯЕМ ОБЪЕКТЫ ИЗ РЕГИСТРАЦИИ
    }
}
