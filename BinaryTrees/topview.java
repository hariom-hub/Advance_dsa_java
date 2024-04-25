package Advance_dsa_java.BinaryTrees;

import java.util.*;

public class topview {

    static class Node {

        Node left;
        int data;
        Node right;

        public Node(int data) {

            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {

        int hd;
        Node node;

        public Info(Node node, int hd) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static void Topview(Node root) {
        if (root == null)
            return;

        int min = 0;
        int max = 0;

        Queue<Info> qu = new LinkedList<>(); //queue for level order traversal
        HashMap<Integer, Node> map = new HashMap<>();  //hashmap for storing hd as key and node as value
        qu.add(new Info(root, 0));

        while (!qu.isEmpty()) {
            Info curr = qu.remove();

            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node);
            }

            if (curr.node.left != null) {
                qu.add(new Info(curr.node.left, curr.hd - 1));
                min = Math.min(min, curr.hd - 1);
            }

            if (curr.node.right != null) {
                qu.add(new Info(curr.node.right, curr.hd + 1));
                max = Math.max(max, curr.hd + 1);
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
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Topview(root);
    }
}