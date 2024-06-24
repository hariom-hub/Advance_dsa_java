package Advance_dsa_java.tries;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.rmi.server.ServerNotActiveException;
import java.util.*;

public class triefile2 {

    static class Node {

        Node[] children = new Node[26];
        boolean eow = false;

        public Node() {

            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
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

    public static Node root = new Node();

    public static void main(String[] args) {

        insert("hariom");
        insert("gaurisha");
        insert("shreesha");

        System.out.println(SearchWord("hariom"));
        System.out.println(SearchWord("shubhi"));


    }
}