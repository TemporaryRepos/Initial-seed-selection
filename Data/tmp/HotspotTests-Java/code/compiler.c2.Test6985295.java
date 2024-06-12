public class Test6985295 {
	public static void main(java.lang.String[] args) {
		int min = java.lang.Integer.MAX_VALUE - 50000;
		int max = java.lang.Integer.MAX_VALUE;
		java.lang.System.out.println("max = " + max);
		long counter = 0;
		int i;
		for (i = min; i <= max; i++) {
			counter++;
			if (counter > 1000000) {
				java.lang.System.out.println("Passed");
				java.lang.System.exit(95);
			}
		}
		java.lang.System.out.println(((("iteration went " + counter) + " times (") + i) + ")");
		java.lang.System.out.println("FAILED");
		java.lang.System.exit(97);
	}
}