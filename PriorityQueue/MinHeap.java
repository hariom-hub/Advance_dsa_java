package Advance_dsa_java.PriorityQueue;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class MinHeap {


    static class Heap {

        ArrayList<Integer> arr = new ArrayList<>();

        public void addData(int data) {

            arr.add(data);

            int child = arr.size() - 1;
            int parent = (child - 1) / 2;

            while (child > 0 && arr.get(child) < arr.get(parent)) {
                int temp = arr.get(child);
                arr.set(arr.get(child), arr.get(parent));
                arr.set(arr.get(parent), temp);
                child = parent;
                parent = (child - 1) / 2;
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> heap = new ArrayList<>();
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(10);

        MinHeap obj = new MinHeap();
        Heap obj1 = new Heap();

        for (int data : heap) {
            obj1.addData(data);
        }

        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
    }
}