package Advance_dsa_java.BinaryTrees;

public class transformSum {

    static class Node {


        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int transformData(Node root) {

        if (root == null) {
            return 0;
        }

        int leftChildData = transformData(root.left);
        int rightChildData = transformData(root.right);

        int data = root.data;

        int newleftData = root.left == null ? 0 : root.left.data;
        int newrightData = root.right == null ? 0 : root.right.data;

        root.data = newleftData + leftChildData + newrightData + rightChildData;

        return data;
    }

    public static void preorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transformData(root);
        preorder(root);
    }
}