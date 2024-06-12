public class PrintTopViewofTree {
	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.trees.TreeNode root = new com.thealgorithms.datastructures.trees.TreeNode(1);
		root.left = new com.thealgorithms.datastructures.trees.TreeNode(2);
		root.right = new com.thealgorithms.datastructures.trees.TreeNode(3);
		root.left.right = new com.thealgorithms.datastructures.trees.TreeNode(4);
		root.left.right.right = new com.thealgorithms.datastructures.trees.TreeNode(5);
		root.left.right.right.right = new com.thealgorithms.datastructures.trees.TreeNode(6);
		com.thealgorithms.datastructures.trees.Tree t = new com.thealgorithms.datastructures.trees.Tree(root);
		java.lang.System.out.println("Following are nodes in top view of Binary Tree");
		t.printTopView();
	}
}