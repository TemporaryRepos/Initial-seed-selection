public class CopyDirectIntMemory extends javaT.nio.Buffer.CopyDirectMemory {
	private static void init(java.nio.IntBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(i, ((int) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.limit(n);
		b.position(0);
	}

	private static void init(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = ((int) (javaT.nio.Buffer.Basic.ic(i + 1)));
		}
	}

	public static void test() {
		java.nio.ByteBuffer bb = java.nio.ByteBuffer.allocateDirect((1024 * 1024) + 1024);
		java.nio.IntBuffer b = bb.asIntBuffer();
		javaT.nio.Buffer.CopyDirectIntMemory.init(b);
		int[] a = new int[b.capacity()];
		javaT.nio.Buffer.CopyDirectIntMemory.init(a);
		b.put(a);
		for (int i = 0; i < a.length; i++) {
			javaT.nio.Buffer.Basic.ck(b, b.get(i), ((int) (javaT.nio.Buffer.Basic.ic(i + 1))));
		}
		javaT.nio.Buffer.CopyDirectIntMemory.init(b);
		javaT.nio.Buffer.CopyDirectIntMemory.init(a);
		b.get(a);
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b.get(i)) {
				javaT.nio.Buffer.Basic.fail(((((("Copy failed at " + i) + ": '") + a[i]) + "' != '") + b.get(i)) + "'");
			}
		}
	}
}