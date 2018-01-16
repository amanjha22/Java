package Concurrency.ThreadSynchronizers;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    private static CyclicBarrier barrier = new CyclicBarrier(2); //Fixed number of parties

    public static void main(String[] args) {
        Thread t1= new Thread(CyclicBarrierExample::runThread);
        Thread t2= new Thread(CyclicBarrierExample::runThread);

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }

    private static void runThread(){
        try {
            Random random= new Random();
            for (int i = 0; i < 10; i++) {
                Thread.sleep(random.nextInt(4)*1000);
                System.out.println("Phase :" +(i+1)+ " Started By "+ Thread.currentThread().getName());
                barrier.await(); // Thread not advanceable , phaser provides arrive() method as an alternative
                System.out.println("Phase :" +(i+1)+ " Completed By "+ Thread.currentThread().getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
