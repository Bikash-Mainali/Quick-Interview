package multithreading.synchronization.synchronizedblock;

public class Main {
    public static void main(String[] args) {
        Table singleObject = new Table();
        MyThread1 thread1 = new MyThread1(singleObject);
        thread1.start();
    }
}
