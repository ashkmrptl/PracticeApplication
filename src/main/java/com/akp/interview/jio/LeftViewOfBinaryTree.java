package com.akp.interview.jio;

public class LeftViewOfBinaryTree {
    private static int max_level = 0;

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void printLeftView(Node node, int level) {
        // Base Case
        if (node == null)
            return;

        // If this is the first node of its level
        if (max_level < level) {
            System.out.print(" " + node.value);
            max_level = level;
        }

        // Recur for left and right subtrees
        printLeftView(node.left, level + 1);
        printLeftView(node.right, level + 1);

    }

    public static void main(String[] args) {
        Node root = null;
        root = new Node(12);
        root.left = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(40);

        printLeftView(root, 1);
    }
}
