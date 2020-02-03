package com.akp.gfg.practice.tree;

import java.util.Stack;

public class BinaryTree {
    private Node root;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder");
        tree.printPreOrder(tree.root);

        System.out.println("\nInorder");
        tree.printInOrder(tree.root);
        System.out.println("--------------------");
        tree.printInOrderIteratively();

        System.out.println("\nPostorder");
        tree.printPostOrder(tree.root);

        System.out.println("\nNo of leaf nodes : " + countLeafNodes(tree.root));
    }

    public static int countLeafNodes(final Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return countLeafNodes(node.left) + countLeafNodes(node.right);
        }
    }

    public void printInOrderIteratively() {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || stack.size() > 0) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.value + " ");
            current = current.right;
        }
    }

    public void printInOrder(final Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);

        System.out.print(node.value + " ");

        printInOrder(node.right);
    }

    public void printPreOrder(final Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void printPostOrder(final Node node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.value + " ");
    }
}
