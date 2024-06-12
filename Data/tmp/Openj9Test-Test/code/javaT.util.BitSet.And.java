public final class And {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.BitSet a = new java.util.BitSet();
		java.util.BitSet b = new java.util.BitSet();
		a.set(0);
		a.set(70);
		b.set(40);
		a.and(b);
		if (a.length() != 0) {
			throw new java.lang.RuntimeException("Incorrect length after and().");
		}
	}
}