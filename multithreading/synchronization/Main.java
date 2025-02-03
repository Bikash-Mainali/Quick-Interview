package multithreading.synchronization;

public class Main {
    public static void main(String[] args) {
        Table object1 = new Table();
        Table object2 = new Table();

        MyThread1 thread1 = new MyThread1(object1);
        MyThread2 thread2 = new MyThread2(object2);

        thread1.start();
        thread2.start();
    }
}
