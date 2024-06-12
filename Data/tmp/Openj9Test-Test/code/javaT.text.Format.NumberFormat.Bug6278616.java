public class Bug6278616 {
	static final int[] ints = new int[]{ java.lang.Integer.MIN_VALUE, -1, 0, 1, java.lang.Integer.MAX_VALUE };

	static final long[] longs = new long[]{ java.lang.Long.MIN_VALUE, -1, 0, 1, java.lang.Long.MAX_VALUE };

	public static void main(java.lang.String[] args) {
		java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
		for (int j = 0; j < javaT.text.Format.NumberFormat.Bug6278616.ints.length; j++) {
			java.lang.String s_i = nf.format(new java.lang.Integer(javaT.text.Format.NumberFormat.Bug6278616.ints[j]));
			java.lang.String s_ai = nf.format(new java.util.concurrent.atomic.AtomicInteger(javaT.text.Format.NumberFormat.Bug6278616.ints[j]));
			if (!s_i.equals(s_ai)) {
				throw new java.lang.RuntimeException(((("format(AtomicInteger " + s_ai) + ") doesn't equal format(Integer ") + s_i) + ")");
			}
		}
		for (int j = 0; j < javaT.text.Format.NumberFormat.Bug6278616.longs.length; j++) {
			java.lang.String s_l = nf.format(new java.lang.Long(javaT.text.Format.NumberFormat.Bug6278616.longs[j]));
			java.lang.String s_al = nf.format(new java.util.concurrent.atomic.AtomicLong(javaT.text.Format.NumberFormat.Bug6278616.longs[j]));
			if (!s_l.equals(s_al)) {
				throw new java.lang.RuntimeException(((("format(AtomicLong " + s_al) + ") doesn't equal format(Long ") + s_l) + ")");
			}
		}
	}
}