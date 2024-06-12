public class Utils {
	public static java.util.HashMap<java.lang.String, java.lang.String> labelcolors;

	static {
		labelcolors = new java.util.HashMap<>();
		labelcolors.put("PER", "yellow");
		labelcolors.put("LOC", "greenyellow");
		labelcolors.put("GPE", "coral");
		labelcolors.put("MISC", "coral");
		labelcolors.put("ORG", "lightblue");
		labelcolors.put("G", "grey");
	}

	public static java.lang.String getColorOrRandom(java.lang.String label) {
		java.lang.String color;
		if (io.github.mayhewsw.utils.Utils.labelcolors.containsKey(label)) {
			color = io.github.mayhewsw.utils.Utils.labelcolors.get(label);
		} else {
			java.util.Random random = new java.util.Random();
			int nextInt = random.nextInt((256 * 256) * 256);
			color = java.lang.String.format("#%06x", nextInt);
		}
		return color;
	}

	public static java.lang.String[] getRomanTaToks(edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta) {
		java.lang.String[] text;
		if (ta.hasView("ROMANIZATION")) {
			edu.illinois.cs.cogcomp.core.datastructures.textannotation.View translit = ta.getView("ROMANIZATION");
			java.lang.StringBuilder sb = new java.lang.StringBuilder();
			for (edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent c : translit.getConstituents()) {
				java.lang.String romantext = c.getLabel().replace(" ", "_");
				if (romantext.length() == 0) {
					romantext = "_";
				}
				sb.append(romantext + " ");
			}
			text = sb.toString().trim().split(" ");
		} else {
			cz.jirutka.unidecode.Unidecode unidecode = cz.jirutka.unidecode.Unidecode.toAscii();
			text = ta.getTokens().clone();
			for (int t = 0; t < text.length; t++) {
				text[t] = unidecode.decode(text[t]);
			}
		}
		return text;
	}

	public static java.lang.String[] getGoogleTaToks(edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta) {
		java.lang.String[] text;
		if (ta.hasView("GOOGLE")) {
			edu.illinois.cs.cogcomp.core.datastructures.textannotation.View google = ta.getView("GOOGLE");
			java.lang.StringBuilder sb = new java.lang.StringBuilder();
			int currIndex = 0;
			for (edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent c : google.getConstituents()) {
				java.lang.String googletext = c.getLabel().replace(" ", "_");
				if (googletext.length() == 0) {
					googletext = "_";
				}
				int start = c.getStartSpan();
				int end = c.getEndSpan();
				java.lang.String[] tokensBefore = ta.getTokensInSpan(currIndex, start);
				for (int i = 0; i < tokensBefore.length; i++) {
					sb.append(tokensBefore[i] + " ");
				}
				currIndex = end;
				sb.append(googletext + " ");
			}
			int lastTAIndex = ta.getTokens().length;
			if (currIndex != lastTAIndex) {
				java.lang.String[] tokensBefore = ta.getTokensInSpan(currIndex, lastTAIndex);
				for (int i = 0; i < tokensBefore.length; i++) {
					sb.append(tokensBefore[i] + " ");
				}
			}
			text = sb.toString().trim().split(" ");
		} else {
			java.lang.System.out.println("GOOGLE_RELEVANT view not found");
			text = ta.getTokens().clone();
		}
		return text;
	}

	public static java.lang.String stem(java.lang.String word, java.util.List<java.lang.String> suffixes) {
		boolean stemmed = false;
		while (!stemmed) {
			stemmed = true;
			for (java.lang.String suff : suffixes) {
				if (word.endsWith(suff)) {
					word = word.substring(0, word.length() - suff.length());
					stemmed = false;
				}
			}
		} 
		return word;
	}

	public static void main(java.lang.String[] args) {
		java.lang.String w = "jungoliqlarning";
		java.util.List<java.lang.String> suf = new java.util.ArrayList<>();
		suf.add("liq");
		suf.add("lar");
		suf.add("ning");
		java.lang.System.out.println(io.github.mayhewsw.utils.Utils.stem(w, suf));
	}
}