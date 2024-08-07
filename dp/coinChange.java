package Advance_dsa_java.dp;

public class coinChange {

    private static int coinval;

    public static int findWays(int[] coins, int sum) {

        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];
        //rows ->0 "sum"
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        //cols ->1 "no of coins"
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int coinval = coins[i - 1];
                if (coinval <= j) {
                    //valid
                    //combining both included and excluded ways to get the total no. of ways
                    dp[i][j] =   dp[i][j - coinval] + dp[i-1][j];
                } else {
                    //exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        printdp(dp);
        return dp[n][sum];

    }

    public static void printdp(int[][] dp) {

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 3};
        int sum = 4;
        System.out.println(findWays(coins,sum));

    }
}