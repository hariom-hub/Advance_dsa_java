package Advance_dsa_java.BinarySearchTree;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class printinRange {

    static class Node {

        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void printInRange(Node root, int k1, int k2) {

        if (root == null) {
            return;
        }

        if (root.data >= k1 && root.data <= k2) {

            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void Inorder(Node root) {

        if (root == null) {

            return;
        }
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }


    public static void printPath(ArrayList<Integer> path) {


        for(int i=0;i<path.size();i++){

            System.out.print(path.get(i)+"->");
        }
        System.out.println("NULL");

    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {

        if (root == null) {
            return;
        }

        path.add(root.data);

        if (root.left == null && root.right == null) {

            printPath(path);
        }

        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);
        root.right.right.right = new Node(14);


//        printInRange(root, 5, 12);
        printRoot2Leaf(root, new ArrayList<>());


    }
}