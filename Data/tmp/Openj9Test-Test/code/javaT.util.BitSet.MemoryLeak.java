public class MemoryLeak {
	public static void main(java.lang.String[] args) {
		java.util.BitSet setOne = new java.util.BitSet();
		java.util.BitSet setTwo = new java.util.BitSet();
		setOne.set(64);
		setTwo.set(129);
		for (int i = 0; i < 50; i++) {
			setOne.or(setTwo);
			setTwo.or(setOne);
		}
	}
}