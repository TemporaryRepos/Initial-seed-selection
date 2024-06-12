public class LongestPalindromicSubsequence {
	public static void main(java.lang.String[] args) {
		java.lang.String a = "BBABCBCAB";
		java.lang.String b = "BABCBAB";
		java.lang.String aLPS = com.thealgorithms.dynamicprogramming.LongestPalindromicSubsequence.LPS(a);
		java.lang.String bLPS = com.thealgorithms.dynamicprogramming.LongestPalindromicSubsequence.LPS(b);
		java.lang.System.out.println((a + " => ") + aLPS);
		java.lang.System.out.println((b + " => ") + bLPS);
	}

	public static java.lang.String LPS(java.lang.String original) throws java.lang.IllegalArgumentException {
		java.lang.StringBuilder reverse = new java.lang.StringBuilder(original);
		reverse = reverse.reverse();
		return com.thealgorithms.dynamicprogramming.LongestPalindromicSubsequence.recursiveLPS(original, reverse.toString());
	}

	private static java.lang.String recursiveLPS(java.lang.String original, java.lang.String reverse) {
		java.lang.String bestResult = "";
		if ((original.length() == 0) || (reverse.length() == 0)) {
			bestResult = "";
		} else if (original.charAt(original.length() - 1) == reverse.charAt(reverse.length() - 1)) {
			java.lang.String bestSubResult = com.thealgorithms.dynamicprogramming.LongestPalindromicSubsequence.recursiveLPS(original.substring(0, original.length() - 1), reverse.substring(0, reverse.length() - 1));
			bestResult = reverse.charAt(reverse.length() - 1) + bestSubResult;
		} else {
			java.lang.String bestSubResult1 = com.thealgorithms.dynamicprogramming.LongestPalindromicSubsequence.recursiveLPS(original, reverse.substring(0, reverse.length() - 1));
			java.lang.String bestSubResult2 = com.thealgorithms.dynamicprogramming.LongestPalindromicSubsequence.recursiveLPS(original.substring(0, original.length() - 1), reverse);
			if (bestSubResult1.length() > bestSubResult2.length()) {
				bestResult = bestSubResult1;
			} else {
				bestResult = bestSubResult2;
			}
		}
		return bestResult;
	}
}