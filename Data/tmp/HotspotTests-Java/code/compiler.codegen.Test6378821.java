public class Test6378821 {
	static final int[] ia = new int[]{ 0x12345678 };

	static final long[] la = new long[]{ 0x12345678abcdefL };

	public static void main(java.lang.String[] args) {
		java.lang.Integer.bitCount(1);
		java.lang.Long.bitCount(1);
		compiler.codegen.Test6378821.sub(compiler.codegen.Test6378821.ia[0]);
		compiler.codegen.Test6378821.sub(compiler.codegen.Test6378821.la[0]);
		compiler.codegen.Test6378821.sub(compiler.codegen.Test6378821.ia);
		compiler.codegen.Test6378821.sub(compiler.codegen.Test6378821.la);
	}

	static void check(int i, int expected, int result) {
		if (result != expected) {
			throw new java.lang.InternalError((((("Wrong population count for " + i) + ": ") + result) + " != ") + expected);
		}
	}

	static void check(long l, int expected, int result) {
		if (result != expected) {
			throw new java.lang.InternalError((((("Wrong population count for " + l) + ": ") + result) + " != ") + expected);
		}
	}

	static void sub(int i) {
		compiler.codegen.Test6378821.check(i, compiler.codegen.Test6378821.fint(i), compiler.codegen.Test6378821.fcomp(i));
	}

	static void sub(int[] ia) {
		compiler.codegen.Test6378821.check(ia[0], compiler.codegen.Test6378821.fint(ia), compiler.codegen.Test6378821.fcomp(ia));
	}

	static void sub(long l) {
		compiler.codegen.Test6378821.check(l, compiler.codegen.Test6378821.fint(l), compiler.codegen.Test6378821.fcomp(l));
	}

	static void sub(long[] la) {
		compiler.codegen.Test6378821.check(la[0], compiler.codegen.Test6378821.fint(la), compiler.codegen.Test6378821.fcomp(la));
	}

	static int fint(int i) {
		return java.lang.Integer.bitCount(i);
	}

	static int fcomp(int i) {
		return java.lang.Integer.bitCount(i);
	}

	static int fint(int[] ia) {
		return java.lang.Integer.bitCount(ia[0]);
	}

	static int fcomp(int[] ia) {
		return java.lang.Integer.bitCount(ia[0]);
	}

	static int fint(long l) {
		return java.lang.Long.bitCount(l);
	}

	static int fcomp(long l) {
		return java.lang.Long.bitCount(l);
	}

	static int fint(long[] la) {
		return java.lang.Long.bitCount(la[0]);
	}

	static int fcomp(long[] la) {
		return java.lang.Long.bitCount(la[0]);
	}
}