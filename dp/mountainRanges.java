package  Advance_dsa_java.dp;

public class mountainRanges {

    public static int mountainrange(int n){

        int []dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i=2;i<n+1;i++){
            for (int j=0;j<i;j++){
                int inner = dp[j];
                int outer = dp[i-j-1];
                dp[i] += inner * outer;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {

        int n = 4;  //four pairs of 2
        System.out.println(mountainrange(n));
    }
}