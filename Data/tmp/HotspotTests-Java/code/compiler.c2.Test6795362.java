public class Test6795362 {
	public static void main(java.lang.String[] args) {
		compiler.c2.Test6795362.sub();
		if (compiler.c2.Test6795362.var_bad != 0) {
			throw new java.lang.InternalError(compiler.c2.Test6795362.var_bad + " != 0");
		}
	}

	static long var_bad = -1L;

	static void sub() {
		compiler.c2.Test6795362.var_bad >>= 65;
		compiler.c2.Test6795362.var_bad /= 65;
	}
}