package com.akp.tree.traversal;

/*
 * Preorder(root, left, right)
 */
public class PreOrderTraversal {
	static Node root;

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	private void printPreOrder() {
		printPreOrder(root);
	}

	private void printPreOrder(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");

		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	public static void main(String[] args) {
		PreOrderTraversal tree = new PreOrderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Pre Order traversal : ");
		tree.printPreOrder();
	}
}
