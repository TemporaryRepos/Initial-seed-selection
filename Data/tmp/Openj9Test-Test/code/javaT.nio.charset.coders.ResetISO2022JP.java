public class ResetISO2022JP {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (!javaT.nio.charset.coders.ResetISO2022JP.encode(true).equals(javaT.nio.charset.coders.ResetISO2022JP.encode(false))) {
			throw new java.lang.Exception("Mismatch!");
		}
	}

	static java.lang.String encode(boolean reuseEncoder) {
		java.lang.String s = "あぃい";
		java.nio.charset.CharsetEncoder e = java.nio.charset.Charset.forName("ISO-2022-JP").newEncoder();
		if (reuseEncoder) {
			e.encode(java.nio.CharBuffer.wrap(s), java.nio.ByteBuffer.allocate(64), true);
			e.reset();
		}
		java.nio.ByteBuffer bb = java.nio.ByteBuffer.allocate(64);
		e.encode(java.nio.CharBuffer.wrap(s), bb, true);
		e.flush(bb);
		bb.flip();
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		for (int i = 0; i < bb.limit(); i++) {
			sb.append(java.lang.String.format("%02x ", bb.get(i)));
		}
		java.lang.System.out.println(sb);
		return sb.toString();
	}
}