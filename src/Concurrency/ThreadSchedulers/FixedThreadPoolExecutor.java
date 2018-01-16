package Concurrency.ThreadSchedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExecutor {
    private static ExecutorService service= Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ThreadExecutor executor= new ThreadExecutor(true);
            service.submit(executor);
        }

        service.shutdown();
    }
}
