public class Swap {
	static final int SIZE = 100;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.List l = new java.util.ArrayList(java.util.Collections.nCopies(100, java.lang.Boolean.FALSE));
		l.set(0, java.lang.Boolean.TRUE);
		for (int i = 0; i < (jsr166tests.jtreg.util.Collections.Swap.SIZE - 1); i++) {
			java.util.Collections.swap(l, i, i + 1);
		}
		java.util.List l2 = new java.util.ArrayList(java.util.Collections.nCopies(100, java.lang.Boolean.FALSE));
		l2.set(jsr166tests.jtreg.util.Collections.Swap.SIZE - 1, java.lang.Boolean.TRUE);
		if (!l.equals(l2)) {
			throw new java.lang.RuntimeException("Wrong result");
		}
	}
}