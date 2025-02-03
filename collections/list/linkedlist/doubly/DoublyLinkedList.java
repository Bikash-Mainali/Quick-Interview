package linkedlist.doubly;

import java.util.ArrayList;
import java.util.List;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 12/15/21
 */
public class DoublyLinkedList {
    Node header;

    DoublyLinkedList() {
        header = new Node(null);
    }

    //adds to the front of the data_structure.list
    public void addFirst(String item) {
        Node newNode = new Node(item);
        //place new node after header and
        //establish links from new node to
        //surrounding nodes
        newNode.next = header.next;
        newNode.previous = header;

        //establish links from surrounding
        //nodes to the new node
        if (header.next != null) {
            header.next.previous = newNode;
        }
        header.next = newNode;
    }

    //adds to the end of the data_structure.list
    public void addLast(String item) {
        Node newNode = new Node(item);
        //find last node
        Node current = header;
        while (current.next != null) {
            current = current.next;
        }
        //now current.next == null
        current.next = newNode;
        newNode.previous = current;
    }

    //removes node in last position
    public void removeLast() {
        //if data_structure.list is empty, return
        if (header.next == null) return;

        Node current = header;
        //traverse the data_structure.list until current.next is
        //null - then remove current
        while (current.next != null) {
            current = current.next;
        }
        //now current.next == null, so remove current
        Node previous = current.previous;
        //previous is not null since current is not header
        previous.next = null;
        current.previous = null;
    }

    //determines whether the input string is in the data_structure.list
    public boolean search(String s) {
        Node next = header.next;
        while (next != null && !next.value.equals(s)) {
            next = next.next;
        }
        //either next == null or next.value is s
        if (next == null) return false;
        else {//next.value.equals(s)
            return true;
        }
    }

    public String toString() {
        var sb = new StringBuffer();
        Node next = header.next;
        while (next != null) {
            sb.append(next.toString() + ", ");
            next = next.next;
        }
        var result = sb.toString().trim();
        if (result.length() == 0) return "<empty data_structure.list>";
        if (result.charAt(result.length() - 1) == ',') {
            return result.substring(0, result.length() - 1);
        }
        return result;
    }

    class Node {
        String value;
        Node next;
        Node previous;

        Node(String value) {
            this.value = value;
        }

        public String toString() {
            return value == null ? "null" : value;
        }
    }

    public static void main(String[] args) {
        var list = new DoublyLinkedList();
        list.addLast("Rich");
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.addFirst("Bob");
        list.addFirst("Harry");
        list.addFirst("Steve");
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        System.out.println(list.search("Harry"));
        System.out.println(list.search("Bob"));
        list.addLast("Tom");
        System.out.println(list);
        List<String> list1 = new ArrayList<>();
    }
}
