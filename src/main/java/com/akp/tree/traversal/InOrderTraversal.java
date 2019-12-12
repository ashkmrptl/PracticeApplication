package com.akp.tree.traversal;

import java.util.Stack;

/*
 * Inorder(left, root, right)
 */
public class InOrderTraversal {
    Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);

        System.out.print(root.data + " ");

        printInOrder(root.right);
    }

    private void printInorderWithoutRecurssion(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || stack.size() > 0) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            //Current is null at this point
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }

    }

    public static void main(String[] args) {
        InOrderTraversal tree = new InOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("In-Order traversal with recursion : ");
        tree.printInOrder();

        System.out.println("\nIn-order traversal without recursion : ");
        tree.printInorderWithoutRecurssion(tree.root);
    }
}
