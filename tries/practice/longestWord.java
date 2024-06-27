package Advance_dsa_java.tries.practice;

import java.util.Arrays;
import java.util.HashSet;

public class longestWord {


    public static String getLongestWord(String[] words) {

        HashSet<String> hset = new HashSet<>();
        //lexicographically sort the words array

        Arrays.sort(words);
        String ans = "";


        for (int i = 0; i < words.length; i++) {

            String str = words[i];

            if (str.length() == 1 || hset.contains(str.substring(0, str.length() - 1))) {
                if (str.length() > ans.length()) {
                    ans = str;
                }
                hset.add(str);
            }
        }

        return ans;

    }

    public static void main(String[] args) {

        String[] words = {"w", "wo", "wor", "worl", "world"};
        System.out.println(getLongestWord(words));


    }
}