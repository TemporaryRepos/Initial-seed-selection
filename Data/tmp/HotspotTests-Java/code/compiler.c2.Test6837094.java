public class Test6837094 {
	private interface Factory<M extends compiler.c2.Test6837094.Interface> {
		public static final compiler.c2.Test6837094.Factory<compiler.c2.Test6837094.Child0> Zero = new compiler.c2.Test6837094.Factory<compiler.c2.Test6837094.Child0>() {
			public compiler.c2.Test6837094.Child0[] getArray() {
				return new compiler.c2.Test6837094.Child0[1];
			}
		};

		public static final compiler.c2.Test6837094.Factory<compiler.c2.Test6837094.Child1> One = new compiler.c2.Test6837094.Factory<compiler.c2.Test6837094.Child1>() {
			public compiler.c2.Test6837094.Child1[] getArray() {
				return new compiler.c2.Test6837094.Child1[1];
			}
		};

		public abstract M[] getArray();
	}

	private static <I extends compiler.c2.Test6837094.Interface> void collectIs(compiler.c2.Test6837094.Factory<I> factory, java.util.Set<compiler.c2.Test6837094.Interface> s) {
		for (I i : factory.getArray()) {
			try {
				s.add(i);
			} catch (java.lang.Exception e) {
			}
		}
	}

	public static void main(java.lang.String[] argv) {
		java.util.Set<compiler.c2.Test6837094.Interface> s = new java.util.HashSet();
		for (int i = 0; i < 25000; i++) {
			compiler.c2.Test6837094.collectIs(compiler.c2.Test6837094.Factory.Zero, s);
			compiler.c2.Test6837094.collectIs(compiler.c2.Test6837094.Factory.One, s);
		}
	}

	static interface Interface {}

	static class Parent {}

	static class Child0 extends compiler.c2.Test6837094.Parent implements compiler.c2.Test6837094.Interface {}

	static class Child1 extends compiler.c2.Test6837094.Parent implements compiler.c2.Test6837094.Interface {}

	static class Child2 extends compiler.c2.Test6837094.Parent implements compiler.c2.Test6837094.Interface {}
}