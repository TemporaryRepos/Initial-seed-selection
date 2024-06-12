public class ResetPos {
	static void checkValue(java.lang.String val, java.lang.String checkVal) {
		java.lang.System.out.println(((("Comparing \"" + val) + "\" <----> \"") + checkVal) + "\"");
		if (!val.equals(checkVal)) {
			throw new java.lang.RuntimeException("Test failed");
		}
	}

	public static void main(java.lang.String[] argv) {
		java.util.StringTokenizer st1 = new java.util.StringTokenizer("ab", "b", true);
		javaT.util.StringTokenizer.ResetPos.checkValue("a", st1.nextToken("b"));
		st1.hasMoreTokens();
		javaT.util.StringTokenizer.ResetPos.checkValue("b", st1.nextToken(""));
		java.util.StringTokenizer st2 = new java.util.StringTokenizer("abcd efg", "abc", true);
		st2.hasMoreTokens();
		javaT.util.StringTokenizer.ResetPos.checkValue("a", st2.nextToken("bc"));
		st2.hasMoreTokens();
		javaT.util.StringTokenizer.ResetPos.checkValue("b", st2.nextToken());
		st2.hasMoreTokens();
		javaT.util.StringTokenizer.ResetPos.checkValue("cd", st2.nextToken(" ef"));
		st2.hasMoreTokens();
		javaT.util.StringTokenizer.ResetPos.checkValue(" ", st2.nextToken(" "));
		st2.hasMoreTokens();
		javaT.util.StringTokenizer.ResetPos.checkValue("ef", st2.nextToken("g"));
		st2.hasMoreTokens();
		javaT.util.StringTokenizer.ResetPos.checkValue("g", st2.nextToken("g"));
		java.util.StringTokenizer st3 = new java.util.StringTokenizer("this is,a interesting,sentence of small, words", ",");
		st3.hasMoreTokens();
		javaT.util.StringTokenizer.ResetPos.checkValue("this is", st3.nextToken());
		st3.hasMoreTokens();
		javaT.util.StringTokenizer.ResetPos.checkValue(",a", st3.nextToken(" "));
		st3.hasMoreTokens();
		javaT.util.StringTokenizer.ResetPos.checkValue(" interesting", st3.nextToken(","));
		st3.hasMoreTokens();
		javaT.util.StringTokenizer.ResetPos.checkValue(",sentence", st3.nextToken(" "));
		st3.hasMoreTokens();
		javaT.util.StringTokenizer.ResetPos.checkValue(" of small", st3.nextToken(","));
		st3.hasMoreTokens();
		javaT.util.StringTokenizer.ResetPos.checkValue(" words", st3.nextToken());
	}
}