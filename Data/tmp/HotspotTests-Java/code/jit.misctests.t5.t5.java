class t5 {
	public static void main(java.lang.String[] args) {
		byte[] data = new byte[16];
		jit.misctests.t5.t5.foo();
	}

	public static int FF(int a, int b, int c, int d, int x, int s, int ac) {
		return ((a += (((b & c) | ((~b) & d)) + x) + ac) << s) | ((a >>> (32 - s)) + b);
	}

	static void foo() {
		java.lang.System.out.println("Starting foo ...");
		int[] W = new int[16];
		int a = 0x67452301;
		int b = 0xefcdab89;
		int c = 0x98badcfe;
		int d = 0x10325476;
		for (int i = 0; i < 16; i++) {
			a = jit.misctests.t5.t5.FF(a, b, c, d, W[0], 7, 0xd76aa478);
			d = jit.misctests.t5.t5.FF(d, a, b, c, W[1], 12, 0xe8c7b756);
			c = jit.misctests.t5.t5.FF(c, d, a, b, W[2], 17, 0x242070db);
			b = jit.misctests.t5.t5.FF(b, c, d, a, W[3], 22, 0xc1bdceee);
			a = jit.misctests.t5.t5.FF(a, b, c, d, W[4], 7, 0xf57c0faf);
			d = jit.misctests.t5.t5.FF(d, a, b, c, W[5], 12, 0x4787c62a);
			c = jit.misctests.t5.t5.FF(c, d, a, b, W[6], 17, 0xa8304613);
			b = jit.misctests.t5.t5.FF(b, c, d, a, W[7], 22, 0xfd469501);
		}
		java.lang.System.out.println("foo ended.");
	}
}