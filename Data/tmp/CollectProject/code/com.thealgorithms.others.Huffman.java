public class Huffman {
	public static void printCode(com.thealgorithms.others.HuffmanNode root, java.lang.String s) {
		if (((root.left == null) && (root.right == null)) && java.lang.Character.isLetter(root.c)) {
			java.lang.System.out.println((root.c + ":") + s);
			return;
		}
		com.thealgorithms.others.Huffman.printCode(root.left, s + "0");
		com.thealgorithms.others.Huffman.printCode(root.right, s + "1");
	}

	public static void main(java.lang.String[] args) {
		java.util.Scanner s = new java.util.Scanner(java.lang.System.in);
		int n = 6;
		char[] charArray = new char[]{ 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = new int[]{ 5, 9, 12, 13, 16, 45 };
		java.util.PriorityQueue<com.thealgorithms.others.HuffmanNode> q = new java.util.PriorityQueue<com.thealgorithms.others.HuffmanNode>(n, new com.thealgorithms.others.MyComparator());
		for (int i = 0; i < n; i++) {
			com.thealgorithms.others.HuffmanNode hn = new com.thealgorithms.others.HuffmanNode();
			hn.c = charArray[i];
			hn.data = charfreq[i];
			hn.left = null;
			hn.right = null;
			q.add(hn);
		}
		com.thealgorithms.others.HuffmanNode root = null;
		while (q.size() > 1) {
			com.thealgorithms.others.HuffmanNode x = q.peek();
			q.poll();
			com.thealgorithms.others.HuffmanNode y = q.peek();
			q.poll();
			com.thealgorithms.others.HuffmanNode f = new com.thealgorithms.others.HuffmanNode();
			f.data = x.data + y.data;
			f.c = '-';
			f.left = x;
			f.right = y;
			root = f;
			q.add(f);
		} 
		com.thealgorithms.others.Huffman.printCode(root, "");
		s.close();
	}
}