package Advance_dsa_java.PriorityQueue.practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class mergeKSortedLL {

    static class Node implements Comparable<Node> {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override

        public int compareTo(Node n2) {

            return this.data - n2.data;
        }
    }

    static Node mergeKList(ArrayList<Node>arr, int k) {

        //k is the size of the array
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node head = new Node(0);
        Node last = head;

        //pushing the head nodes of all the k lists in the priority queue

        for (int i = 0; i < k; i++) {
            if (arr.get(i) != null) {
                pq.add(arr.get(i));
            }
        }

        //check whether number of lists are not zero

        if (pq.isEmpty()) {
            return null;
        }

        while (!pq.isEmpty()) {

            Node curr = pq.poll();

            last.next = curr;
            last = last.next;

            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return head.next;

    }

    public static void printList(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {


        int k = 3;

        ArrayList<Node>a = new ArrayList<>();
        //linkedList1
        Node head1 = new Node(1);
        a.add(head1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        //linkedList2

        Node head2 = new Node(2);
        a.add(head2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);

        //linkedList3


        Node head3 = new Node(7);
        a.add(head3);
        head3.next = new Node(8);
        head3.next.next = new Node(9);


        Node res = mergeKList(a, k);

        if (res != null) {
            printList(res);
        }


    }
}