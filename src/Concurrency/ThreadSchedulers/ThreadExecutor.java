package Concurrency.ThreadSchedulers;

public class ThreadExecutor extends Thread{

    private boolean isSleepRequired;
    ThreadExecutor(boolean isSleepRequired){
        this.isSleepRequired=isSleepRequired;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" : Executed" );
        if (isSleepRequired)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}