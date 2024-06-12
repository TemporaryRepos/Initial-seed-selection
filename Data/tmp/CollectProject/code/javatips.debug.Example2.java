public class Example2 {
	private static void execute(int num) {
		java.lang.System.out.println("execute: " + num);
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 1000; i++) {
			javatips.debug.Example2.execute(i);
		}
	}
}