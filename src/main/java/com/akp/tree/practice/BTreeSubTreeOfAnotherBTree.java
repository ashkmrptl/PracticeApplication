package com.akp.tree.practice;

public class BTreeSubTreeOfAnotherBTree {
	Node root1, root2;

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	// Method to check if trees with root1 and root2 are identical
	boolean areIdentical(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}

		// checking data of both nodes are same and proceed with checking other nodes
		// and return accordingly
		return ((root1.data == root2.data) && areIdentical(root1.left, root2.left)
				&& areIdentical(root1.right, root2.right));
	}

	// Method to return true if node2 is subtree of node1
	boolean isSubtree(Node node1, Node node2) {
		if (node2 == null) {
			return true;
		}

		if (node1 == null) {
			return false;
		}

		if (areIdentical(node1, node2)) {
			return true;
		}

		return isSubtree(node1.left, node2) || isSubtree(node1.right, node2);
	}

	public static void main(String[] args) {
		BTreeSubTreeOfAnotherBTree tree = new BTreeSubTreeOfAnotherBTree();

		// TREE 1
		tree.root1 = new Node(26);
		tree.root1.right = new Node(3);
		tree.root1.right.right = new Node(3);
		tree.root1.left = new Node(10);
		tree.root1.left.left = new Node(4);
		tree.root1.left.left.right = new Node(30);
		tree.root1.left.right = new Node(6);

		// TREE 2
		tree.root2 = new Node(10);
		tree.root2.right = new Node(6);
		tree.root2.left = new Node(4);
		tree.root2.left.right = new Node(3);

		if (tree.isSubtree(tree.root1, tree.root2)) {
			System.out.println("Tree 2 is subtree of Tree 1 ");
		} else {
			System.out.println("Tree 2 is not a subtree of Tree 1");
		}
	}
}
