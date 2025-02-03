package linkedlist;

import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 8/7/22
 */
public class LinkedListTest {

    Node head;
    Node tail;

    class Node {
        Node next;
        String data;

        Node(String data) {
            this.data = data;
        }

        public String toString() {
            return data;
        }
    }

    private void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void print() {
        Node current = head;
        StringBuilder result = new StringBuilder();
        while (current != null) {
            result.append(current.data).append("->");
            current = current.next;
        }
        System.out.println(result);
    }

    public void remove(int index) {
        if (size() == 1 && index == 0) {
            head = null;
            tail = null;
        } else {
            if (index == 0) {
                new LinkedListTest().removeFirst();
            } else {
                new LinkedListTest().removeAny(index);
            }
        }
    }

    public void removeFirst() {
        Node current = head;
        head.next = null;
        head = current.next;
    }

    public void removeAny(int index) {
        Node prev = null;
        Node next = null;
        Node current = head;
        for (int i = 0; i < size(); i++) {
            if (i == index) {
                current = next;
                next = current.next;
                break;
            }
            current = head;  //a
            prev = current;
            next = current.next;  //b
        }
        System.out.println("prev " + prev);
        System.out.println("current " + current);
        System.out.println("next " + next);
        prev.next = next;
        current.next = null;
    }

    public int size() {

        Node current = head;
        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }

        return size;
    }


    public static void main(String[] args) {
        LinkedListTest linkedListTest = new LinkedListTest();
        String[] arr = {"a", "b", "c"};
        //insert
        Stream.of(arr).forEach(x -> linkedListTest.add(x));

        //print list
        linkedListTest.print();

        //remove
        linkedListTest.remove(1);

        //size
        System.out.println(linkedListTest.size());

        System.out.println("list after remove " + linkedListTest.size());
        linkedListTest.print();
    }
}
