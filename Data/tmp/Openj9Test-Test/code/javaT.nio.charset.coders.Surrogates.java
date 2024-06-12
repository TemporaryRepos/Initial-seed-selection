public class Surrogates {
	static java.io.PrintStream log = java.lang.System.err;

	static char[] input;

	static byte[] output;

	static final int LEN = 128;

	static void initData() throws java.io.IOException {
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		for (int i = 0; i < javaT.nio.charset.coders.Surrogates.LEN; i++) {
			int c = java.lang.Character.MIN_SUPPLEMENTARY_CODE_POINT + 1;
			sb.append(java.lang.Character.toChars(c));
		}
		javaT.nio.charset.coders.Surrogates.input = sb.toString().toCharArray();
		java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
		java.io.OutputStreamWriter osw = new java.io.OutputStreamWriter(bos, java.nio.charset.Charset.forName("UTF-8"));
		osw.write(javaT.nio.charset.coders.Surrogates.input);
		osw.close();
		javaT.nio.charset.coders.Surrogates.output = bos.toByteArray();
	}

	static void testLeftovers(boolean doMalformed) throws java.lang.Exception {
		javaT.nio.charset.coders.Surrogates.log.print("Leftover surrogates, doMalformed = " + doMalformed);
		java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
		java.io.OutputStreamWriter osw = new java.io.OutputStreamWriter(bos, java.nio.charset.Charset.forName("UTF-8"));
		for (int i = 0; i < javaT.nio.charset.coders.Surrogates.input.length; i += 7) {
			osw.write(javaT.nio.charset.coders.Surrogates.input, i, java.lang.Math.min(javaT.nio.charset.coders.Surrogates.input.length - i, 7));
		}
		if (doMalformed) {
			osw.write(javaT.nio.charset.coders.Surrogates.input, 0, 1);
		}
		osw.close();
		byte[] result = bos.toByteArray();
		int rl = result.length + (doMalformed ? -1 : 0);
		if (rl != javaT.nio.charset.coders.Surrogates.output.length) {
			throw new java.lang.Exception((("Incorrect result length " + rl) + ", expected ") + javaT.nio.charset.coders.Surrogates.output.length);
		}
		for (int i = 0; i < javaT.nio.charset.coders.Surrogates.output.length; i++) {
			if (result[i] != javaT.nio.charset.coders.Surrogates.output[i]) {
				throw new java.lang.Exception("Unexpected result value at index " + i);
			}
		}
		javaT.nio.charset.coders.Surrogates.log.println(": Passed");
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.nio.charset.coders.Surrogates.initData();
		javaT.nio.charset.coders.Surrogates.testLeftovers(false);
		javaT.nio.charset.coders.Surrogates.testLeftovers(true);
	}
}