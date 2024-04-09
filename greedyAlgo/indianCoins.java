import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class indianCoins {

    public static void main(String[] args) {

        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };

        ArrayList<Integer> ans = new ArrayList<>();

        int coinCount = 0;
        int Amount = 12590;

        Arrays.sort(coins, Comparator.reverseOrder());

        for (int i = 0; i < coins.length; i++) {

            if (coins[i] <= Amount) {

                while (coins[i] <= Amount) {

                    coinCount++;
                    ans.add(coins[i]);
                    Amount = Amount - coins[i];
                }
            }
        }

        System.out.println("Minimum number of coins used are : " + coinCount);

        System.out.println("Coins used : ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

    }
}