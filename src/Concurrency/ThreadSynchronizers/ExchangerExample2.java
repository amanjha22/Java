package Concurrency.ThreadSynchronizers;

import java.util.concurrent.Exchanger;

public class ExchangerExample2 {
    private static Exchanger<Object> exchanger =new Exchanger<>();

    public static void main(String[] args) {
        Thread even = new Thread(ExchangerExample2::runEvenThread);
        Thread odd = new Thread(ExchangerExample2::runOddThread);

        odd.start();
        even.start();
    }

    private static void runEvenThread(){
        for (int i = 2; i <=100; i+=2) {
            try {
                exchanger.exchange("Even");
                System.out.println(i);
                exchanger.exchange("Even");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void runOddThread(){
        for (int i = 1; i <=100 ; i+=2) {
            try {
                System.out.println(i);
                exchanger.exchange("Odd");
                exchanger.exchange("Odd");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
