public class ConsoleRunner {
	public static final java.lang.String property = "jline.history";

	public static void main(final java.lang.String[] args) throws java.lang.Exception {
		java.util.List<java.lang.String> argList = new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList(args));
		if (argList.size() == 0) {
			jline.console.internal.ConsoleRunner.usage();
			return;
		}
		java.lang.String historyFileName = java.lang.System.getProperty(jline.console.internal.ConsoleRunner.property, null);
		java.lang.String mainClass = argList.remove(0);
		jline.console.ConsoleReader reader = new jline.console.ConsoleReader();
		if (historyFileName != null) {
			reader.setHistory(new jline.console.history.FileHistory(new java.io.File(jline.internal.Configuration.getUserHome(), java.lang.String.format(".jline-%s.%s.history", mainClass, historyFileName))));
		} else {
			reader.setHistory(new jline.console.history.FileHistory(new java.io.File(jline.internal.Configuration.getUserHome(), java.lang.String.format(".jline-%s.history", mainClass))));
		}
		java.lang.String completors = java.lang.System.getProperty(jline.console.internal.ConsoleRunner.class.getName() + ".completers", "");
		java.util.List<jline.console.completer.Completer> completorList = new java.util.ArrayList<jline.console.completer.Completer>();
		for (java.util.StringTokenizer tok = new java.util.StringTokenizer(completors, ","); tok.hasMoreTokens();) {
			java.lang.Object obj = java.lang.Class.forName(tok.nextToken()).newInstance();
			completorList.add(((jline.console.completer.Completer) (obj)));
		}
		if (completorList.size() > 0) {
			reader.addCompleter(new jline.console.completer.ArgumentCompleter(completorList));
		}
		jline.console.internal.ConsoleReaderInputStream.setIn(reader);
		try {
			java.lang.Class<?> type = java.lang.Class.forName(mainClass);
			java.lang.reflect.Method method = type.getMethod("main", java.lang.String[].class);
			java.lang.String[] mainArgs = argList.toArray(new java.lang.String[argList.size()]);
			method.invoke(null, ((java.lang.Object) (mainArgs)));
		} finally {
			jline.console.internal.ConsoleReaderInputStream.restoreIn();
			if (reader.getHistory() instanceof jline.console.history.PersistentHistory) {
				((jline.console.history.PersistentHistory) (reader.getHistory())).flush();
			}
		}
	}

	private static void usage() {
		java.lang.System.out.println(((((("Usage: \n   java " + "[-Djline.history='name'] ") + jline.console.internal.ConsoleRunner.class.getName()) + " <target class name> [args]") + "\n\nThe -Djline.history option will avoid history") + "\nmangling when running ConsoleRunner on the same application.") + "\n\nargs will be passed directly to the target class name.");
	}
}