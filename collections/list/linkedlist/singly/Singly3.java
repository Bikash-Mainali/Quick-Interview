package linkedlist.singly;

/**
 * same as Singly2
 */
public class Singly3 {
    private Node startNode;
    private Node lastNode;


    void insert(String s, int pos) {
        int size = size();
        if (pos < 0 || pos > size) {
            throw new IllegalArgumentException(
                    "Illegal position for new node");
        }
        if (pos == size) {
            addLast(s); //same as add(s);
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

            Node newNode = new Node();

            newNode.data = s;
            newNode.next = next;
            if (count == 0) {
                startNode = newNode;
            } else {
                prev.next = newNode;
            }
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
        if (s == null) return false;
        Node next = startNode;
        while (next != null) {
            String t = next.data;
            if (s.equals(t)) {
                return true;
            }
            next = next.next;
        }
        return false;
    }

    void removeNode(String s) {
        if (s == null) return;
        if (startNode != null && startNode.data.equals(s)) {
            startNode = startNode.next;
            return;
        }
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
        System.out.println(startNode.toString());
        System.out.println();
    }

    void addFirst(String s) {
        Node newNode = new Node();
        newNode.data = s;
        if (startNode != null) {
            newNode.next = startNode;
        }
        startNode = newNode;  // startNode is head node adding before the existing node
    }

    void addLast(String s) {
        Node newNode = new Node();
        newNode.data = s;
        //if startNode == null, set startNode to be newNode
        if (startNode == null) {
            startNode = newNode;
            lastNode = newNode;
        } else {

            lastNode.next = newNode;
            lastNode = newNode;
        }
    }

    class Node {
        String data;
        Node next;

        @Override
        public String toString() {
            if (data == null) return "";
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

    public static void main(String[] args) {

        Singly3 m = new Singly3();
        m.populateNodes();
        boolean foundCharles = m.search("Charles");
        System.out.println("Found Charles? " + foundCharles);

        m.printNodes();
        m.addFirst("Frank");
        m.removeNode("David");
        m.printNodes();
        m.addLast("Ricardo");
        m.printNodes();
        m.insert("Bob", 0);
        m.addFirst("Biki");
        m.printNodes();
    }

    private void populateNodes() {
        String[] stringData = {"Albert", "Billy", "Charles", "David", "Emma"};
        Node newNode = new Node();
        startNode = newNode; //start node is head
        startNode.data = stringData[0];

        Node tail = startNode;

        for (int i = 1; i < stringData.length; ++i) {
            tail.next = new Node();
            tail.next.data = stringData[i];
            tail = tail.next;
            lastNode = tail;
        }
    }
}
