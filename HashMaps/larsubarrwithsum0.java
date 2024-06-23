package Advance_dsa_java.HashMaps;

import java.util.HashMap;

public class larsubarrwithsum0 {

    public static void main(String[] args) {

        int[] nums = {-1,1,-1,1};
        HashMap<Integer, Integer> hm = new HashMap<>();

        int sum = 0;
        int len = 0;
        hm.put(0,-1);

        for (int j = 0; j < nums.length; j++) {

            sum += nums[j];
            if (hm.containsKey(sum)) {
                len = Math.max(len, j - hm.get(sum));
            } else {
                hm.put(sum, j);
            }
        }
        System.out.println("largest subarray with sum as zero : "+len);


    }
}