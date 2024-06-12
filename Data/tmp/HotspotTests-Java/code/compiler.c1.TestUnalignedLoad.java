public class TestUnalignedLoad {
	static long l1v = 0x200000003L;

	static long l2v = 0x400000005L;

	static double d1v = java.lang.Double.MAX_VALUE;

	static double d2v = java.lang.Double.MIN_VALUE;

	public static void main(java.lang.String[] args) {
		long l1 = compiler.c1.TestUnalignedLoad.l1v;
		double d1 = compiler.c1.TestUnalignedLoad.d1v;
		long l2 = compiler.c1.TestUnalignedLoad.l2v;
		double d2 = compiler.c1.TestUnalignedLoad.d2v;
		for (int i = 0; i < 10000000; i++) {
		}
		boolean error = false;
		if (l1 != compiler.c1.TestUnalignedLoad.l1v) {
			java.lang.System.out.println((l1 + " != ") + compiler.c1.TestUnalignedLoad.l1v);
			error = true;
		}
		if (l2 != compiler.c1.TestUnalignedLoad.l2v) {
			java.lang.System.out.println((l2 + " != ") + compiler.c1.TestUnalignedLoad.l2v);
			error = true;
		}
		if (d1 != compiler.c1.TestUnalignedLoad.d1v) {
			java.lang.System.out.println((d1 + " != ") + compiler.c1.TestUnalignedLoad.d1v);
			error = true;
		}
		if (d2 != compiler.c1.TestUnalignedLoad.d2v) {
			java.lang.System.out.println((d2 + " != ") + compiler.c1.TestUnalignedLoad.d2v);
			error = true;
		}
		if (error) {
			throw new java.lang.InternalError();
		}
	}
}