public class ExtractFirstParagraphs implements info.bliki.wiki.dump.IArticleFilter {
	protected final java.lang.String baseURL = "http://en.wikipedia.org/wiki/";

	protected final java.lang.String linkBaseURL = java.lang.String.valueOf(this.baseURL) + "${title}";

	protected final java.lang.String imageBaseURL = java.lang.String.valueOf(this.baseURL) + "${image}";

	protected final it.unimi.dsi.io.FastBufferedReader wordReader = new it.unimi.dsi.io.FastBufferedReader();

	protected final it.unimi.dsi.lang.MutableString word = new it.unimi.dsi.lang.MutableString();

	protected final it.unimi.dsi.lang.MutableString nonWord = new it.unimi.dsi.lang.MutableString();

	protected static final it.unimi.dsi.util.TextPattern BRACKETS_CLOSED = new it.unimi.dsi.util.TextPattern(((java.lang.CharSequence) ("]]")));

	protected static final it.unimi.dsi.util.TextPattern BRACES_CLOSED = new it.unimi.dsi.util.TextPattern(((java.lang.CharSequence) ("}}")));

	protected final java.io.FileWriter writer;

	private it.unimi.dsi.lang.MutableString title = new it.unimi.dsi.lang.MutableString();

	protected it.unimi.dsi.lang.MutableString firstPar = new it.unimi.dsi.lang.MutableString();

	public ExtractFirstParagraphs(java.lang.String file) throws java.io.IOException {
		this.writer = new java.io.FileWriter(file);
	}

	public static void main(java.lang.String[] arg) {
		if (arg.length < 2) {
			java.lang.System.err.println(" USAGE java ExtractFirstParagraphs  <inputFile> <outputFile>");
		}
		try {
			com.yahoo.semsearch.fastlinking.utils.ExtractFirstParagraphs handler = new com.yahoo.semsearch.fastlinking.utils.ExtractFirstParagraphs(arg[1]);
			info.bliki.wiki.dump.WikiXMLParser wxp = new info.bliki.wiki.dump.WikiXMLParser(arg[0], ((info.bliki.wiki.dump.IArticleFilter) (handler)));
			wxp.parse();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	@java.lang.SuppressWarnings("deprecation")
	@java.lang.Override
	public void process(info.bliki.wiki.dump.WikiArticle article, info.bliki.wiki.dump.Siteinfo siteinfo) throws org.xml.sax.SAXException {
		this.title.length(0);
		this.firstPar.length(0);
		this.title.append(java.net.URLEncoder.encode(article.getTitle().replace(' ', '_')));
		info.bliki.wiki.model.WikiModel wikiModel = new info.bliki.wiki.model.WikiModel(this.imageBaseURL, this.linkBaseURL);
		java.lang.String plainText = wikiModel.render(new info.bliki.wiki.filter.PlainTextConverter(), article.getText());
		for (int start = 0; start < plainText.length(); ++start) {
			if (java.lang.Character.isWhitespace(plainText.charAt(start))) {
				continue;
			}
			if (plainText.charAt(start) == '{') {
				if ((start = com.yahoo.semsearch.fastlinking.utils.ExtractFirstParagraphs.BRACES_CLOSED.search(plainText, start)) == (-1)) {
					break;
				}
				++start;
				continue;
			}
			if (plainText.charAt(start) == '[') {
				if ((start = com.yahoo.semsearch.fastlinking.utils.ExtractFirstParagraphs.BRACKETS_CLOSED.search(plainText, start)) == (-1)) {
					break;
				}
				++start;
				continue;
			}
			int end = plainText.indexOf(10, start);
			if (end <= start) {
				break;
			}
			this.firstPar.append(plainText.substring(start, end));
			break;
		}
		this.word.length(0);
		this.nonWord.length(0);
		this.wordReader.setReader(((java.io.Reader) (new it.unimi.dsi.io.FastBufferedReader(this.firstPar))));
		try {
			this.writer.append(this.title).append("\t");
			while (this.wordReader.next(this.word, this.nonWord)) {
				this.writer.append(this.word.toLowerCase()).append(" ");
			} 
			this.writer.append("\n");
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
}