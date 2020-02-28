package com.akp.gfg.practice.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class DiameterOfBinaryTree {
    public static Node buildTreeByLevelOrder(String str) {
        if (str.isEmpty() || str.charAt(0) == 'N') {
            return null;
        }

        String[] array = str.split(" ");

        Queue<Node> queue = new LinkedList<>();

        //Push root to the queue
        Node root = new Node(Integer.parseInt(array[0]));
        queue.add(root);

        //Proceed for next nodes
        int i = 1;
        while (!queue.isEmpty() && i < array.length) {
            Node currentNode = queue.peek();
            queue.remove();

            //Left node
            if (!array[i].equals("N")) {
                currentNode.left = new Node(Integer.parseInt(array[i]));
                queue.add(currentNode.left);
            }

            i++;

            //Right node
            if (i >= array.length) {
                break;
            }
            if (!array[i].equals("N")) {
                currentNode.right = new Node(Integer.parseInt(array[i]));
                queue.add(currentNode.right);
            }

            i++;
        }
        return root;
    }

    private static void printLevelOrderUsingQueue(Node root) {
        if (root == null) {
            System.out.println("Empty tree");
        }
        Queue<Node> queue = new LinkedList<>();

        //Add root node to the queue
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.peek();
            queue.remove();
            System.out.print(node.value + " ");

            //Left Node
            Node left = node.left;
            if (left != null) {
                queue.add(left);
            }

            //Right Node
            Node right = node.right;
            if (right != null) {
                queue.add(right);
            }
        }
    }

    private static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left) + 1, getHeight(root.right) + 1);
    }

    private static void printLevelOrderIteratively(Node root) {
        int height = getHeight(root);
        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i);
        }
    }

    private static void printGivenLevel(Node node, int level) {
        if (node == null) {
            return;
        } else if (level == 1) {
            System.out.print(node.value + " ");
        } else if (level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }

    private static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.value + " ");

        printInorder(root.right);
    }

    /*
     *The diameter is the MAX of the following
     * i) Diameter of the T's left subtree
     * ii) Diameter of the T's right subtree
     * iii) Longest path between leaves that goes through root
     */
    private static int getDiameter(Node node) {
        if (node == null) {
            return 0;
        }
        //Height of left and right sub-trees
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        //Diameter of left and right sub-trees
        int leftDiameter = getDiameter(node.left);
        int rightDiameter = getDiameter(node.right);

        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            Node root = buildTreeByLevelOrder(input);

            System.out.println("\nIn order : ");
            printInorder(root);
            System.out.println("\nLevel order : ");
            printLevelOrderUsingQueue(root);
            System.out.println("\nLevel order iteratively : ");
            printLevelOrderIteratively(root);
            System.out.println("\nDiameter : ");
            System.out.println(getDiameter(root));
        }
    }
}
