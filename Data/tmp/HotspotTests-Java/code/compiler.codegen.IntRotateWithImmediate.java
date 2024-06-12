public class IntRotateWithImmediate {
	static int rotateRight1(int i, int distance) {
		return (i >>> distance) | (i << (-distance));
	}

	static int rotateRight2(int i, int distance) {
		return (i >>> distance) | (i << (32 - distance));
	}

	static int compute1(int x) {
		return compiler.codegen.IntRotateWithImmediate.rotateRight1(x, 3);
	}

	static int compute2(int x) {
		return compiler.codegen.IntRotateWithImmediate.rotateRight2(x, 3);
	}

	public static void main(java.lang.String[] args) {
		int val = 4096;
		int firstResult = compiler.codegen.IntRotateWithImmediate.compute1(val);
		for (int i = 0; i < 100000; i++) {
			int newResult = compiler.codegen.IntRotateWithImmediate.compute1(val);
			if (firstResult != newResult) {
				throw new java.lang.InternalError((firstResult + " != ") + newResult);
			}
			newResult = compiler.codegen.IntRotateWithImmediate.compute2(val);
			if (firstResult != newResult) {
				throw new java.lang.InternalError((firstResult + " != ") + newResult);
			}
		}
		java.lang.System.out.println("OK");
	}
}