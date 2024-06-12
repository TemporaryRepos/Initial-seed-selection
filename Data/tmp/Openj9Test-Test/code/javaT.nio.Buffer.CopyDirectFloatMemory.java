public class CopyDirectFloatMemory extends javaT.nio.Buffer.CopyDirectMemory {
	private static void init(java.nio.FloatBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(i, ((float) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.limit(n);
		b.position(0);
	}

	private static void init(float[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = ((float) (javaT.nio.Buffer.Basic.ic(i + 1)));
		}
	}

	public static void test() {
		java.nio.ByteBuffer bb = java.nio.ByteBuffer.allocateDirect((1024 * 1024) + 1024);
		java.nio.FloatBuffer b = bb.asFloatBuffer();
		javaT.nio.Buffer.CopyDirectFloatMemory.init(b);
		float[] a = new float[b.capacity()];
		javaT.nio.Buffer.CopyDirectFloatMemory.init(a);
		b.put(a);
		for (int i = 0; i < a.length; i++) {
			javaT.nio.Buffer.Basic.ck(b, b.get(i), ((float) (javaT.nio.Buffer.Basic.ic(i + 1))));
		}
		javaT.nio.Buffer.CopyDirectFloatMemory.init(b);
		javaT.nio.Buffer.CopyDirectFloatMemory.init(a);
		b.get(a);
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b.get(i)) {
				javaT.nio.Buffer.Basic.fail(((((("Copy failed at " + i) + ": '") + a[i]) + "' != '") + b.get(i)) + "'");
			}
		}
	}
}