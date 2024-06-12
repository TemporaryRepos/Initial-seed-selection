public class Frequency {
	static final int N = 100;

	public static void main(java.lang.String[] args) {
		javaT.util.Collections.Frequency.test(new java.util.ArrayList<java.lang.Integer>());
		javaT.util.Collections.Frequency.test(new java.util.LinkedList<java.lang.Integer>());
	}

	static void test(java.util.List<java.lang.Integer> list) {
		for (int i = 0; i < javaT.util.Collections.Frequency.N; i++) {
			for (int j = 0; j < i; j++) {
				list.add(i);
			}
		}
		java.util.Collections.shuffle(list);
		for (int i = 0; i < javaT.util.Collections.Frequency.N; i++) {
			if (java.util.Collections.frequency(list, i) != i) {
				throw new java.lang.RuntimeException((list.getClass() + ": ") + i);
			}
		}
	}
}