package Concurrency.ThreadSchedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolExecutor {
    private static ExecutorService executorService= Executors.newSingleThreadExecutor();  //Enables Thread Reclamation but creates new threads if none of the others previously created are free

    public static void main(String[] args) {
        for(int i=0;i<10; i++){
            ThreadExecutor executor=new ThreadExecutor(false);
            executorService.submit(executor);
        }

        executorService.shutdown();
    }
}
