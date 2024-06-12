public class Test6659207 {
	static int[] array = new int[12];

	static int index(int i) {
		if (i == 0) {
			return 0;
		}
		for (int n = 0; n < compiler.loopopts.Test6659207.array.length; n++) {
			if (i < compiler.loopopts.Test6659207.array[n]) {
				return n;
			}
		}
		return -1;
	}

	static int test(int i) {
		int result = 0;
		i = compiler.loopopts.Test6659207.index(i);
		if (i >= 0) {
			if (compiler.loopopts.Test6659207.array[i] != 0) {
				result++;
			}
		}
		if (i != (-1)) {
			compiler.loopopts.Test6659207.array[i]++;
		}
		return result;
	}

	public static void main(java.lang.String[] args) {
		int total = 0;
		for (int i = 0; i < 100000; i++) {
			total += compiler.loopopts.Test6659207.test(10);
		}
		java.lang.System.out.println(total);
	}
}