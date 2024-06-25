package Advance_dsa_java.tries;
import java.util.*;
public class wordbreakprblm {

    static class Node {

        Node[] children = new Node[26];
        boolean eow = false;

        public Node() {

            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static boolean SearchWord(String word) {

        Node curr = root;

        for (int level = 0; level < word.length(); level++) {

            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {

                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;

    }

    public static void insert(String word) {

        Node curr = root;

        for (int level = 0; level < word.length(); level++) {

            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {

                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }


    public static boolean wordbreak(String key){


        //base case
        if (key.length() == 0){
            return true;
        }
        for(int i=1;i<=key.length();i++){

            if(SearchWord(key.substring(0,i))&& wordbreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){


        String arr[] = {"i","like","sam","samsung","mobile","ice"};

        for (int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        String key = "ilikesamsung";
        System.out.println(wordbreak(key));

    }
}
