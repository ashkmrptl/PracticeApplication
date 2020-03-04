package com.akp.gfg.practice.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary search tree is a special kind of binary tree, where the left subtree of a node contains
 * nodes with value which are less than the node's value and right subtree contains nodes with value which
 * are greater than node's value.
 * Both left and right subtrees must also binary search tree.
 * <p>
 * Method 1: (Correct but inefficient)
 * For each node check if MAX_VALUE in left subtree is smaller than the node and MIN_VALUE in right subtree
 * is greater than the node.
 * <p>
 * Method 2: We can do a in-order traversal of the binary tree and store the result in a temporary array. Then by
 * checking if the temporary arr is in ascending order we can tell the tree is BST or not.
 * Time complexity for this is O(n).
 */
public class CheckForBST {

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

    private static List<Integer> getPostOrderList(Node root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private static void postOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.value);
    }

    private static List<Integer> getInOrderList(Node root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private static void inOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.value);
        inOrder(node.right, list);
    }

    private static boolean isSorted(List<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) > array.get(i + 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            Node root = buildBinaryTreeByLevelOrder(input);
            List<Integer> list = getPostOrderList(root);

            System.out.println("\nPost order list : ");
            System.out.println("list : " + list);

            list = getInOrderList(root);

            System.out.println("\nIn order list : ");
            System.out.println("list : " + list);

            System.out.println("\nIs BST ?");
            if (isSorted(list)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
