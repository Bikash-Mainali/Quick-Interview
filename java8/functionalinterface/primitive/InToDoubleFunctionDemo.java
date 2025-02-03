package java8.functionalinterface.primitive;

import java.util.function.IntToDoubleFunction;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/21/22
 */
public class InToDoubleFunctionDemo {
    public static void main(String[] args) {
        IntToDoubleFunction intToDoubleFunction = (intValue) ->  intValue;
        System.out.println(intToDoubleFunction.applyAsDouble(100));
    }
}
