public class TestStringIntrinsicMemoryFlow {
	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 100000; ++i) {
			java.lang.String s = "MyString";
			char[] c = new char[]{ 'M' };
			char res = compiler.intrinsics.string.TestStringIntrinsicMemoryFlow.testInflate1(s);
			jdk.test.lib.Asserts.assertEquals(res, 'M', "testInflate1 failed");
			res = compiler.intrinsics.string.TestStringIntrinsicMemoryFlow.testInflate2(s);
			jdk.test.lib.Asserts.assertEquals(res, ((char) (42)), "testInflate2 failed");
			res = compiler.intrinsics.string.TestStringIntrinsicMemoryFlow.testCompress1(c);
			jdk.test.lib.Asserts.assertEquals(res, 'M', "testCompress1 failed");
			byte resB = compiler.intrinsics.string.TestStringIntrinsicMemoryFlow.testCompress2(c);
			jdk.test.lib.Asserts.assertEquals(resB, ((byte) (42)), "testCompress2 failed");
		}
	}

	private static char testInflate1(java.lang.String s) {
		char[] c = new char[1];
		s.getChars(0, 1, c, 0);
		return c[0];
	}

	private static char testInflate2(java.lang.String s) {
		char[] c1 = new char[1];
		char[] c2 = new char[1];
		c2[0] = 42;
		s.getChars(0, 1, c1, 0);
		return c2[0];
	}

	private static char testCompress1(char[] c) {
		java.lang.String s = new java.lang.String(c);
		return s.charAt(0);
	}

	private static byte testCompress2(char[] c) {
		byte[] b1 = new byte[1];
		b1[0] = 42;
		new java.lang.String(c);
		return b1[0];
	}
}