public class UnsignedLoads {
	public static int testUnsignedByte() {
		byte[] bytes = new byte[]{ -1 };
		int res = 0;
		for (int i = 0; i < 100000; i++) {
			for (java.lang.Byte b : bytes) {
				res = b & 0xff;
			}
		}
		return res;
	}

	public static int testUnsignedShort() {
		int res = 0;
		short[] shorts = new short[]{ -1 };
		for (int i = 0; i < 100000; i++) {
			for (java.lang.Short s : shorts) {
				res = s & 0xffff;
			}
		}
		return res;
	}

	public static void main(java.lang.String[] args) {
		jdk.test.lib.Asserts.assertEQ(compiler.eliminateAutobox.UnsignedLoads.testUnsignedByte(), 255);
		jdk.test.lib.Asserts.assertEQ(compiler.eliminateAutobox.UnsignedLoads.testUnsignedShort(), 65535);
		java.lang.System.out.println("TEST PASSED");
	}
}