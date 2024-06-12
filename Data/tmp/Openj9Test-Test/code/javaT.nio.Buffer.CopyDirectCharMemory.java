public class CopyDirectCharMemory extends javaT.nio.Buffer.CopyDirectMemory {
	private static void init(java.nio.CharBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(i, ((char) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.limit(n);
		b.position(0);
	}

	private static void init(char[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = ((char) (javaT.nio.Buffer.Basic.ic(i + 1)));
		}
	}

	public static void test() {
		java.nio.ByteBuffer bb = java.nio.ByteBuffer.allocateDirect((1024 * 1024) + 1024);
		java.nio.CharBuffer b = bb.asCharBuffer();
		javaT.nio.Buffer.CopyDirectCharMemory.init(b);
		char[] a = new char[b.capacity()];
		javaT.nio.Buffer.CopyDirectCharMemory.init(a);
		b.put(a);
		for (int i = 0; i < a.length; i++) {
			javaT.nio.Buffer.Basic.ck(b, b.get(i), ((char) (javaT.nio.Buffer.Basic.ic(i + 1))));
		}
		javaT.nio.Buffer.CopyDirectCharMemory.init(b);
		javaT.nio.Buffer.CopyDirectCharMemory.init(a);
		b.get(a);
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b.get(i)) {
				javaT.nio.Buffer.Basic.fail(((((("Copy failed at " + i) + ": '") + a[i]) + "' != '") + b.get(i)) + "'");
			}
		}
	}
}