package Advance_dsa_java.dp;

public class knapsack_0_1 {


    public static int knapsack(int[] val, int[] wt, int W, int n, int[][] dp) {

        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {

            //choices - include and exclude
            //include
            int ans1 = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1, dp);
            //exclude
            int ans2 = knapsack(val, wt, W, n - 1, dp);
//            return Math.max(ans1, ans2);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            dp[n][W] = knapsack(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }


    public static int knapsackTabulation(int[] val, int[] wt, int W) {

        int n = val.length;

        int[][] dp = new int[n + 1][W + 1];
        //if number of items are zero or if the sum if zero then.

        //for cols
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        //for rows
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int w = wt[i - 1];
                int v = val[i - 1];
                if (w <= j) {
                    //valid and include
                    int incProfit = v + dp[i - 1][j - w];
                    int exProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, exProfit);
                } else {
                    //invalid and exclude
                    int exProfit = dp[i - 1][j];
                    dp[i][j] = exProfit;
                }
            }
        }
        printDp(dp);
        return dp[n][W];
    }

    public static void printDp(int[][] dp) {

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int W = 7;
        int[][] dp = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("maximum cost : " + knapsackTabulation(val, wt, W));
    }
}