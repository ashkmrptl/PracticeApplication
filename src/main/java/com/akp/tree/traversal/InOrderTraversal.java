package com.akp.tree.traversal;

/*
 * Inorder(left, root, right)
 */
public class InOrderTraversal {
	Node root;

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	private void printInOrder() {
		printInOrder(root);
	}

	private void printInOrder(Node root) {
		if (root == null) {
			return;
		}

		printInOrder(root.left);

		System.out.print(root.data + " ");

		printInOrder(root.right);
	}

	public static void main(String[] args) {
		InOrderTraversal tree = new InOrderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Pre Order traversal : ");
		tree.printInOrder();
	}
}
