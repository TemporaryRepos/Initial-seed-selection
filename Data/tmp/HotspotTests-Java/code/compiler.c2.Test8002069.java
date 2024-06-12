public class Test8002069 {
	abstract static class O {
		int f;

		public O() {
			f = 5;
		}

		abstract void put(int i);

		public int foo(int i) {
			put(i);
			return i;
		}
	}

	static class A extends compiler.c2.Test8002069.O {
		int[] a;

		public A(int s) {
			a = new int[s];
		}

		public void put(int i) {
			a[i % a.length] = i;
		}
	}

	static class B extends compiler.c2.Test8002069.O {
		int sz;

		int[] a;

		public B(int s) {
			sz = s;
			a = new int[s];
		}

		public void put(int i) {
			a[i % sz] = i;
		}
	}

	public static void main(java.lang.String[] args) {
		int sum = 0;
		for (int i = 0; i < 8000; i++) {
			sum += compiler.c2.Test8002069.test1(i);
		}
		for (int i = 0; i < 100000; i++) {
			sum += compiler.c2.Test8002069.test2(i);
		}
		java.lang.System.out.println("PASSED. sum = " + sum);
	}

	private compiler.c2.Test8002069.O o;

	private int foo(int i) {
		return o.foo(i);
	}

	static int test1(int i) {
		compiler.c2.Test8002069 t = new compiler.c2.Test8002069();
		t.o = new compiler.c2.Test8002069.A(5);
		return t.foo(i);
	}

	static int test2(int i) {
		compiler.c2.Test8002069 t = new compiler.c2.Test8002069();
		t.o = new compiler.c2.Test8002069.B(5);
		compiler.c2.Test8002069.dummy(i);
		return t.foo(i);
	}

	static int dummy(int i) {
		return i * 2;
	}
}