public class Test6860469 {
	private static final int H = 16;

	private static final int F = 9;

	static int[] fl = new int[1 << compiler.loopopts.Test6860469.F];

	static int C(int ll, int f) {
		int max = -1;
		int min = compiler.loopopts.Test6860469.H + 1;
		if (ll != 0) {
			if (ll < min) {
				min = ll;
			}
			if (ll > max) {
				max = ll;
			}
		}
		if (f > max) {
			f = max;
		}
		if (min > f) {
			min = f;
		}
		for (int mc = 1 >> (max - f); mc <= 0; mc++) {
			int i = mc << (32 - f);
			compiler.loopopts.Test6860469.fl[i] = max;
		}
		return min;
	}

	public static void main(java.lang.String[] argv) {
		compiler.loopopts.Test6860469.C(0, 10);
	}
}