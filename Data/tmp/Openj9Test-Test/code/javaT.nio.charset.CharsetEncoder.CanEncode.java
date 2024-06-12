public class CanEncode {
	private static int errors = 0;

	private static java.io.PrintStream out = java.lang.System.err;

	private static void wrong(java.nio.charset.CharsetEncoder ce, boolean can, java.lang.String what) {
		javaT.nio.charset.CharsetEncoder.CanEncode.out.println((((ce.charset().name() + ": Wrong answer for ") + what) + ": ") + (!can));
		javaT.nio.charset.CharsetEncoder.CanEncode.errors++;
	}

	private static void ck(java.nio.charset.CharsetEncoder ce, char c, boolean can) throws java.lang.Exception {
		if (ce.canEncode(c) != can) {
			javaT.nio.charset.CharsetEncoder.CanEncode.wrong(ce, can, ((("'" + c) + "' (0x") + java.lang.Integer.toHexString(c & 0xffff)) + ")");
		}
	}

	private static void ck(java.nio.charset.CharsetEncoder ce, java.lang.String s, boolean can) throws java.lang.Exception {
		if (ce.canEncode(java.nio.CharBuffer.wrap(s.toCharArray())) != can) {
			javaT.nio.charset.CharsetEncoder.CanEncode.wrong(ce, can, ("array \"" + s) + "\"");
		}
		if (ce.canEncode(java.nio.CharBuffer.wrap(s)) != can) {
			javaT.nio.charset.CharsetEncoder.CanEncode.wrong(ce, can, ("buffer  \"" + s) + "\"");
		}
	}

	private static void test(java.lang.String csn) throws java.lang.Exception {
		java.nio.charset.Charset cs = java.nio.charset.Charset.forName(csn);
		java.nio.charset.CharsetEncoder ce = cs.newEncoder();
		if (cs.name().equals("US-ASCII")) {
			javaT.nio.charset.CharsetEncoder.CanEncode.ck(ce, 'x', true);
			javaT.nio.charset.CharsetEncoder.CanEncode.ck(ce, '¶', false);
			javaT.nio.charset.CharsetEncoder.CanEncode.ck(ce, "x", true);
			javaT.nio.charset.CharsetEncoder.CanEncode.ck(ce, "¶", false);
			javaT.nio.charset.CharsetEncoder.CanEncode.ck(ce, "xyzzy", true);
			javaT.nio.charset.CharsetEncoder.CanEncode.ck(ce, "xy¶", false);
		}
		javaT.nio.charset.CharsetEncoder.CanEncode.ck(ce, '?', false);
		javaT.nio.charset.CharsetEncoder.CanEncode.ck(ce, '?', false);
		javaT.nio.charset.CharsetEncoder.CanEncode.ck(ce, '?', false);
		javaT.nio.charset.CharsetEncoder.CanEncode.ck(ce, '?', false);
		javaT.nio.charset.CharsetEncoder.CanEncode.ck(ce, "?", false);
		javaT.nio.charset.CharsetEncoder.CanEncode.ck(ce, "?", false);
		javaT.nio.charset.CharsetEncoder.CanEncode.ck(ce, "?", false);
		javaT.nio.charset.CharsetEncoder.CanEncode.ck(ce, "?", false);
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.nio.charset.CharsetEncoder.CanEncode.test("US-ASCII");
		javaT.nio.charset.CharsetEncoder.CanEncode.test("UTF-8");
	}
}