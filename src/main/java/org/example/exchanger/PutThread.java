package org.example.exchanger;

import java.util.concurrent.Exchanger;

public class PutThread implements Runnable {
    Exchanger<String> exchanger;
    String message;

    public PutThread(Exchanger<String> ex) {
        this.exchanger = ex;
        this.message = "Я сообщение от PutThread";
    }

    @Override
    public void run() {
        try {
            System.out.println("Выполняю обмен сообщениями");
            String gettedBackMessage = exchanger.exchange(message);
            System.out.println("Я PutThread, я получил в ответ: " + gettedBackMessage);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
