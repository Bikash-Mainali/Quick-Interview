package collections.set;

import java.util.*;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 2/13/23
 */
//Tree set implements SortedSet interface
//It does not allow null value
//sorted in ascending order so no insertion order
public class SortedSetExample {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>(new SortedComparator());
        //sortedSet.add(null);
        sortedSet.add("a");
        sortedSet.add("b");
        sortedSet.add("c");
        System.out.println(sortedSet);
    }
}

class SortedComparator implements  Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}
