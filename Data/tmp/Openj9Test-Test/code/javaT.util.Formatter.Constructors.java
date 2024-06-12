public class Constructors {
	private static int fail = 0;

	private static int pass = 0;

	private static java.lang.Throwable first;

	static void pass() {
		javaT.util.Formatter.Constructors.pass++;
	}

	static void fail(java.lang.String fs) {
		java.lang.String s = ("'" + fs) + "': exception not thrown";
		if (javaT.util.Formatter.Constructors.first == null) {
			javaT.util.Formatter.Constructors.first = new java.lang.RuntimeException(s);
		}
		java.lang.System.err.println("FAILED: " + s);
		javaT.util.Formatter.Constructors.fail++;
	}

	static void fail(java.lang.String fs, java.lang.Throwable ex) {
		java.lang.String s = ((("'" + fs) + "': ") + ex.getClass().getName()) + " thrown";
		if (javaT.util.Formatter.Constructors.first == null) {
			javaT.util.Formatter.Constructors.first = ex;
		}
		java.lang.System.err.println("FAILED: " + s);
		javaT.util.Formatter.Constructors.fail++;
	}

	static void locale(java.util.Formatter f) {
		javaT.util.Formatter.Constructors.locale(f, java.util.Locale.getDefault(java.util.Locale.Category.FORMAT));
	}

	static void locale(java.util.Formatter f, java.util.Locale l) {
		try {
			if (((l != null) && (!l.equals(f.locale()))) || ((l == null) && (f.locale() != null))) {
				throw new java.lang.RuntimeException((f.locale() + " != ") + l);
			}
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.RuntimeException x) {
			javaT.util.Formatter.Constructors.fail(x.getMessage());
		}
	}

	static void out(java.util.Formatter f, java.lang.Class c) {
		try {
			java.lang.Appendable a = f.out();
			if (!c.isInstance(a)) {
				throw new java.lang.RuntimeException((a.getClass().getName() + " != ") + c.getName());
			}
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.RuntimeException x) {
			javaT.util.Formatter.Constructors.fail(x.getMessage());
		}
	}

	public static void main(java.lang.String[] args) {
		try (final java.util.Formatter f = new java.util.Formatter()) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.out(f, java.lang.StringBuilder.class);
			javaT.util.Formatter.Constructors.locale(f);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter()", x);
		}
		try (final java.util.Formatter f = new java.util.Formatter(((java.lang.Appendable) (null)))) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.out(f, java.lang.StringBuilder.class);
			javaT.util.Formatter.Constructors.locale(f);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter((Appendable)null)", x);
		}
		try (final java.util.Formatter f = new java.util.Formatter(((java.util.Locale) (null)))) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.out(f, java.lang.StringBuilder.class);
			javaT.util.Formatter.Constructors.locale(f, null);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter((Locale)null)", x);
		}
		try (final java.util.Formatter f = new java.util.Formatter(((java.lang.Appendable) (null)), ((java.util.Locale) (null)))) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.out(f, java.lang.StringBuilder.class);
			javaT.util.Formatter.Constructors.locale(f, null);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter((Appendable) null, (Locale) null)", x);
		}
		try (final java.util.Formatter f = new java.util.Formatter("foo")) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.out(f, java.io.BufferedWriter.class);
			javaT.util.Formatter.Constructors.locale(f);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(\"foo\")", x);
		}
		try {
			new java.util.Formatter(((java.lang.String) (null)));
			javaT.util.Formatter.Constructors.fail("new Formatter((String)null)");
		} catch (java.lang.NullPointerException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter((String)null)", x);
		}
		try (final java.util.Formatter f = new java.util.Formatter("foo", "UTF-8")) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.out(f, java.io.BufferedWriter.class);
			javaT.util.Formatter.Constructors.locale(f);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(\"foo\", \"UTF-8\")", x);
		}
		try {
			new java.util.Formatter("foo", "bar");
			javaT.util.Formatter.Constructors.fail("new Formatter(\"foo\", \"bar\")");
		} catch (java.io.UnsupportedEncodingException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(\"foo\", \"bar\")", x);
		}
		try {
			new java.util.Formatter(".", "bar");
			javaT.util.Formatter.Constructors.fail("new Formatter(\".\", \"bar\")");
		} catch (java.io.FileNotFoundException | java.io.UnsupportedEncodingException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(\".\", \"bar\")", x);
		}
		try (final java.util.Formatter f = new java.util.Formatter("foo", "ISO-8859-1", java.util.Locale.GERMANY)) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.out(f, java.io.BufferedWriter.class);
			javaT.util.Formatter.Constructors.locale(f, java.util.Locale.GERMANY);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(\"foo\", \"ISO-8859-1\", Locale.GERMANY)", x);
		}
		try (final java.util.Formatter f = new java.util.Formatter("foo", "ISO-8859-1", null)) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.locale(f, null);
			javaT.util.Formatter.Constructors.out(f, java.io.BufferedWriter.class);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(\"foo\", \"ISO-8859-1\", null)", x);
		}
		try (final java.util.Formatter f = new java.util.Formatter(new java.io.File("foo"))) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.locale(f);
			javaT.util.Formatter.Constructors.out(f, java.io.BufferedWriter.class);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new File(\"foo\")", x);
		}
		try {
			new java.util.Formatter(((java.io.File) (null)));
			javaT.util.Formatter.Constructors.fail("new Formatter((File)null)");
		} catch (java.lang.NullPointerException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter((File)null)", x);
		}
		try {
			java.util.Formatter f = new java.util.Formatter(java.lang.System.out);
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.out(f, java.io.PrintStream.class);
			javaT.util.Formatter.Constructors.locale(f);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(System.out)", x);
		}
		try {
			new java.util.Formatter(((java.io.PrintStream) (null)));
			javaT.util.Formatter.Constructors.fail("new Formatter((PrintStream) null)");
		} catch (java.lang.NullPointerException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter((PrintStream) null)", x);
		}
		try (final java.util.Formatter f = new java.util.Formatter(new java.io.PrintStream("foo"))) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.locale(f);
			javaT.util.Formatter.Constructors.out(f, java.io.PrintStream.class);
		} catch (java.io.FileNotFoundException x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\")", x);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\")", x);
		}
		try (final java.util.Formatter f = new java.util.Formatter(new java.io.PrintStream("foo"), java.util.Locale.JAPANESE)) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.locale(f, java.util.Locale.JAPANESE);
			javaT.util.Formatter.Constructors.out(f, java.io.PrintStream.class);
		} catch (java.io.FileNotFoundException x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\")", x);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\")", x);
		}
		try (final java.io.PrintStream ps = new java.io.PrintStream("foo")) {
			new java.util.Formatter(ps, ((java.lang.String) (null)));
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), (String)null)");
		} catch (java.io.FileNotFoundException x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), (String)null)", x);
		} catch (java.lang.NullPointerException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.io.UnsupportedEncodingException x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), (String)null)", x);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), (String)null)", x);
		}
		try (final java.util.Formatter f = new java.util.Formatter(new java.io.PrintStream("foo"), ((java.util.Locale) (null)))) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.locale(f, null);
			javaT.util.Formatter.Constructors.out(f, java.io.PrintStream.class);
		} catch (java.io.FileNotFoundException x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), (Locale)null)", x);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), (Locale)null)", x);
		}
		try (final java.util.Formatter f = new java.util.Formatter(new java.io.PrintStream("foo"), java.util.Locale.KOREAN)) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.locale(f, java.util.Locale.KOREAN);
			javaT.util.Formatter.Constructors.out(f, java.io.PrintStream.class);
		} catch (java.io.FileNotFoundException x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), Locale.KOREAN)", x);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), Locale.KOREAN)", x);
		}
		try (final java.util.Formatter f = new java.util.Formatter(new java.io.PrintStream("foo"), "UTF-16BE", null)) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.locale(f, null);
			javaT.util.Formatter.Constructors.out(f, java.io.BufferedWriter.class);
		} catch (java.io.FileNotFoundException x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), \"UTF-16BE\", null");
		} catch (java.io.UnsupportedEncodingException x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), \"UTF-16BE\", null");
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), \"UTF-16BE\", null");
		}
		try (final java.util.Formatter f = new java.util.Formatter(new java.io.PrintStream("foo"), "UTF-16BE", java.util.Locale.ITALIAN)) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.locale(f, java.util.Locale.ITALIAN);
			javaT.util.Formatter.Constructors.out(f, java.io.BufferedWriter.class);
		} catch (java.io.FileNotFoundException x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), \"UTF-16BE\", Locale.ITALIAN");
		} catch (java.io.UnsupportedEncodingException x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), \"UTF-16BE\", Locale.ITALIAN");
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), \"UTF-16BE\", Locale.ITALIAN");
		}
		java.lang.String csn = (java.nio.charset.Charset.defaultCharset().newEncoder().canEncode('£')) ? "ASCII" : "ISO-8859-1";
		try {
			java.io.ByteArrayOutputStream[] bs = new java.io.ByteArrayOutputStream[]{ new java.io.ByteArrayOutputStream(), new java.io.ByteArrayOutputStream(), new java.io.ByteArrayOutputStream() };
			new java.util.Formatter(((java.lang.Appendable) (new java.io.PrintStream(bs[0], true, csn)))).format("£");
			new java.util.Formatter(((java.io.OutputStream) (new java.io.PrintStream(bs[1], true, csn)))).format("£");
			new java.util.Formatter(new java.io.PrintStream(bs[2], true, csn)).format("£");
			if (java.util.Arrays.equals(bs[0].toByteArray(), bs[1].toByteArray())) {
				javaT.util.Formatter.Constructors.fail("arrays shouldn't match: " + bs[0].toByteArray());
			} else {
				javaT.util.Formatter.Constructors.pass();
			}
			if (!java.util.Arrays.equals(bs[0].toByteArray(), bs[2].toByteArray())) {
				javaT.util.Formatter.Constructors.fail((("arrays should match: " + bs[0].toByteArray()) + " != ") + bs[2].toByteArray());
			} else {
				javaT.util.Formatter.Constructors.pass();
			}
		} catch (java.io.UnsupportedEncodingException x) {
			javaT.util.Formatter.Constructors.fail(("new PrintStream(newByteArrayOutputStream, true, " + csn) + ")", x);
		}
		try {
			new java.util.Formatter(((java.io.OutputStream) (null)));
			javaT.util.Formatter.Constructors.fail("new Formatter((OutputStream) null)");
		} catch (java.lang.NullPointerException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter((OutputStream) null)", x);
		}
		try (final java.util.Formatter f = new java.util.Formatter(((java.io.OutputStream) (new java.io.PrintStream("foo"))))) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.locale(f);
			javaT.util.Formatter.Constructors.out(f, java.io.BufferedWriter.class);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter((OutputStream) new PrintStream(\"foo\")", x);
		}
		try {
			new java.util.Formatter(((java.io.OutputStream) (null)), "ISO-8859-1");
			javaT.util.Formatter.Constructors.fail("new Formatter((OutputStream) null, \"ISO-8859-1\")");
		} catch (java.lang.NullPointerException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter((OutputStream) null, \"ISO-8859-1\")", x);
		}
		try (final java.io.PrintStream ps = new java.io.PrintStream("foo")) {
			new java.util.Formatter(((java.io.OutputStream) (ps)), null);
			javaT.util.Formatter.Constructors.fail("new Formatter((OutputStream) new PrintStream(\"foo\"), null");
		} catch (java.lang.NullPointerException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter((OutputStream) new PrintStream(\"foo\"), null", x);
		}
		try (final java.io.PrintStream ps = new java.io.PrintStream("foo")) {
			new java.util.Formatter(ps, "bar");
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), \"bar\")");
		} catch (java.io.UnsupportedEncodingException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), \"bar\")", x);
		}
		try (final java.util.Formatter f = new java.util.Formatter(new java.io.PrintStream("foo"), "UTF-8")) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.locale(f);
			javaT.util.Formatter.Constructors.out(f, java.io.BufferedWriter.class);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), \"UTF-8\")", x);
		}
		try {
			new java.util.Formatter(((java.io.OutputStream) (null)), "ISO-8859-1", java.util.Locale.UK);
			javaT.util.Formatter.Constructors.fail("new Formatter((OutputStream) null, \"ISO-8859-1\", Locale.UK)");
		} catch (java.lang.NullPointerException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter((OutputStream) null, \"ISO-8859-1\", Locale.UK)", x);
		}
		try (final java.io.PrintStream ps = new java.io.PrintStream("foo")) {
			new java.util.Formatter(ps, null, java.util.Locale.UK);
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), null, Locale.UK)");
		} catch (java.lang.NullPointerException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), null, Locale.UK)", x);
		}
		try (final java.io.PrintStream ps = new java.io.PrintStream("foo")) {
			new java.util.Formatter(ps, "bar", java.util.Locale.UK);
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), \"bar\", Locale.UK)");
		} catch (java.io.UnsupportedEncodingException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), \"bar\", Locale.UK)", x);
		}
		try (final java.util.Formatter f = new java.util.Formatter(new java.io.PrintStream("foo"), "UTF-8", java.util.Locale.UK)) {
			javaT.util.Formatter.Constructors.pass();
			javaT.util.Formatter.Constructors.out(f, java.io.BufferedWriter.class);
			javaT.util.Formatter.Constructors.locale(f, java.util.Locale.UK);
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new Formatter(new PrintStream(\"foo\"), \"UTF-8\"), Locale.UK", x);
		}
		try (final java.io.PrintStream ps = new java.io.PrintStream("foo")) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new PrintStream(\"foo\")", x);
		}
		try {
			new java.io.PrintStream("foo", null);
			javaT.util.Formatter.Constructors.fail("new PrintStream(\"foo\", null)");
		} catch (java.lang.NullPointerException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new PrintStream(\"foo\", null)", x);
		}
		try (final java.io.PrintStream ps = new java.io.PrintStream(new java.io.File("foo"))) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new PrintStream(new File(\"foo\"))", x);
		}
		try {
			new java.io.PrintStream(new java.io.File("foo"), null);
			javaT.util.Formatter.Constructors.fail("new PrintStream(new File(\"foo\"), null)");
		} catch (java.lang.NullPointerException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new PrintStream(new File(\"foo\"), null)", x);
		}
		try (final java.io.PrintWriter pw = new java.io.PrintWriter("foo")) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new PrintWriter(\"foo\")", x);
		}
		try {
			new java.io.PrintWriter("foo", null);
			javaT.util.Formatter.Constructors.fail("new PrintWriter(\"foo\"), null");
		} catch (java.lang.NullPointerException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new PrintWriter(\"foo\"), null", x);
		}
		try (final java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.File("foo"))) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new PrintWriter(new File(\"foo\"))", x);
		}
		try {
			new java.io.PrintWriter(new java.io.File("foo"), null);
			javaT.util.Formatter.Constructors.fail("new PrintWriter(new File(\"foo\")), null");
		} catch (java.lang.NullPointerException x) {
			javaT.util.Formatter.Constructors.pass();
		} catch (java.lang.Exception x) {
			javaT.util.Formatter.Constructors.fail("new PrintWriter(new File(\"foo\")), null", x);
		}
		if (javaT.util.Formatter.Constructors.fail != 0) {
			throw new java.lang.RuntimeException((((javaT.util.Formatter.Constructors.fail + javaT.util.Formatter.Constructors.pass) + " tests: ") + javaT.util.Formatter.Constructors.fail) + " failure(s), first", javaT.util.Formatter.Constructors.first);
		} else {
			java.lang.System.out.println(("all " + (javaT.util.Formatter.Constructors.fail + javaT.util.Formatter.Constructors.pass)) + " tests passed");
		}
	}
}