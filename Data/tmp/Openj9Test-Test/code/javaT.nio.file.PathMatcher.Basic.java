public class Basic {
	static int failures;

	static void match(java.lang.String name, java.lang.String pattern, boolean expectedToMatch) {
		java.lang.System.out.format("%s -> %s", name, pattern);
		java.nio.file.Path file = java.nio.file.Paths.get(name);
		boolean matched = file.getFileSystem().getPathMatcher("glob:" + pattern).matches(file);
		if (matched) {
			java.lang.System.out.print(" (matched)");
		} else {
			java.lang.System.out.print(" (no match)");
		}
		if (matched != expectedToMatch) {
			java.lang.System.out.println(" ==> UNEXPECTED RESULT!");
			javaT.nio.file.PathMatcher.Basic.failures++;
		} else {
			java.lang.System.out.println(" OKAY");
		}
	}

	static void assertMatch(java.lang.String path, java.lang.String pattern) {
		javaT.nio.file.PathMatcher.Basic.match(path, pattern, true);
	}

	static void assertNotMatch(java.lang.String path, java.lang.String pattern) {
		javaT.nio.file.PathMatcher.Basic.match(path, pattern, false);
	}

	static void assertBadPattern(java.lang.String path, java.lang.String pattern) {
		java.lang.System.out.format("Compile bad pattern %s\t", pattern);
		try {
			java.nio.file.FileSystems.getDefault().getPathMatcher("glob:" + pattern);
			java.lang.System.out.println("Compiled ==> UNEXPECTED RESULT!");
			javaT.nio.file.PathMatcher.Basic.failures++;
		} catch (java.util.regex.PatternSyntaxException e) {
			java.lang.System.out.println("Failed to compile ==> OKAY");
		}
	}

	static void assertRegExMatch(java.lang.String path, java.lang.String pattern) {
		java.lang.System.out.format("Test regex pattern: %s", pattern);
		java.nio.file.Path file = java.nio.file.Paths.get(path);
		boolean matched = file.getFileSystem().getPathMatcher("regex:" + pattern).matches(file);
		if (matched) {
			java.lang.System.out.println(" OKAY");
		} else {
			java.lang.System.out.println(" ==> UNEXPECTED RESULT!");
			javaT.nio.file.PathMatcher.Basic.failures++;
		}
	}

	public static void main(java.lang.String[] args) {
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "foo.html");
		javaT.nio.file.PathMatcher.Basic.assertNotMatch("foo.html", "foo.htm");
		javaT.nio.file.PathMatcher.Basic.assertNotMatch("foo.html", "bar.html");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "f*");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "*.html");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "foo.html*");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "*foo.html");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "*foo.html*");
		javaT.nio.file.PathMatcher.Basic.assertNotMatch("foo.html", "*.htm");
		javaT.nio.file.PathMatcher.Basic.assertNotMatch("foo.html", "f.*");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "?oo.html");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "??o.html");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "???.html");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "???.htm?");
		javaT.nio.file.PathMatcher.Basic.assertNotMatch("foo.html", "foo.???");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "foo{.html,.class}");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "foo.{class,html}");
		javaT.nio.file.PathMatcher.Basic.assertNotMatch("foo.html", "foo{.htm,.class}");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "[f]oo.html");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "[e-g]oo.html");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "[abcde-g]oo.html");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "[abcdefx-z]oo.html");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "[!a]oo.html");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "[!a-e]oo.html");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo-bar", "foo[-a-z]bar");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "foo[!-]html");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "[f]oo.{[h]tml,class}");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "foo.{[a-z]tml,class}");
		javaT.nio.file.PathMatcher.Basic.assertMatch("foo.html", "foo.{[!a-e]tml,.class}");
		javaT.nio.file.PathMatcher.Basic.assertMatch("{foo}.html", "\\{foo*");
		javaT.nio.file.PathMatcher.Basic.assertMatch("{foo}.html", "*\\}.html");
		javaT.nio.file.PathMatcher.Basic.assertMatch("[foo].html", "\\[foo*");
		javaT.nio.file.PathMatcher.Basic.assertMatch("[foo].html", "*\\].html");
		javaT.nio.file.PathMatcher.Basic.assertBadPattern("foo.html", "*[a--z]");
		javaT.nio.file.PathMatcher.Basic.assertBadPattern("foo.html", "*[a--]");
		javaT.nio.file.PathMatcher.Basic.assertBadPattern("foo.html", "*[a-z");
		javaT.nio.file.PathMatcher.Basic.assertBadPattern("foo.html", "*{class,java");
		javaT.nio.file.PathMatcher.Basic.assertBadPattern("foo.html", "*.{class,{.java}}");
		javaT.nio.file.PathMatcher.Basic.assertBadPattern("foo.html", "*.html\\");
		if (java.lang.System.getProperty("os.name").startsWith("Windows")) {
			javaT.nio.file.PathMatcher.Basic.assertMatch("C:\\foo", "C:\\\\f*");
			javaT.nio.file.PathMatcher.Basic.assertMatch("C:\\FOO", "c:\\\\f*");
			javaT.nio.file.PathMatcher.Basic.assertMatch("C:\\foo\\bar\\gus", "C:\\\\**\\\\gus");
			javaT.nio.file.PathMatcher.Basic.assertMatch("C:\\foo\\bar\\gus", "C:\\\\**");
		} else {
			javaT.nio.file.PathMatcher.Basic.assertMatch("/tmp/foo", "/tmp/*");
			javaT.nio.file.PathMatcher.Basic.assertMatch("/tmp/foo/bar", "/tmp/**");
			javaT.nio.file.PathMatcher.Basic.assertMatch("myfile?", "myfile\\?");
			javaT.nio.file.PathMatcher.Basic.assertMatch("one\\two", "one\\\\two");
			javaT.nio.file.PathMatcher.Basic.assertMatch("one*two", "one\\*two");
		}
		javaT.nio.file.PathMatcher.Basic.assertRegExMatch("foo.html", ".*\\.html");
		if (java.lang.System.getProperty("os.name").startsWith("Windows")) {
			javaT.nio.file.PathMatcher.Basic.assertRegExMatch("foo012", "foo\\d+");
			javaT.nio.file.PathMatcher.Basic.assertRegExMatch("fo o", "fo\\so");
			javaT.nio.file.PathMatcher.Basic.assertRegExMatch("foo", "\\w+");
		}
		try {
			java.lang.System.out.format("Test unknown syntax");
			java.nio.file.FileSystems.getDefault().getPathMatcher("grep:foo");
			java.lang.System.out.println(" ==> NOT EXPECTED TO COMPILE");
			javaT.nio.file.PathMatcher.Basic.failures++;
		} catch (java.lang.UnsupportedOperationException e) {
			java.lang.System.out.println(" OKAY");
		}
		if (javaT.nio.file.PathMatcher.Basic.failures > 0) {
			throw new java.lang.RuntimeException(javaT.nio.file.PathMatcher.Basic.failures + " sub-test(s) failed - see log for details");
		}
	}
}