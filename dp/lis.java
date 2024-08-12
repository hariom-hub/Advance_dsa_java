package Advance_dsa_java.dp;

import java.util.Arrays;
import java.util.HashSet;

public class lis {


    public static int lcs(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int m = arr2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int LIS(int[] arr) {

        HashSet<Integer> hset = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hset.add(arr[i]);
        }
        int[] arr2 = new int[hset.size()];
        int i = 0;
        for (int num : hset) {
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);
        return lcs(arr, arr2);
    }

    public static void main(String[] args) {

        int[] arr = {50, 3, 10, 7, 40, 80};
        System.out.println(LIS(arr));

    }
}