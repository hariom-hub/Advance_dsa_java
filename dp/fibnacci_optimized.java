package Advance_dsa_java.dp;

public class fibnacci_optimized {

    public static int fib(int n, int[] fn) {

        if (n == 0 || n == 1) {
            return n;
        }
        if (fn[n] != 0) {
            return fn[n];
        }
        fn[n] = fib(n - 1, fn) + fib(n - 2, fn);
        return fn[n];
    }

    public static int fib_Tabulation(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 10;
        int[] fn = new int[n + 1];
        System.out.println(fib_Tabulation(n));
    }
}
