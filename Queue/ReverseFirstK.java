import java.util.*;

public class ReverseFirstK {

    public static void Reverse(Queue<Integer> qu, int k) {

        Stack<Integer> stk = new Stack<>();

        Queue<Integer> newQu = new LinkedList<>();

        for (int i = 0; i < k; i++) {

            stk.push(qu.remove());
        }

        for (int i = 0; i < k; i++) {

            newQu.add(stk.pop());
        }

        for (int i = 0; i < k; i++) {

            newQu.add(qu.remove());
        }

        System.out.println(newQu);
        System.out.println(newQu.size());
        
    }

    public static void main(String[] args) {

        Queue<Integer> qu = new LinkedList<>();
        qu.add(1);
        qu.add(2);
        qu.add(3);
        qu.add(4);
        qu.add(5);
        qu.add(6);
        int k = 3;
        Reverse(qu, k);
    }
}
