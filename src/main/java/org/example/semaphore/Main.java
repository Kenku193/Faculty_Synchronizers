package org.example.semaphore;

import java.util.concurrent.Semaphore;

// ТОЧКА ВХОДА
public class Main {
    public static void main(String[] args) {
        // СОЗДАЕМ СЕМАФОР - ОБЩИЙ ДЛЯ ПОТОКОВ
        Semaphore semaphore = new Semaphore(1); // ОДНО РАЗРЕШЕНИЕ - В ЕДИНИЦУ ВРЕМЕНИ С РЕСУРСОМ МОЖЕТ РАБОАТЬ 1 ПОТОК
        // СОЗДАЕМ ОБЩИЙ РЕСУРС
        CommonResource commonResource = new CommonResource();

        // ИНДЖЕКТИМ ЧЕРЕЗ КОНСТРУКТОР В ПОТОЧНЫЙ ОБЪЕКТ ОБЩИЕ РЕСУРС И СЕМАФОР, А ТАКЖЕ ИМЕНА ПОТОКОВ
        // ТУТ ЖЕ ЗАПУСКАЕМ
        new Thread(new CountThread(commonResource, semaphore, "Поток номер 1")).start();
        new Thread(new CountThread(commonResource, semaphore, "Поток номер 2")).start();
        new Thread(new CountThread(commonResource, semaphore, "Поток номер 3")).start();
    }
}
