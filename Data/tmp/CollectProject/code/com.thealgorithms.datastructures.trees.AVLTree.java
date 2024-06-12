public class AVLTree {
	private com.thealgorithms.datastructures.trees.AVLTree.Node root;

	private class Node {
		private int key;

		private int balance;

		private int height;

		private com.thealgorithms.datastructures.trees.AVLTree.Node left;

		private com.thealgorithms.datastructures.trees.AVLTree.Node right;

		private com.thealgorithms.datastructures.trees.AVLTree.Node parent;

		Node(int k, com.thealgorithms.datastructures.trees.AVLTree.Node p) {
			key = k;
			parent = p;
		}
	}

	public boolean insert(int key) {
		if (root == null) {
			root = new com.thealgorithms.datastructures.trees.AVLTree.Node(key, null);
		} else {
			com.thealgorithms.datastructures.trees.AVLTree.Node n = root;
			com.thealgorithms.datastructures.trees.AVLTree.Node parent;
			while (true) {
				if (n.key == key) {
					return false;
				}
				parent = n;
				boolean goLeft = n.key > key;
				n = (goLeft) ? n.left : n.right;
				if (n == null) {
					if (goLeft) {
						parent.left = new com.thealgorithms.datastructures.trees.AVLTree.Node(key, parent);
					} else {
						parent.right = new com.thealgorithms.datastructures.trees.AVLTree.Node(key, parent);
					}
					rebalance(parent);
					break;
				}
			} 
		}
		return true;
	}

	private void delete(com.thealgorithms.datastructures.trees.AVLTree.Node node) {
		if ((node.left == null) && (node.right == null)) {
			if (node.parent == null) {
				root = null;
			} else {
				com.thealgorithms.datastructures.trees.AVLTree.Node parent = node.parent;
				if (parent.left == node) {
					parent.left = null;
				} else {
					parent.right = null;
				}
				rebalance(parent);
			}
			return;
		}
		com.thealgorithms.datastructures.trees.AVLTree.Node child;
		if (node.left != null) {
			child = node.left;
			while (child.right != null) {
				child = child.right;
			} 
		} else {
			child = node.right;
			while (child.left != null) {
				child = child.left;
			} 
		}
		node.key = child.key;
		delete(child);
	}

	public void delete(int delKey) {
		if (root == null) {
			return;
		}
		com.thealgorithms.datastructures.trees.AVLTree.Node node = root;
		com.thealgorithms.datastructures.trees.AVLTree.Node child = root;
		while (child != null) {
			node = child;
			child = (delKey >= node.key) ? node.right : node.left;
			if (delKey == node.key) {
				delete(node);
				return;
			}
		} 
	}

	private void rebalance(com.thealgorithms.datastructures.trees.AVLTree.Node n) {
		setBalance(n);
		if (n.balance == (-2)) {
			if (height(n.left.left) >= height(n.left.right)) {
				n = rotateRight(n);
			} else {
				n = rotateLeftThenRight(n);
			}
		} else if (n.balance == 2) {
			if (height(n.right.right) >= height(n.right.left)) {
				n = rotateLeft(n);
			} else {
				n = rotateRightThenLeft(n);
			}
		}
		if (n.parent != null) {
			rebalance(n.parent);
		} else {
			root = n;
		}
	}

	private com.thealgorithms.datastructures.trees.AVLTree.Node rotateLeft(com.thealgorithms.datastructures.trees.AVLTree.Node a) {
		com.thealgorithms.datastructures.trees.AVLTree.Node b = a.right;
		b.parent = a.parent;
		a.right = b.left;
		if (a.right != null) {
			a.right.parent = a;
		}
		b.left = a;
		a.parent = b;
		if (b.parent != null) {
			if (b.parent.right == a) {
				b.parent.right = b;
			} else {
				b.parent.left = b;
			}
		}
		setBalance(a, b);
		return b;
	}

	private com.thealgorithms.datastructures.trees.AVLTree.Node rotateRight(com.thealgorithms.datastructures.trees.AVLTree.Node a) {
		com.thealgorithms.datastructures.trees.AVLTree.Node b = a.left;
		b.parent = a.parent;
		a.left = b.right;
		if (a.left != null) {
			a.left.parent = a;
		}
		b.right = a;
		a.parent = b;
		if (b.parent != null) {
			if (b.parent.right == a) {
				b.parent.right = b;
			} else {
				b.parent.left = b;
			}
		}
		setBalance(a, b);
		return b;
	}

	private com.thealgorithms.datastructures.trees.AVLTree.Node rotateLeftThenRight(com.thealgorithms.datastructures.trees.AVLTree.Node n) {
		n.left = rotateLeft(n.left);
		return rotateRight(n);
	}

	private com.thealgorithms.datastructures.trees.AVLTree.Node rotateRightThenLeft(com.thealgorithms.datastructures.trees.AVLTree.Node n) {
		n.right = rotateRight(n.right);
		return rotateLeft(n);
	}

	private int height(com.thealgorithms.datastructures.trees.AVLTree.Node n) {
		if (n == null) {
			return -1;
		}
		return n.height;
	}

	private void setBalance(com.thealgorithms.datastructures.trees.AVLTree.Node... nodes) {
		for (com.thealgorithms.datastructures.trees.AVLTree.Node n : nodes) {
			reheight(n);
			n.balance = height(n.right) - height(n.left);
		}
	}

	public void printBalance() {
		printBalance(root);
	}

	private void printBalance(com.thealgorithms.datastructures.trees.AVLTree.Node n) {
		if (n != null) {
			printBalance(n.left);
			java.lang.System.out.printf("%s ", n.balance);
			printBalance(n.right);
		}
	}

	private void reheight(com.thealgorithms.datastructures.trees.AVLTree.Node node) {
		if (node != null) {
			node.height = 1 + java.lang.Math.max(height(node.left), height(node.right));
		}
	}

	public boolean search(int key) {
		com.thealgorithms.datastructures.trees.AVLTree.Node result = searchHelper(this.root, key);
		return result != null;
	}

	private com.thealgorithms.datastructures.trees.AVLTree.Node searchHelper(com.thealgorithms.datastructures.trees.AVLTree.Node root, int key) {
		if ((root == null) || (root.key == key)) {
			return root;
		}
		if (root.key > key) {
			return searchHelper(root.left, key);
		}
		return searchHelper(root.right, key);
	}

	public static void main(java.lang.String[] args) {
		com.thealgorithms.datastructures.trees.AVLTree tree = new com.thealgorithms.datastructures.trees.AVLTree();
		java.lang.System.out.println("Inserting values 1 to 10");
		for (int i = 1; i < 10; i++) {
			tree.insert(i);
		}
		java.lang.System.out.print("Printing balance: ");
		tree.printBalance();
	}
}