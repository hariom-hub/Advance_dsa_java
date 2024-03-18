import java.util.Stack;

public class queueBystack {

    static class Queue {

        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {

            return s1.isEmpty();
        }

        public static void add(int data) {

            // add in stack2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            // adding in stack1
            s1.push(data);

            // adding the data remained in stack2 to stack1

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

        }

        public static int remove() {

            if (isEmpty()) {
                System.out.println("stack is empty");
                return -1;
            }
            return s1.pop();
        }

        public static int peek() {

            if (isEmpty()) {
                System.out.println("stack is empty");
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {

        Queue qu = new Queue();
        qu.add(1);
        qu.add(2);
        qu.add(3);

        while(!qu.isEmpty()){
            System.out.println(qu.peek());
            qu.remove();
        }
    }
}