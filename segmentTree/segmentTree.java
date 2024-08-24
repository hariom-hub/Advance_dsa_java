package Advance_dsa_java.segmentTree;

public class segmentTree {

    static int[] tree;

    public static void init(int n) {

        tree = new int[4 * n];
    }

    public static int buildst(int[] arr, int sti, int start, int end) {

        if (start == end) {
            tree[sti] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        buildst(arr, 2 * sti + 1, start, mid);
        buildst(arr, 2 * sti + 2, mid + 1, end);

        tree[sti] = tree[2 * sti + 1] + tree[2 * sti + 2];
        return tree[sti];
    }

    //query on
    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        init(n);
        buildst(arr, 0, 0, n - 1);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }

    }
}
