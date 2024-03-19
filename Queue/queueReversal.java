import java.util.*;

public class queueReversal {

    public static void reverseQu(Queue<Integer> qu) {

        Stack<Integer> Stk = new Stack<>();

        while (!qu.isEmpty()) {

            Stk.push(qu.remove());
        }

        while (!Stk.isEmpty()) {

            qu.add(Stk.pop());
        }
    }

    public static void main(String[] args) {

        Queue<Integer> qu = new LinkedList<>();

        qu.add(1);
        qu.add(2);
        qu.add(3);
        qu.add(4);
        qu.add(5);

        reverseQu(qu);

        while (!qu.isEmpty()) {

            System.out.print(qu.remove() + " ");
        }
        System.out.println();
    }
}