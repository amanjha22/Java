package Concurrency.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueExample {
    private static BlockingQueue<Integer> blockingQueue= new LinkedBlockingQueue<>(1);

    public static void main(String[] args) {
        Thread producer= new Thread(LinkedBlockingQueueExample::runProducer);
        Thread consumer= new Thread(LinkedBlockingQueueExample::runConsumer);

        producer.start();
        consumer.start();
    }

    private static void runProducer(){
        for(int i=1; i<=10;i++){
            try {
                blockingQueue.put(i);
                System.out.println("Producing: "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void runConsumer(){
        for (int i=0;i<=10; i++){
            try {
                Thread.sleep(1000);
                System.out.println("Consuming: "+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
