public class Test6901572 {
	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 2; i++) {
			compiler.c2.Test6901572.NestedLoop();
		}
	}

	public static long NestedLoop() {
		final int n = 50;
		int x = 0;
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				for (int c = 0; c < n; c++) {
					for (int d = 0; d < n; d++) {
						for (int e = 0; e < n; e++) {
							for (int f = 0; f < n; f++) {
								x++;
							}
						}
					}
				}
			}
		}
		return 100000;
	}
}