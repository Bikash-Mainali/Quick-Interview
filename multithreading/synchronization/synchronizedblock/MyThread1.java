package multithreading.synchronization.synchronizedblock;

public class MyThread1 extends Thread {
    Table table;

    MyThread1(Table table) {
        this.table = table;
    }

    public void run() {
        table.printTable(5);
        table.printTable2(5);
    }
}
