public class MetricLCS {
	public static void main(java.lang.String[] args) {
		info.debatty.java.stringsimilarity.MetricLCS lcs = new info.debatty.java.stringsimilarity.MetricLCS();
		java.lang.String s1 = "ABCDEFG";
		java.lang.String s2 = "ABCDEFHJKL";
		java.lang.System.out.println(lcs.distance(s1, s2));
		java.lang.System.out.println(lcs.distance("ABDEF", "ABDIF"));
	}
}