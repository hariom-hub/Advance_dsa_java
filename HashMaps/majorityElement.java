package Advance_dsa_java.HashMaps;

import java.util.*;

public class majorityElement {

    public static void main(String[] args) {

        int[] nums = {2, 3, 2, 2, 4, 5, 4, 1, 2};

        HashMap<Integer, Integer> hmap = new HashMap<>();

        //checking and putting the values
        for (int i = 0; i < nums.length; i++) {
            hmap.put(nums[i],hmap.getOrDefault(nums[i],0)+1);
        }


        for(Integer key:hmap.keySet()){
            if(hmap.get(key) > nums.length/3){
                System.out.println(key);
            }
        }
    }
}