package collections.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/26/22
 */
//FailFastIterator throws ConcurrentModificationException if a collection is modified while iterating over it.
//It uses original collection to traverse over the elements of the collection.
public class FailFastIterator {
    public static void main(String[] args) {
        List<String> alphabet = new ArrayList<>();
        alphabet.add("a");
        alphabet.add("b");
        alphabet.add("c");

        alphabet.removeIf(p -> p.equals("a")); // does not throw exception

        Iterator<String> iterator = alphabet.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            alphabet.remove("c");  // throws exception
            if (element.equals("c"))  // does not throw exception
                iterator.remove();
        }
        System.out.println(alphabet);
    }
}
