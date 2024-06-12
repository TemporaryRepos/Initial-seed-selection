public class Zombies {
	static final java.lang.String os = java.lang.System.getProperty("os.name");

	static final java.lang.String TrueCommand = (javaT.lang.ProcessBuilder.Zombies.os.contains("OS X")) ? "/usr/bin/true" : "/bin/true";

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		if ((!new java.io.File("/usr/bin/perl").canExecute()) || (!new java.io.File("/bin/ps").canExecute())) {
			return;
		}
		java.lang.System.out.println("Looks like a Unix system.");
		final java.lang.Runtime rt = java.lang.Runtime.getRuntime();
		try {
			rt.exec("no-such-file");
			throw new java.lang.Error("expected IOException not thrown");
		} catch (java.io.IOException _) {
		}
		try {
			rt.exec(".");
			throw new java.lang.Error("expected IOException not thrown");
		} catch (java.io.IOException _) {
		}
		try {
			rt.exec(javaT.lang.ProcessBuilder.Zombies.TrueCommand, null, new java.io.File("no-such-dir"));
			throw new java.lang.Error("expected IOException not thrown");
		} catch (java.io.IOException _) {
		}
		rt.exec(javaT.lang.ProcessBuilder.Zombies.TrueCommand).waitFor();
		final java.lang.String[] zombieCounter = new java.lang.String[]{ "/usr/bin/perl", "-e", "exit @{[`/bin/ps -eo ppid,s` =~ /^ *@{[getppid]} +Z$/mog]}" };
		int zombies = rt.exec(zombieCounter).waitFor();
		if (zombies != 0) {
			throw new java.lang.Error(zombies + " zombies!");
		}
	}
}