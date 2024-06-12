public class CountedLoopProblem {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int x = 0;
		try {
			java.lang.StringBuilder sb = new java.lang.StringBuilder();
			for (int i = 0; i < 1000000; ++i) {
				int v = java.lang.Math.abs(10);
				sb.append('+').append(v).append('\n');
				x += v;
				while (x < 0) {
					x += 1000000000;
				} 
				sb.append('=').append(x).append('\n');
			}
			if (sb.toString().hashCode() != 0xaba94591) {
				throw new java.lang.Exception("Unexpected result");
			}
		} catch (java.lang.OutOfMemoryError e) {
		}
	}
}