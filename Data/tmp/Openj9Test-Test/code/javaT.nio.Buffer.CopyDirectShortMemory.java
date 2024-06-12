public class CopyDirectShortMemory extends javaT.nio.Buffer.CopyDirectMemory {
	private static void init(java.nio.ShortBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(i, ((short) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.limit(n);
		b.position(0);
	}

	private static void init(short[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = ((short) (javaT.nio.Buffer.Basic.ic(i + 1)));
		}
	}

	public static void test() {
		java.nio.ByteBuffer bb = java.nio.ByteBuffer.allocateDirect((1024 * 1024) + 1024);
		java.nio.ShortBuffer b = bb.asShortBuffer();
		javaT.nio.Buffer.CopyDirectShortMemory.init(b);
		short[] a = new short[b.capacity()];
		javaT.nio.Buffer.CopyDirectShortMemory.init(a);
		b.put(a);
		for (int i = 0; i < a.length; i++) {
			javaT.nio.Buffer.Basic.ck(b, b.get(i), ((short) (javaT.nio.Buffer.Basic.ic(i + 1))));
		}
		javaT.nio.Buffer.CopyDirectShortMemory.init(b);
		javaT.nio.Buffer.CopyDirectShortMemory.init(a);
		b.get(a);
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b.get(i)) {
				javaT.nio.Buffer.Basic.fail(((((("Copy failed at " + i) + ": '") + a[i]) + "' != '") + b.get(i)) + "'");
			}
		}
	}
}