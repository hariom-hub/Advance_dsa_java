package Advance_dsa_java.HashMaps;

import java.util.*;


public class Hashmap1 {

    public static void main(String[] args) {

        //create
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 1);
        hm.put("pakistan", 0);
        hm.put("america", 10);
//        System.out.println(hm);
//        System.out.println(hm.get("India"));
//        System.out.println(hm.get("Hatta"));
//        System.out.println(hm.containsKey("Hatta"));
//        System.out.println(hm.containsKey("India"));
        hm.remove("India");
//        System.out.println(hm);
//        System.out.println(hm.size());
        Set<String> keys = hm.keySet();
//        System.out.println(keys);
        for (String str : keys) {
            System.out.println("keys=" + str + "," + "values=" + hm.get(str));
        }

    }
}