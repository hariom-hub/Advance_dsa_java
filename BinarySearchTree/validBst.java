package Advance_dsa_java.BinarySearchTree;

public class validBst {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean isValidBst(Node root, Node min, Node max) {

        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        }
        if (max != null && root.data >= max.data) {

            return false;
        }

        return isValidBst(root.left, min, root) && isValidBst(root.right, root, max);
    }

    public static void inorder(Node root){

        if(root == null){

            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(10);
        root.left.right = new Node(4);
        inorder(root);
        System.out.println();

        if (isValidBst(root, null, null)) {
            System.out.println("Valid bst");
        } else {
            System.out.println("Invalid bst");
        }

    }
}