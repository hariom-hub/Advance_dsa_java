package Advance_dsa_java.BinarySearchTree;

public class largestBst {

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

    static class Info {

        boolean isbst;
        int size;
        int min;
        int max;

        public Info(boolean isbst, int size, int min, int max) {

            this.isbst = isbst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBst = 0;

    public static Info largestBst(Node root) {

        //base case
        if (root == null) {

            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBst(root.left);
        Info righInfo = largestBst(root.right);

        int size = leftInfo.size + righInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, righInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, righInfo.max));

        if (leftInfo.max >= root.data || righInfo.min <= root.data) {
            return new Info(false, size, min, max);
        }
        if (leftInfo.isbst && righInfo.isbst) {
            maxBst = Math.max(maxBst, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right.right = new Node(70);
        root.right.left = new Node(45);
        root.right.right.right = new Node(80);
        root.right.right.left = new Node(65);

        Info info = largestBst(root);
        System.out.println("size of largest bst is : " + maxBst);


    }
}