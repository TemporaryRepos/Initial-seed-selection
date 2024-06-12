public class Normalize {
	private static final java.util.regex.Pattern SPACE = java.util.regex.Pattern.compile("[\\p{Space}\\p{Cntrl}]+");

	private static final java.util.regex.Pattern PUNCT = java.util.regex.Pattern.compile("\\p{Punct}+");

	private static final java.lang.String SUBST_EMPTY = java.util.regex.Matcher.quoteReplacement("");

	private static final java.lang.String SUBST_SPACE = java.util.regex.Matcher.quoteReplacement(" ");

	private static final java.util.regex.Pattern DIACRITICS = java.util.regex.Pattern.compile("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");

	private static final java.lang.String[] ID_SW = new java.lang.String[]{ " the ", " of ", " a ", " at ", " in " };

	public static java.lang.String normalize(java.lang.String args) {
		return com.yahoo.semsearch.fastlinking.utils.Normalize.normalizeFast(args);
	}

	public static com.yahoo.semsearch.fastlinking.view.Span[] normalizeWithSpans(java.lang.String args) {
		final java.lang.StringBuilder t = new java.lang.StringBuilder();
		final int length = args.length();
		java.util.List<com.yahoo.semsearch.fastlinking.view.Span> res = new java.util.ArrayList<com.yahoo.semsearch.fastlinking.view.Span>();
		int pi = -1;
		for (int i = 0; i < length; i++) {
			char charAt = args.charAt(i);
			if (java.lang.Character.isLetterOrDigit(charAt) && (!java.lang.Character.isWhitespace(charAt))) {
				if (pi < 0) {
					pi = i;
				}
				t.append(java.lang.Character.toLowerCase(charAt));
			} else if (t.length() > 0) {
				res.add(new com.yahoo.semsearch.fastlinking.view.Span(t.toString(), pi, i));
				pi = -1;
				t.setLength(0);
			}
		}
		if (t.length() > 0) {
			res.add(new com.yahoo.semsearch.fastlinking.view.Span(t.toString(), pi, length));
		}
		return res.toArray(new com.yahoo.semsearch.fastlinking.view.Span[0]);
	}

	public static java.lang.String normalizeFast(java.lang.String args) {
		final java.lang.StringBuilder t = new java.lang.StringBuilder();
		final int length = args.length();
		boolean inSpace = false;
		for (int i = 0; i < length; i++) {
			char charAt = args.charAt(i);
			if (java.lang.Character.isLetterOrDigit(charAt)) {
				if (inSpace) {
					t.append(' ');
				}
				t.append(java.lang.Character.toLowerCase(charAt));
				inSpace = false;
			} else if (t.length() > 0) {
				inSpace = true;
			}
		}
		return t.toString();
	}

	public static java.lang.String normalizeRegExp(java.lang.String norm) {
		norm = com.yahoo.semsearch.fastlinking.utils.Normalize.SPACE.matcher(norm).replaceAll(com.yahoo.semsearch.fastlinking.utils.Normalize.SUBST_SPACE);
		norm = java.text.Normalizer.normalize(norm, java.text.Normalizer.Form.NFD);
		norm = com.yahoo.semsearch.fastlinking.utils.Normalize.DIACRITICS.matcher(norm).replaceAll(com.yahoo.semsearch.fastlinking.utils.Normalize.SUBST_EMPTY);
		return norm.toLowerCase().trim();
	}

	public static java.lang.String normalizeRegExpCopy(java.lang.String str) {
		java.lang.String norm = str;
		norm = com.yahoo.semsearch.fastlinking.utils.Normalize.PUNCT.matcher(norm).replaceAll(com.yahoo.semsearch.fastlinking.utils.Normalize.SUBST_EMPTY);
		norm = com.yahoo.semsearch.fastlinking.utils.Normalize.SPACE.matcher(norm).replaceAll(com.yahoo.semsearch.fastlinking.utils.Normalize.SUBST_SPACE);
		return norm.toLowerCase().trim();
	}

	public static java.lang.String getIntentPart(java.lang.String q, java.lang.String result) {
		java.lang.String normalizedId = result.replaceAll("(.*?)(%28)" + ("(.*?)" + "(%29.*)"), "$1");
		normalizedId = org.apache.commons.lang.StringUtils.remove(normalizedId, "%3A");
		normalizedId = com.yahoo.semsearch.fastlinking.utils.Normalize.normalize(normalizedId.replaceAll("[^A-Za-z0-9]", " "));
		for (java.lang.String sw : com.yahoo.semsearch.fastlinking.utils.Normalize.ID_SW) {
			normalizedId = normalizedId.replaceAll(sw, " ");
			q = q.replaceAll(sw, " ");
		}
		return org.apache.commons.lang.StringUtils.remove(q, normalizedId);
	}

	public static void main(java.lang.String[] args) {
		java.lang.String test = "ad. - asd. ; ; ; ;asdf assssXxvv.com hola.com .com one two     three four   ";
		java.lang.System.out.println(test);
		java.lang.System.out.println(com.yahoo.semsearch.fastlinking.utils.Normalize.normalize(test));
		for (com.yahoo.semsearch.fastlinking.view.Span a : com.yahoo.semsearch.fastlinking.utils.Normalize.normalizeWithSpans(test)) {
			java.lang.System.out.println(((((((a.getStartOffset() + "-") + a.getEndOffset()) + " >") + a.span) + "<:>") + test.subSequence(a.getStartOffset(), a.getEndOffset())) + "<");
		}
	}
}