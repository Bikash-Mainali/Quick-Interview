package java8.StreamAPI.parallelStream;

import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 1/27/23
 */
public class ParallelStreamDemo {
    public static void main(String[] args) {
        List<String> list = List.of("1", "2", "3", "4", "5", "6", "7");
        list.stream().forEach(l -> System.out.println(l + " " + Thread.currentThread().getName()));

        System.out.println("////////");
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        listOfNumbers.parallelStream().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );
    }

    /**
     * Real Life Application
    List<Transaction> transactions = ... // a list of transactions

    // Use a parallel stream to filter and sum transactions in parallel
    double totalAmount = transactions.parallelStream()
            .filter(t -> t.getType() == TransactionType.GROCERY)
            .mapToDouble(Transaction::getAmount)
            .sum();

System.out.println("Total amount spent on groceries: " + totalAmount);
     */
}
