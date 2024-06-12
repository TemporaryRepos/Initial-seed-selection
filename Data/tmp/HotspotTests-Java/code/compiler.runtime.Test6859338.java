public class Test6859338 {
	static java.lang.Object[] o = new java.lang.Object[]{ new java.lang.Object(), null };

	public static void main(java.lang.String[] args) {
		int total = 0;
		try {
			for (int i = 0; i < 40000; i++) {
				int limit = compiler.runtime.Test6859338.o.length;
				if (i < 20000) {
					limit = 1;
				}
				for (int j = 0; j < limit; j++) {
					total += 10000;
				}
			}
		} catch (java.lang.NullPointerException e) {
		}
	}
}