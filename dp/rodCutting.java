package Advance_dsa_java.dp;

public class rodCutting {

    public static int getMaxPrice(int[] length, int[] price, int rodLength) {

        int n = price.length;
        int[][] dp = new int[n + 1][rodLength + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int cost = price[i - 1];
                int len = length[i - 1];
                if (len <= j) {
                    //valid
                    int incCost = cost + dp[i][j - len];
                    int exCost = dp[i - 1][j];
                    dp[i][j] = Math.max(incCost, exCost);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][rodLength];
    }

    public static void main(String[] args) {

        int rodLength = 8;
        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(getMaxPrice(length, price, rodLength));
    }
}