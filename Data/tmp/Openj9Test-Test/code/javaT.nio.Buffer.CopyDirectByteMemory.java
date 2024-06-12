public class CopyDirectByteMemory extends javaT.nio.Buffer.CopyDirectMemory {
	private static void init(java.nio.ByteBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(i, ((byte) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.limit(n);
		b.position(0);
	}

	private static void init(byte[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = ((byte) (javaT.nio.Buffer.Basic.ic(i + 1)));
		}
	}

	public static void test() {
		java.nio.ByteBuffer b = java.nio.ByteBuffer.allocateDirect((1024 * 1024) + 1024);
		javaT.nio.Buffer.CopyDirectByteMemory.init(b);
		byte[] a = new byte[b.capacity()];
		javaT.nio.Buffer.CopyDirectByteMemory.init(a);
		b.put(a);
		for (int i = 0; i < a.length; i++) {
			javaT.nio.Buffer.Basic.ck(b, b.get(i), ((byte) (javaT.nio.Buffer.Basic.ic(i + 1))));
		}
		javaT.nio.Buffer.CopyDirectByteMemory.init(b);
		javaT.nio.Buffer.CopyDirectByteMemory.init(a);
		b.get(a);
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b.get(i)) {
				javaT.nio.Buffer.Basic.fail(((((("Copy failed at " + i) + ": '") + a[i]) + "' != '") + b.get(i)) + "'");
			}
		}
	}
}