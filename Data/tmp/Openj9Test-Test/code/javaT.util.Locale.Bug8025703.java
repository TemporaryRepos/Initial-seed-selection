public class Bug8025703 {
	public static void main(java.lang.String[] args) {
		boolean err = false;
		java.lang.String[][] mappings = new java.lang.String[][]{ new java.lang.String[]{ "ilw", "gal" }, new java.lang.String[]{ "meg", "cir" }, new java.lang.String[]{ "pcr", "adx" }, new java.lang.String[]{ "xia", "acn" }, new java.lang.String[]{ "yos", "zom" } };
		for (int i = 0; i < mappings.length; i++) {
			java.util.List<java.util.Locale.LanguageRange> got = java.util.Locale.LanguageRange.parse(mappings[i][0]);
			java.util.ArrayList<java.util.Locale.LanguageRange> expected = new java.util.ArrayList<>();
			expected.add(new java.util.Locale.LanguageRange(mappings[i][0], 1.0));
			expected.add(new java.util.Locale.LanguageRange(mappings[i][1], 1.0));
			if (!expected.equals(got)) {
				err = true;
				java.lang.System.err.println("Incorrect language ranges. ");
				for (java.util.Locale.LanguageRange lr : expected) {
					java.lang.System.err.println((("  Expected: range=" + lr.getRange()) + ", weight=") + lr.getWeight());
				}
				for (java.util.Locale.LanguageRange lr : got) {
					java.lang.System.err.println((("  Got:      range=" + lr.getRange()) + ", weight=") + lr.getWeight());
				}
			}
		}
		if (err) {
			throw new java.lang.RuntimeException("Failed.");
		}
	}
}