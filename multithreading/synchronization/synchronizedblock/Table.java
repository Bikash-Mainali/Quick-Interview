package multithreading.synchronization.synchronizedblock;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 4/8/23
 */
public class Table {
    synchronized public void printTable(int n) {
            System.out.println(" Thread name " + Thread.currentThread().getName());
            printTable2(4);

    }
    synchronized public void printTable2(int n) {
            System.out.println(" Thread name " + Thread.currentThread().getName());
    }
}

