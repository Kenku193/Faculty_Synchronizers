package org.example.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Store {

    private int product = 0;
    ReentrantLock lock;
    Condition condition;

    public Store(ReentrantLock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    public void get(){
        lock.lock();
        try {
            // ПОКА НЕТ ДОСТУПНЫХ ТОВАРОВ НА СКЛАДЕ - ОЖИДАЕМ
            while (product<1) condition.await();

            // КАК ТОЛЬКО ПОЯВЛЯЮТСЯ
            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товаров на складе: " + product);

            // СИГНАЛИЗИРУЕМ
            condition.signalAll();
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        finally {
            lock.unlock();
        }
    }

    public void put() {
        lock.lock();
        try {
            while (product>3) condition.await();

            product++;
            System.out.println("Производитель добавил 1 товар на склад");
            System.out.println("Товаров на складе: " + product);

            // СИГНАЛИЗИРУЕМ
            condition.signalAll();
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        finally {
            lock.unlock();
        }
    }
}
