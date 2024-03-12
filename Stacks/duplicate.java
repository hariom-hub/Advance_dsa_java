import java.util.Stack;

public class duplicate {

    public static boolean isDuplicate(String str) {

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            // closing
            char currChar = str.charAt(i);

            if (currChar == ')') {
                int count = 0;

                while (stk.peek() != '(') {
                    stk.pop();
                    count++;
                }
                if (count < 1) {
                    return true; // duplicate
                } else {
                    stk.pop(); // opening pair
                }
            } else {
                // opening
                stk.push(currChar);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String str = "((a+b))";
        String str2 = "(a+b)";
        System.out.println(isDuplicate(str)+" yes duplicate");
        System.out.println(isDuplicate(str2)+" not a duplicate");
        

    }
}