public class Height {

    static class Node {

        Node right;
        Node left;
        int data;

        Node(int data) {

            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void levelOrder(Node root) {

        if (root == null) {

            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {

            Node currNode = q.remove();

            if (currNode == null) {

                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {

                System.out.print(currNode.data + " ");

                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }

    public static int treeHeight(Node root) {

        if (root == null) {
            return 0;
        }
        int lh = treeHeight(root.left);
        int rh = treeHeight(root.right);

        return Math.max(lh, rh) + 1;
    }

    public static int NodeCount(Node root) {

        if (root == null) {
            return 0;
        }

        int leftCount = NodeCount(root.left);
        int rightCount = NodeCount(root.right);
        int totalCount = leftCount + rightCount + 1;

        return totalCount;
    }

    public static int NodeSum(Node root) {

        if (root == null) {
            return 0;
        }

        int leftSum = NodeSum(root.left);
        int rightSum = NodeSum(root.right);

        return leftSum + rightSum + root.data;
    }

    public static int treeDiameter(Node root) {

        if (root == null) {
            return 0;
        }

        int lh = treeHeight(root.left);
        int rh = treeHeight(root.right);

        int ld = treeDiameter(root.left);
        int rd = treeDiameter(root.right);

        int selfDiameter = lh + rh + 1;

        return Math.max(selfDiameter, Math.max(rd, ld));
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left = new Node(6);

        // root.right.left = new Node(6);
        // root.right.right = new Node(7);
        // System.out.println(treeHeight(root));
        // System.out.println(levelOrder(root));
        System.out.println(treeDiameter(root));

    }
}
}