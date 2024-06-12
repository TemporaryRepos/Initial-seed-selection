public class subcommon01 {
	static final int LEN = 500;

	public static void main(java.lang.String[] args) {
		double[] a = new double[vm.compiler.jbe.subcommon.subcommon01.subcommon01.LEN];
		double[] ao = new double[vm.compiler.jbe.subcommon.subcommon01.subcommon01.LEN];
		vm.compiler.jbe.subcommon.subcommon01.Preopt preOptRun = new vm.compiler.jbe.subcommon.subcommon01.Preopt();
		vm.compiler.jbe.subcommon.subcommon01.subcommon01.initAr(a);
		preOptRun.b1(a);
		preOptRun.b2(a);
		preOptRun.b3(a);
		preOptRun.b5(a);
		preOptRun.b2(a);
		preOptRun.b6(a);
		vm.compiler.jbe.subcommon.subcommon01.Opt optRun = new vm.compiler.jbe.subcommon.subcommon01.Opt();
		vm.compiler.jbe.subcommon.subcommon01.subcommon01.initAr(ao);
		optRun.b1(ao);
		optRun.b2(ao);
		optRun.b3(ao);
		optRun.b5(ao);
		optRun.b2(ao);
		optRun.b6(ao);
		vm.compiler.jbe.subcommon.subcommon01.subcommon01.eCheck(a, ao);
	}

	static int getLen() {
		return vm.compiler.jbe.subcommon.subcommon01.subcommon01.LEN;
	}

	static void initAr(double[] arr) {
		double r1;
		double r2;
		double r3;
		for (int r = 0; r < vm.compiler.jbe.subcommon.subcommon01.subcommon01.LEN; r++) {
			r1 = vm.compiler.jbe.subcommon.subcommon01.subcommon01.LEN / (r + 1);
			r2 = java.lang.Math.sqrt(r1 * r1);
			r3 = java.lang.Math.sin(r2);
			arr[r] = r2 / r3;
		}
	}

	static void pt(double[] arr) {
		java.lang.System.out.println();
		for (int k = 0; k < 10; k++) {
			java.lang.System.out.print((("a[" + k) + "]=") + arr[k]);
		}
	}

	static void eCheck(double[] b1, double[] b2) {
		for (int k = 0; k < vm.compiler.jbe.subcommon.subcommon01.subcommon01.LEN; k++) {
			if (b1[k] != b2[k]) {
				java.lang.System.out.println(("eCheck fails in a[" + k) + "]");
				java.lang.System.out.println((("a [" + k) + "]=") + b1[k]);
				java.lang.System.out.println((("ao[" + k) + "]=") + b2[k]);
				java.lang.System.out.println("Test subcommon01 Failed.");
				throw new java.lang.Error((((((((("Test subcommon01 Failed: eCheck fails in a[" + k) + "]. a[") + k) + "]=") + b1[k]) + " != ao[") + k) + "]=") + b2[k]);
			}
		}
		java.lang.System.out.println("Test subcommon01 Passed.");
	}
}