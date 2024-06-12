public class Random {
	private int current;

	public Random(int init) {
		this.current = init;
	}

	private static long BASE = 1003001;

	public int nextInt() {
		return current;
	}

	public int nextInt(int n) {
		return nextInt();
	}

	public static void main(java.lang.String[] args) {
		vm.compiler.share.Random r = new vm.compiler.share.Random(11);
		int[] a = new int[100];
		for (int i = 0; i < 1000; i++) {
			a[0]++;
		}
		for (int i = 0; i < 100; i++) {
			java.lang.System.out.println(vm.compiler.share.Random.times(a[i]));
		}
	}

	public static java.lang.String times(int n) {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append("*");
		}
		return sb.toString();
	}
}