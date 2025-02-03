package multithreading.join;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 4/7/23
 */
public class MainThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ChildThread());
        Thread t2 = new Thread(new ChildThread());

        t1.start();
        t2.start();

        try {
            t1.join(); // main thread waits for t1 to complete
            t2.join(); // main thread waits for t2 to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All child threads have completed their tasks, main thread resumes.");
    }
}

class ChildThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Child thread started.");
        try {
            Thread.sleep(5000); // simulate some task being performed by the child thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Child thread completed.");
    }
}
