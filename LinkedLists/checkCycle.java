import java.util.*;

public class checkCycle {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void Add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (temp != null && i < idx - 1) {
            temp = temp.next;
            i++;
        }

        if (temp == null) {
            System.out.println("Index out of bounds");
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    public int removeFirst() {

        if (size == 0) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {

        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;

    }

    public int IterativeSearch(int key) {

        Node temp = head;
        int i = 0;

        while (temp != null) {

            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        // if key not found
        return -1;
    }

    public int helper(Node head, int key) {

        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);

        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int ReucursiveSearch(int key) {
        return helper(head, key);
    }

    public void Reverse() {

        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthnodefromEnd(int n) {

        // calculate size of node

        int size_ = 0;
        Node temp = head;

        // while (temp != null) {

        // if(n != temp.data){
        // System.out.println("Element not present");
        // return;
        // }
        // }

        while (temp != null) {
            temp = temp.next;
            size_++;
        }

        if (n == size_) {
            head = head.next; // remove first
            return;
        }

        // sz-n
        int i = 1;
        int itoFind = size_ - n;
        Node prev = head;
        while (i < itoFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;

    }

    public static boolean isCycle() {

        Node slow = head; // +1
        Node fast = head; // +2

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                return true; // cycle exist
            }
        }
        return false; // cycle doesn't exist
    }

    public static void removeCycle() {

        // detect cycle

        Node slow = head;
        Node fast = head;

        boolean cycle = false;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {

                cycle = true;
            }
        }

        if (cycle == false) {
            return;
        }
        // find meeting point

        slow = head;
        Node prev = null;

        while (slow != fast) {

            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle

        prev.next = null;

    }

    public static void main(String[] args) {
        LLintro linkedList = new LLintro();

        // linkedList.addFirst(1);
        // linkedList.addLast(2);
        // linkedList.addLast(3);
        // linkedList.addLast(4);
        // linkedList.print();
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = head;
        // linkedList.print();

        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());

        // System.out.println(linkedList.IterativeSearch(10));
        // System.out.println(linkedList.ReucursiveSearch(3));
        // System.out.println(linkedList.ReucursiveSearch(10));
        // System.out.println(size);

        // linkedList.removeFirst();
        // linkedList.print();

        // linkedList.removeLast();
        // linkedList.removeLast();
        // linkedList.removeLast();
        // linkedList.print();

        // linkedList.Reverse();
        // linkedList.print();
        // System.out.println("Deleted element "+n);
        // linkedList.deleteNthnodefromEnd(n);
        // linkedList.print();
    }
}
