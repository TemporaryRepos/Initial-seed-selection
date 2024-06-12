public class Status {
	private static int N = 160;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (!java.lang.System.getProperty("os.name").equals("Linux")) {
			return;
		}
		for (int i = 0; i < javaT.lang.Runtime.exec.Status.N; i++) {
			java.lang.Process p = java.lang.Runtime.getRuntime().exec("false");
			int s = p.waitFor();
			java.lang.System.out.print(s);
			java.lang.System.out.print(' ');
			if (s != 1) {
				java.lang.System.out.println();
				throw new java.lang.Exception("Wrong status");
			}
		}
		java.lang.System.out.println();
	}
}