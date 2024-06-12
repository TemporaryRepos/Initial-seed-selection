public class KMP {
	public static void main(java.lang.String[] args) {
		final java.lang.String haystack = "AAAAABAAABA";
		final java.lang.String needle = "AAAA";
		com.thealgorithms.others.KMP.KMPmatcher(haystack, needle);
	}

	public static void KMPmatcher(final java.lang.String haystack, final java.lang.String needle) {
		final int m = haystack.length();
		final int n = needle.length();
		final int[] pi = com.thealgorithms.others.KMP.computePrefixFunction(needle);
		int q = 0;
		for (int i = 0; i < m; i++) {
			while ((q > 0) && (haystack.charAt(i) != needle.charAt(q))) {
				q = pi[q - 1];
			} 
			if (haystack.charAt(i) == needle.charAt(q)) {
				q++;
			}
			if (q == n) {
				java.lang.System.out.println("Pattern starts: " + ((i + 1) - n));
				q = pi[q - 1];
			}
		}
	}

	private static int[] computePrefixFunction(final java.lang.String P) {
		final int n = P.length();
		final int[] pi = new int[n];
		pi[0] = 0;
		int q = 0;
		for (int i = 1; i < n; i++) {
			while ((q > 0) && (P.charAt(q) != P.charAt(i))) {
				q = pi[q - 1];
			} 
			if (P.charAt(q) == P.charAt(i)) {
				q++;
			}
			pi[i] = q;
		}
		return pi;
	}
}