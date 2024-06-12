public class RegionMatches {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String s1 = "abc";
		java.lang.String s2 = "def";
		if (!s1.regionMatches(0, s2, 0, java.lang.Integer.MIN_VALUE)) {
			throw new java.lang.RuntimeException("Integer overflow in RegionMatches");
		}
	}
}