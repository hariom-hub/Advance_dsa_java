import java.util.Stack;

public class HistogramAreaMax {

    public static void MaxHistogramArea(int[] arr) {

        int maxArea = 0;
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];

        Stack<Integer> stk = new Stack<>();

        // next smaller right

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = stk.peek();
            }
            stk.push(i);
        }

        // next smaller left
        for (int i = 0; i < arr.length; i++) {

            while (stk.isEmpty() && arr[stk.peek()] <= arr[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = stk.peek();
            }
            stk.push(i);
        }

        for (int i = 0; i < arr.length; i++) {

            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currentArea = height * width;

            maxArea = Math.max(maxArea, currentArea);
        }
        System.out.println("max area of histogram is : " + maxArea);
    }

    public static void main(String[] args) {

        int[] histogram = { 2, 1, 5, 6, 2, 3 };
        MaxHistogramArea(histogram);

    }
}