package collections.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/26/22
 */
//it does not allow null key and null value
    //uses HashTable
    //it does not maintain insertion order
    //synchronized (thread safe)
    //good performance than HashMap as resizing happens quickly
public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("v", null);  // does not contain null value or null key or both
        map.put("a", "aa");
        map.put("x", "xx");
        map.put("t", "tt");
        map.put("b", "bb");
        System.out.println(map);
    }
}
