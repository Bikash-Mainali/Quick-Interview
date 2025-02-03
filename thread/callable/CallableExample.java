package thread.callable;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 8/4/22
 */
public class CallableExample implements Callable {

    public Object call(){
        return 100;
    }

    public static void main(String[] args) throws Exception {
        CallableExample task = new CallableExample();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Future<Integer> future = executor.submit(task);
        System.out.println(future.get());
    }
}
