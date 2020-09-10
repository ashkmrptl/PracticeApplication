package com.akp.tree.practice;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseBinaryTree {
    private Node root;

    static class Node {
        int value;
        Node left, right;

        public Node(final int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private void reverseRecursively(final Node root) {
        if (root == null) {
            return;
        }

        //Reverse left and right child
        final Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        reverseRecursively(root.left);
        reverseRecursively(root.right);
    }

    private void reverseIteratively(final Node root) {
        final Queue<Node> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            Node tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;
        }
    }

    public static void main(String[] args) {
        final ReverseBinaryTree tree = new ReverseBinaryTree();

        final Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        tree.root = root;

        System.out.println("before reversing : ");
        tree.printInOrder();

        tree.reverseRecursively(tree.root);

        System.out.println("\nafter reversing : ");
        tree.printInOrder();

        tree.reverseIteratively(tree.root);

        System.out.println("\nafter reversing again : ");
        tree.printInOrder();

    }

    private void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);

        System.out.print(root.value + " ");

        printInOrder(root.right);
    }

}
