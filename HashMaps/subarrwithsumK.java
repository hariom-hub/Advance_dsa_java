package Advance_dsa_java.HashMaps;
import java.util.*;

public class subarrwithsumK {

    public static void main(String[] args){

        int k = 10;
        int []arr = {10,-20,2,5,-10,20,10};

        HashMap<Integer,Integer>hmap = new HashMap<>();

        int sum = 0;
        int freq = 0;

        hmap.put(0,1);

        for(int j=0;j<arr.length;j++){

            sum += arr[j];

            if(hmap.containsKey(sum - k)){
                freq += hmap.get(sum-k);
            }
            hmap.put(sum, hmap.getOrDefault(sum,0)+1);
        }
        System.out.println(freq);

    }
}