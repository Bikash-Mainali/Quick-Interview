package collections.iterator;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/26/22
 */
public class FailSafeIterator {
    public static void main(String args[]) {

        //example: CopyOnWriteArrayList
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            list.add(14);    // this will not print here so created a separate copy adding 14 to original list in each iteration
        }

        System.out.println("original collection: " + list);

        //example: concurrent hashmap. Concurrent hashmap allows manipulation while iterating over it.
        //but concurrent hashmap does not create a separate copy
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THREE", 3);
        map.put("FOUR", 4);
        map.put("FOUR", 4);

        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key + " : " + map.get(key));
            map.put("SEVEN", 7); // This will reflect in iterator. Hence, it has not created separate copy
            map.remove("FOUR");
        }
        System.out.println(map);
    }
}
