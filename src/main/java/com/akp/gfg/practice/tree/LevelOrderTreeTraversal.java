package com.akp.gfg.practice.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTreeTraversal {

    /**
     * Builds a binary tree from an array in level order fashion
     *
     * @param input input array separated by single space
     * @return root node
     */
    private static Node buildTreeByLevelOrder(final String input) {
        if (input.charAt(0) == 'N') {
            return null;
        }

        String[] array = input.split(" ");
        Queue<Node> queue = new LinkedList<>();

        //Push first node to queue
        Node root = new Node(Integer.parseInt(array[0]));
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < array.length) {
            Node curr = queue.peek();
            queue.remove();

            //Left node
            if (!array[i].equals("N")) {
                curr.left = new Node(Integer.parseInt(array[i]));
                queue.add(curr.left);
            }

            i++;
            if (i >= array.length) {
                break;
            }
            if (!array[i].equals("N")) {
                curr.right = new Node(Integer.parseInt(array[i]));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void printLevelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        //Push root to the queue
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.peek();
            queue.remove();

            System.out.print(curr.value + " ");
            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    private static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static void printLevelOrderLineByLine(Node root) {
        int height = getHeight(root);
        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i);
            System.out.print("$ ");
        }
    }

    private static void printGivenLevel(Node root, int level) {
        if (root == null) {
            return;
        } else if (level == 1) {
            System.out.print(root.value + " ");
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();

            Node root = buildTreeByLevelOrder(input);

            System.out.println("\nLevel order : ");
            printLevelOrder(root);

            System.out.println("\nLevel order line by line : ");
            printLevelOrderLineByLine(root);
        }

    }
}
