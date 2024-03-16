package Queue;

// import Stacks.stack1;

public class queue {

    static class Node {

        static Node head = null;
        static Node tail = null;

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {

        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {

            return rear == -1 && front == -1; // if rear is -1 then it will return true
        }

        public static boolean isFull() {

            return (rear + 1) % size == front;
        }

        // add function
        public static void add(int data) {

            if (rear == size - 1) {
                System.out.println("queue is full");
                return;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int remove() {

            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int result = arr[front];

            if (rear == front) {
                rear = front = -1;
            } else {

                front = (front + 1) % size;

            }

            for (int i = 0; i < rear; i++) {

                arr[i] = arr[i + 1];
            }
            rear = rear - 1;
            return front;
        }

        public static int peek() {

            if (isEmpty()) {
                System.out.println("queue is Empty");
                return -1;
            }
            return arr[0];
        }
    };

    public static void main(String[] args) {

        Queue qu = new Queue(5);
        qu.add(5);
        qu.add(4);
        qu.add(7);
        qu.add(10);
        qu.add(0);

        while (qu.isEmpty()) {
            System.out.println(qu.peek());
            qu.remove();
        }

    }
}
