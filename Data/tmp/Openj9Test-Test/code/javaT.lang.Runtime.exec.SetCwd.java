public class SetCwd {
	public static void testExec(java.lang.String cmd, java.lang.String[] cmdarray, boolean flag) throws java.lang.Exception {
		java.io.File dir = new java.io.File(".");
		java.io.File[] files = dir.listFiles();
		java.lang.String curDir = dir.getCanonicalPath();
		for (int i = 0; i < files.length; i++) {
			java.io.File f = files[i];
			if (f.isDirectory() && new java.io.File(f, "SetCwd.class").exists()) {
				java.lang.String newDir = f.getCanonicalPath();
				java.lang.Process p = null;
				if (flag) {
					p = java.lang.Runtime.getRuntime().exec(cmd, null, f);
				} else {
					p = java.lang.Runtime.getRuntime().exec(cmdarray, null, f);
				}
				java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
				java.lang.String s = in.readLine();
				if (!s.startsWith(newDir)) {
					throw new java.lang.Exception("inconsistent directory after exec");
				}
				p.waitFor();
			}
		}
		java.lang.System.out.println(curDir);
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String[] cmdarray = new java.lang.String[2];
		cmdarray[0] = (((java.lang.System.getProperty("java.home") + java.io.File.separator) + "bin") + java.io.File.separator) + "java";
		cmdarray[1] = "SetCwd";
		java.lang.String cmd = (cmdarray[0] + " ") + cmdarray[1];
		javaT.lang.Runtime.exec.SetCwd.testExec(cmd, null, true);
		javaT.lang.Runtime.exec.SetCwd.testExec(null, cmdarray, false);
	}
}