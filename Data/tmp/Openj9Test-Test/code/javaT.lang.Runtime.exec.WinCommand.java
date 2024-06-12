public class WinCommand {
	private static int failed = 0;

	private static void fail(java.lang.String msg) {
		java.lang.System.err.printf("FAIL: %s%n", msg);
		javaT.lang.Runtime.exec.WinCommand.failed++;
	}

	private static java.lang.String outputOf(java.lang.String... args) {
		try {
			javaT.lang.Runtime.exec.CommandRunner cr = new javaT.lang.Runtime.exec.CommandRunner(args);
			if (cr.exitValue != 0) {
				javaT.lang.Runtime.exec.WinCommand.fail("exitValue != 0");
			}
			if (!cr.err.equals("")) {
				javaT.lang.Runtime.exec.WinCommand.fail("stderr: " + cr.err);
			}
			return cr.out.replaceFirst("[\r\n]+$", "");
		} catch (java.lang.Exception e) {
			javaT.lang.Runtime.exec.WinCommand.fail(e.toString());
			return "";
		}
	}

	private static void checkCD(java.lang.String... filespecs) {
		java.lang.String firstCD = null;
		for (java.lang.String filespec : filespecs) {
			java.lang.String CD = javaT.lang.Runtime.exec.WinCommand.outputOf(filespec, "/C", "CD");
			java.lang.System.out.printf("%s CD ==> %s%n", filespec, CD);
			if (firstCD == null) {
				firstCD = CD;
				javaT.lang.Runtime.exec.WinCommand.checkDir(CD);
			}
			if (!CD.equals(firstCD)) {
				javaT.lang.Runtime.exec.WinCommand.fail("Inconsistent result from CD subcommand");
				javaT.lang.Runtime.exec.WinCommand.checkDir(CD);
			}
		}
	}

	private static void checkDir(java.lang.String dirname) {
		if (!new java.io.File(dirname).isDirectory()) {
			javaT.lang.Runtime.exec.WinCommand.fail(java.lang.String.format("Not a directory: %s%n", dirname));
		}
	}

	private static void writeFile(java.lang.String filename, java.lang.String contents) {
		try {
			java.io.FileOutputStream fos = new java.io.FileOutputStream(filename);
			fos.write(contents.getBytes());
			fos.close();
		} catch (java.lang.Exception e) {
			javaT.lang.Runtime.exec.WinCommand.fail("Unexpected exception" + e.toString());
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.io.File systemRoot = (java.lang.System.getenv("SystemRoot") != null) ? new java.io.File(java.lang.System.getenv("SystemRoot")) : java.lang.System.getenv("WINDIR") != null ? new java.io.File(java.lang.System.getenv("WINDIR")) : null;
		if ((systemRoot == null) || (!systemRoot.isDirectory())) {
			return;
		}
		java.lang.String systemDirW = new java.io.File(systemRoot, "System32").getPath();
		java.lang.String systemDirM = systemDirW.replace('\\', '/');
		java.lang.System.out.printf("systemDirW=%s%n", systemDirW);
		java.lang.System.out.printf("systemDirM=%s%n", systemDirM);
		if (new java.io.File(systemDirW, "cmd.exe").exists()) {
			try {
				java.lang.System.out.println("Running cmd.exe tests...");
				javaT.lang.Runtime.exec.WinCommand.writeFile("cdcmd.cmd", "@echo off\r\nCD\r\n");
				javaT.lang.Runtime.exec.WinCommand.writeFile("cdbat.bat", "@echo off\r\nCD\r\n");
				javaT.lang.Runtime.exec.WinCommand.checkCD("cmd", "cmd.exe", systemDirW + "\\cmd.exe", systemDirW + "\\cmd", systemDirM + "/cmd.exe", systemDirM + "/cmd", ("/" + systemDirM) + "/cmd", "cdcmd.cmd", "./cdcmd.cmd", ".\\cdcmd.cmd", "cdbat.bat", "./cdbat.bat", ".\\cdbat.bat");
			} finally {
				new java.io.File("cdcmd.cmd").delete();
				new java.io.File("cdbat.bat").delete();
			}
		}
		if (javaT.lang.Runtime.exec.WinCommand.failed > 0) {
			throw new java.lang.Exception(javaT.lang.Runtime.exec.WinCommand.failed + " tests failed");
		}
	}
}