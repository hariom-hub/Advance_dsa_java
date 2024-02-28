
import java.util.ArrayList;
import java.util.Collections;

public class checkLonely {

    public static ArrayList<Integer> checkLonelyPair(ArrayList<Integer> nums) {

        Collections.sort(nums);

        ArrayList<Integer> LonelyList = new ArrayList<>();

        for (int i = 1; i < nums.size() - 1; i++) {

            if (nums.get(i - 1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i + 1)) {
                LonelyList.add(nums.get(i));
            }

            if (nums.size() == 1) {
                LonelyList.add(nums.get(0));
            }

            if (nums.size() > 1) {
                if (nums.get(0) + 1 < nums.get(1)) {
                    LonelyList.add(nums.get(    0));
                }
                if (nums.get(nums.size() - 2) + 1 < nums.get(nums.size() - 1)) {

                    LonelyList.add(nums.get(nums.size() - 1));
                }
            }

        }
        return LonelyList;

    }

    public static void main(String[] args) {

        ArrayList<Integer> lists = new ArrayList<>();

        lists.add(10);
        lists.add(6);
        lists.add(5);
        lists.add(8);
        System.out.println(checkLonelyPair(lists));
    }
}