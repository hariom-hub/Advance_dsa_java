package Advance_dsa_java.dp;

public class minPartitioning {

    public static boolean MinDiff(int[] nums) {

        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int W = sum / 2;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int wt = nums[i - 1];
                if (wt <= j) {
                    //included
                    dp[i][j] = Math.max(wt + dp[i - 1][j - wt], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        if (Math.abs(sum1 - sum2) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {


        int[] arr = {1, 6, 10, 5};
        System.out.println(MinDiff(arr));

    }
}