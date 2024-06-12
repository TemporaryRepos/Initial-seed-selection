public class Test8005419 {
	public static int SIZE = 64;

	public static void main(java.lang.String[] args) {
		char[] a = new char[compiler.intrinsics.Test8005419.SIZE];
		char[] b = new char[compiler.intrinsics.Test8005419.SIZE];
		for (int i = 16; i < compiler.intrinsics.Test8005419.SIZE; i++) {
			a[i] = ((char) (i));
			b[i] = ((char) (i));
		}
		java.lang.String s1 = new java.lang.String(a);
		java.lang.String s2 = new java.lang.String(b);
		boolean failed = false;
		int result = 0;
		for (int i = 0; i < 10000; i++) {
			result += compiler.intrinsics.Test8005419.test(s1, s2);
		}
		for (int i = 0; i < 10000; i++) {
			result += compiler.intrinsics.Test8005419.test(s1, s2);
		}
		for (int i = 0; i < 10000; i++) {
			result += compiler.intrinsics.Test8005419.test(s1, s2);
		}
		if (result != 0) {
			failed = true;
		}
		java.lang.System.out.println("Start testing");
		result = compiler.intrinsics.Test8005419.test(s1, s1);
		if (result != 0) {
			failed = true;
			java.lang.System.out.println(("Failed same: result = " + result) + ", expected 0");
		}
		for (int i = 1; i <= compiler.intrinsics.Test8005419.SIZE; i++) {
			s1 = new java.lang.String(a, 0, i);
			s2 = new java.lang.String(b, 0, i);
			result = compiler.intrinsics.Test8005419.test(s1, s2);
			if (result != 0) {
				failed = true;
				java.lang.System.out.println(((((("Failed equals s1[" + i) + "], s2[") + i) + "]: result = ") + result) + ", expected 0");
			}
		}
		for (int i = 1; i <= compiler.intrinsics.Test8005419.SIZE; i++) {
			s1 = new java.lang.String(a, 0, i);
			for (int j = 1; j <= compiler.intrinsics.Test8005419.SIZE; j++) {
				s2 = new java.lang.String(b, 0, j);
				result = compiler.intrinsics.Test8005419.test(s1, s2);
				if (result != (i - j)) {
					failed = true;
					java.lang.System.out.println((((((("Failed diff size s1[" + i) + "], s2[") + j) + "]: result = ") + result) + ", expected ") + (i - j));
				}
			}
		}
		for (int i = 1; i <= compiler.intrinsics.Test8005419.SIZE; i++) {
			s1 = new java.lang.String(a, 0, i);
			for (int j = 0; j < i; j++) {
				b[j] -= 3;
				s2 = new java.lang.String(b, 0, i);
				result = compiler.intrinsics.Test8005419.test(s1, s2);
				int chdiff = a[j] - b[j];
				if (result != chdiff) {
					failed = true;
					java.lang.System.out.println((((((("Failed diff char s1[" + i) + "], s2[") + i) + "]: result = ") + result) + ", expected ") + chdiff);
				}
				result = compiler.intrinsics.Test8005419.test(s2, s1);
				chdiff = b[j] - a[j];
				if (result != chdiff) {
					failed = true;
					java.lang.System.out.println((((((("Failed diff char s2[" + i) + "], s1[") + i) + "]: result = ") + result) + ", expected ") + chdiff);
				}
				b[j] += 3;
			}
		}
		if (failed) {
			java.lang.System.out.println("FAILED");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	private static int test(java.lang.String str1, java.lang.String str2) {
		return str1.compareTo(str2);
	}
}