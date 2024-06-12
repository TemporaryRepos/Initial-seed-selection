public class Test6753639 {
	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		int END = java.lang.Integer.MAX_VALUE;
		int count = 0;
		for (int i = java.lang.Integer.MAX_VALUE - 5; i <= END; i++) {
			count++;
			if (count > 100000) {
				java.lang.System.out.println("Passed");
				java.lang.System.exit(95);
			}
		}
		java.lang.System.out.println("broken " + count);
		java.lang.System.out.println("FAILED");
		java.lang.System.exit(97);
	}
}