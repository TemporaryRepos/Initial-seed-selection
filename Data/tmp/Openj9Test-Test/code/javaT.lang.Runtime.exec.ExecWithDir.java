public class ExecWithDir {
	private static final java.lang.String CMD = "/bin/true";

	private static final int N = 500;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (!new java.io.File(javaT.lang.Runtime.exec.ExecWithDir.CMD).canExecute()) {
			return;
		}
		java.io.File dir = new java.io.File(".");
		for (int i = 1; i <= javaT.lang.Runtime.exec.ExecWithDir.N; i++) {
			java.lang.System.out.print(i);
			java.lang.System.out.print(" e");
			java.lang.Process p = java.lang.Runtime.getRuntime().exec(javaT.lang.Runtime.exec.ExecWithDir.CMD, null, dir);
			java.lang.System.out.print('w');
			int s = p.waitFor();
			java.lang.System.out.println("x " + s);
			if (s != 0) {
				throw new java.lang.Error("Unexpected return code " + s);
			}
			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();
		}
	}
}