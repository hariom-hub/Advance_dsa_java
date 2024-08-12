package Advance_dsa_java.dp;

public class stringConversion {

    public static int lcs(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i][j - 1];
                    int ans2 = dp[i - 1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int ConvertStr(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();
        int ans = 0;
        int delete = n - lcs(word1,word2);
        int add = m - lcs(word1,word2);
        ans = add + delete;
        return ans;
    }

    public static void main(String[] args) {

        //only insertion and deletion
        String word1 = "af";
        String word2 = "aceg";
        System.out.println(ConvertStr(word1, word2));
    }
}