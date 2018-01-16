package Concurrency.ThreadSynchronizers;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    private static CountDownLatch latch= new CountDownLatch(2); //Fixed Number of Parties

    public static void main(String[] args) throws InterruptedException {
        Thread thread1= new Thread(CountDownLatchExample::runThread);
        Thread thread2= new Thread(CountDownLatchExample::runThread);

        thread1.setName("Thread-1");
        thread2.setName("Thread-2");

        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }

    private static void runThread(){
        try {
            latch.countDown(); //Advanceable, Can complete phase and advance without waiting, similar to arrive() in phaser
            System.out.println("Count down: "+ Thread.currentThread().getName());
            latch.await(); // Waits for N(Passed as parameter while latch object creation0 threads to call this method, thread block at this call until then
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Released: "+Thread.currentThread().getName());
    }
}
