import java.util.*;

public class stackbyqu {

    static class StackByQue {

        static Queue<Integer> qu1 = new LinkedList<>();
        static Queue<Integer> qu2 = new LinkedList<>();

        public static boolean isEmpty() {

            return qu1.isEmpty() && qu2.isEmpty();
        }

        public static void push(int data) {

            if (!qu1.isEmpty()) {
                qu1.add(data);
            } else {
                qu2.add(data);
            }
        }

        public static int pop() {

            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }

            int top = -1;

            if (!qu1.isEmpty()) {

                while (!qu1.isEmpty()) {
                    top = qu1.remove();
                    if (qu1.isEmpty()) {
                        break;
                    }
                    qu2.add(top);
                }
            } else {
                while (!qu2.isEmpty()) {
                    top = qu2.remove();
                    if (qu2.isEmpty()) {
                        break;
                    }
                    qu1.add(top);
                }
            }
            return top;
        }

        public static int peek() {

            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }

            int top = -1;

            if (!qu1.isEmpty()) {

                while (!qu1.isEmpty()) {
                    top = qu1.remove();
                    // if (qu1.isEmpty()) {
                    // break;
                    // }
                    qu2.add(top);
                }
            } else {
                while (!qu2.isEmpty()) {
                    top = qu2.remove();
                    // if (qu2.isEmpty()) {
                    // break;
                    // }
                    qu1.add(top);
                }
            }
            return top;
        }
    }

    public static void main(String[] args) {

        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);

        while (!stk.isEmpty()) {
            System.out.println(stk.peek());
            stk.pop();
        }
    }
}