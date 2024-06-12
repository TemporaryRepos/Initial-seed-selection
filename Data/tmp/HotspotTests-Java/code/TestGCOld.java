public class TestGCOld {
	private static int size;

	private static int workUnits;

	private static int promoteRate;

	private static int ptrMutRate;

	private static int steps;

	private static final int MEG = 1000000;

	private static final int INSIGNIFICANT = 999;

	private static final int BYTES_PER_WORD = 4;

	private static final int BYTES_PER_NODE = 20;

	private static final int WORDS_DEAD = 100;

	private static final int treeHeight = 14;

	private static final long treeSize = TestGCOld.heightToBytes(TestGCOld.treeHeight);

	private static final java.lang.String msg1 = "Usage: java TestGCOld <size> <work> <ratio> <mutation> <steps>";

	private static final java.lang.String msg2 = "  where <size> is the live storage in megabytes";

	private static final java.lang.String msg3 = "        <work> is the mutator work per step (arbitrary units)";

	private static final java.lang.String msg4 = "        <ratio> is the ratio of short-lived to long-lived allocation";

	private static final java.lang.String msg5 = "        <mutation> is the mutations per step";

	private static final java.lang.String msg6 = "        <steps> is the number of steps";

	private static long youngBytes = 0;

	private static long nodes = 0;

	private static long actuallyMut = 0;

	private static long mutatorSum = 0;

	public static int[] aexport;

	private static TreeNode[] trees;

	private static int where = 0;

	private static int height(TreeNode t) {
		if (t == null) {
			return 0;
		} else {
			return 1 + java.lang.Math.max(TestGCOld.height(t.left), TestGCOld.height(t.right));
		}
	}

	private static int shortestPath(TreeNode t) {
		if (t == null) {
			return 0;
		} else {
			return 1 + java.lang.Math.min(TestGCOld.shortestPath(t.left), TestGCOld.shortestPath(t.right));
		}
	}

	private static long heightToNodes(int h) {
		if (h == 0) {
			return 0;
		} else {
			long n = 1;
			while (h > 1) {
				n = n + n;
				h = h - 1;
			} 
			return (n + n) - 1;
		}
	}

	private static long heightToBytes(int h) {
		return TestGCOld.BYTES_PER_NODE * TestGCOld.heightToNodes(h);
	}

	private static int nodesToHeight(long nodes) {
		int h = 1;
		long n = 1;
		while (((n + n) - 1) <= nodes) {
			n = n + n;
			h = h + 1;
		} 
		return h - 1;
	}

	private static int bytesToHeight(long bytes) {
		return TestGCOld.nodesToHeight(bytes / TestGCOld.BYTES_PER_NODE);
	}

	private static TreeNode makeTree(int h) {
		if (h == 0) {
			return null;
		} else {
			TreeNode res = new TreeNode();
			TestGCOld.nodes++;
			res.left = TestGCOld.makeTree(h - 1);
			res.right = TestGCOld.makeTree(h - 1);
			res.val = h;
			return res;
		}
	}

	private static void init() {
		int ntrees = ((int) ((TestGCOld.size * TestGCOld.MEG) / TestGCOld.treeSize));
		TestGCOld.trees = new TreeNode[ntrees];
		java.lang.System.err.println(("Allocating " + ntrees) + " trees.");
		java.lang.System.err.println(("  (" + (ntrees * TestGCOld.treeSize)) + " bytes)");
		for (int i = 0; i < ntrees; i++) {
			TestGCOld.trees[i] = TestGCOld.makeTree(TestGCOld.treeHeight);
		}
		java.lang.System.err.println(("  (" + TestGCOld.nodes) + " nodes)");
	}

	private static void checkTrees() {
		int ntrees = TestGCOld.trees.length;
		for (int i = 0; i < ntrees; i++) {
			TreeNode t = TestGCOld.trees[i];
			int h1 = TestGCOld.height(t);
			int h2 = TestGCOld.shortestPath(t);
			if ((h1 != TestGCOld.treeHeight) || (h2 != TestGCOld.treeHeight)) {
				java.lang.System.err.println((("*****BUG: " + h1) + " ") + h2);
			}
		}
	}

	private static void replaceTreeWork(TreeNode full, TreeNode partial, boolean dir) {
		boolean canGoLeft = (full.left != null) && (full.left.val > partial.val);
		boolean canGoRight = (full.right != null) && (full.right.val > partial.val);
		if (canGoLeft && canGoRight) {
			if (dir) {
				TestGCOld.replaceTreeWork(full.left, partial, !dir);
			} else {
				TestGCOld.replaceTreeWork(full.right, partial, !dir);
			}
		} else if ((!canGoLeft) && (!canGoRight)) {
			if (dir) {
				full.left = partial;
			} else {
				full.right = partial;
			}
		} else if (!canGoLeft) {
			full.left = partial;
		} else {
			full.right = partial;
		}
	}

	private static void replaceTree(TreeNode full, TreeNode partial) {
		boolean dir = (partial.val % 2) == 0;
		TestGCOld.actuallyMut++;
		TestGCOld.replaceTreeWork(full, partial, dir);
	}

	private static void oldGenAlloc(long n) {
		int full = ((int) (n / TestGCOld.treeSize));
		long partial = n % TestGCOld.treeSize;
		for (int i = 0; i < full; i++) {
			TestGCOld.trees[TestGCOld.where++] = TestGCOld.makeTree(TestGCOld.treeHeight);
			if (TestGCOld.where == TestGCOld.trees.length) {
				TestGCOld.where = 0;
			}
		}
		while (partial > TestGCOld.INSIGNIFICANT) {
			int h = TestGCOld.bytesToHeight(partial);
			TreeNode newTree = TestGCOld.makeTree(h);
			TestGCOld.replaceTree(TestGCOld.trees[TestGCOld.where++], newTree);
			if (TestGCOld.where == TestGCOld.trees.length) {
				TestGCOld.where = 0;
			}
			partial = partial - TestGCOld.heightToBytes(h);
		} 
	}

	private static void oldGenSwapSubtrees() {
		int index1 = TestGCOld.trees.length - 1;
		int index2 = TestGCOld.trees.length - 2;
		int depth = TestGCOld.treeHeight - 1;
		int path = 0;
		TreeNode tn1 = TestGCOld.trees[index1];
		TreeNode tn2 = TestGCOld.trees[index2];
		for (int i = 0; i < depth; i++) {
			if ((path & 1) == 0) {
				tn1 = tn1.left;
				tn2 = tn2.left;
			} else {
				tn1 = tn1.right;
				tn2 = tn2.right;
			}
			path >>= 1;
		}
		TreeNode tmp;
		if ((path & 1) == 0) {
			tmp = tn1.left;
			tn1.left = tn2.left;
			tn2.left = tmp;
		} else {
			tmp = tn1.right;
			tn1.right = tn2.right;
			tn2.right = tmp;
		}
		TestGCOld.actuallyMut += 2;
	}

	private static void oldGenMut(long n) {
		for (int i = 0; i < (n / 2); i++) {
			TestGCOld.oldGenSwapSubtrees();
		}
	}

	private static void doMutWork(long n) {
		int sum = 0;
		long limit = (TestGCOld.workUnits * n) / 10;
		for (long k = 0; k < limit; k++) {
			sum++;
		}
		TestGCOld.mutatorSum = TestGCOld.mutatorSum + sum;
	}

	private static void doYoungGenAlloc(long n, int nwords) {
		final int nbytes = nwords * TestGCOld.BYTES_PER_WORD;
		int allocated = 0;
		while (allocated < n) {
			TestGCOld.aexport = new int[nwords];
			allocated += nbytes;
		} 
		TestGCOld.youngBytes = TestGCOld.youngBytes + allocated;
	}

	private static void doStep(long n) {
		long mutations = TestGCOld.actuallyMut;
		TestGCOld.doYoungGenAlloc(n, TestGCOld.WORDS_DEAD);
		TestGCOld.doMutWork(n);
		TestGCOld.oldGenAlloc(n / TestGCOld.promoteRate);
		TestGCOld.oldGenMut(java.lang.Math.max(0L, (mutations + TestGCOld.ptrMutRate) - TestGCOld.actuallyMut));
	}

	public static void main(java.lang.String[] args) {
		if (args.length != 5) {
			java.lang.System.err.println(TestGCOld.msg1);
			java.lang.System.err.println(TestGCOld.msg2);
			java.lang.System.err.println(TestGCOld.msg3);
			java.lang.System.err.println(TestGCOld.msg4);
			java.lang.System.err.println(TestGCOld.msg5);
			java.lang.System.err.println(TestGCOld.msg6);
			return;
		}
		TestGCOld.size = java.lang.Integer.parseInt(args[0]);
		TestGCOld.workUnits = java.lang.Integer.parseInt(args[1]);
		TestGCOld.promoteRate = java.lang.Integer.parseInt(args[2]);
		TestGCOld.ptrMutRate = java.lang.Integer.parseInt(args[3]);
		TestGCOld.steps = java.lang.Integer.parseInt(args[4]);
		java.lang.System.out.println(TestGCOld.size + " megabytes of live storage");
		java.lang.System.out.println(TestGCOld.workUnits + " work units per step");
		java.lang.System.out.println("promotion ratio is 1:" + TestGCOld.promoteRate);
		java.lang.System.out.println("pointer mutation rate is " + TestGCOld.ptrMutRate);
		java.lang.System.out.println(TestGCOld.steps + " steps");
		TestGCOld.init();
		TestGCOld.youngBytes = 0;
		TestGCOld.nodes = 0;
		java.lang.System.err.println("Initialization complete...");
		long start = 0;
		for (int step = 0; step < TestGCOld.steps; step++) {
			TestGCOld.doStep(TestGCOld.MEG);
		}
		long end = 0;
		float secs = ((float) (end - start)) / 1000.0F;
		java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);
		java.lang.System.out.println(("\nTook " + nf.format(secs)) + " sec in steady state.");
		nf.setMaximumFractionDigits(2);
		java.lang.System.out.println((((("Allocated " + TestGCOld.steps) + " Mb of young gen garbage") + " (= ") + nf.format(((float) (TestGCOld.steps)) / secs)) + " Mb/sec)");
		java.lang.System.out.println(("    (actually allocated " + nf.format(((float) (TestGCOld.youngBytes)) / TestGCOld.MEG)) + " megabytes)");
		float promoted = ((float) (TestGCOld.steps)) / ((float) (TestGCOld.promoteRate));
		java.lang.System.out.println(((("Promoted " + promoted) + " Mb (= ") + nf.format(promoted / secs)) + " Mb/sec)");
		java.lang.System.out.println(("    (actually promoted " + nf.format(((float) (TestGCOld.nodes * TestGCOld.BYTES_PER_NODE)) / TestGCOld.MEG)) + " megabytes)");
		if (TestGCOld.ptrMutRate != 0) {
			java.lang.System.out.println(((("Mutated " + TestGCOld.actuallyMut) + " pointers (= ") + nf.format(TestGCOld.actuallyMut / secs)) + " ptrs/sec)");
		}
		java.lang.System.out.println("Checksum = " + (TestGCOld.mutatorSum + TestGCOld.aexport.length));
	}
}