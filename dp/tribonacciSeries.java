package Advance_dsa_java.dp;

public class tribonacciSeries {

    public static int tribNacciSeries(int n){

        //recursion
        if (n==0||n==1||n==2){
            return n;
        }
        int ans = tribNacciSeries(n-1) + tribNacciSeries(n-2) + tribNacciSeries(n-3);
        return ans;
    }

    public static void main(String []args){

        int n = 20;
        System.out.println(tribNacciSeries(n));

    }
}