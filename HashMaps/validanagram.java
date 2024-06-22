package Advance_dsa_java.HashMaps;

import java.util.HashMap;

public class validanagram {

    public static boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        //putting the characters and their frequencies in the hashmap of string s

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // now comparing the frequencies of s with t using a loop

        for (int j = 0; j < t.length(); j++) {
            char ch = t.charAt(j);

            if (map.get(ch) != null) {

                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {

        String s = "hariom";
        String t = "omhario";
        System.out.println(isAnagram(s,t));

    }

}