package com.akp.gfg.practice.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeftViewOfBinaryTree {
    private static Node buildBinaryTreeByLevelOrder(String input) {
        if (input.charAt(0) == 'N') {
            return null;
        }

        String[] array = input.split(" ");

        Queue<Node> queue = new LinkedList<>();

        //Push root to the queue
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
            //Right node
            if (!array[i].equals("N")) {
                curr.right = new Node(Integer.parseInt(array[i]));
                queue.add(curr.right);
            }
            i++;
        }

        return root;
    }

    private static int max_level = 0;

    public static void printLeftViewByLevelOrder(Node root) {
        printLeftNodeForGivenLevel(root, 1);
    }

    private static void printLeftNodeForGivenLevel(Node node, int level) {
        if (node == null) {
            return;
        }

        //Print if this is first node of the level
        if (max_level < level) {
            System.out.print(node.value + " ");
            max_level = level;
        }

        printLeftNodeForGivenLevel(node.left, level + 1);
        printLeftNodeForGivenLevel(node.right, level + 1);

    }

    private static void printLeftViewUsingQueue(Node root) {
        if (root == null) {
            return;
        }

        //Add root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;

            while (i++ < size) {
                Node curr = queue.peek();
                queue.remove();

                //Print the first node of the current level
                if (i == 1) {
                    System.out.print(curr.value + " ");
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }

    private static void leftView(Node node, int level, Map<Integer, Integer> map) {
        //Base case
        if (node == null) {
            return;
        }

        //If level is visited first time, insert current node and level into the map
        if (!map.containsKey(level)) {
            map.put(level, node.value);
        }

        leftView(node.left, level + 1, map);
        leftView(node.right, level + 1, map);
    }

    public static void leftViewUsingmap(Node root) {
        //Empty map to store 1st node of each level
        Map<Integer, Integer> map = new HashMap<>();

        leftView(root, 1, map);

        //Print elements from map
        map.forEach((key, value) -> System.out.print(value + " "));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            max_level = 0;
            String input = br.readLine();
            Node root = buildBinaryTreeByLevelOrder(input);

            System.out.println("\nLeft view : ");
            printLeftViewByLevelOrder(root);

            System.out.println("\nLeft view with queue : ");
            printLeftViewUsingQueue(root);

            System.out.println("\nLeft view using map : ");
            leftViewUsingmap(root);
        }
    }
}
