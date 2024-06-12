public class Test6778657 {
	public static void check_f2i(int expect) {
		float check = expect;
		check *= 2;
		int actual = ((int) (check));
		if (actual != expect) {
			throw new java.lang.RuntimeException((("expecting " + expect) + ", got ") + actual);
		}
	}

	public static void check_f2l(long expect) {
		float check = expect;
		check *= 2;
		long actual = ((long) (check));
		if (actual != expect) {
			throw new java.lang.RuntimeException((("expecting " + expect) + ", got ") + actual);
		}
	}

	public static void check_d2i(int expect) {
		double check = expect;
		check *= 2;
		int actual = ((int) (check));
		if (actual != expect) {
			throw new java.lang.RuntimeException((("expecting " + expect) + ", got ") + actual);
		}
	}

	public static void check_d2l(long expect) {
		double check = expect;
		check *= 2;
		long actual = ((long) (check));
		if (actual != expect) {
			throw new java.lang.RuntimeException((("expecting " + expect) + ", got ") + actual);
		}
	}

	public static void main(java.lang.String[] args) {
		compiler.runtime.Test6778657.check_f2i(java.lang.Integer.MAX_VALUE);
		compiler.runtime.Test6778657.check_f2i(java.lang.Integer.MIN_VALUE);
		compiler.runtime.Test6778657.check_f2l(java.lang.Long.MAX_VALUE);
		compiler.runtime.Test6778657.check_f2l(java.lang.Long.MIN_VALUE);
		compiler.runtime.Test6778657.check_d2i(java.lang.Integer.MAX_VALUE);
		compiler.runtime.Test6778657.check_d2i(java.lang.Integer.MIN_VALUE);
		compiler.runtime.Test6778657.check_d2l(java.lang.Long.MAX_VALUE);
		compiler.runtime.Test6778657.check_d2l(java.lang.Long.MIN_VALUE);
	}
}