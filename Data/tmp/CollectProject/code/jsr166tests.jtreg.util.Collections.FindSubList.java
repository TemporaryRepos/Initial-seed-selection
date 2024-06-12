public class FindSubList {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int N = 500;
		java.util.List source = new java.util.ArrayList(3 * N);
		java.util.List[] target = new java.util.List[N + 1];
		int[] index = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			java.util.List t = new java.util.ArrayList();
			java.lang.String s = java.lang.Integer.toString(i, 2);
			for (int j = 0, len = s.length(); j < len; j++) {
				t.add(s.charAt(j) == '1' ? "1" : "0");
			}
			target[i] = t;
			if (i == N) {
				index[i] = -1;
			} else {
				index[i] = source.size();
				source.addAll(t);
				source.add("*");
			}
		}
		java.util.List[] src = new java.util.List[]{ source, new java.util.LinkedList(source), new java.util.Vector(source), java.util.Arrays.asList(source.toArray()) };
		for (int j = 0; j < src.length; j++) {
			java.util.List s = src[j];
			for (int i = 0; i <= N; i++) {
				int idx = java.util.Collections.indexOfSubList(s, target[i]);
				if (idx != index[i]) {
					throw new java.lang.Exception((((((s.getClass() + " indexOfSubList: ") + i) + "is ") + idx) + ", should be ") + index[i]);
				}
			}
			if (java.util.Collections.indexOfSubList(s, java.util.Collections.nCopies(2 * s.size(), "0")) != (-1)) {
				throw new java.lang.Exception(s.getClass() + " indexOfSubList: big target");
			}
		}
		java.util.Collections.reverse(source);
		int srcSize = source.size();
		for (int i = 0; i <= N; i++) {
			java.util.Collections.reverse(target[i]);
			if (i != N) {
				index[i] = (srcSize - index[i]) - target[i].size();
			}
		}
		java.util.List[] src2 = new java.util.List[]{ source, new java.util.LinkedList(source), new java.util.Vector(source), java.util.Arrays.asList(source.toArray()) };
		for (int j = 0; j < src2.length; j++) {
			java.util.List s = src2[j];
			for (int i = 0; i <= N; i++) {
				int idx = java.util.Collections.lastIndexOfSubList(s, target[i]);
				if (idx != index[i]) {
					throw new java.lang.Exception((((((s.getClass() + " lastIdexOfSubList: ") + i) + "is ") + idx) + ", should be ") + index[i]);
				}
			}
			if (java.util.Collections.indexOfSubList(s, java.util.Collections.nCopies(2 * s.size(), "0")) != (-1)) {
				throw new java.lang.Exception(s.getClass() + " lastIndexOfSubList: big tgt");
			}
		}
	}
}