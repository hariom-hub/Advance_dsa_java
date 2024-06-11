package Advance_dsa_java.PriorityQueue;

import java.util.*;

public class heapsort {

    public static void heapify(int[] arr, int i, int size) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIndex = i;

        if (left < size && arr[minIndex] > arr[left]) {
            minIndex = left;
        }
        if (right < size && arr[minIndex] > arr[right]) {

            minIndex = right;
        }

        if (minIndex != i) {

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            heapify(arr, i, size);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        //building max heap
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        //extracting elements from heap
        for (int i = n - 1; i >= 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {

        int arr[] = {5, 3, 4, 2, 1};
        heapSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}