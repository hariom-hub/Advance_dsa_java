package Advance_dsa_java.BinarySearchTree;//package Advance_dsa_java.BinarySearchTree;
//
//public class largestBst {
//
//    static class Node {
//
//        int data;
//        Node left;
//        Node right;
//
//        public Node(int data) {
//
//            this.data = data;
//            this.left = null;
//            this.right = null;
//        }
//    }
//
//    static class Info {
//
//        boolean isBst;
//        int size;
//        int min;
//        int max;
//
//        public Info(boolean isBst, int size, int min, int max) {
//
//            this.isBst = isBst;
//            this.size = size;
//            this.min = min;
//            this.max = max;
//        }
//    }
//
//    public static int maxBst = 0;    //tracks the largest size
//
//
//    public static Info largestBst(Node root) {
//
//        if (root == null) {
//            return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        }
//
//        Info leftInfo = largestBst(root.left);
//        Info rightInfo = largestBst(root.right);
//
//        int size = leftInfo.size + rightInfo.size + 1;
//        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
//        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
//
//        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
//            return new Info(false, size, min, max);
//        }
//        if (leftInfo.isBst && rightInfo.isBst) {
//            maxBst = Math.max(maxBst, size);
//            return new Info(true, size, min, max);
//        }
//        return new Info(false, size, min, max);
//
//    }
//
//    public static void main(String[] args) {
//
//        Node root = new Node(1);
//        Info info = largestBst(root);
//        System.out.println("largest BST size = " + maxBst);
//
//    }
//
//}


public class largestBst{

    public static void main(String[] args){

        int arr[] = {1,2,3,5,10,12,16,20};
        int target = 10;
        int ans = binarySearch(arr,target);

        if(ans == -1){
            System.out.println("Target not found.");
        }else{
            System.out.println("Target found at index "+ans);
        }
    }

    public static int binarySearch(int arr[], int target){

        int left = 0;
        int right = arr.length - 1;
        int mid = left + (right-left)/2;

        while(left <= right){

            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
            left ++;
        }
        return -1;
    }
}