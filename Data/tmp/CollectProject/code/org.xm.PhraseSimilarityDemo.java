public class PhraseSimilarityDemo {
	public static void main(java.lang.String[] args) {
		java.lang.String phrase1 = "继续努力";
		java.lang.String phrase2 = "持续发展";
		double result = org.xm.Similarity.phraseSimilarity(phrase1, phrase2);
		java.lang.System.out.println((((phrase1 + " vs ") + phrase2) + " 短语相似度值：") + result);
	}
}