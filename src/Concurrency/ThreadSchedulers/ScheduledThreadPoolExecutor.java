package Concurrency.ThreadSchedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutor {

    private static ScheduledExecutorService service= Executors.newScheduledThreadPool(2);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            ThreadExecutor executor= new ThreadExecutor(false);
            service.schedule(executor,2, TimeUnit.SECONDS);
        }

        for (int i = 0; i < 2; i++) {
            ThreadExecutor executor= new ThreadExecutor(true);
            service.scheduleAtFixedRate(executor, 2,2, TimeUnit.SECONDS);
        }

        for (int i = 0; i < 2; i++) {
            ThreadExecutor executor= new ThreadExecutor(true);
            service.scheduleWithFixedDelay(executor, 2,2, TimeUnit.SECONDS);
        }

        Thread.sleep(50000);
        service.shutdown();
    }
}
