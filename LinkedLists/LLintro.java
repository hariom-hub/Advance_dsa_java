import java.util.*;

public class LLintro {

    public static class Node {

        int data;
        Node next;

        public Node(int data) {

            this.data = data;
            this.next = null;
        }

    }

    public static Node Head;
    public static Node Tail;

    public void addFirst(int data) {

        Node newNode = new Node(data);
        if (Head == null) {

            Head = Tail = newNode;
        }

        newNode.next = Head;
        Head = newNode;
    }

    public void addLast(int data) {

        Node newNode = new Node(data);
        if (Head == null) {
            Head = Tail = newNode;
        }

        newNode.next = Tail;

        Tail = newNode;
    }

    public void Print() {

        if (Head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = Head;
        while (temp != null) {
            System.out.println(temp.data+"->");
            temp = temp.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {

        LinkedList<Integer>ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);

    }
}
