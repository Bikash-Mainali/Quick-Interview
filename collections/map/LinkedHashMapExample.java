package collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/26/22
 */
//it uses HashMap primarily
//it uses doubly linked list to maintain order of insertion
//it maintains order of insertion
public class LinkedHashMapExample {
    public static void main(String[] args) {
        String s = "text";
        String result = "";
        for(int i = s.length()-1; i >= 0 ; i--){
            result =  result + s.charAt(i);
        }
        System.out.println(result);
    }
}
