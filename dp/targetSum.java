package Advance_dsa_java.dp;

public class targetSum {

    //tc = O(n*sum)

    public static boolean TargetSum(int[] val, int sum) {

        int n = val.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        //if the sum is zero than the values will make no impact
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        //and if the number of values are zero than the sum will be invalid that's why for all dp[0][j] = false "automatically"

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = val[i - 1];
                if (v <= j && dp[i - 1][j - v]) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }

            }
        }
        printDp(dp);
        return dp[n][sum];

    }
    public static void printDp(boolean[][] dp) {

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 7, 1, 3};
        int sum = 10;
        System.out.println(TargetSum(arr, sum));

    }
}