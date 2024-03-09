import java.util.*;

public class stockSpan {

    public static void StockSpan(int[] stocks, int[] spans) {

        Stack<Integer> s = new Stack<>();
        spans[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {

            int currentPrice = stocks[i];

            while (!s.isEmpty() && currentPrice > stocks[s.peek()]) {

                s.pop();
            }
            if (s.isEmpty()) {
                spans[i] = i + 1;
            } else {

                int prevHigh = s.peek();
                spans[i] = i - prevHigh;
            }
            s.push(i);
        }

    }

    public static void main(String[] args) {

        int[] stocks = { 100, 80, 60, 70, 60, 85, 100 };
        int[] span = new int[stocks.length];

        StockSpan(stocks, span);
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
