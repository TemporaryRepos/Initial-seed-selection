public class Constructors {
	private static java.lang.Class NPE = java.lang.NullPointerException.class;

	private static int fail = 0;

	private static int pass = 0;

	private static java.lang.Throwable first;

	private static void pass() {
		javaT.util.IllegalFormatException.Constructors.pass++;
	}

	private static void fail(java.lang.Throwable t, java.lang.Class c) {
		java.lang.String s = (t.getClass().getName() + " constructor did not throw ") + c.getName();
		if (javaT.util.IllegalFormatException.Constructors.first == null) {
			javaT.util.IllegalFormatException.Constructors.first = new java.lang.RuntimeException(s);
		}
		java.lang.System.err.println("FAILED: " + s);
		javaT.util.IllegalFormatException.Constructors.fail++;
	}

	private static void nullTests() {
		java.util.IllegalFormatException ex;
		try {
			ex = new java.util.DuplicateFormatFlagsException(null);
			javaT.util.IllegalFormatException.Constructors.fail(ex, javaT.util.IllegalFormatException.Constructors.NPE);
		} catch (java.lang.NullPointerException x) {
			javaT.util.IllegalFormatException.Constructors.pass();
		}
		try {
			ex = new java.util.FormatFlagsConversionMismatchException(null, 'a');
			javaT.util.IllegalFormatException.Constructors.fail(ex, javaT.util.IllegalFormatException.Constructors.NPE);
		} catch (java.lang.NullPointerException x) {
			javaT.util.IllegalFormatException.Constructors.pass();
		}
		try {
			ex = new java.util.IllegalFormatConversionException('b', null);
			javaT.util.IllegalFormatException.Constructors.fail(ex, javaT.util.IllegalFormatException.Constructors.NPE);
		} catch (java.lang.NullPointerException x) {
			javaT.util.IllegalFormatException.Constructors.pass();
		}
		try {
			ex = new java.util.IllegalFormatFlagsException(null);
			javaT.util.IllegalFormatException.Constructors.fail(ex, javaT.util.IllegalFormatException.Constructors.NPE);
		} catch (java.lang.NullPointerException x) {
			javaT.util.IllegalFormatException.Constructors.pass();
		}
		try {
			ex = new java.util.MissingFormatArgumentException(null);
			javaT.util.IllegalFormatException.Constructors.fail(ex, javaT.util.IllegalFormatException.Constructors.NPE);
		} catch (java.lang.NullPointerException x) {
			javaT.util.IllegalFormatException.Constructors.pass();
		}
		try {
			ex = new java.util.MissingFormatWidthException(null);
			javaT.util.IllegalFormatException.Constructors.fail(ex, javaT.util.IllegalFormatException.Constructors.NPE);
		} catch (java.lang.NullPointerException x) {
			javaT.util.IllegalFormatException.Constructors.pass();
		}
		try {
			ex = new java.util.UnknownFormatConversionException(null);
			javaT.util.IllegalFormatException.Constructors.fail(ex, javaT.util.IllegalFormatException.Constructors.NPE);
		} catch (java.lang.NullPointerException x) {
			javaT.util.IllegalFormatException.Constructors.pass();
		}
		try {
			ex = new java.util.UnknownFormatFlagsException(null);
			javaT.util.IllegalFormatException.Constructors.fail(ex, javaT.util.IllegalFormatException.Constructors.NPE);
		} catch (java.lang.NullPointerException x) {
			javaT.util.IllegalFormatException.Constructors.pass();
		}
	}

	public static void main(java.lang.String[] args) {
		javaT.util.IllegalFormatException.Constructors.nullTests();
		if (javaT.util.IllegalFormatException.Constructors.fail != 0) {
			throw new java.lang.RuntimeException((((javaT.util.IllegalFormatException.Constructors.fail + javaT.util.IllegalFormatException.Constructors.pass) + " tests: ") + javaT.util.IllegalFormatException.Constructors.fail) + " failure(s), first", javaT.util.IllegalFormatException.Constructors.first);
		} else {
			java.lang.System.out.println(("all " + (javaT.util.IllegalFormatException.Constructors.fail + javaT.util.IllegalFormatException.Constructors.pass)) + " tests passed");
		}
	}
}