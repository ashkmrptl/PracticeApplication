/*
 * 					1
 * 				2		3
 * 			4		56		7
 * 
 * For the above binary tree level order traversal will be 1 2 3 4 5 6 7
 */
public class LevelOrderTraversalBinaryTreeExample {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(12);
		root.right.left = new TreeNode(16);
		root.right.right = new TreeNode(25);

		levelOrderTraversal(root);
	}

	private static void levelOrderTraversal(TreeNode root) {
		// Start from level - 1 till height of the tree
		int level = 1;

		while (printLevel(root, level)) {
			level++;
		}
	}

	private static boolean printLevel(TreeNode root, int level) {
		// Checking for root node
		if (root == null) {
			return false;
		}

		if (level == 1) {
			System.out.print(root.key + " ");
			return true;
		}

		boolean left = printLevel(root.left, level - 1);
		boolean right = printLevel(root.right, level - 1);

		return left || right;
	}
}

//Data structure to store a Binary Tree node
class TreeNode {
	int key;
	TreeNode left = null, right = null;

	TreeNode(int key) {
		this.key = key;
	}
}
