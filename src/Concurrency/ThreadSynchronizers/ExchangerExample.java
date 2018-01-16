package Concurrency.ThreadSynchronizers;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    private static Exchanger<String> exchanger= new Exchanger<>();

    public static void main(String[] args) {
        Thread t1= new Thread(ExchangerExample::doExchange);
        Thread t2= new Thread(ExchangerExample::doExchange);
        Thread t3= new Thread(ExchangerExample::doExchange);

        t1.start();
        t2.start();

        t3.start(); // This will wait until some thread calls exchange, can be used to maintain dependency on two threads
    }

    private static void doExchange(){
        try {
            String received=exchanger.exchange(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName()+" received : "+ received);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
