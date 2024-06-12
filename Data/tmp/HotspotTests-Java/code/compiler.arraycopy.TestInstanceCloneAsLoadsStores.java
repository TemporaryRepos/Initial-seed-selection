public class TestInstanceCloneAsLoadsStores extends compiler.arraycopy.TestInstanceCloneUtils {
	static java.lang.Object m1(compiler.arraycopy.TestInstanceCloneUtils.D src) throws java.lang.CloneNotSupportedException {
		return src.clone();
	}

	static int m2(compiler.arraycopy.TestInstanceCloneUtils.D src) throws java.lang.CloneNotSupportedException {
		compiler.arraycopy.TestInstanceCloneUtils.D dest = ((compiler.arraycopy.TestInstanceCloneUtils.D) (src.clone()));
		return (((dest.i1 + dest.i2) + ((int) (dest.i3))) + dest.i4) + dest.i5;
	}

	static int m3(compiler.arraycopy.TestInstanceCloneUtils.E src) throws java.lang.CloneNotSupportedException {
		compiler.arraycopy.TestInstanceCloneUtils.E dest = ((compiler.arraycopy.TestInstanceCloneUtils.E) (src.clone()));
		return (((((((dest.i1 + dest.i2) + dest.i3) + dest.i4) + dest.i5) + dest.i6) + dest.i7) + dest.i8) + dest.i9;
	}

	static java.lang.Object m4(compiler.arraycopy.TestInstanceCloneUtils.A src) throws java.lang.CloneNotSupportedException {
		return src.clone();
	}

	static int m5(compiler.arraycopy.TestInstanceCloneUtils.A src) throws java.lang.CloneNotSupportedException {
		compiler.arraycopy.TestInstanceCloneUtils.A dest = ((compiler.arraycopy.TestInstanceCloneUtils.A) (src.clone()));
		return (((dest.i1 + dest.i2) + dest.i3) + dest.i4) + dest.i5;
	}

	static java.lang.Object m6(compiler.arraycopy.TestInstanceCloneUtils.F src) throws java.lang.CloneNotSupportedException {
		return src.clone();
	}

	static compiler.arraycopy.TestInstanceCloneUtils.G m7(compiler.arraycopy.TestInstanceCloneUtils.G src) throws java.lang.CloneNotSupportedException {
		return ((compiler.arraycopy.TestInstanceCloneUtils.G) (src.myclone()));
	}

	static compiler.arraycopy.TestInstanceCloneUtils.J m8(compiler.arraycopy.TestInstanceCloneUtils.J src) throws java.lang.CloneNotSupportedException {
		return ((compiler.arraycopy.TestInstanceCloneUtils.J) (src.myclone()));
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		compiler.arraycopy.TestInstanceCloneAsLoadsStores test = new compiler.arraycopy.TestInstanceCloneAsLoadsStores();
		test.doTest(compiler.arraycopy.TestInstanceCloneUtils.d, "m1");
		test.doTest(compiler.arraycopy.TestInstanceCloneUtils.d, "m2");
		test.doTest(compiler.arraycopy.TestInstanceCloneUtils.e, "m3");
		test.doTest(compiler.arraycopy.TestInstanceCloneUtils.a, "m4");
		test.doTest(compiler.arraycopy.TestInstanceCloneUtils.a, "m5");
		test.doTest(compiler.arraycopy.TestInstanceCloneUtils.f, "m6");
		test.doTest(compiler.arraycopy.TestInstanceCloneUtils.g, "m7");
		test.doTest(compiler.arraycopy.TestInstanceCloneUtils.k, "m8");
		if (!test.success) {
			throw new java.lang.RuntimeException("some tests failed");
		}
	}
}