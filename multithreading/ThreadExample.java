package multithreading;
/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 3/15/23
 */
public class ThreadExample extends Thread implements  Runnable{

    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println(i);
            System.out.println(Thread.currentThread().getName());
        }
    }
    public static void main(String args[]) throws InterruptedException {
        ThreadExample t1=new ThreadExample();
        t1.start();
        Runtime runtime = Runtime.getRuntime();
        //runtime.addShutdownHook(t1);
        for(int i = 0; i < 10; i ++){
            System.out.println("main thread");
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1500);
        }
    }
}
