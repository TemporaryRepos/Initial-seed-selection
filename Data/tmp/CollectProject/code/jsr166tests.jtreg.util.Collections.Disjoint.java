public class Disjoint {
	static final int N = 20;

	public static void main(java.lang.String[] args) {
		java.util.Random rnd = new java.util.Random();
		java.util.List[] lists = new java.util.List[jsr166tests.jtreg.util.Collections.Disjoint.N];
		int x = 0;
		for (int i = 0; i < jsr166tests.jtreg.util.Collections.Disjoint.N; i++) {
			int size = rnd.nextInt(10) + 2;
			java.util.List<java.lang.Integer> list = new java.util.ArrayList<java.lang.Integer>(size);
			for (int j = 1; j < size; j++) {
				list.add(x++);
			}
			list.add(x);
			java.util.Collections.shuffle(list);
			lists[i] = list;
		}
		for (int i = 0; i < jsr166tests.jtreg.util.Collections.Disjoint.N; i++) {
			for (int j = 0; j < jsr166tests.jtreg.util.Collections.Disjoint.N; j++) {
				boolean disjoint = java.lang.Math.abs(i - j) > 1;
				java.util.List<java.lang.Integer> a = ((java.util.List<java.lang.Integer>) (lists[i]));
				java.util.List<java.lang.Integer> b = ((java.util.List<java.lang.Integer>) (lists[j]));
				if (java.util.Collections.disjoint(a, b) != disjoint) {
					throw new java.lang.RuntimeException((("A: " + i) + ", ") + j);
				}
				if (java.util.Collections.disjoint(new java.util.HashSet<java.lang.Integer>(a), b) != disjoint) {
					throw new java.lang.RuntimeException((("B: " + i) + ", ") + j);
				}
				if (java.util.Collections.disjoint(new java.util.HashSet<java.lang.Integer>(a), new java.util.HashSet<java.lang.Integer>(b)) != disjoint) {
					throw new java.lang.RuntimeException((("C: " + i) + ", ") + j);
				}
			}
		}
	}
}