public class Test7009359 {
	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 100000; i++) {
			if (!compiler.c2.Test7009359.stringmakerBUG(null).equals("NPE")) {
				java.lang.System.out.println("StringBuffer(null) does not throw NPE");
				java.lang.System.exit(97);
			}
		}
	}

	public static java.lang.String stringmakerBUG(java.lang.String str) {
		try {
			return new java.lang.StringBuffer(str).toString();
		} catch (java.lang.NullPointerException e) {
			return "NPE";
		}
	}
}