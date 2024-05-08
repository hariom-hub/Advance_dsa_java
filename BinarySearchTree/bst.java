package Advance_dsa_java.BinarySearchTree;

public class bst {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {

            this.data = data;
        }
    }

    public static Node Insert(Node root, int val) {

        if (root == null) {

            root = new Node(val);
            return root;
        }

        if (root.data < val) {

            root.right = Insert(root.right, val);
        } else {
            root.left = Insert(root.left, val);
        }

        return root;
    }

    public static void Inorder(Node root) {

        if (root == null) {
            return;
        }

        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }

    public static void main(String[] args) {

        int[] val = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for (int i = 0; i < val.length; i++) {
            root = Insert(root, val[i]);
        }

        Inorder(root);
        System.out.println();
    }
}