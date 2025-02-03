package collections.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/26/22
 */

//it uses doubly linked list to maintain order of insertion
//it maintains order of insertion
public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("b");
        linkedHashSet.add("a");
        linkedHashSet.add("c");
        System.out.println(linkedHashSet);
        linkedHashSet.stream().sorted((o1, o2) -> o2.compareTo(o1)).forEach(System.out::println);
        linkedHashSet.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}

