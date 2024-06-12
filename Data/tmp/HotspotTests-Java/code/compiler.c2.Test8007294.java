public class Test8007294 {
	int i1;

	int i2;

	Test8007294(int i1, int i2) {
		this.i1 = i1;
		this.i2 = i2;
	}

	static int m(int v) {
		return v;
	}

	static compiler.c2.Test8007294 test1() {
		compiler.c2.Test8007294 obj = new compiler.c2.Test8007294(10, 100);
		int v1 = obj.i1;
		int v3 = compiler.c2.Test8007294.m(v1);
		int v2 = obj.i2;
		obj.i2 = v3;
		obj.i1 = v2;
		return obj;
	}

	static int test2(int i) {
		int j = 0;
		if (i > 0) {
			j = 1;
		}
		int[] arr = new int[10];
		arr[0] = 1;
		arr[1] = 2;
		int v1 = arr[j];
		arr[0] = 3;
		arr[1] = 4;
		return v1;
	}

	public static void main(java.lang.String[] args) {
		boolean failed = false;
		for (int i = 0; i < 20000; i++) {
			compiler.c2.Test8007294 obj = compiler.c2.Test8007294.test1();
			if ((obj.i1 != 100) || (obj.i2 != 10)) {
				java.lang.System.out.println((("FAILED test1 obj.i1 = " + obj.i1) + ", obj.i2 = ") + obj.i2);
				failed = true;
				break;
			}
		}
		for (int i = 0; i < 20000; i++) {
			compiler.c2.Test8007294.test2(0);
			int res = compiler.c2.Test8007294.test2(1);
			if (res != 2) {
				java.lang.System.out.println("FAILED test2 = " + res);
				failed = true;
				break;
			}
		}
		if (failed) {
			java.lang.System.exit(97);
		} else {
			java.lang.System.out.println("PASSED");
		}
	}
}