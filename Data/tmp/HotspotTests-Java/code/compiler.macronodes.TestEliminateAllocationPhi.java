public class TestEliminateAllocationPhi {
	static java.lang.Integer m2(java.lang.Integer I, int i) {
		for (; i < 10; i = (i + 2) * (i + 2)) {
		}
		if (i == 121) {
			return compiler.macronodes.TestEliminateAllocationPhi.II;
		}
		return I;
	}

	static java.lang.Integer II = new java.lang.Integer(42);

	static int m(int[] integers, boolean flag) {
		int j = 0;
		while (true) {
			try {
				int k = integers[j++];
				if (flag) {
					k += 42;
				}
				if (k < 1000) {
					throw new java.lang.Exception();
				}
				java.lang.Integer I = new java.lang.Integer(k);
				I = compiler.macronodes.TestEliminateAllocationPhi.m2(I, 0);
				int i = I.intValue();
				return i;
			} catch (java.lang.Exception e) {
			}
		} 
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 5000; i++) {
			compiler.macronodes.TestEliminateAllocationPhi.m2(null, 1);
		}
		int[] integers = new int[]{ 2000 };
		for (int i = 0; i < 6000; i++) {
			compiler.macronodes.TestEliminateAllocationPhi.m(integers, (i % 2) == 0);
		}
		int[] integers2 = new int[]{ 1, 2, 3, 4, 5, 2000 };
		for (int i = 0; i < 10000; i++) {
			compiler.macronodes.TestEliminateAllocationPhi.m(integers2, (i % 2) == 0);
		}
	}
}