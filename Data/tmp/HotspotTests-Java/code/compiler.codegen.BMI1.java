public class BMI1 {
	private static final int ITERATIONS = 1000000;

	public static void main(java.lang.String[] args) {
		int ix = 0x1234567;
		int iy = 0x89abcdef;
		compiler.codegen.BMI1.MemI imy = new compiler.codegen.BMI1.MemI(iy);
		long lx = 0x123456701234567L;
		long ly = 0x89abcdef89abcdefL;
		compiler.codegen.BMI1.MemL lmy = new compiler.codegen.BMI1.MemL(ly);
		{
			int z = compiler.codegen.BMI1.BMITests.andnl(ix, iy);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				int ii = compiler.codegen.BMI1.BMITests.andnl(ix, iy);
				if (ii != z) {
					throw new java.lang.Error("andnl with register failed");
				}
			}
		}
		{
			long z = compiler.codegen.BMI1.BMITests.andnq(lx, ly);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				long ll = compiler.codegen.BMI1.BMITests.andnq(lx, ly);
				if (ll != z) {
					throw new java.lang.Error("andnq with register failed");
				}
			}
		}
		{
			int z = compiler.codegen.BMI1.BMITests.andnl(ix, imy);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				int ii = compiler.codegen.BMI1.BMITests.andnl(ix, imy);
				if (ii != z) {
					throw new java.lang.Error("andnl with memory failed");
				}
			}
		}
		{
			long z = compiler.codegen.BMI1.BMITests.andnq(lx, lmy);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				long ll = compiler.codegen.BMI1.BMITests.andnq(lx, lmy);
				if (ll != z) {
					throw new java.lang.Error("andnq with memory failed");
				}
			}
		}
		{
			int z = compiler.codegen.BMI1.BMITests.blsil(ix);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				int ii = compiler.codegen.BMI1.BMITests.blsil(ix);
				if (ii != z) {
					throw new java.lang.Error("blsil with register failed");
				}
			}
		}
		{
			long z = compiler.codegen.BMI1.BMITests.blsiq(lx);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				long ll = compiler.codegen.BMI1.BMITests.blsiq(lx);
				if (ll != z) {
					throw new java.lang.Error("blsiq with register failed");
				}
			}
		}
		{
			int z = compiler.codegen.BMI1.BMITests.blsil(imy);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				int ii = compiler.codegen.BMI1.BMITests.blsil(imy);
				if (ii != z) {
					throw new java.lang.Error("blsil with memory failed");
				}
			}
		}
		{
			long z = compiler.codegen.BMI1.BMITests.blsiq(lmy);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				long ll = compiler.codegen.BMI1.BMITests.blsiq(lmy);
				if (ll != z) {
					throw new java.lang.Error("blsiq with memory failed");
				}
			}
		}
		{
			int z = compiler.codegen.BMI1.BMITests.blsmskl(ix);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				int ii = compiler.codegen.BMI1.BMITests.blsmskl(ix);
				if (ii != z) {
					throw new java.lang.Error("blsmskl with register failed");
				}
			}
		}
		{
			long z = compiler.codegen.BMI1.BMITests.blsmskq(lx);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				long ll = compiler.codegen.BMI1.BMITests.blsmskq(lx);
				if (ll != z) {
					throw new java.lang.Error("blsmskq with register failed");
				}
			}
		}
		{
			int z = compiler.codegen.BMI1.BMITests.blsmskl(imy);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				int ii = compiler.codegen.BMI1.BMITests.blsmskl(imy);
				if (ii != z) {
					throw new java.lang.Error("blsmskl with memory failed");
				}
			}
		}
		{
			long z = compiler.codegen.BMI1.BMITests.blsmskq(lmy);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				long ll = compiler.codegen.BMI1.BMITests.blsmskq(lmy);
				if (ll != z) {
					throw new java.lang.Error("blsmskq with memory failed");
				}
			}
		}
		{
			int z = compiler.codegen.BMI1.BMITests.blsrl(ix);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				int ii = compiler.codegen.BMI1.BMITests.blsrl(ix);
				if (ii != z) {
					throw new java.lang.Error("blsrl with register failed");
				}
			}
		}
		{
			long z = compiler.codegen.BMI1.BMITests.blsrq(lx);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				long ll = compiler.codegen.BMI1.BMITests.blsrq(lx);
				if (ll != z) {
					throw new java.lang.Error("blsrq with register failed");
				}
			}
		}
		{
			int z = compiler.codegen.BMI1.BMITests.blsrl(imy);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				int ii = compiler.codegen.BMI1.BMITests.blsrl(imy);
				if (ii != z) {
					throw new java.lang.Error("blsrl with memory failed");
				}
			}
		}
		{
			long z = compiler.codegen.BMI1.BMITests.blsrq(lmy);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				long ll = compiler.codegen.BMI1.BMITests.blsrq(lmy);
				if (ll != z) {
					throw new java.lang.Error("blsrq with memory failed");
				}
			}
		}
		{
			int z = compiler.codegen.BMI1.BMITests.lzcntl(ix);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				int ii = compiler.codegen.BMI1.BMITests.lzcntl(ix);
				if (ii != z) {
					throw new java.lang.Error("lzcntl failed");
				}
			}
		}
		{
			int z = compiler.codegen.BMI1.BMITests.lzcntq(lx);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				int ii = compiler.codegen.BMI1.BMITests.lzcntq(lx);
				if (ii != z) {
					throw new java.lang.Error("lzcntq failed");
				}
			}
		}
		{
			int z = compiler.codegen.BMI1.BMITests.tzcntl(ix);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				int ii = compiler.codegen.BMI1.BMITests.tzcntl(ix);
				if (ii != z) {
					throw new java.lang.Error("tzcntl failed");
				}
			}
		}
		{
			int z = compiler.codegen.BMI1.BMITests.tzcntq(lx);
			for (int i = 0; i < compiler.codegen.BMI1.ITERATIONS; i++) {
				int ii = compiler.codegen.BMI1.BMITests.tzcntq(lx);
				if (ii != z) {
					throw new java.lang.Error("tzcntq failed");
				}
			}
		}
	}

	static class MemI {
		public int x;

		public MemI(int x) {
			this.x = x;
		}
	}

	static class MemL {
		public long x;

		public MemL(long x) {
			this.x = x;
		}
	}

	static class BMITests {
		static int andnl(int src1, int src2) {
			return (~src1) & src2;
		}

		static long andnq(long src1, long src2) {
			return (~src1) & src2;
		}

		static int andnl(int src1, compiler.codegen.BMI1.MemI src2) {
			return (~src1) & src2.x;
		}

		static long andnq(long src1, compiler.codegen.BMI1.MemL src2) {
			return (~src1) & src2.x;
		}

		static int blsil(int src1) {
			return src1 & (-src1);
		}

		static long blsiq(long src1) {
			return src1 & (-src1);
		}

		static int blsil(compiler.codegen.BMI1.MemI src1) {
			return src1.x & (-src1.x);
		}

		static long blsiq(compiler.codegen.BMI1.MemL src1) {
			return src1.x & (-src1.x);
		}

		static int blsmskl(int src1) {
			return (src1 - 1) ^ src1;
		}

		static long blsmskq(long src1) {
			return (src1 - 1) ^ src1;
		}

		static int blsmskl(compiler.codegen.BMI1.MemI src1) {
			return (src1.x - 1) ^ src1.x;
		}

		static long blsmskq(compiler.codegen.BMI1.MemL src1) {
			return (src1.x - 1) ^ src1.x;
		}

		static int blsrl(int src1) {
			return (src1 - 1) & src1;
		}

		static long blsrq(long src1) {
			return (src1 - 1) & src1;
		}

		static int blsrl(compiler.codegen.BMI1.MemI src1) {
			return (src1.x - 1) & src1.x;
		}

		static long blsrq(compiler.codegen.BMI1.MemL src1) {
			return (src1.x - 1) & src1.x;
		}

		static int lzcntl(int src1) {
			return java.lang.Integer.numberOfLeadingZeros(src1);
		}

		static int lzcntq(long src1) {
			return java.lang.Long.numberOfLeadingZeros(src1);
		}

		static int tzcntl(int src1) {
			return java.lang.Integer.numberOfTrailingZeros(src1);
		}

		static int tzcntq(long src1) {
			return java.lang.Long.numberOfTrailingZeros(src1);
		}
	}
}