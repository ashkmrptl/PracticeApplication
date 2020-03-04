package com.akp.gfg.practice.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SumOfLeafNodes {
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

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    /**
     * Sibling is the node that has same parent
     *
     * @param node node
     * @param list list
     */
    public static void printAllLeafNodes(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.right != null) {
            printAllLeafNodes(node.left, list);
            printAllLeafNodes(node.right, list);
        } else if (node.right != null) {
            list.add(node.right.value);
            printAllLeafNodes(node.right, list);
        } else if (node.left != null) {
            list.add(node.left.value);
            printAllLeafNodes(node.left, list);
        }
    }

    public static int getSumOfLeafNodes(Node node) {
        if (node == null) {
            return 0;
        }

        if (isLeaf(node)) {
            return node.value;
        }

        return getSumOfLeafNodes(node.left) + getSumOfLeafNodes(node.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            Node root = buildTreeByLevelOrder(input);

            System.out.println("Leaf nodes : ");
            List<Integer> output = new ArrayList<>();
            printAllLeafNodes(root, output);

            if (output.isEmpty()) {
                System.out.println("-1");
            } else {
                output.stream().sorted().forEach(e -> System.out.print(e + " "));
            }

            int sum = getSumOfLeafNodes(root);
            System.out.println("\nsum : " + sum);
        }
    }
}
