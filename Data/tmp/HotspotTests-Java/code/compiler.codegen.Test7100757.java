public class Test7100757 {
	public static final int NBITS = 256;

	public static void main(java.lang.String[] args) {
		java.util.BitSet bs = new java.util.BitSet(compiler.codegen.Test7100757.NBITS);
		long[] ra = new long[(compiler.codegen.Test7100757.NBITS + 63) / 64];
		for (int l = 0; l < 5000000; l++) {
			for (int r = 0; r < ra.length; r++) {
				ra[r] = 0;
			}
			compiler.codegen.Test7100757.test(ra, bs);
		}
	}

	static void test(long[] ra, java.util.BitSet bs) {
		bs.clear();
		int bits_set = 0;
		for (int i = 0, t = 0, b = 0; i < compiler.codegen.Test7100757.NBITS; i++) {
			long bit = 1L << (b++);
			if ((ra[t] & bit) != 0) {
				bs.set(i);
				bits_set++;
			}
			if (b == 64) {
				t++;
				b = 0;
			}
		}
		int check_bits = bs.cardinality();
		if (check_bits != bits_set) {
			java.lang.String bs_str = bs.toString();
			java.lang.System.err.printf("cardinality bits: %d != %d  bs: %s\n", check_bits, bits_set, bs_str);
			java.lang.System.exit(97);
		}
		check_bits = 0;
		for (int i = bs.nextSetBit(0); i >= 0; i = bs.nextSetBit(i + 1)) {
			check_bits++;
		}
		if (check_bits != bits_set) {
			java.lang.String bs_str = bs.toString();
			java.lang.System.err.printf("nextSetBit bits: %d != %d  bs: %s\n", check_bits, bits_set, bs_str);
			java.lang.System.exit(97);
		}
		for (int i = bs.length(); i > 0; i = bs.length()) {
			bs.clear(i - 1);
		}
		check_bits = bs.cardinality();
		if (check_bits != 0) {
			java.lang.String bs_str = bs.toString();
			java.lang.System.err.printf("after clear bits: %d != 0  bs: %s\n", check_bits, bs_str);
			java.lang.System.exit(97);
		}
	}
}