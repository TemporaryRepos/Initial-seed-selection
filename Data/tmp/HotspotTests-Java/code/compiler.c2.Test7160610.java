public class Test7160610 {
	private static final byte[] BYTE_ARRAY = new byte[7];

	private static int[] anIntArray1190 = new int[32768];

	private static int[] anIntArray1191 = new int[32768];

	public static void main(java.lang.String[] arg) {
		int i = 256;
		for (int j = compiler.c2.Test7160610.BYTE_ARRAY[2]; j < compiler.c2.Test7160610.anIntArray1190.length; j++) {
			compiler.c2.Test7160610.anIntArray1190[j] = compiler.c2.Test7160610.BYTE_ARRAY[2];
		}
		for (int k = compiler.c2.Test7160610.BYTE_ARRAY[2]; (k ^ compiler.c2.Test7160610.BYTE_ARRAY[1]) > (-5001); k++) {
			int i1 = ((int) ((0.1 * 128.0) * ((double) (i))));
			compiler.c2.Test7160610.anIntArray1190[i1] = ((int) (0.2 * 256.0));
		}
		for (int l = compiler.c2.Test7160610.BYTE_ARRAY[2]; (l ^ compiler.c2.Test7160610.BYTE_ARRAY[1]) > (-21); l++) {
			for (int j1 = compiler.c2.Test7160610.BYTE_ARRAY[0]; j1 < (i + (-compiler.c2.Test7160610.BYTE_ARRAY[0])); j1++) {
				for (int k1 = compiler.c2.Test7160610.BYTE_ARRAY[0]; (k1 ^ compiler.c2.Test7160610.BYTE_ARRAY[1]) > (-128); k1++) {
					int l1 = k1 - (-(j1 << 0x26cb6487));
					compiler.c2.Test7160610.anIntArray1191[l1] = (((compiler.c2.Test7160610.anIntArray1190[l1 + (-compiler.c2.Test7160610.BYTE_ARRAY[0])] - (-compiler.c2.Test7160610.anIntArray1190[l1 - (-compiler.c2.Test7160610.BYTE_ARRAY[0])])) - (-compiler.c2.Test7160610.anIntArray1190[(-128) + l1])) - (-compiler.c2.Test7160610.anIntArray1190[128 + l1])) / compiler.c2.Test7160610.BYTE_ARRAY[6];
				}
			}
			int[] ai = compiler.c2.Test7160610.anIntArray1190;
			compiler.c2.Test7160610.anIntArray1190 = compiler.c2.Test7160610.anIntArray1191;
			compiler.c2.Test7160610.anIntArray1191 = ai;
		}
	}

	static {
		BYTE_ARRAY[6] = 4;
		BYTE_ARRAY[5] = 5;
		BYTE_ARRAY[4] = 3;
		BYTE_ARRAY[3] = 2;
		BYTE_ARRAY[2] = 0;
		BYTE_ARRAY[1] = -1;
		BYTE_ARRAY[0] = 1;
	}
}