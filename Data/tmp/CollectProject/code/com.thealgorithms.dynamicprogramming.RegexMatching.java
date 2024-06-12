public class RegexMatching {
	static boolean regexRecursion(java.lang.String src, java.lang.String pat) {
		if ((src.length() == 0) && (pat.length() == 0)) {
			return true;
		}
		if ((src.length() != 0) && (pat.length() == 0)) {
			return false;
		}
		if ((src.length() == 0) && (pat.length() != 0)) {
			for (int i = 0; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}
		char chs = src.charAt(0);
		char chp = pat.charAt(0);
		java.lang.String ros = src.substring(1);
		java.lang.String rop = pat.substring(1);
		boolean ans;
		if ((chs == chp) || (chp == '?')) {
			ans = com.thealgorithms.dynamicprogramming.RegexMatching.regexRecursion(ros, rop);
		} else if (chp == '*') {
			boolean blank = com.thealgorithms.dynamicprogramming.RegexMatching.regexRecursion(src, rop);
			boolean multiple = com.thealgorithms.dynamicprogramming.RegexMatching.regexRecursion(ros, pat);
			ans = blank || multiple;
		} else {
			ans = false;
		}
		return ans;
	}

	static boolean regexRecursion(java.lang.String src, java.lang.String pat, int svidx, int pvidx) {
		if ((src.length() == svidx) && (pat.length() == pvidx)) {
			return true;
		}
		if ((src.length() != svidx) && (pat.length() == pvidx)) {
			return false;
		}
		if ((src.length() == svidx) && (pat.length() != pvidx)) {
			for (int i = pvidx; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}
		char chs = src.charAt(svidx);
		char chp = pat.charAt(pvidx);
		boolean ans;
		if ((chs == chp) || (chp == '?')) {
			ans = com.thealgorithms.dynamicprogramming.RegexMatching.regexRecursion(src, pat, svidx + 1, pvidx + 1);
		} else if (chp == '*') {
			boolean blank = com.thealgorithms.dynamicprogramming.RegexMatching.regexRecursion(src, pat, svidx, pvidx + 1);
			boolean multiple = com.thealgorithms.dynamicprogramming.RegexMatching.regexRecursion(src, pat, svidx + 1, pvidx);
			ans = blank || multiple;
		} else {
			ans = false;
		}
		return ans;
	}

	static boolean regexRecursion(java.lang.String src, java.lang.String pat, int svidx, int pvidx, int[][] strg) {
		if ((src.length() == svidx) && (pat.length() == pvidx)) {
			return true;
		}
		if ((src.length() != svidx) && (pat.length() == pvidx)) {
			return false;
		}
		if ((src.length() == svidx) && (pat.length() != pvidx)) {
			for (int i = pvidx; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}
		if (strg[svidx][pvidx] != 0) {
			return strg[svidx][pvidx] != 1;
		}
		char chs = src.charAt(svidx);
		char chp = pat.charAt(pvidx);
		boolean ans;
		if ((chs == chp) || (chp == '?')) {
			ans = com.thealgorithms.dynamicprogramming.RegexMatching.regexRecursion(src, pat, svidx + 1, pvidx + 1, strg);
		} else if (chp == '*') {
			boolean blank = com.thealgorithms.dynamicprogramming.RegexMatching.regexRecursion(src, pat, svidx, pvidx + 1, strg);
			boolean multiple = com.thealgorithms.dynamicprogramming.RegexMatching.regexRecursion(src, pat, svidx + 1, pvidx, strg);
			ans = blank || multiple;
		} else {
			ans = false;
		}
		strg[svidx][pvidx] = (ans) ? 2 : 1;
		return ans;
	}

	static boolean regexBU(java.lang.String src, java.lang.String pat) {
		boolean[][] strg = new boolean[src.length() + 1][pat.length() + 1];
		strg[src.length()][pat.length()] = true;
		for (int row = src.length(); row >= 0; row--) {
			for (int col = pat.length() - 1; col >= 0; col--) {
				if (row == src.length()) {
					if (pat.charAt(col) == '*') {
						strg[row][col] = strg[row][col + 1];
					} else {
						strg[row][col] = false;
					}
				} else {
					char chs = src.charAt(row);
					char chp = pat.charAt(col);
					boolean ans;
					if ((chs == chp) || (chp == '?')) {
						ans = strg[row + 1][col + 1];
					} else if (chp == '*') {
						boolean blank = strg[row][col + 1];
						boolean multiple = strg[row + 1][col];
						ans = blank || multiple;
					} else {
						ans = false;
					}
					strg[row][col] = ans;
				}
			}
		}
		return strg[0][0];
	}

	public static void main(java.lang.String[] args) {
		java.lang.String src = "aa";
		java.lang.String pat = "*";
		java.lang.System.out.println("Method 1: " + com.thealgorithms.dynamicprogramming.RegexMatching.regexRecursion(src, pat));
		java.lang.System.out.println("Method 2: " + com.thealgorithms.dynamicprogramming.RegexMatching.regexRecursion(src, pat, 0, 0));
		java.lang.System.out.println("Method 3: " + com.thealgorithms.dynamicprogramming.RegexMatching.regexRecursion(src, pat, 0, 0, new int[src.length()][pat.length()]));
		java.lang.System.out.println("Method 4: " + com.thealgorithms.dynamicprogramming.RegexMatching.regexBU(src, pat));
	}
}