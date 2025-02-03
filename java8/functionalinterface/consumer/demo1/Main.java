package java8.functionalinterface.consumer.demo1;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/20/22
 */
public class Main {
    public static void main(String[] args) {
        ConsumerImpl consumerImpl = new ConsumerImpl();
        consumerImpl.accept("consumer functional interface");
    }
}
