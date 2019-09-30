package com.akp.tree.traversal;

import com.akp.tree.traversal.PreOrderTraversal.Node;

/*
 * PostOrder(left, right, root)
 */
public class PostOrderTraversal {
	Node root;

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	private void printPostOrder() {
		printPostOrder(root);
	}

	private void printPostOrder(Node root) {
		if (root == null) {
			return;
		}

		printPostOrder(root.left);
		printPostOrder(root.right);

		System.out.print(root.data + " ");
	}
	
	public static void main(String[] args) {
		PostOrderTraversal tree = new PostOrderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Pre Order traversal : ");
		tree.printPostOrder();
	}
}
