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

        public Node(int value) {
            this.value = value;
        }
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            //Computing the height of each sub-tree
            int lHeight = height(root.left);
            int rHeight = height(root.right);

            //Taking the largest one
            if (lHeight > rHeight) {
                return ++lHeight;
            } else {
                return ++rHeight;
            }
        }
    }

    public void printLevelOrder(Node root) {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printGivenLevel(root, i);
        }
    }

    public void printGivenLevel(Node root, int level) {
        if (root == null) {
            return;
        } else if (level == 1) {
            System.out.println(root.value);
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    public static void main(String[] args) {
        LevelOrderTraversal lot = new LevelOrderTraversal();
        lot.root = new Node(1);
        lot.root.left = new Node(2);
        lot.root.right = new Node(3);
        lot.root.left.left = new Node(4);
        lot.root.left.right = new Node(5);

        lot.printLevelOrder(lot.root);
    }

}
