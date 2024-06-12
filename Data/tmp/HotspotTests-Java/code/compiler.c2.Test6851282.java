public class Test6851282 {
	void foo(compiler.c2.Test6851282.A a, compiler.c2.Test6851282.A[] as) {
		for (compiler.c2.Test6851282.A a1 : as) {
			compiler.c2.Test6851282.B[] filtered = a.c(a1);
			for (compiler.c2.Test6851282.B b : filtered) {
				if (b == null) {
					java.lang.System.out.println("bug: b == null");
					java.lang.System.exit(97);
				}
			}
		}
	}

	public static void main(java.lang.String[] args) {
		java.util.List<compiler.c2.Test6851282.A> as = new java.util.ArrayList<compiler.c2.Test6851282.A>();
		for (int i = 0; i < 5000; i++) {
			java.util.List<compiler.c2.Test6851282.B> bs = new java.util.ArrayList<compiler.c2.Test6851282.B>();
			for (int j = i; j < (i + 1000); j++) {
				bs.add(new compiler.c2.Test6851282.B(j));
			}
			as.add(new compiler.c2.Test6851282.A(bs.toArray(new compiler.c2.Test6851282.B[0])));
		}
		new compiler.c2.Test6851282().foo(as.get(0), as.subList(1, as.size()).toArray(new compiler.c2.Test6851282.A[0]));
	}

	static class A {
		final compiler.c2.Test6851282.B[] bs;

		public A(compiler.c2.Test6851282.B[] bs) {
			this.bs = bs;
		}

		final compiler.c2.Test6851282.B[] c(final compiler.c2.Test6851282.A a) {
			return new compiler.c2.Test6851282.BoxedArray<compiler.c2.Test6851282.B>(bs).filter(new compiler.c2.Test6851282.Function<compiler.c2.Test6851282.B, java.lang.Boolean>() {
				public java.lang.Boolean apply(compiler.c2.Test6851282.B arg) {
					for (compiler.c2.Test6851282.B b : a.bs) {
						if (b.d == arg.d) {
							return true;
						}
					}
					return false;
				}
			});
		}
	}

	static class BoxedArray<T> {
		private final T[] array;

		BoxedArray(T[] array) {
			this.array = array;
		}

		public T[] filter(compiler.c2.Test6851282.Function<T, java.lang.Boolean> function) {
			boolean[] include = new boolean[array.length];
			int len = 0;
			int i = 0;
			while (i < array.length) {
				if (function.apply(array[i])) {
					include[i] = true;
					len += 1;
				}
				i += 1;
			} 
			T[] result = ((T[]) (java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), len)));
			len = 0;
			i = 0;
			while (len < result.length) {
				if (include[i]) {
					result[len] = array[i];
					len += 1;
				}
				i += 1;
			} 
			return result;
		}
	}

	static interface Function<T, R> {
		public abstract R apply(T arg);
	}

	static class B {
		final int d;

		public B(int d) {
			this.d = d;
		}
	}
}