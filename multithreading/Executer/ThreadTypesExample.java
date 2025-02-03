package multithreading.Executer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 4/8/23
 */
public class ThreadTypesExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Thread.activeCount());
        for (int i = 0; i < 3; i++) {
            service.execute(new Task());
        }
        System.out.println("Thread name : " + Thread.currentThread().getName());

/*
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        // task to run after 10 seconds delay
        scheduledExecutorService.schedule(new Task(), 10, TimeUnit.SECONDS);

        // task to run repeatedly every 10 seconds
        scheduledExecutorService.scheduleAtFixedRate(new Task(), 15, 10, TimeUnit.SECONDS);

        // task to run repeatedly every 10 seconds after previous task completes
        scheduledExecutorService.scheduleWithFixedDelay(new Task(), 15, 10, TimeUnit.SECONDS);

*/
    }
    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread name : " + Thread.currentThread().getName());
        }
    }
}
