import java.util.*;

public class validParenthesis {

    public static boolean checkParenthesis(String str) {

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // opening
            if (ch == '(' || ch == '{' || ch == '[') {
                stk.push(ch);
            } else {

                if (stk.isEmpty()) {
                    return false;
                }

                // check for pair condition

                if ((stk.peek() == '(' && ch == ')') || (stk.peek() == '{' && ch == '}')
                        || (stk.peek() == '[' && ch == ']')) {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }
        if (stk.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        String str = "({})";
        System.out.println(checkParenthesis(str));
    }
}