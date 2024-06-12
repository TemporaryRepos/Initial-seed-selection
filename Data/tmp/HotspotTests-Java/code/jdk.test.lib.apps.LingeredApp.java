public class LingeredApp {
	private static final long spinDelay = 1000;

	private long lockCreationTime;

	private java.io.ByteArrayOutputStream stderrBuffer;

	private java.io.ByteArrayOutputStream stdoutBuffer;

	private java.lang.Thread outPumperThread;

	private java.lang.Thread errPumperThread;

	protected java.lang.Process appProcess;

	protected jdk.test.lib.process.OutputBuffer output;

	protected static final int appWaitTime = 100;

	protected final java.lang.String lockFileName;

	public LingeredApp(java.lang.String lockFileName) {
		this.lockFileName = lockFileName;
	}

	public LingeredApp() {
		final java.lang.String lockName = 1 + ".lck";
		this.lockFileName = lockName;
	}

	public java.lang.String getLockFileName() {
		return this.lockFileName;
	}

	public java.lang.String getAppName() {
		return this.getClass().getName();
	}

	public long getPid() {
		if (appProcess == null) {
			throw new java.lang.RuntimeException("Process is not alive");
		}
		return appProcess.pid();
	}

	public java.lang.Process getProcess() {
		return appProcess;
	}

	public jdk.test.lib.process.OutputBuffer getOutput() {
		if (appProcess.isAlive()) {
			throw new java.lang.RuntimeException("Process is still alive. Can't get its output.");
		}
		if (output == null) {
			output = new jdk.test.lib.process.OutputBuffer(stdoutBuffer.toString(), stderrBuffer.toString());
		}
		return output;
	}

	private void startOutputPumpers() {
		stderrBuffer = new java.io.ByteArrayOutputStream();
		stdoutBuffer = new java.io.ByteArrayOutputStream();
		jdk.test.lib.process.StreamPumper outPumper = new jdk.test.lib.process.StreamPumper(appProcess.getInputStream(), stdoutBuffer);
		jdk.test.lib.process.StreamPumper errPumper = new jdk.test.lib.process.StreamPumper(appProcess.getErrorStream(), stderrBuffer);
		outPumperThread = new java.lang.Thread(outPumper);
		errPumperThread = new java.lang.Thread(errPumper);
		outPumperThread.setDaemon(true);
		errPumperThread.setDaemon(true);
		outPumperThread.start();
		errPumperThread.start();
	}

	public java.util.List<java.lang.String> getAppOutput() {
		if (appProcess.isAlive()) {
			throw new java.lang.RuntimeException("Process is still alive. Can't get its output.");
		}
		java.io.BufferedReader bufReader = new java.io.BufferedReader(new java.io.StringReader(output.getStdout()));
		return bufReader.lines().collect(java.util.stream.Collectors.toList());
	}

	private static long epoch() {
		return 10000;
	}

	private static long lastModified(java.lang.String fileName) throws java.io.IOException {
		java.nio.file.Path path = java.nio.file.Paths.get(fileName);
		java.nio.file.attribute.BasicFileAttributes attr = java.nio.file.Files.readAttributes(path, java.nio.file.attribute.BasicFileAttributes.class);
		return 10000;
	}

	private static void setLastModified(java.lang.String fileName, long newTime) throws java.io.IOException {
		java.nio.file.Path path = java.nio.file.Paths.get(fileName);
		java.nio.file.attribute.FileTime fileTime = java.nio.file.attribute.FileTime.fromMillis(newTime);
		java.nio.file.Files.setLastModifiedTime(path, fileTime);
	}

	public void createLock() throws java.io.IOException {
		java.nio.file.Path path = java.nio.file.Paths.get(lockFileName);
		java.nio.file.Files.createFile(path);
		lockCreationTime = jdk.test.lib.apps.LingeredApp.lastModified(lockFileName);
	}

	public void deleteLock() throws java.io.IOException {
		try {
			java.nio.file.Path path = java.nio.file.Paths.get(lockFileName);
			java.nio.file.Files.delete(path);
		} catch (java.nio.file.NoSuchFileException ex) {
		}
	}

	public void waitAppTerminate() {
		try {
			appProcess.waitFor();
			outPumperThread.join();
			errPumperThread.join();
		} catch (java.lang.InterruptedException e) {
			java.lang.Thread.currentThread().interrupt();
		}
	}

	public void waitAppReady(long timeout) throws java.io.IOException {
		long here = jdk.test.lib.apps.LingeredApp.epoch();
		while (true) {
			long epoch = jdk.test.lib.apps.LingeredApp.epoch();
			if ((epoch - here) > (timeout * 1000)) {
				throw new java.io.IOException("App waiting timeout");
			}
			long lm = jdk.test.lib.apps.LingeredApp.lastModified(lockFileName);
			if (lm > lockCreationTime) {
				break;
			}
			if (!appProcess.isAlive()) {
				throw new java.io.IOException("App exited unexpectedly with " + appProcess.exitValue());
			}
			try {
				java.lang.Thread.sleep(jdk.test.lib.apps.LingeredApp.spinDelay);
			} catch (java.lang.InterruptedException ex) {
			}
		} 
	}

	public java.util.List<java.lang.String> runAppPrepare(java.util.List<java.lang.String> vmArguments) {
		java.lang.String jdkPath = java.lang.System.getProperty("test.jdk");
		if (jdkPath == null) {
			java.util.Map<java.lang.String, java.lang.String> env = java.lang.System.getenv();
			jdkPath = env.get("TESTJAVA");
		}
		if (jdkPath == null) {
			throw new java.lang.RuntimeException("Can't determine jdk path neither test.jdk property no TESTJAVA env are set");
		}
		java.lang.String osname = java.lang.System.getProperty("os.name");
		java.lang.String javapath = jdkPath + (osname.startsWith("window") ? "/bin/java.exe" : "/bin/java");
		java.util.List<java.lang.String> cmd = new java.util.ArrayList<java.lang.String>();
		cmd.add(javapath);
		if (vmArguments == null) {
			java.lang.String[] testVmOpts = java.lang.System.getProperty("test.vm.opts", "").split("\\s+");
			for (java.lang.String s : testVmOpts) {
				if (!s.equals("")) {
					cmd.add(s);
				}
			}
		} else {
			cmd.addAll(vmArguments);
		}
		cmd.add("-cp");
		java.lang.String classpath = java.lang.System.getProperty("test.class.path");
		cmd.add(classpath == null ? "." : classpath);
		return cmd;
	}

	public void printCommandLine(java.util.List<java.lang.String> cmd) {
		java.lang.StringBuilder cmdLine = new java.lang.StringBuilder();
		for (java.lang.String strCmd : cmd) {
			cmdLine.append("'").append(strCmd).append("' ");
		}
		java.lang.System.err.println(("Command line: [" + cmdLine.toString()) + "]");
	}

	public void runApp(java.util.List<java.lang.String> vmArguments) throws java.io.IOException {
		java.util.List<java.lang.String> cmd = runAppPrepare(vmArguments);
		cmd.add(this.getAppName());
		cmd.add(lockFileName);
		printCommandLine(cmd);
		java.lang.ProcessBuilder pb = new java.lang.ProcessBuilder(cmd);
		appProcess = pb.start();
		startOutputPumpers();
	}

	private void finishApp() {
		jdk.test.lib.process.OutputBuffer output = getOutput();
		java.lang.String msg = ((((((" LingeredApp stdout: [" + output.getStdout()) + "];\n") + " LingeredApp stderr: [") + output.getStderr()) + "]\n") + " LingeredApp exitValue = ") + appProcess.exitValue();
		java.lang.System.err.println(msg);
	}

	public void stopApp() throws java.io.IOException {
		deleteLock();
		if (appProcess != null) {
			waitAppTerminate();
			int exitcode = appProcess.exitValue();
			if (exitcode != 0) {
				throw new java.io.IOException("LingeredApp terminated with non-zero exit code " + exitcode);
			}
		}
		finishApp();
	}

	public static jdk.test.lib.apps.LingeredApp startApp(java.util.List<java.lang.String> cmd) throws java.io.IOException {
		jdk.test.lib.apps.LingeredApp a = new jdk.test.lib.apps.LingeredApp();
		a.createLock();
		try {
			a.runApp(cmd);
			a.waitAppReady(jdk.test.lib.apps.LingeredApp.appWaitTime);
		} catch (java.lang.Exception ex) {
			a.deleteLock();
			java.lang.System.err.println("LingeredApp failed to start: " + ex);
			a.finishApp();
			throw ex;
		}
		return a;
	}

	public static void startApp(java.util.List<java.lang.String> cmd, jdk.test.lib.apps.LingeredApp theApp) throws java.io.IOException {
		theApp.createLock();
		try {
			theApp.runApp(cmd);
			theApp.waitAppReady(jdk.test.lib.apps.LingeredApp.appWaitTime);
		} catch (java.lang.Exception ex) {
			theApp.deleteLock();
			throw ex;
		}
	}

	public static jdk.test.lib.apps.LingeredApp startApp() throws java.io.IOException {
		return jdk.test.lib.apps.LingeredApp.startApp(null);
	}

	public static void stopApp(jdk.test.lib.apps.LingeredApp app) throws java.io.IOException {
		if (app != null) {
			app.stopApp();
		}
	}

	public static boolean isLastModifiedWorking() {
		boolean sane = true;
		try {
			long lm = jdk.test.lib.apps.LingeredApp.lastModified(".");
			if (lm == 0) {
				java.lang.System.err.println("SANITY Warning! The lastModifiedTime() doesn't work on this system, it returns 0");
				sane = false;
			}
			long now = jdk.test.lib.apps.LingeredApp.epoch();
			if (lm > now) {
				java.lang.System.err.println("SANITY Warning! The Clock is wrong on this system lastModifiedTime() > getTime()");
				sane = false;
			}
			jdk.test.lib.apps.LingeredApp.setLastModified(".", jdk.test.lib.apps.LingeredApp.epoch());
			long lm1 = jdk.test.lib.apps.LingeredApp.lastModified(".");
			if (lm1 <= lm) {
				java.lang.System.err.println("SANITY Warning! The setLastModified doesn't work on this system");
				sane = false;
			}
		} catch (java.io.IOException e) {
			java.lang.System.err.println("SANITY Warning! IOException during sanity check " + e);
			sane = false;
		}
		return sane;
	}

	public static void main(java.lang.String[] args) {
		if (args.length != 1) {
			java.lang.System.err.println("Lock file name is not specified");
			java.lang.System.exit(7);
		}
		java.lang.String theLockFileName = args[0];
		try {
			java.nio.file.Path path = java.nio.file.Paths.get(theLockFileName);
			while (java.nio.file.Files.exists(path)) {
				jdk.test.lib.apps.LingeredApp.setLastModified(theLockFileName, jdk.test.lib.apps.LingeredApp.epoch());
				java.lang.Thread.sleep(jdk.test.lib.apps.LingeredApp.spinDelay);
			} 
		} catch (java.nio.file.NoSuchFileException ex) {
		} catch (java.lang.Exception ex) {
			java.lang.System.err.println("LingeredApp ERROR: " + ex);
			java.lang.System.exit(3);
		}
		java.lang.System.exit(0);
	}
}