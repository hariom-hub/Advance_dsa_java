package Advance_dsa_java.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class bstMirror {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {

            this.data = data;
            this.right = this.left = null;
        }
    }


    public static Node MirrorBst(Node root) {


        if (root == null) {

            return null;
        }

        Node leftS = MirrorBst(root.left);
        Node rightS = MirrorBst(root.right);

        root.left = rightS;
        root.right = leftS;

        return root;
    }


//    public static void LevelOrder(Node root) {
//
//        if (root == null) {
//            return;
//        }
//
//        Queue<Node> qu = new LinkedList<>();
//
//        qu.add(root);
//        qu.add(null);
//
//        while (!qu.isEmpty()) {
//
//            Node currNode = qu.remove();
//
//            if (currNode == null) {
//                System.out.println();
//
//                if (qu.isEmpty()) {
//                    break;
//                } else {
//                    qu.add(null);
//                }
//            } else {
//
//                System.out.print(root.data+" ");
//                if (root.left != null) {
//                    qu.add(root.left);
//                }
//
//                if (root.right != null) {
//                    qu.add(root.right);
//                }
//            }
//        }
//    }

    public static void preorder(Node root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        //original tree

            /*
                8
               / \
              5   10
             / \     \
            3   6     11

          */

        MirrorBst(root);
        preorder(root);
        //mirror tree
        /*
                   8
                  / \
                 10  5
                /   / \
               11  6   3
         */

    }
}