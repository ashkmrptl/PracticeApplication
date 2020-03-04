package com.akp.gfg.practice.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {

    private static Node buildTreeByLevelOrder(String input) {
        if (input.charAt(0) == 'N') {
            return null;
        }

        String[] array = input.split(" ");

        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(array[0]));
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < array.length) {
            Node curr = queue.peek();
            queue.remove();

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

    private static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static Node getMirror(Node root) {
        int height = getHeight(root);

        for (int i = 1; i <= height; i++) {
            getMirrorByLevel(root, i);
        }

        return root;
    }

    public static void getMirrorByLevel(Node node, int level) {
        if (node == null) {
            return;
        }

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        getMirrorByLevel(node.left, level - 1);
        getMirrorByLevel(node.right, level - 1);

    }

    public static void printInOrder(Node node) {
        if (node == null) {
            return;
        }

        printInOrder(node.left);
        System.out.print(node.value + " ");
        printInOrder(node.right);
    }

    public static boolean areMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.value == root2.value &&
                areMirror(root1.left, root2.right) &&
                areMirror(root1.right, root2.left);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            Node root = buildTreeByLevelOrder(input);

            System.out.println("\nInorder traversal : ");
            printInOrder(root);

            System.out.println("\nInorder traversal after mirror : ");
            //Node mirrorRoot = getMirror(root);
            getMirrorByLevel(root, getHeight(root));
            printInOrder(root);

            String input1 = br.readLine();
            Node root1 = buildTreeByLevelOrder(input1);
            System.out.println("\n are trees mirror");
            areMirror(root, root1);
        }
    }
}
