public class TagWordDemo {
	public static void main(java.lang.String[] args) {
		org.ansj.app.summary.TagContent tw = new org.ansj.app.summary.TagContent("<begin>", "<end>");
		java.lang.String content = "台湾两岸共同市场基金会代表团12312   不断推动两岸关";
		java.util.List<org.ansj.app.keyword.Keyword> keyWords = new java.util.ArrayList<org.ansj.app.keyword.Keyword>();
		keyWords.add(new org.ansj.app.keyword.Keyword("两岸关系", 1.0));
		keyWords.add(new org.ansj.app.keyword.Keyword("两岸", 1.0));
		keyWords.add(new org.ansj.app.keyword.Keyword("李克强", 1.0));
		keyWords.add(new org.ansj.app.keyword.Keyword("博鳌", 1.0));
		keyWords.add(new org.ansj.app.keyword.Keyword("12", 1.0));
		java.lang.System.out.println(tw.tagContent(keyWords, content));
	}
}