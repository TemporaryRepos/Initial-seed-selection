public class Regex {
	static void ck(boolean x, boolean ans) throws java.lang.Exception {
		if (x != ans) {
			throw new java.lang.Exception("Test failed");
		}
	}

	static void ck(java.lang.String x, java.lang.String ans) throws java.lang.Exception {
		if (!x.equals(ans)) {
			throw new java.lang.Exception("Test failed");
		}
	}

	static void ck(java.lang.String[] x, java.lang.String[] ans) throws java.lang.Exception {
		if (x.length != ans.length) {
			throw new java.lang.Exception("Test failed");
		}
		for (int i = 0; i < x.length; i++) {
			if (!x[i].equals(ans[i])) {
				throw new java.lang.Exception("Test failed");
			}
		}
	}

	static void testLiteralReplacement() throws java.lang.Exception {
		java.lang.String data = "abcdefghi";
		java.lang.String result = data.replace("def", "abc");
		if (!result.equals("abcabcghi")) {
			throw new java.lang.Exception("Test failed");
		}
		data = "abc(def)?ghi";
		result = data.replace("(def)?", "abc");
		if (!result.equals("abcabcghi")) {
			throw new java.lang.Exception("Test failed");
		}
		data = "abcdefghi";
		result = data.replace("def", "\\ab$c");
		if (!result.equals("abc\\ab$cghi")) {
			throw new java.lang.Exception("Test failed");
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String foo = "boo:and:foo";
		javaT.lang.String.Regex.ck(foo.matches("b+"), false);
		javaT.lang.String.Regex.ck(foo.matches("o+"), false);
		javaT.lang.String.Regex.ck(foo.matches("b..:and:f.*"), true);
		javaT.lang.String.Regex.ck(foo.replaceAll("oo", "uu"), "buu:and:fuu");
		javaT.lang.String.Regex.ck(foo.replaceAll("o+", "<$0>"), "b<oo>:and:f<oo>");
		javaT.lang.String.Regex.ck(foo.replaceFirst("oo", "uu"), "buu:and:foo");
		javaT.lang.String.Regex.ck(foo.replaceFirst("o+", "<$0>"), "b<oo>:and:foo");
		javaT.lang.String.Regex.ck(foo.split(":"), new java.lang.String[]{ "boo", "and", "foo" });
		javaT.lang.String.Regex.ck(foo.split("o"), new java.lang.String[]{ "b", "", ":and:f" });
		javaT.lang.String.Regex.ck(foo.split(":", 2), new java.lang.String[]{ "boo", "and:foo" });
		javaT.lang.String.Regex.ck(foo.split("o", -2), new java.lang.String[]{ "b", "", ":and:f", "", "" });
		javaT.lang.String.Regex.testLiteralReplacement();
	}
}