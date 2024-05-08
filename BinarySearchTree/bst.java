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

    //search for a node

    public static boolean search(Node root, int key) {

        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (root.data > key) {

            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {



        if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else {
            // case - 1 delete leaf nodes

            if (root.left == null && root.right == null) {

                return null;
            }

            // case - 2 delete single children

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            //case 3 both children

            Node inorderSucc = findInorderSucc(root.right);
            root.data = inorderSucc.data;
            root.right = delete(root.right, inorderSucc.data);
        }
        return root;
    }

    public static Node findInorderSucc(Node root) {

        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {

        int[] val = {7, 2, 5, 4, 9, 3, 1, 8, 10,};
        Node root = null;
        for (int i = 0; i < val.length; i++) {
            root = Insert(root, val[i]);
        }

        Inorder(root);
        System.out.println();
//        if (search(root, 50)) {
//            System.out.println(" Key found");
//        } else {
//            System.out.println(" key Not found");
//        }
        delete(root,5);
        Inorder(root);
    }
}