public class NaNInfinityParsing {
	static java.lang.String[] NaNStrings = new java.lang.String[]{ "NaN", "+NaN", "-NaN" };

	static java.lang.String[] infinityStrings = new java.lang.String[]{ "Infinity", "+Infinity", "-Infinity" };

	static java.lang.String[] invalidStrings = new java.lang.String[]{ "+", "-", "@", "N", "Na", "Nan", "NaNf", "NaNd", "NaNF", "NaND", "+N", "+Na", "+Nan", "+NaNf", "+NaNd", "+NaNF", "+NaND", "-N", "-Na", "-Nan", "-NaNf", "-NaNd", "-NaNF", "-NaND", "I", "In", "Inf", "Infi", "Infin", "Infini", "Infinit", "InfinitY", "Infinityf", "InfinityF", "Infinityd", "InfinityD", "+I", "+In", "+Inf", "+Infi", "+Infin", "+Infini", "+Infinit", "+InfinitY", "+Infinityf", "+InfinityF", "+Infinityd", "+InfinityD", "-I", "-In", "-Inf", "-Infi", "-Infin", "-Infini", "-Infinit", "-InfinitY", "-Infinityf", "-InfinityF", "-Infinityd", "-InfinityD", "NaNInfinity", "InfinityNaN", "nan", "infinity" };

	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		int i;
		double d;
		for (i = 0; i < javaT.lang.Double.NaNInfinityParsing.NaNStrings.length; i++) {
			if (!java.lang.Double.isNaN(d = java.lang.Double.parseDouble(javaT.lang.Double.NaNInfinityParsing.NaNStrings[i]))) {
				throw new java.lang.RuntimeException(((("NaN string ``" + javaT.lang.Double.NaNInfinityParsing.NaNStrings[i]) + "'' did not parse as a NaN; returned ") + d) + " instead.");
			}
		}
		for (i = 0; i < javaT.lang.Double.NaNInfinityParsing.infinityStrings.length; i++) {
			if (!java.lang.Double.isInfinite(d = java.lang.Double.parseDouble(javaT.lang.Double.NaNInfinityParsing.infinityStrings[i]))) {
				throw new java.lang.RuntimeException(((("Infinity string ``" + javaT.lang.Double.NaNInfinityParsing.infinityStrings[i]) + "'' did not parse as infinity; returned ") + d) + "instead.");
			}
			boolean negative = javaT.lang.Double.NaNInfinityParsing.infinityStrings[i].charAt(0) == '-';
			if (d != (negative ? java.lang.Double.NEGATIVE_INFINITY : java.lang.Double.POSITIVE_INFINITY)) {
				throw new java.lang.RuntimeException("Infinity has wrong sign;" + (negative ? "positive instead of negative." : "negative instead of positive."));
			}
		}
		for (i = 0; i < javaT.lang.Double.NaNInfinityParsing.invalidStrings.length; i++) {
			try {
				double result;
				d = java.lang.Double.parseDouble(javaT.lang.Double.NaNInfinityParsing.invalidStrings[i]);
				throw new java.lang.RuntimeException(((("Invalid string ``" + javaT.lang.Double.NaNInfinityParsing.invalidStrings[i]) + "'' parsed as ") + d) + ".");
			} catch (java.lang.NumberFormatException e) {
			}
		}
	}
}