public class PrecomputedCosine {
	public static void main(java.lang.String[] args) {
		java.lang.String s1 = "My first string";
		java.lang.String s2 = "My other string...";
		info.debatty.java.stringsimilarity.Cosine cosine = new info.debatty.java.stringsimilarity.Cosine(2);
		java.util.Map<java.lang.String, java.lang.Integer> profile1 = cosine.getProfile(s1);
		java.util.Map<java.lang.String, java.lang.Integer> profile2 = cosine.getProfile(s2);
		java.lang.System.out.println(cosine.similarity(profile1, profile2));
	}
}