public class VerifyStackForExceptionHandlers extends java.lang.ClassLoader {
	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		vm.verifier.VerifyStackForExceptionHandlers t = new vm.verifier.VerifyStackForExceptionHandlers();
		try {
			t.loadGoodClass();
		} catch (java.lang.VerifyError e) {
			throw new java.lang.Exception("FAIL: should be no VerifyError for class A");
		}
		try {
			t.loadBadClass();
			throw new java.lang.Exception("FAIL: should be a VerifyError for class B");
		} catch (java.lang.VerifyError e) {
			java.lang.System.out.println("PASS");
		}
	}

	private void loadGoodClass() {
		long[] cls_data = new long[]{ 0xcafebabe00000031L, 0xe0a0003000b07L, 0xc07000d010006L, 0x3c696e69743e0100L, 0x328295601000443L, 0x6f646501000f4c69L, 0x6e654e756d626572L, 0x5461626c65010001L, 0x6601000a536f7572L, 0x636546696c650100L, 0x6412e6a6176610cL, 0x4000501000141L, 0x100106a6176612fL, 0x6c616e672f4f626aL, 0x6563740021000200L, 0x300000000000200L, 0x100040005000100L, 0x60000001d000100L, 0x1000000052ab700L, 0x1b1000000010007L, 0x600010000L, 0x1000900080005L, 0x1000600000019L, 0x1L, 0xb100000001000700L, 0x60001000000L, 0x200010009000000L, 0x2000a0000000000L };
		final int EXTRA = 5;
		byte[] cf_bytes = vm.verifier.VerifyStackForExceptionHandlers.toByteArray(cls_data);
		java.lang.Class c = defineClass("A", cf_bytes, 0, cf_bytes.length - EXTRA);
		try {
			c.newInstance();
		} catch (java.lang.InstantiationException e) {
		} catch (java.lang.IllegalAccessException e) {
		}
	}

	private void loadBadClass() throws java.lang.VerifyError {
		long[] cls_data = new long[]{ 0xcafebabe00000031L, 0x120a000400060aL, 0xd00030c000f00L, 0xa0700050100106aL, 0x6176612f6c616e67L, 0x2f4f626a6563740cL, 0x11000a01000a53L, 0x6f7572636546696cL, 0x6507000901001e6aL, 0x6176612f6c616e67L, 0x2f4e756c6c506f69L, 0x6e74657245786365L, 0x7074696f6e010003L, 0x282956010006422eL, 0x6a61736d01000443L, 0x6f646507000e0100L, 0x142010001670100L, 0x1660100063c696eL, 0x69743e0021000d00L, 0x400000000000300L, 0x10011000a000100L, 0xc00000011000100L, 0x1000000052ab700L, 0x1b1000000000009L, 0xf000a0001000cL, 0xd00000000L, 0x1b1000000L, 0x90010000a00L, 0x1000c0000001c00L, 0x100000008b8L, 0x2a700044bb100L, 0x100000003000600L, 0x800000001000700L, 0x2000b000000L };
		final int EXTRA = 3;
		byte[] cf_bytes = vm.verifier.VerifyStackForExceptionHandlers.toByteArray(cls_data);
		java.lang.Class c = defineClass("B", cf_bytes, 0, cf_bytes.length - EXTRA);
		try {
			c.newInstance();
		} catch (java.lang.InstantiationException e) {
		} catch (java.lang.IllegalAccessException e) {
		}
	}

	private static byte[] toByteArray(long[] arr) {
		java.nio.ByteBuffer bbuf = java.nio.ByteBuffer.allocate(arr.length * 8);
		bbuf.asLongBuffer().put(java.nio.LongBuffer.wrap(arr));
		return bbuf.array();
	}
}