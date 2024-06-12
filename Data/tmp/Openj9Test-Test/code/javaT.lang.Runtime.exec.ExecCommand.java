public class ExecCommand {
	static class SecurityMan extends java.lang.SecurityManager {
		public static java.lang.String unquote(java.lang.String str) {
			int length = (str == null) ? 0 : str.length();
			if (((length > 1) && (str.charAt(0) == '\"')) && (str.charAt(length - 1) == '\"')) {
				return str.substring(1, length - 1);
			}
			return str;
		}

		@java.lang.Override
		public void checkExec(java.lang.String cmd) {
			java.lang.String ncmd = new java.io.File(javaT.lang.Runtime.exec.ExecCommand.SecurityMan.unquote(cmd)).getPath();
			if ((((ncmd.equals(".\\Program") || ncmd.equals("\".\\Program")) || ncmd.equals(".\\Program Files\\do.cmd")) || ncmd.equals(".\\Program.cmd")) || ncmd.equals("cmd")) {
				return;
			}
			super.checkExec(cmd);
		}

		@java.lang.Override
		public void checkDelete(java.lang.String file) {
		}

		@java.lang.Override
		public void checkRead(java.lang.String file) {
		}
	}

	private static final java.lang.String[] TEST_RTE_ARG = new java.lang.String[]{ "cmd /C dir > dirOut.txt", "cmd /C dir > \".\\Program Files\\dirOut.txt\"", ".\\Program Files\\do.cmd", "\".\\Program Files\\doNot.cmd\" arg", "\".\\Program Files\\do.cmd\" arg", "\".\\Program.cmd\" arg", ".\\Program.cmd arg" };

	private static final java.lang.String[] doCmdCopy = new java.lang.String[]{ ".\\Program.cmd", ".\\Program Files\\doNot.cmd", ".\\Program Files\\do.cmd" };

	private static final java.lang.String[][] TEST_RTE_GI = new java.lang.String[][]{ new java.lang.String[]{ "Success", "IOException", "Success", "IOException" }, new java.lang.String[]{ "Success", "IOException", "Success", "IOException" }, new java.lang.String[]{ "Success", "IOException", "Success", "IOException" }, new java.lang.String[]{ "Success", "Success", "Success", "AccessControlException" }, new java.lang.String[]{ "Success", "Success", "Success", "Success" }, new java.lang.String[]{ "Success", "Success", "Success", "Success" }, new java.lang.String[]{ "Success", "Success", "Success", "Success" } };

	private static void deleteOut(java.lang.String path) {
		try {
			java.nio.file.Files.delete(java.nio.file.FileSystems.getDefault().getPath(path));
		} catch (java.io.IOException ex) {
		}
	}

	private static void checkOut(java.lang.String path) throws java.io.FileNotFoundException {
		if (java.nio.file.Files.notExists(java.nio.file.FileSystems.getDefault().getPath(path))) {
			throw new java.io.FileNotFoundException(path);
		}
	}

	public static void main(java.lang.String[] _args) throws java.lang.Exception {
		if (!java.lang.System.getProperty("os.name").startsWith("Windows")) {
			return;
		}
		try {
			new java.io.File(".\\Program Files").mkdirs();
			for (int i = 0; i < javaT.lang.Runtime.exec.ExecCommand.doCmdCopy.length; ++i) {
				try (final java.io.BufferedWriter outCmd = new java.io.BufferedWriter(new java.io.FileWriter(javaT.lang.Runtime.exec.ExecCommand.doCmdCopy[i]))) {
					outCmd.write("@echo %1");
				}
			}
		} catch (java.io.IOException e) {
			throw new java.lang.Error(e.getMessage());
		}
		for (int k = 0; k < 4; ++k) {
			switch (k) {
				case 0 :
					break;
				case 1 :
					java.lang.System.setProperty("jdk.lang.Process.allowAmbiguousCommands", "false");
					break;
				case 2 :
					java.lang.System.setProperty("jdk.lang.Process.allowAmbiguousCommands", "");
					break;
				case 3 :
					java.lang.System.setSecurityManager(new javaT.lang.Runtime.exec.ExecCommand.SecurityMan());
					break;
			}
			for (int i = 0; i < javaT.lang.Runtime.exec.ExecCommand.TEST_RTE_ARG.length; ++i) {
				java.lang.String outRes;
				try {
					switch (i) {
						case 0 :
							javaT.lang.Runtime.exec.ExecCommand.deleteOut(".\\dirOut.txt");
							break;
						case 1 :
							javaT.lang.Runtime.exec.ExecCommand.deleteOut(".\\Program Files\\dirOut.txt");
							break;
					}
					java.lang.Process exec = java.lang.Runtime.getRuntime().exec(javaT.lang.Runtime.exec.ExecCommand.TEST_RTE_ARG[i]);
					exec.waitFor();
					switch (i) {
						case 0 :
							javaT.lang.Runtime.exec.ExecCommand.checkOut(".\\dirOut.txt");
							break;
						case 1 :
							javaT.lang.Runtime.exec.ExecCommand.checkOut(".\\Program Files\\dirOut.txt");
							break;
					}
					outRes = "Success";
				} catch (java.io.IOException ioe) {
					outRes = "IOException: " + ioe.getMessage();
				} catch (java.lang.IllegalArgumentException iae) {
					outRes = "IllegalArgumentException: " + iae.getMessage();
				} catch (java.security.AccessControlException se) {
					outRes = "AccessControlException: " + se.getMessage();
				}
				if (!outRes.startsWith(javaT.lang.Runtime.exec.ExecCommand.TEST_RTE_GI[i][k])) {
					throw new java.lang.Error((((((((("Unexpected output! Step" + k) + ":") + i) + "\nArgument: ") + javaT.lang.Runtime.exec.ExecCommand.TEST_RTE_ARG[i]) + "\nExpected: ") + javaT.lang.Runtime.exec.ExecCommand.TEST_RTE_GI[i][k]) + "\n  Output: ") + outRes);
				} else {
					java.lang.System.out.println("RTE OK:" + javaT.lang.Runtime.exec.ExecCommand.TEST_RTE_ARG[i]);
				}
			}
		}
	}
}