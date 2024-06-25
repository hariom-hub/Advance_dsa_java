package Advance_dsa_java.tries;
import java.util.*;
public class startswithPrblm {

    static class Node{

        Node[]children = new Node[26];
        int freq;
        boolean eow = false;

        public Node(){

            for(int i=0;i<26;i++){
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();
    public static void insert(String words){

        Node curr = root;

        for(int i=0;i<words.length();i++){

            int idx = words.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = false;
    }

    public static boolean isStartsWith(String prefix){

        Node curr = root;

        for (int i=0;i<prefix.length();i++){

            int idx = prefix.charAt(i) - 'a';

            if(curr.children[idx] == null){
                return false;
            }

            curr = curr.children[idx];

        }
        return true;
    }

    public static void main(String[] args){

        String []words = {"apple","app","mango","man","woman"};
        for (int i=0;i<words.length;i++){

            insert(words[i]);
        }
        String prefix = "app";
        String prefix2 = "mmata";
        System.out.println(isStartsWith(prefix));
        System.out.println(isStartsWith(prefix2));
    }


}