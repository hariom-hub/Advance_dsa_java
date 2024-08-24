package Advance_dsa_java.segmentTree;

public class queryonBst {

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


    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {

        //case1: non overlapping
        if (qj <= si || qi >= sj) {
            return 0;
        }
        //overlapped completely
        else if (si >= qi && sj <= qj) {

            return tree[i];
        } else {

            //partially overlapped
            int mid = (si + sj) / 2;
            int left = getSumUtil(2 * i + 1, si, mid, qi, qj);
            int right = getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return left + right;
        }
    }

    public static int getSum(int[] arr, int qi, int qj) {

        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        init(n);
        buildst(arr, 0, 0, n - 1);
        System.out.println(getSum(arr, 2, 5));
    }
}