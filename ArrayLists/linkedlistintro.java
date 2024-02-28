import java.util.LinkedList;

public class linkedlistintro {

    public static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public static Node head;
        public static Node Tail;

        public void addFirst(int data) {

            Node newNode = new Node(data);

            if (head == null) {
                head = Tail = newNode;
                return;
            }
            newNode.next = head;

            head = newNode;
        }

        public void addLast(int data) {

            Node newNode = new Node(data);
            if (head == null) {
                head = Tail = newNode;
            }
            Tail.next = newNode;
            Tail = newNode;
        }
    }

    public static void main(String[] args) {

        // LinkedList ll = new LinkedList<>();

    }
}