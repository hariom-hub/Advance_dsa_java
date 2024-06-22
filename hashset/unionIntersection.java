package Advance_dsa_java.hashset;

import java.util.*;

public class unionIntersection {

    public static void main(String[] args) {

        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        for (int j = 0; j < arr2.length; j++) {
            hs.add(arr2[j]);
        }
//        System.out.println(hs);
//        System.out.println(hs.size());

        hs.clear();


        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        int count = 0;
        for (int j = 0; j < arr2.length; j++) {
            if (hs.contains(arr2[j])) {
                count++;
                hs.remove(arr2[j]);
                System.out.print(arr2[j]+" ");
            }

        }
        System.out.println();
        System.out.println(count);


    }
}