package Advance_dsa_java.BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class topview {


    static class Info {

        int hd;
        Node node;

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {

            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static void topView(Node node) {

        Queue<Info> qu = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0;
        int max = 0;

        qu.add(new Info(node, 0));


        while (!qu.isEmpty()) {
            Info curr = qu.remove();

            if (curr == null) {
                if (qu.isEmpty()) {
                    break;
                } else {
                    qu.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {          //first time hd is occuring

                    map.put(curr.hd, curr.node);

                }

                if (curr.node.left != null) {
                    qu.add(new Info(curr.node, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    qu.add(new Info(curr.node, curr.hd));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();


    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        root.right.left = new Node(6);

        topView(root);

    }
}