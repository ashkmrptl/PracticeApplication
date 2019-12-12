package com.akp.tree.traversal;

/*
This is also known as BFS(Breadth First Search)
 */
public class LevelOrderTraversal {
    private Node root;

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight + 1, rightHeight + 1);
    }

    private void printLevelOrder() {
        int height = getHeight(root);
        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i);
        }
    }

    private void printGivenLevel(Node node, int level) {
        if (node == null) {
            return;
        } else if (level == 1) {
            System.out.println(node.value);
        } else if (level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }

    }

    public static void main(String[] args) {
        LevelOrderTraversal lot = new LevelOrderTraversal();
        lot.root = new Node(1);
        lot.root.left = new Node(2);
        lot.root.right = new Node(3);
        lot.root.left.left = new Node(4);
        lot.root.left.right = new Node(5);

        System.out.println("height : " + lot.getHeight(lot.root));
        lot.printLevelOrder();
    }

}
