import java.util.LinkedList;

public class newLL {

    public static class Node {

        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
        // head node and tail node
    }

    public static Node head;
    public static Node tail;
    // find size
    public static int size = 0;

    public void addFirst(int data) {

        Node newNode = new Node(data);

        // check for ll is empty or not

        if (head == null) {
            head = tail = newNode;
        }

        // step2

        newNode.next = head;

        // step 3.
        head = newNode;
        size++;
    }

    public void addLast(int data) {

        // step 1:
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = null;
            return;
        }
        // step 2

        tail.next = newNode;
        // step 3
        tail = newNode;
        size++;
    }

    public void printLL() {

        Node temp = head;
        if (head == null) {
            System.out.println("ll is empty");
            System.out.println(head.data);
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public void add(int idx, int data) {

        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;

        while (i < idx - 1) {

            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public int removeFirst() {

        if (size == 0) {
            System.out.println("ll is emtpy");
            return -1;
        }
        if (size == 1) {
            int val = head.data;
            head = head.next;
            size = 0;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {

        if (size == 0) {
            System.out.println("ll is empty");
            return -1;
        }
        if (size == 1) {
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

    public static int findTargetItr(int target) {

        int idx = 0;
        Node temp = head;
        if (head == null) {
            return head.data;
        }

        while (temp != null) {
            if (temp.data == target) {
                return idx;
            }
            temp = temp.next;
            idx++;
        }
        return -1;
    }

    public static int helper(Node head, int key) {

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

    public static int RecursiveSearch(int key) {

        return helper(head, key);
    }

    public void reverse() {

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

    public void deleteNthNodefromEnd(int n) {

        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (n == sz) {
            head = head.next;
            return;
        }

        int i = 1;
        int itoFind = size - n;
        Node prev = head;
        while (i < itoFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    public Node findMid(Node head) {

        Node slow = head;
        Node fast = head;

        if (head == null) {
            return head;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid
    }

    public boolean checkPalindrome() {

        // step1 : find mid

        Node midNode = findMid(head);
        // step2 : reverse second or left part

        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // step3 : check whether right part is equal to left part or not

        Node right = prev; // head of right half
        Node left = head;

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;

    }

    public static void main(String[] args) {

        newLL ll = new newLL();
        LinkedList<Integer>list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        System.out.println(list.checkPalindrome());
        // ll.printLL();
        // ll.addFirst(1);
        // ll.addLast(3);
        // ll.printLL();

    }
}