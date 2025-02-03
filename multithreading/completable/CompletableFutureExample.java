package multithreading.completable;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 4/9/23
 */
public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService poolForCPUBound = Executors.newFixedThreadPool(5);
        ExecutorService poolForIOBound = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            String orderNo = "order " + i;
            CompletableFuture.supplyAsync(() -> getOrder(orderNo))
                    .thenApplyAsync(order -> addToCart(order), poolForCPUBound)
                    .thenApply(order -> checkOut(order))
                    .thenApply(order -> performPayment(order))
                    .exceptionally(order -> new RuntimeException("payment failed"))
                    .thenAcceptAsync(order -> sendEmail(order), poolForIOBound);
        }
        System.out.println("main thread can do other tasks");

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("first" + Thread.currentThread().getName());
            return "Hello";
        });
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> {
            System.out.println("second" + Thread.currentThread().getName());
            return "Beautiful";
        });
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture
                = CompletableFuture.allOf(future1, future2, future3);

        String result = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        System.out.println(result);
        Optional.of("baeldung")
                .orElse(getRandomName());
    }
    public static String getRandomName() {
        System.out.println("hello");
        return "hello";
    }
    public static String getOrder(final String orderNo) {
        return orderNo;
    }

    public static Object addToCart(Object order) {
        //perform IO (database) call
        return order + "->cart";
    }

    public static Object checkOut(Object order) {
        return order + "->checkout";
    }

    public static Object performPayment(Object order) {
        if (order.toString().contains("2"))
            throw new RuntimeException();  //for exception check
        return order + "->payment";
    }

    public static void sendEmail(Object order) {
        //send http request
        System.out.println("email sent: " + order);
    }
}
