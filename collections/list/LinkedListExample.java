package collections.list;

import java.util.LinkedList;
import java.util.List;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/26/22
 */
//it maintains insertion order
//it uses doubly linked list
//used to insert O(1) at the beginning and ending position
public class LinkedListExample {
    public static void main(String[] args) {
        List<String> linkedList = new LinkedList<>();
        linkedList.add("bikash");
        linkedList.add("Apple");
        linkedList.add("BIk");
        System.out.println(linkedList);
    }
}
