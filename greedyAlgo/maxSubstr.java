public class maxSubstr {

    public static int MaxSubstrCount(String str) {

        int Lcount = 0;
        int Rcount = 0;
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch == 'L') {

                Lcount++;
            } else {
                Rcount++;
            }

            if (Lcount == Rcount) {

                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String str = "LRRRRLLRLLRL";

        System.out.println("maximum number of equal substr is : "+MaxSubstrCount(str));
    }
}
