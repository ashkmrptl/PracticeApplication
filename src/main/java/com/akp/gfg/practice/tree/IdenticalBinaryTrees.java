package com.akp.gfg.practice.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class IdenticalBinaryTrees {
    private static Node buildTreeByLevelOrder(String input) {
        if (input.charAt(0) == 'N') {
            return null;
        }

        String[] array = input.split(" ");

        //Push first element to queue
        Queue<Node> queue = new LinkedList<>();
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

    public static boolean areTreesIdentical(Node root1, Node root2) {

        if (Objects.isNull(root1) && Objects.isNull(root2)) {
            return true;
        } else if (!Objects.isNull(root1) && !Objects.isNull(root2)) {
            return root1.value == root2.value &&
                    areTreesIdentical(root1.left, root2.left) &&
                    areTreesIdentical(root1.right, root2.right);
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input1 = br.readLine();
            String input2 = br.readLine();

            Node root1 = buildTreeByLevelOrder(input1);
            Node root2 = buildTreeByLevelOrder(input2);

            if (areTreesIdentical(root1, root2)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
