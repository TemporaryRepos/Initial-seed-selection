public class CopyDirectDoubleMemory extends javaT.nio.Buffer.CopyDirectMemory {
	private static void init(java.nio.DoubleBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(i, ((double) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.limit(n);
		b.position(0);
	}

	private static void init(double[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = ((double) (javaT.nio.Buffer.Basic.ic(i + 1)));
		}
	}

	public static void test() {
		java.nio.ByteBuffer bb = java.nio.ByteBuffer.allocateDirect((1024 * 1024) + 1024);
		java.nio.DoubleBuffer b = bb.asDoubleBuffer();
		javaT.nio.Buffer.CopyDirectDoubleMemory.init(b);
		double[] a = new double[b.capacity()];
		javaT.nio.Buffer.CopyDirectDoubleMemory.init(a);
		b.put(a);
		for (int i = 0; i < a.length; i++) {
			javaT.nio.Buffer.Basic.ck(b, b.get(i), ((double) (javaT.nio.Buffer.Basic.ic(i + 1))));
		}
		javaT.nio.Buffer.CopyDirectDoubleMemory.init(b);
		javaT.nio.Buffer.CopyDirectDoubleMemory.init(a);
		b.get(a);
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b.get(i)) {
				javaT.nio.Buffer.Basic.fail(((((("Copy failed at " + i) + ": '") + a[i]) + "' != '") + b.get(i)) + "'");
			}
		}
	}
}