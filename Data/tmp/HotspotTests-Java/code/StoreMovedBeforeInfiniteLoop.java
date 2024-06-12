public class StoreMovedBeforeInfiniteLoop {
	public static void main(java.lang.String[] args) {
		StoreMovedBeforeInfiniteLoop.field = -1;
		StoreMovedBeforeInfiniteLoop.test(new java.lang.Object());
	}

	static int field;

	static int constant() {
		return 65;
	}

	private static int test(java.lang.Object o) {
		do {
			if (StoreMovedBeforeInfiniteLoop.field <= 0) {
				return -109;
			}
			do {
				StoreMovedBeforeInfiniteLoop.field = 4;
			} while (StoreMovedBeforeInfiniteLoop.constant() >= 0 );
		} while (o == null );
		return -109;
	}
}