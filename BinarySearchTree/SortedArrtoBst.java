package Advance_dsa_java.BinarySearchTree;

public class SortedArrtoBst {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {

            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void preorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);


    }

    public static Node createBst(int arr[], int start, int end) {

        int mid = (start + end) / 2;

        if (start > end) {
            return null;
        }

        //middle node of array will be the root element

        Node root = new Node(arr[mid]);
        root.left = createBst(arr, start, mid - 1);
        root.right = createBst(arr, mid + 1, end);

        return root;

    }

    public static void main(String[] args) {

        int[] arr = {3, 5, 6, 8, 10, 11, 12};
        int start = 0;
        int end = arr.length - 1;
        Node root = createBst(arr, start, end);
        preorder(root);
    }
}