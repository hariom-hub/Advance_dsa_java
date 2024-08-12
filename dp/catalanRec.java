package Advance_dsa_java.dp;

import javax.net.ssl.HttpsURLConnection;

public class catalanRec {

    public static int calcCatalan(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += calcCatalan(i) * calcCatalan(n - i - 1);
        }
        return ans;
    }

    public static void main(String[] args) {

        int n = 21;

        System.out.println(calcCatalan(n));
    }
}