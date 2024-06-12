public class Example {
	public static void usage() {
		java.lang.System.out.println(("Usage: java " + jline.example.Example.class.getName()) + " [none/simple/files/dictionary [trigger mask]]");
		java.lang.System.out.println("  none - no completors");
		java.lang.System.out.println("  simple - a simple completor that comples " + "\"foo\", \"bar\", and \"baz\"");
		java.lang.System.out.println("  files - a completor that comples " + "file names");
		java.lang.System.out.println("  classes - a completor that comples " + "java class names");
		java.lang.System.out.println("  trigger - a special word which causes it to assume " + "the next line is a password");
		java.lang.System.out.println("  mask - is the character to print in place of " + "the actual password character");
		java.lang.System.out.println("  color - colored prompt and feedback");
		java.lang.System.out.println("\n  E.g - java Example simple su \'*\'\n" + ("will use the simple compleator with \'su\' triggering\n" + "the use of '*' as a password mask."));
	}

	public static void main(java.lang.String[] args) throws java.io.IOException {
		try {
			java.lang.Character mask = null;
			java.lang.String trigger = null;
			boolean color = false;
			jline.console.ConsoleReader reader = new jline.console.ConsoleReader();
			reader.setPrompt("prompt> ");
			if ((args == null) || (args.length == 0)) {
				jline.example.Example.usage();
				return;
			}
			java.util.List<jline.console.completer.Completer> completors = new java.util.LinkedList<jline.console.completer.Completer>();
			if (args.length > 0) {
				if (args[0].equals("none")) {
				} else if (args[0].equals("files")) {
					completors.add(new jline.console.completer.FileNameCompleter());
				} else if (args[0].equals("simple")) {
					completors.add(new jline.console.completer.StringsCompleter("foo", "bar", "baz"));
				} else if (args[0].equals("color")) {
					color = true;
					reader.setPrompt("\u001b[42mfoo\u001b[0m@bar\u001b[32m@baz\u001b[0m> ");
					completors.add(new jline.console.completer.AnsiStringsCompleter("\u001b[1mfoo\u001b[0m", "bar", "\u001b[32mbaz\u001b[0m"));
					jline.console.completer.CandidateListCompletionHandler handler = new jline.console.completer.CandidateListCompletionHandler();
					handler.setStripAnsi(true);
					reader.setCompletionHandler(handler);
				} else {
					jline.example.Example.usage();
					return;
				}
			}
			if (args.length == 3) {
				mask = args[2].charAt(0);
				trigger = args[1];
			}
			for (jline.console.completer.Completer c : completors) {
				reader.addCompleter(c);
			}
			java.lang.String line;
			java.io.PrintWriter out = new java.io.PrintWriter(reader.getOutput());
			while ((line = reader.readLine()) != null) {
				if (color) {
					out.println(("\u001b[33m======>\u001b[0m\"" + line) + "\"");
				} else {
					out.println(("======>\"" + line) + "\"");
				}
				out.flush();
				if ((trigger != null) && (line.compareTo(trigger) == 0)) {
					line = reader.readLine("password> ", mask);
				}
				if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit")) {
					break;
				}
				if (line.equalsIgnoreCase("cls")) {
					reader.clearScreen();
				}
			} 
		} catch (java.lang.Throwable t) {
			t.printStackTrace();
		}
	}
}