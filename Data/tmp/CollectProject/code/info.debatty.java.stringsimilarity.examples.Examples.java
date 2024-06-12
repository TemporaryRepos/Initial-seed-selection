public class Examples {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("\nLevenshtein");
		info.debatty.java.stringsimilarity.Levenshtein levenshtein = new info.debatty.java.stringsimilarity.Levenshtein();
		java.lang.System.out.println(levenshtein.distance("My string", "My $tring"));
		java.lang.System.out.println(levenshtein.distance("My string", "M string2"));
		java.lang.System.out.println(levenshtein.distance("My string", "My $tring"));
		java.lang.System.out.println("\nJaccard");
		info.debatty.java.stringsimilarity.Jaccard j2 = new info.debatty.java.stringsimilarity.Jaccard(2);
		java.lang.System.out.println(j2.similarity("ABCDE", "ABCDF"));
		java.lang.System.out.println("\nJaro-Winkler");
		info.debatty.java.stringsimilarity.JaroWinkler jw = new info.debatty.java.stringsimilarity.JaroWinkler();
		java.lang.System.out.println(jw.similarity("My string", "My tsring"));
		java.lang.System.out.println(jw.similarity("My string", "My ntrisg"));
		java.lang.System.out.println("\nCosine");
		info.debatty.java.stringsimilarity.Cosine cos = new info.debatty.java.stringsimilarity.Cosine(3);
		java.lang.System.out.println(cos.similarity("ABC", "ABCE"));
		cos = new info.debatty.java.stringsimilarity.Cosine(2);
		java.lang.System.out.println(cos.similarity("ABAB", "BAB"));
		java.lang.System.out.println("\nDamerau");
		info.debatty.java.stringsimilarity.Damerau damerau = new info.debatty.java.stringsimilarity.Damerau();
		java.lang.System.out.println(damerau.distance("ABCDEF", "ABDCEF"));
		java.lang.System.out.println(damerau.distance("ABCDEF", "BACDFE"));
		java.lang.System.out.println(damerau.distance("ABCDEF", "ABCDE"));
		java.lang.System.out.println(damerau.distance("ABCDEF", "BCDEF"));
		java.lang.System.out.println(damerau.distance("ABCDEF", "ABCGDEF"));
		java.lang.System.out.println(damerau.distance("ABCDEF", "POIU"));
		java.lang.System.out.println("\nOptimal String Alignment");
		info.debatty.java.stringsimilarity.OptimalStringAlignment osa = new info.debatty.java.stringsimilarity.OptimalStringAlignment();
		java.lang.System.out.println(osa.distance("CA", "ABC"));
		java.lang.System.out.println("\nLongest Common Subsequence");
		info.debatty.java.stringsimilarity.LongestCommonSubsequence lcs = new info.debatty.java.stringsimilarity.LongestCommonSubsequence();
		java.lang.System.out.println(lcs.distance("AGCAT", "GAC"));
		java.lang.System.out.println(lcs.distance("AGCAT", "AGCT"));
		java.lang.System.out.println("\nNGram");
		info.debatty.java.stringsimilarity.NGram twogram = new info.debatty.java.stringsimilarity.NGram(2);
		java.lang.System.out.println(twogram.distance("ABCD", "ABTUIO"));
		java.lang.String s1 = "Adobe CreativeSuite 5 Master Collection from cheap 4zp";
		java.lang.String s2 = "Adobe CreativeSuite 5 Master Collection from cheap d1x";
		info.debatty.java.stringsimilarity.NGram ngram = new info.debatty.java.stringsimilarity.NGram(4);
		java.lang.System.out.println(ngram.distance(s1, s2));
		java.lang.System.out.println("\nNormalized Levenshtein");
		info.debatty.java.stringsimilarity.NormalizedLevenshtein l = new info.debatty.java.stringsimilarity.NormalizedLevenshtein();
		java.lang.System.out.println(l.distance("My string", "My $tring"));
		java.lang.System.out.println(l.distance("My string", "M string2"));
		java.lang.System.out.println(l.distance("My string", "abcd"));
		java.lang.System.out.println("\nQGram");
		info.debatty.java.stringsimilarity.QGram dig = new info.debatty.java.stringsimilarity.QGram(2);
		java.lang.System.out.println(dig.distance("ABCD", "ABCE"));
		java.lang.System.out.println(dig.distance("", "QSDFGHJKLM"));
		java.lang.System.out.println(dig.distance("Best Deal Ever! Viagra50/100mg - $1.85 071", "Best Deal Ever! Viagra50/100mg - $1.85 7z3"));
		java.lang.System.out.println("\nSorensen-Dice");
		info.debatty.java.stringsimilarity.SorensenDice sd = new info.debatty.java.stringsimilarity.SorensenDice(2);
		java.lang.System.out.println(sd.similarity("ABCDE", "ABCDFG"));
		java.lang.System.out.println("\nWeighted Levenshtein");
		info.debatty.java.stringsimilarity.WeightedLevenshtein wl = new info.debatty.java.stringsimilarity.WeightedLevenshtein(new info.debatty.java.stringsimilarity.CharacterSubstitutionInterface() {
			public double cost(char c1, char c2) {
				if ((c1 == 't') && (c2 == 'r')) {
					return 0.5;
				}
				return 1.0;
			}
		});
		java.lang.System.out.println(wl.distance("String1", "Srring2"));
		java.lang.System.out.println("\nK-Shingling");
		s1 = "my string,  \n  my song";
		s2 = "another string, from a song";
		info.debatty.java.stringsimilarity.Cosine cosine = new info.debatty.java.stringsimilarity.Cosine(4);
		java.lang.System.out.println(cosine.getProfile(s1));
		java.lang.System.out.println(cosine.getProfile(s2));
		cosine = new info.debatty.java.stringsimilarity.Cosine(2);
		java.lang.System.out.println(cosine.getProfile("ABCAB"));
	}
}