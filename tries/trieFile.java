package Advance_dsa_java.tries;

import java.util.*;


public class trieFile {

    static class Node {

        Node child[] = new Node[26];
        boolean eow = false;

        //constructor

        public Node() {

            for (int i = 0; i < 26; i++) {

                child[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {

        Node curr = root;

        for (int level = 0; level < word.length(); level++) {

            int idx = word.charAt(level) - 'a';
            if (curr.child[idx] == null) {

                curr.child[idx] = new Node();
            }
            curr = curr.child[idx];
        }
        curr.eow = true;
    }

    public static void main(String[] args) {

    }
}