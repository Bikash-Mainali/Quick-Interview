package collections.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/26/22
 */
//it allows one null key, many null values
//it uses hash table to store elements
//it does not maintain order of insertion
//non-synchronized (not thread safe)

public class HashMapExample {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        map.put(null, null);
        map.put("y", null);
        map.put("a", "aa");
        map.put("x", "xx");
        map.put("t", "tt");
        map.put("b", "bb");
        System.out.println(map);
    }
}
