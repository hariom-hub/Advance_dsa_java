import java.util.*;

public class reverseQu {

    public static void reverseQue(Queue<Integer> qu) {

        Stack<Integer> stk = new Stack<>();

        while (!qu.isEmpty()) {
            stk.push(qu.remove());
        }

        while (!stk.isEmpty()) {

            qu.add(stk.pop());
        }
        System.out.println(qu);

    }

    public static void main(String[] args) {

        Queue<Integer> qu = new LinkedList<>();
        qu.add(1);
        qu.add(2);
        qu.add(3);
        qu.add(4);
        qu.add(5);

        System.out.println(qu);
        System.out.println("Reversed Queue");
        reverseQue(qu);


    }
}
