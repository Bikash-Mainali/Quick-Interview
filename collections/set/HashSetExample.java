package collections.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/26/22
 */

//it uses hash table to store elements. Value is stored as a key and PRESENT (static object) is used as a value
//it does not maintain insertion order
//it allows null values but store only one
public class HashSetExample {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("lamda", "lamda");

        Set<String> hashSet = new HashSet<>(list);
        hashSet.add(null);
        hashSet.add(null);
        hashSet.add("alpha");
        hashSet.add("testing");
        hashSet.add("gama");
        hashSet.add("beta");

        System.out.println(hashSet);

    }
}
