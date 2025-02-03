package java8.functionalinterface.consumer.demo3;

import java.util.function.Consumer;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/20/22
 */
public class Main {
    public static void main(String[] args) {
        Consumer consumer  = (s) -> System.out.println(s);
        consumer.accept("consumer functional interface demo 3");
    }
}
