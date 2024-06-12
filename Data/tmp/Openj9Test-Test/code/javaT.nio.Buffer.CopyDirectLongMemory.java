public class CopyDirectLongMemory extends javaT.nio.Buffer.CopyDirectMemory {
	private static void init(java.nio.LongBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(i, ((long) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.limit(n);
		b.position(0);
	}

	private static void init(long[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = ((long) (javaT.nio.Buffer.Basic.ic(i + 1)));
		}
	}

	public static void test() {
		java.nio.ByteBuffer bb = java.nio.ByteBuffer.allocateDirect((1024 * 1024) + 1024);
		java.nio.LongBuffer b = bb.asLongBuffer();
		javaT.nio.Buffer.CopyDirectLongMemory.init(b);
		long[] a = new long[b.capacity()];
		javaT.nio.Buffer.CopyDirectLongMemory.init(a);
		b.put(a);
		for (int i = 0; i < a.length; i++) {
			javaT.nio.Buffer.Basic.ck(b, b.get(i), ((long) (javaT.nio.Buffer.Basic.ic(i + 1))));
		}
		javaT.nio.Buffer.CopyDirectLongMemory.init(b);
		javaT.nio.Buffer.CopyDirectLongMemory.init(a);
		b.get(a);
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b.get(i)) {
				javaT.nio.Buffer.Basic.fail(((((("Copy failed at " + i) + ": '") + a[i]) + "' != '") + b.get(i)) + "'");
			}
		}
	}
}