package Advance_dsa_java.BinarySearchTree.selfPractice;

import java.util.LinkedList;
import java.util.Queue;

public class bstRangeSum {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static int sum = 0;

    public static int bstRangeSum(Node root, int l, int r) {

        if (root == null) {
            return 0;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);

        while (!qu.isEmpty()) {

            Node curr = qu.peek();
            qu.remove();

            if (curr.data >= l && curr.data <= r) {
                sum += curr.data;
            }
            if (curr.left != null && curr.data > l) {
                qu.add(curr.left);
            }
            if (curr.right != null && curr.data < r) {
                qu.add(curr.right);
            }
        }
        return sum;

    }

    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);

        int l = 3;
        int r = 20;
        System.out.println("sum is : "+bstRangeSum(root, l, r));


    }
}