public class LotsOfDestroys {
	static final int RUNS = 400;

	static final java.lang.String ECHO = "/usr/bin/echo";

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if ((java.io.File.separatorChar == '\\') || (!new java.io.File(javaT.lang.Runtime.exec.LotsOfDestroys.ECHO).exists())) {
			return;
		}
		for (int i = 0; i <= javaT.lang.Runtime.exec.LotsOfDestroys.RUNS; i++) {
			java.lang.Process process = java.lang.Runtime.getRuntime().exec(javaT.lang.Runtime.exec.LotsOfDestroys.ECHO + " x");
			process.destroy();
		}
	}
}