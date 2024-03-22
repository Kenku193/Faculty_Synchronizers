package org.example.phaser;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {

        Phaser phaser = new Phaser(1);
        new Thread(new PhaseThread(phaser, "PhaseThread 1")).start();
        new Thread(new PhaseThread(phaser, "PhaseThread 2")).start();

        // ЖДЕМ ЗАВЕРШЕНИЯ ФАЗЫ 0
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ЖДЕМ ЗАВЕРШЕНИЯ ФАЗЫ 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ЖДЕМ ЗАВЕРШЕНИЯ ФАЗЫ 2
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();

    }
}
