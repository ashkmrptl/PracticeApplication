package com.akp.interview.jpmc;

public class CalculateSumOfAllNodesInBinaryTree {
    Node root;

    static class Node {
        Integer data;
        Node left;
        Node right;

        public Node(Integer data) {
            this.data = data;
        }
    }

    int sum = 0;

    public Integer calculateSum(Node root) {
        if (root != null) {
            calculateSum(root.left);
            sum = sum + root.data;
            calculateSum(root.right);
        }
        return sum;
    }

    public static void main(String[] args) {
        CalculateSumOfAllNodesInBinaryTree clc = new CalculateSumOfAllNodesInBinaryTree();
        clc.root = new Node(5);
        clc.root.left = new Node(2);
        clc.root.right = new Node(9);
        clc.root.left.left = new Node(1);
        clc.root.right.left = new Node(8);
        clc.root.right.right = new Node(6);

        System.out.println("Sum of all nodes : " + clc.calculateSum(clc.root));
    }
}
