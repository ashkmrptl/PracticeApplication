package com.akp.gfg.practice.tree;

/**
 * While creating a binary tree in level order from an array, the left child of an element at index 'n' is at
 * (2*n + 1) and the right child of a node is at (2*n + 2).
 * <p>
 * Using this we can construct a binary tree from an array using level order traversal.
 */
public class DiameterOfBinaryTreeNotWorking {
    private Node root;

    public Node createTreeInLevelOrder(int[] array, Node node, int i) {
        if (i < array.length && array[i] != -1) {
            node = new Node(array[i]);

            node.left = createTreeInLevelOrder(array, node.left, (2 * i + 1));

            node.right = createTreeInLevelOrder(array, node.right, (2 * i + 2));
        }
        return node;
    }

    //Function to get eight of the tree
    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left) + 1, getHeight(node.right) + 1);
    }

    //Function to print tree nodes in InOrder fashion
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }

    //Function to print tree nodes in LevelOrder fashion
    public void levelOrder(Node root) {
        final int height = getHeight(root);
        System.out.println("Height of the tree : " + height);
        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i);
        }
    }

    private void printGivenLevel(Node node, int level) {
        if (node == null) {
            return;
        } else if (level == 1) {
            System.out.print(node.value + " ");
        } else if (level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }

    public int getDiameter(Node root) {
        return Math.addExact(getHeight(root.left), getHeight(root.right) + 1);
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, -1, 4, 10, -1, 8, 5, -1, 8, 8, -1, 6};
        DiameterOfBinaryTreeNotWorking tree = new DiameterOfBinaryTreeNotWorking();
        tree.root = tree.createTreeInLevelOrder(arr, tree.root, 0);
        tree.inOrder(tree.root);

        tree.levelOrder(tree.root);

        System.out.println("diameter : " + tree.getDiameter(tree.root));
    }
}