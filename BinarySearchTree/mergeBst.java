package Advance_dsa_java.BinarySearchTree;

import java.util.ArrayList;

public class mergeBst {

    static class Node {

        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node createBst(ArrayList<Integer> arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createBst(arr, start, mid - 1); // Corrected: start instead of 0
        root.right = createBst(arr, mid + 1, end);
        return root;
    }

    public static Node mergeBst(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        ArrayList<Integer> finalArr = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while (i < arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }
        while (j < arr2.size()) { // Fixed missing j++ here
            finalArr.add(arr2.get(j));
            j++;
        }

        return createBst(finalArr, 0, finalArr.size() - 1);
    }

    public static void main(String[] args) {
        // Creating first BST
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        // Creating second BST
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        // Final merged BST
        Node root = mergeBst(root1, root2);
        preorder(root); // Should print the merged BST in preorder
    }
}
