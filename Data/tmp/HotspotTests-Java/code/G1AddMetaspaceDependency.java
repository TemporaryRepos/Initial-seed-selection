public class G1AddMetaspaceDependency {
	static byte[] getClassBytes(java.lang.String name) {
		byte[] b = null;
		try (final java.io.InputStream is = java.lang.ClassLoader.getSystemResourceAsStream(name)) {
			byte[] tmp = new byte[is.available()];
			is.read(tmp);
			b = tmp;
		} finally {
			if (b == null) {
				throw new java.lang.RuntimeException("Unable to load class file");
			}
			return b;
		}
	}

	static final java.lang.String a_name = G1AddMetaspaceDependency.class.getName() + "$A";

	static final java.lang.String b_name = G1AddMetaspaceDependency.class.getName() + "$B";

	public static void main(java.lang.String... args) throws java.lang.Exception {
		final byte[] a_bytes = G1AddMetaspaceDependency.getClassBytes(G1AddMetaspaceDependency.a_name + ".class");
		final byte[] b_bytes = G1AddMetaspaceDependency.getClassBytes(G1AddMetaspaceDependency.b_name + ".class");
		for (int i = 0; i < 1000; i += 1) {
			G1AddMetaspaceDependency.runTest(a_bytes, b_bytes);
		}
	}

	static class Loader extends java.lang.ClassLoader {
		private final java.lang.String myClass;

		private final byte[] myBytes;

		private final java.lang.String friendClass;

		private final java.lang.ClassLoader friendLoader;

		Loader(java.lang.String myClass, byte[] myBytes, java.lang.String friendClass, java.lang.ClassLoader friendLoader) {
			this.myClass = myClass;
			this.myBytes = myBytes;
			this.friendClass = friendClass;
			this.friendLoader = friendLoader;
		}

		Loader(java.lang.String myClass, byte[] myBytes) {
			this(myClass, myBytes, null, null);
		}

		@java.lang.Override
		public java.lang.Class<?> loadClass(java.lang.String name) throws java.lang.ClassNotFoundException {
			java.lang.Class<?> c = findLoadedClass(name);
			if (c != null) {
				return c;
			}
			if (name.equals(friendClass)) {
				return friendLoader.loadClass(name);
			}
			if (name.equals(myClass)) {
				c = defineClass(name, myBytes, 0, myBytes.length);
				resolveClass(c);
				return c;
			}
			return findSystemClass(name);
		}
	}

	private static void runTest(final byte[] a_bytes, final byte[] b_bytes) throws java.lang.Exception {
		G1AddMetaspaceDependency.Loader a_loader = new G1AddMetaspaceDependency.Loader(G1AddMetaspaceDependency.a_name, a_bytes);
		G1AddMetaspaceDependency.Loader b_loader = new G1AddMetaspaceDependency.Loader(G1AddMetaspaceDependency.b_name, b_bytes, G1AddMetaspaceDependency.a_name, a_loader);
		G1AddMetaspaceDependency.Loader c_loader = new G1AddMetaspaceDependency.Loader(G1AddMetaspaceDependency.b_name, b_bytes, G1AddMetaspaceDependency.a_name, a_loader);
		G1AddMetaspaceDependency.Loader d_loader = new G1AddMetaspaceDependency.Loader(G1AddMetaspaceDependency.b_name, b_bytes, G1AddMetaspaceDependency.a_name, a_loader);
		G1AddMetaspaceDependency.Loader e_loader = new G1AddMetaspaceDependency.Loader(G1AddMetaspaceDependency.b_name, b_bytes, G1AddMetaspaceDependency.a_name, a_loader);
		G1AddMetaspaceDependency.Loader f_loader = new G1AddMetaspaceDependency.Loader(G1AddMetaspaceDependency.b_name, b_bytes, G1AddMetaspaceDependency.a_name, a_loader);
		G1AddMetaspaceDependency.Loader g_loader = new G1AddMetaspaceDependency.Loader(G1AddMetaspaceDependency.b_name, b_bytes, G1AddMetaspaceDependency.a_name, a_loader);
		java.lang.Class<?> c;
		c = b_loader.loadClass(G1AddMetaspaceDependency.b_name);
		c = c_loader.loadClass(G1AddMetaspaceDependency.b_name);
		c = d_loader.loadClass(G1AddMetaspaceDependency.b_name);
		c = e_loader.loadClass(G1AddMetaspaceDependency.b_name);
		c = f_loader.loadClass(G1AddMetaspaceDependency.b_name);
		c = g_loader.loadClass(G1AddMetaspaceDependency.b_name);
	}

	public class A {}

	class B extends G1AddMetaspaceDependency.A {}
}