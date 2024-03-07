public class doubleLL {

    public class Node {

        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node prev;
    public static Node next;
    public static Node tail;
    public static int size;

    // add
    public void AddFirst(int data) {

        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = null;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    // print

    public  void printNode() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        doubleLL dll = new doubleLL();
        dll.AddFirst(5);
        dll.AddFirst(4);
        dll.AddFirst(3);
        dll.AddFirst(2);
        dll.AddFirst(1);
        dll.printNode();


    }

}