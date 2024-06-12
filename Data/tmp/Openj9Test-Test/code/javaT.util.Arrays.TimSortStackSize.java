public class TimSortStackSize {
	public static void main(java.lang.String[] args) {
		javaT.util.Arrays.TimSortStackSize.testComparableTimSort();
		javaT.util.Arrays.TimSortStackSize.testTimSort();
	}

	static void testComparableTimSort() {
		java.lang.System.out.printf("testComparableTimSort()%n");
		java.util.Arrays.sort(javaT.util.Arrays.TimSortStackSize.genData());
	}

	static void testTimSort() {
		java.lang.System.out.printf("testTimSort()%n");
		java.util.Arrays.sort(javaT.util.Arrays.TimSortStackSize.genData(), java.lang.Integer::compare);
	}

	private static final int MIN = 16;

	private static final int BOUND1 = (2 * javaT.util.Arrays.TimSortStackSize.MIN) + 1;

	private static final int BOUND2 = (javaT.util.Arrays.TimSortStackSize.BOUND1 + javaT.util.Arrays.TimSortStackSize.MIN) + 2;

	private static final int BOUND3 = (javaT.util.Arrays.TimSortStackSize.BOUND1 + 1) + javaT.util.Arrays.TimSortStackSize.BOUND2;

	private static final int BOUND4 = (javaT.util.Arrays.TimSortStackSize.BOUND2 + 1) + javaT.util.Arrays.TimSortStackSize.BOUND3;

	private static final int BOUND5 = (javaT.util.Arrays.TimSortStackSize.BOUND3 + 1) + javaT.util.Arrays.TimSortStackSize.BOUND4;

	static int build(int size, int B, java.util.ArrayDeque<java.lang.Integer> chunks) {
		chunks.addFirst(B);
		if (size < javaT.util.Arrays.TimSortStackSize.BOUND1) {
			chunks.addFirst(size);
			return size;
		}
		int asize = (size + 2) / 2;
		if ((size >= javaT.util.Arrays.TimSortStackSize.BOUND2) && (asize < javaT.util.Arrays.TimSortStackSize.BOUND1)) {
			asize = javaT.util.Arrays.TimSortStackSize.BOUND1;
		} else if ((size >= javaT.util.Arrays.TimSortStackSize.BOUND3) && (asize < javaT.util.Arrays.TimSortStackSize.BOUND2)) {
			asize = javaT.util.Arrays.TimSortStackSize.BOUND2;
		} else if ((size >= javaT.util.Arrays.TimSortStackSize.BOUND4) && (asize < javaT.util.Arrays.TimSortStackSize.BOUND3)) {
			asize = javaT.util.Arrays.TimSortStackSize.BOUND3;
		} else if ((size >= javaT.util.Arrays.TimSortStackSize.BOUND5) && (asize < javaT.util.Arrays.TimSortStackSize.BOUND4)) {
			asize = javaT.util.Arrays.TimSortStackSize.BOUND4;
		}
		if ((size - asize) >= B) {
			throw new java.lang.AssertionError(((((" " + size) + " , ") + asize) + " , ") + B);
		}
		return javaT.util.Arrays.TimSortStackSize.build(asize, size - asize, chunks);
	}

	static java.lang.Integer[] genData() {
		java.util.ArrayDeque<java.lang.Integer> chunks = new java.util.ArrayDeque<java.lang.Integer>();
		chunks.addFirst(javaT.util.Arrays.TimSortStackSize.MIN);
		int B = javaT.util.Arrays.TimSortStackSize.MIN + 4;
		int A = (B + javaT.util.Arrays.TimSortStackSize.MIN) + 1;
		for (int i = 0; i < 8; i++) {
			int eps = javaT.util.Arrays.TimSortStackSize.build(A, B, chunks);
			B = (B + A) + 1;
			A = (B + eps) + 1;
		}
		chunks.addFirst(B);
		chunks.addFirst(A);
		int total = 0;
		for (java.lang.Integer len : chunks) {
			total += len;
		}
		int pow = javaT.util.Arrays.TimSortStackSize.MIN;
		while (pow < total) {
			pow += pow;
		} 
		chunks.addLast(pow - total);
		java.lang.System.out.println(" Total: " + total);
		java.lang.Integer[] array = new java.lang.Integer[pow];
		int off = 0;
		int pos = 0;
		for (java.lang.Integer len : chunks) {
			for (int i = 0; i < len; i++) {
				array[pos++] = java.lang.Integer.valueOf(i == 0 ? 0 : 1);
			}
			off++;
		}
		return array;
	}
}