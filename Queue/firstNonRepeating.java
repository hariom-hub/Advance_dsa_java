import java.util.*;

public class firstNonRepeating {

    public static void printNonRepeating(String str) {

        int[] freq = new int[26];

        Queue<Character> qu = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            qu.add(ch);
            freq[ch - 'a']++;

            while (!qu.isEmpty() && freq[qu.peek() - 'a'] > 1) {

                qu.remove();
            }

            if (qu.isEmpty()) {

                System.out.print("-1" + " ");
            } else {
                System.out.print(qu.peek() + " ");
            }
        }
        
    }

    public static void main(String[] args) {

        String str = "aabccxbyzkq";

        printNonRepeating(str);
    }
}