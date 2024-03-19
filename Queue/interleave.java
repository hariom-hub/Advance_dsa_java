import java.util.*;

public class interleave {

    public static void interLeave(Queue<Integer> qu) {

        Queue<Integer> firstHalf = new LinkedList<>();

        int size = qu.size();

        for (int i = 0; i < size / 2; i++) {

            firstHalf.add(qu.remove());
        }

        while (!qu.isEmpty()) {

            qu.add(firstHalf.remove());
            qu.add(qu.remove());
        }
    }

    public static void main(String[] args) {

        Queue<Integer> qu = new LinkedList<>();

        qu.add(1);
        qu.add(2);
        qu.add(3);
        qu.add(4);
        qu.add(5);
        qu.add(6);
        qu.add(7);
        qu.add(8);
        qu.add(9);
        qu.add(10);

        while (!qu.isEmpty()) {

            System.out.print(qu.remove() + " ");
        }
        System.out.println();
    }
}
