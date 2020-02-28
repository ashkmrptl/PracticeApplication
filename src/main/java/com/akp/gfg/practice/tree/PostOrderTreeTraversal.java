package com.akp.gfg.practice.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PostOrderTreeTraversal {
    private static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private static void printLevelOrderRecursively(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();

        //Push root to queue
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.peek();
            queue.remove();
            if (curr == null) {
                continue;
            }

            System.out.print(curr.value + " ");

            queue.add(curr.left);
            queue.add(curr.right);

        }
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

    private static Node buildTreeByLevelOrder(String input) {
        if (input.charAt(0) == 'N') {
            return null;
        }

        String[] array = input.split(" ");

        Queue<Node> queue = new LinkedList<>();
        //Push first element to the queue
        Node root = new Node(Integer.parseInt(array[0]));
        queue.add(root);

        //Process next elements
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
            //Right node
            if (!array[i].equals("N")) {
                curr.right = new Node(Integer.parseInt(array[i]));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void printPostorder(Node node) {
        if (node == null) {
            return;
        }

        printPostorder(node.left);
        printPostorder(node.right);

        System.out.print(node.value + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            Node root = buildTreeByLevelOrder(input);

            System.out.println("\nLevel order : ");
            printLevelOrderIteratively(root);

            System.out.println("\nLevel order recursively : ");
            printLevelOrderRecursively(root);

            System.out.println("\nPost order : ");
            printPostorder(root);
        }
    }
}
