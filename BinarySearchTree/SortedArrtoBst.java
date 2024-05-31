package Advance_dsa_java.BinarySearchTree;

public class SortedArrtoBst {

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

    public static void preoder(Node root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preoder(root.left);
        preoder(root.right);
    }

    public static Node createBst(int arr[], int start, int end) {

        if(start>end){
            return null;
        }
        int mid = start + (end - start) / 2;

        Node root = new Node(arr[mid]);
        root.left = createBst(arr, start, mid - 1);
        root.right = createBst(arr, mid + 1, end);
        return root;


    }

    public static void main(String[] args) {

        int sortedArr[] = {3,5,8,10,12,15,18};
        Node root = createBst(sortedArr,0,sortedArr.length-1);
        preoder(root);
    }
}