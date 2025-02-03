package java8.functionalinterface.supplier;

import java.util.function.Supplier;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/21/22
 */
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String>  supplier = () ->  "Bikash Mainali";
        System.out.println(supplier.get());
    }
}
