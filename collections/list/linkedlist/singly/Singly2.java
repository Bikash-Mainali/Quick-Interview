package linkedlist.singly;

public class Singly2 {
    public Node startNode = null;  //this is head
    public Node tail = null;

    void insert(String s, int pos) {
        int size = size();
        if (pos < 0 || pos > size) {
            throw new IllegalArgumentException(
                    "Illegal position for new node");
        }
        if (pos == size) {
            addLast(s);
        } else if (pos == 0) {
            addFirst(s);
        } else {
            int count = 0;
            Node prev = startNode;
            Node next = startNode;

            while (count != pos) {
                count++;
                prev = next;
                next = next.next;
            }

            Node newNode = new Node(s);
            if (count == 0) {
                //empty linked list so add new node
                startNode = newNode;
            }
            newNode.next = next;
            prev.next = newNode;
        }
    }

    /**
     * size = the number of non-null nodes
     */
    int size() {
        if (startNode == null) return 0;
        Node temp = startNode;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    boolean search(String s) {
        if (startNode != null) {
            if (s == null) return false;
            Node current = startNode;
            while (current != null) {
                String t = startNode.data;
                if (s.equals(t)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    void removeNode(String s) {
        if (s == null) {
            return;
        }
        if (startNode != null && startNode.data.equals(s)) {
            //if there is only one node in list
            // assign null value to the start node or break the link
            startNode = startNode.next;
            return;
        }

        //break the link
        Node previous = startNode;
        Node next = startNode.next;
        while (next != null) {
            if (s.equals(next.data)) {
                previous.next = next.next;
                return;
            }
            previous = next;
            next = next.next;
        }
    }

    void printNodes() {
        if (startNode != null) {
            System.out.println(startNode.toString());  //calling toString() in Node
            System.out.println();
        }
    }

    void addFirst(String s) {
        Node newNode = new Node(s);
        if (startNode != null) {
            newNode.next = startNode;
            startNode = newNode;
        } else {
            startNode = new Node(s);
            startNode.data = s;
        }
    }

    void addLast(String s) {
        Node newNode = new Node(s);
        //if startNode == null, set startNode to be newNode
        if (startNode == null) {
            startNode = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            if (data == null) return "";
            StringBuilder sb = new StringBuilder(data + " ");
            sb = toString(sb, next);
            return sb.toString();
        }


        //recursion
        private StringBuilder toString(StringBuilder sb, Node n) {
            if (n == null) return sb;
            sb.append(n.data + " ");
            return toString(sb, n.next);  //recursion
        }
    }

    Node reverse() {
        Node prev = null;
        Node current = startNode;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        //now node is reversed and prev becomes start node
        startNode = prev;
        return startNode;
    }


    public static void main(String[] args) {

        Singly2 m = new Singly2();
        m.populateNodes();
        boolean foundCharles = m.search("Charles");
        System.out.println("Found Charles? " + foundCharles);

        m.printNodes();
        m.addFirst("Frank");
        m.removeNode("David");
        m.printNodes();
        m.addLast("Ricardo");
        m.printNodes();
        m.insert("Bob", 1);  // add node with position
        m.addFirst("Biki");
        m.printNodes();
        System.out.println("reverse list: " + m.reverse());
    }

    private void populateNodes() {
        String[] stringData = {"Albert", "Billy", "Charles", "David", "Emma"};
        startNode = new Node(stringData[0]);
        tail = startNode;

        for (int i = 1; i < stringData.length; ++i) {
            tail.next = new Node(stringData[i]);
            tail = tail.next;
        }
    }
}
