public class Test7174363 {
	static java.lang.Object[] m(java.lang.Object[] original, int from, int to) {
		return java.util.Arrays.copyOfRange(original, from, to, java.lang.Object[].class);
	}

	public static void main(java.lang.String[] args) {
		java.lang.Object[] orig = new java.lang.Object[10];
		for (int i = 0; i < 20000; i++) {
			try {
				compiler.c2.Test7174363.m(orig, 15, 20);
			} catch (java.lang.ArrayIndexOutOfBoundsException excp) {
			}
		}
	}
}