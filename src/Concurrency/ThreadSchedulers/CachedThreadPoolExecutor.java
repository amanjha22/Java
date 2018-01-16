package Concurrency.ThreadSchedulers;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExecutor {
    private static ExecutorService executorService = Executors.newCachedThreadPool();  //Enables Thread Reclamation but creates new threads if none of the others previously created are free

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ThreadExecutor executor = new ThreadExecutor(false);
            executorService.submit(executor);

            Random random = new Random();
            try {
                int val = random.nextInt(5);
                Thread.sleep(((val + 1) * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }
}
