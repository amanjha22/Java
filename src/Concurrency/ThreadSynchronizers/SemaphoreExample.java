package Concurrency.ThreadSynchronizers;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    private static Semaphore semaphore= new Semaphore(2,true);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1= new Thread(SemaphoreExample::useCriticalSection);
        Thread thread2= new Thread(SemaphoreExample::useCriticalSection);
        Thread thread3= new Thread(SemaphoreExample::useCriticalSection);
        Thread thread4= new Thread(SemaphoreExample::useCriticalSection);
        Thread thread5= new Thread(SemaphoreExample::useCriticalSection);

        thread1.start();
        Thread.sleep(10);
        thread2.start();
        Thread.sleep(10);
        thread3.start();
        Thread.sleep(10);
        thread4.start();
        Thread.sleep(10);
        thread5.start();

    }

    private static void useCriticalSection(){
        try {
            semaphore.acquire();
            System.out.println("Current Thread: "+ Thread.currentThread().getName() +" , LOCK ACQUIRED, INSIDE CRITICAL SECTION");
            Thread.sleep(1000);
            semaphore.release();
            System.out.println("Current Thread: "+ Thread.currentThread().getName() +" , LOCK RELEASED, OUTSIDE CRITICAL SECTION");
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
