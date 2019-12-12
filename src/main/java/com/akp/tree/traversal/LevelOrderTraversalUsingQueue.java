package com.akp.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalUsingQueue {
    private Node root;

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private void printLevelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.println(tempNode.value);

            //en-queue left child
            if (tempNode.left != null)
                queue.add(tempNode.left);

            //en-queue right child
            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
    }

    public static void main(String[] args) {
        LevelOrderTraversalUsingQueue lot = new LevelOrderTraversalUsingQueue();
        lot.root = new Node(1);
        lot.root.left = new Node(2);
        lot.root.right = new Node(3);
        lot.root.left.left = new Node(4);
        lot.root.left.right = new Node(5);

        lot.printLevelOrder();
    }
}
