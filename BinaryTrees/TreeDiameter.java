package Advance_dsa_java.BinaryTrees;

public class TreeDiameter {

    static class Node {

        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public static int treeHeight(Node root) {

            if (root == null) {
                return 0;
            }

            int lh = treeHeight(root.left);
            int rh = treeHeight(root.right);

            return Math.max(lh, rh) + 1;
        }

        public static int treeDiameter(Node root) {

            if (root == null) {
                return 0;
            }

            int lh = treeHeight(root.left);
            int rh = treeHeight(root.right);

            int rd = treeDiameter(root.right);
            int ld = treeDiameter(root.left);

            int selfDiameter = lh + rh + 1;

            return Math.max(selfDiameter, Math.max(ld, rd));
        }

        static class Info {

            int diam;
            int ht;

            public Info(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }

        public static Info diameter(Node root) {

            if (root == null) {
                return new Info(0, 0);
            }

            Info leftInfo = diameter(root.left);
            Info rightInfo = diameter(root.right);

            int diameter = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
            int height = Math.max(leftInfo.ht, rightInfo.ht) + 1;

            return new Info(diameter, height);
        }
    }

    public static boolean isIdentical(Node node, Node subTree) {

        if (node == null && subTree == null) {
            return true;
        } else if (node == null || subTree == null || node.data != subTree.data) {
            return false;
        }
        if (!isSubtree(node.right, subTree.right)) {
            return false;
        }
        if (!isSubtree(node.left, subTree.left)) {
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subTree) {

        if (root == null) {
            return false;
        }
        if (root.data == subTree.data) {
            if (isIdentical(root, subTree)) {
                return true;
            }
        }
        return isSubtree(root.right, subTree) || isSubtree(root.left, subTree);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root,subRoot));

    }
}