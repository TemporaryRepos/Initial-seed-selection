public class TestArrayCopyUNCBadMem {
	static volatile int field;

	static class unloaded {
		static int dummy;
	}

	static int test(int[] input) {
		int[] alloc = new int[10];
		java.lang.System.arraycopy(input, 0, alloc, 0, 10);
		TestArrayCopyUNCBadMem.field = 0x42;
		TestArrayCopyUNCBadMem.unloaded.dummy = 0x42;
		return alloc[0] + alloc[1];
	}

	public static void main(java.lang.String[] args) {
		int[] array = new int[10];
		java.lang.System.arraycopy(array, 0, array, 0, 0);
		TestArrayCopyUNCBadMem.test(array);
	}
}