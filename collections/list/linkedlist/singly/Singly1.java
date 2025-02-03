package linkedlist.singly;

/**
 * simply adding node to the end
 */

public class Singly1 {

    //Represent a node of the singly linked list
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(data + " ");
            sb = toString(sb, next);
            return sb.toString();
        }

        private StringBuilder toString(StringBuilder sb, Node n) {
            if (n == null) return sb;
            sb.append(n.data + " ");
            return toString(sb, n.next);
        }
    }

    //Represent the head and tail of the singly linked list
    public Node head = null;
    public Node tail = null;

    //addNode() will add a new node to the list
    public void addNode(int data) {
        //Create a new node
        Node newNode = new Node(data);

        //Checks if the list is empty
        if (head == null) {
            //If list is empty, both head and tail will point to new node
            // At first node is added and this node will be head and tail both.
            head = newNode;
            tail = newNode;
        } else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;   //important to note here
            //newNode will become new tail of the list
            tail = newNode;
        }
    }

    //display() will display all the nodes present in the list
    public void display() {
        //Node current will point to head
        System.out.println("nodes are: " + head);  // this can prints all nodes present using toString method and recursion

        //Below portion is only for understanding without recursion
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while (current != null) {
            //Prints each node by incrementing pointer
            System.out.print("nodes are: " + current + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {

        Singly1 sList = new Singly1();

        //Add nodes to the list
        sList.addNode(1);
        sList.addNode(2);
        sList.addNode(3);
        sList.addNode(4);

        //Displays the nodes present in the list
        sList.display();
    }
}
