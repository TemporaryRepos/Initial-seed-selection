public class PunctuationDiacriticsFolder {
	public static final java.util.regex.Pattern SPACE = java.util.regex.Pattern.compile("[\\p{Space}\\p{Cntrl}]+");

	public static final java.util.regex.Pattern PUNCT = java.util.regex.Pattern.compile("\\p{Punct}+");

	public static final java.lang.String SUBST_SPACE = java.util.regex.Matcher.quoteReplacement(" ");

	public static final java.lang.String SUBST_EMPTY = java.util.regex.Matcher.quoteReplacement("");

	public static final java.util.regex.Pattern DIACRITICS = java.util.regex.Pattern.compile("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");

	private static java.lang.String stripDiacritics(java.lang.String str) {
		str = java.text.Normalizer.normalize(str, java.text.Normalizer.Form.NFD);
		str = com.yahoo.semsearch.fastlinking.io.PunctuationDiacriticsFolder.DIACRITICS.matcher(str).replaceAll(com.yahoo.semsearch.fastlinking.io.PunctuationDiacriticsFolder.SUBST_EMPTY);
		return str;
	}

	public static java.lang.String normalize(java.lang.String str) {
		java.lang.String norm = str;
		norm = com.yahoo.semsearch.fastlinking.io.PunctuationDiacriticsFolder.PUNCT.matcher(norm).replaceAll(com.yahoo.semsearch.fastlinking.io.PunctuationDiacriticsFolder.SUBST_SPACE);
		norm = com.yahoo.semsearch.fastlinking.io.PunctuationDiacriticsFolder.SPACE.matcher(norm).replaceAll(com.yahoo.semsearch.fastlinking.io.PunctuationDiacriticsFolder.SUBST_SPACE);
		norm = com.yahoo.semsearch.fastlinking.io.PunctuationDiacriticsFolder.stripDiacritics(norm);
		return norm.toLowerCase().trim();
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(com.yahoo.semsearch.fastlinking.io.PunctuationDiacriticsFolder.normalize("\'\'\'Jim Durham\'\'\' (February 12, \'47 - November 4, 2012) was an [[United States of America|American]] [[sportscaster]]. Durham died on November 4, 2012.abc-def\nhello\'s"));
	}
}