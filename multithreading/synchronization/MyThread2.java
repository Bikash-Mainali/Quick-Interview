package multithreading.synchronization;

public class MyThread2 extends Thread {
    Table table;

    MyThread2(Table table) {
        this.table = table;
    }

    public void run() {
        table.printTable(100);
    }
}
