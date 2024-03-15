package Queue;

// import Stacks.stack1;

public class queue {

    static class Queue {

        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {

            return rear == -1; // if rear is -1 then it will return true
        }

        // add function
        public static void add(int data) {

            if (rear == size - 1) {
                System.out.println("queue is full");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }

        public static int remove() {

            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int front = arr[0];
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

    }
}