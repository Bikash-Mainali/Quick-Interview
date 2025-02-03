package java8.functionalinterface.consumer.biconsumer;

import java.util.function.BiConsumer;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/21/22
 */
public class BiConsumerDemo {
    public static void main(String[] args) {

        BiConsumer<String, Double> biConsumer = (param1, param2) -> System.out.println(Double.valueOf(param1) + param2);
        biConsumer.accept("12.00", 34.00);
    }
}
