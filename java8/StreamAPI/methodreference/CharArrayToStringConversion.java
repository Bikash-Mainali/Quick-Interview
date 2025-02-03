package java8.StreamAPI.methodreference;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/22/22
 */
public class CharArrayToStringConversion {
    public static void main(String[] args) {
        char[] chars = {'b', 'i', 'k' ,'a', 's', 'h'};
        Function<char[], String> function = String::new;  //(x) -> return new String(x);
        String str = function.apply(chars);
        System.out.println(str);

        //usual way
        System.out.println(String.valueOf(chars));
    }
}
