package org.example.exchanger;

import java.util.concurrent.Exchanger;

public class GetThread implements Runnable {

    Exchanger<String> exchanger;
    String message;

    public GetThread(Exchanger<String> ex) {
        this.exchanger = ex;
        this.message = "Я сообщение от GetThread";
    }

    @Override
    public void run() {
        try {
            System.out.println("Выполняю обмен сообщениями");
            String gettedBackMessage = exchanger.exchange(message);
            System.out.println("Я GetThread, я получил в ответ: " + gettedBackMessage);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

