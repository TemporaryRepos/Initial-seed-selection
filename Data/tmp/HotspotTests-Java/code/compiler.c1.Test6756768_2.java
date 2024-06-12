public class Test6756768_2 {
	static int var = 1;

	static java.lang.Object d2 = null;

	static void test_static_field() {
		int v = compiler.c1.Test6756768_2.var;
		int v2 = compiler.c1.Test6756768_2a.var;
		int v3 = compiler.c1.Test6756768_2.var;
		compiler.c1.Test6756768_2.var = v3;
	}

	public static void main(java.lang.String[] args) {
		compiler.c1.Test6756768_2.var = 1;
		compiler.c1.Test6756768_2.test_static_field();
		if (compiler.c1.Test6756768_2.var != 2) {
			throw new java.lang.InternalError();
		}
	}
}