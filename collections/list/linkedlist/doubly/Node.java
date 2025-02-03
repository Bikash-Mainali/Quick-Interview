package linkedlist.doubly;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 12/15/21
 */
public class Node {

    Node next;
    Node prev;
    String data;

    public Node(String data) {
        this.next = null;
        this.prev = null;
        this.data = data;
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
        sb.append(n.next + " ");
        return toString(sb, n.next);  //recursion
    }
}
