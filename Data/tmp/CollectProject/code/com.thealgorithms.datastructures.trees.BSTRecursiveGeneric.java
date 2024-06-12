public class BSTRecursiveGeneric<T extends java.lang.Comparable<T>> {
	private com.thealgorithms.datastructures.trees.BSTRecursiveGeneric.Node<T> root;

	public BSTRecursiveGeneric() {
		root = null;
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing for integer data...");
		com.thealgorithms.datastructures.trees.BSTRecursiveGeneric<java.lang.Integer> integerTree = new com.thealgorithms.datastructures.trees.BSTRecursiveGeneric<java.lang.Integer>();
		integerTree.add(5);
		integerTree.add(10);
		integerTree.add(9);
		assert !integerTree.find(4) : "4 is not yet present in BST";
		assert integerTree.find(10) : "10 should be present in BST";
		integerTree.remove(9);
		assert !integerTree.find(9) : "9 was just deleted from BST";
		integerTree.remove(1);
		assert !integerTree.find(1) : "Since 1 was not present so find deleting would do no change";
		integerTree.add(20);
		integerTree.add(70);
		assert integerTree.find(70) : "70 was inserted but not found";
		integerTree.inorder();
		java.lang.System.out.println();
		java.lang.System.out.println("Testing for string data...");
		com.thealgorithms.datastructures.trees.BSTRecursiveGeneric<java.lang.String> stringTree = new com.thealgorithms.datastructures.trees.BSTRecursiveGeneric<java.lang.String>();
		stringTree.add("banana");
		stringTree.add("pineapple");
		stringTree.add("date");
		assert !stringTree.find("girl") : "girl is not yet present in BST";
		assert stringTree.find("pineapple") : "10 should be present in BST";
		stringTree.remove("date");
		assert !stringTree.find("date") : "date was just deleted from BST";
		stringTree.remove("boy");
		assert !stringTree.find("boy") : "Since boy was not present so deleting would do no change";
		stringTree.add("india");
		stringTree.add("hills");
		assert stringTree.find("hills") : "hills was inserted but not found";
		stringTree.inorder();
	}

	private com.thealgorithms.datastructures.trees.BSTRecursiveGeneric.Node<T> delete(com.thealgorithms.datastructures.trees.BSTRecursiveGeneric.Node<T> node, T data) {
		if (node == null) {
			java.lang.System.out.println("No such data present in BST.");
		} else if (node.data.compareTo(data) > 0) {
			node.left = delete(node.left, data);
		} else if (node.data.compareTo(data) < 0) {
			node.right = delete(node.right, data);
		} else if ((node.right == null) && (node.left == null)) {
			node = null;
		} else if (node.left == null) {
			com.thealgorithms.datastructures.trees.BSTRecursiveGeneric.Node<T> temp = node.right;
			node.right = null;
			node = temp;
		} else if (node.right == null) {
			com.thealgorithms.datastructures.trees.BSTRecursiveGeneric.Node<T> temp = node.left;
			node.left = null;
			node = temp;
		} else {
			com.thealgorithms.datastructures.trees.BSTRecursiveGeneric.Node<T> temp = node.right;
			while (temp.left != null) {
				temp = temp.left;
			} 
			node.data = temp.data;
			node.right = delete(node.right, temp.data);
		}
		return node;
	}

	private com.thealgorithms.datastructures.trees.BSTRecursiveGeneric.Node<T> insert(com.thealgorithms.datastructures.trees.BSTRecursiveGeneric.Node<T> node, T data) {
		if (node == null) {
			node = new com.thealgorithms.datastructures.trees.BSTRecursiveGeneric.Node<>(data);
		} else if (node.data.compareTo(data) > 0) {
			node.left = insert(node.left, data);
		} else if (node.data.compareTo(data) < 0) {
			node.right = insert(node.right, data);
		}
		return node;
	}

	private void preOrder(com.thealgorithms.datastructures.trees.BSTRecursiveGeneric.Node<T> node) {
		if (node == null) {
			return;
		}
		java.lang.System.out.print(node.data + " ");
		if (node.left != null) {
			preOrder(node.left);
		}
		if (node.right != null) {
			preOrder(node.right);
		}
	}

	private void postOrder(com.thealgorithms.datastructures.trees.BSTRecursiveGeneric.Node<T> node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			postOrder(node.left);
		}
		if (node.right != null) {
			postOrder(node.right);
		}
		java.lang.System.out.print(node.data + " ");
	}

	private void inOrder(com.thealgorithms.datastructures.trees.BSTRecursiveGeneric.Node<T> node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			inOrder(node.left);
		}
		java.lang.System.out.print(node.data + " ");
		if (node.right != null) {
			inOrder(node.right);
		}
	}

	private void inOrderSort(com.thealgorithms.datastructures.trees.BSTRecursiveGeneric.Node<T> node, java.util.List<T> sortedList) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			inOrderSort(node.left, sortedList);
		}
		sortedList.add(node.data);
		if (node.right != null) {
			inOrderSort(node.right, sortedList);
		}
	}

	private boolean search(com.thealgorithms.datastructures.trees.BSTRecursiveGeneric.Node<T> node, T data) {
		if (node == null) {
			return false;
		} else if (node.data.compareTo(data) == 0) {
			return true;
		} else if (node.data.compareTo(data) > 0) {
			return search(node.left, data);
		} else {
			return search(node.right, data);
		}
	}

	public void add(T data) {
		this.root = insert(this.root, data);
	}

	public void remove(T data) {
		this.root = delete(this.root, data);
	}

	public void inorder() {
		java.lang.System.out.println("Inorder traversal of this tree is:");
		inOrder(this.root);
		java.lang.System.out.println();
	}

	public java.util.List<T> inorderSort() {
		java.util.List<T> sortedList = new java.util.ArrayList<>();
		inOrderSort(this.root, sortedList);
		return sortedList;
	}

	public void postorder() {
		java.lang.System.out.println("Postorder traversal of this tree is:");
		postOrder(this.root);
		java.lang.System.out.println();
	}

	public void preorder() {
		java.lang.System.out.println("Preorder traversal of this tree is:");
		preOrder(this.root);
		java.lang.System.out.println();
	}

	public boolean find(T data) {
		if (search(this.root, data)) {
			java.lang.System.out.println(data + " is present in given BST.");
			return true;
		}
		java.lang.System.out.println(data + " not found.");
		return false;
	}

	private static class Node<T> {
		T data;

		com.thealgorithms.datastructures.trees.BSTRecursiveGeneric.Node<T> left;

		com.thealgorithms.datastructures.trees.BSTRecursiveGeneric.Node<T> right;

		Node(T d) {
			data = d;
			left = null;
			right = null;
		}
	}
}