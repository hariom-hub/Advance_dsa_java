package Advance_dsa_java.PriorityQueue;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class MinHeap {


    static class Heap {

        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {

            arr.add(data);

            int child = arr.size() - 1;
            int parent = (child - 1) / 2;

            while (child > 0 && arr.get(child) >arr.get(parent)) {
                int temp = arr.get(child);
                arr.set(child, arr.get(parent));
                arr.set(parent, temp);
                child = parent;
                parent = (child - 1) / 2;
            }
        }

        public int peek() {

            return arr.get(0);
        }

        public int remove() {

            int data = arr.get(0);
            //1 swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            //2 delete the last node
            arr.remove(arr.size() - 1);

            //3 heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {

            return arr.size() == 0;
        }

        private void heapify(int i) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIndex = i;

            if (left < arr.size() && arr.get(minIndex) < arr.get(left)) {
                minIndex = left;
            }
            if (right< arr.size() && arr.get(minIndex) < arr.get(right)) {
                minIndex = right;
            }
            if (minIndex != i) {
                //swap
                int temp = arr.get(minIndex);
                arr.set(minIndex, arr.get(i));
                arr.set(i, temp);

                heapify(minIndex);

            }
        }
    }

    public static void main(String[] args) {

//        ArrayList<Integer> heap = new ArrayList<>();
//        heap.add(2);
//        heap.add(3);
//        heap.add(4);
//        heap.add(5);
//        heap.add(10);
//
//        MinHeap obj = new MinHeap();
//        Heap obj1 = new Heap();
//
//        for (int data : heap) {
//            obj1.addData(data);
//        }
//
//        for (int i = 0; i < heap.size(); i++) {
//            System.out.print(heap.get(i) + " ");
//        }
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}