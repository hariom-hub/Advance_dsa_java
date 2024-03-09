import java.util.*;
public class stockSpan {

    public static void StockSpan(int []stocks,int []spans){

        Stack<Integer>s = new Stack<>();
        
    }

    public static void main(String[] args) {

        int[] stocks = { 100, 80, 60, 70, 60, 85, 100 };
        int []span = new int[stocks.length];

        StockSpan(stocks,span);
        for(int i=0;i<span.length;i++){
            System.out.print(span[i]+" ");
        }
    }
}
