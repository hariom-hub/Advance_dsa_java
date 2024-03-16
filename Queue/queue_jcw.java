import java.util.*;

import javax.sound.sampled.Line;

public class queue_jcw {

    public static void main(String[] args) {

        Queue<Integer> qu = new LinkedList<>();
        qu.add(4);
        qu.add(8);
        qu.add(10);

        while (!qu.isEmpty()) {
            System.out.println(qu.peek());
            qu.remove();
        }
    }
}