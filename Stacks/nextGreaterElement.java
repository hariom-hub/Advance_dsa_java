import java.util.*;

public class nextGreaterElement {

    public static void main(String[] args) {


        Stack<Integer>stk = new Stack<>();
        int arr[] = { 6, 8, 0, 1, 3 };

        int nextGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            // 1 while
            if (!stk.isEmpty() && arr[stk.peek()] < arr[i]) {
                stk.pop();
            }

            // 2 if-else

            if (stk.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[stk.peek()];
            }

            // 3 push

            stk.push(i);
        }

        //printing the new arr

        for(int i=0;i<nextGreater.length;i++){

            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();

    }
}