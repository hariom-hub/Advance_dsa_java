

public class queuebyLL {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queues {

        Queues(int n) {

        }
    }

    public static boolean isEmpty() {

        return head == null && tail == null;
    }

    public static void add(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public static int remove() {

        if (isEmpty()) {
            System.out.println("Empty queue");
            return -1;

        }
        int front = head.data;

        // single

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return front;
    }

    public static int peek() {

        if (isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        }
        return head.data;
    }

    static Node head;
    static Node tail;

    public static void main(String[] args) {

    }
}
