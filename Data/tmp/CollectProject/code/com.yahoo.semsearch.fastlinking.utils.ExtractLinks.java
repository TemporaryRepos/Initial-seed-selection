public class ExtractLinks implements info.bliki.wiki.dump.IArticleFilter {
	private static final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("(.*)href=\"/(.*?)\"(.*)");

	private it.unimi.dsi.lang.MutableString html = new it.unimi.dsi.lang.MutableString();

	private it.unimi.dsi.lang.MutableString title = new it.unimi.dsi.lang.MutableString();

	protected final java.lang.String baseURL = "http://en.wikipedia.org/wiki/";

	protected final java.lang.String linkBaseURL = java.lang.String.valueOf(this.baseURL) + "${title}";

	protected final java.lang.String imageBaseURL = java.lang.String.valueOf(this.baseURL) + "${image}";

	protected final it.unimi.dsi.io.FastBufferedReader wordReader = new it.unimi.dsi.io.FastBufferedReader();

	protected final it.unimi.dsi.lang.MutableString word = new it.unimi.dsi.lang.MutableString();

	protected final it.unimi.dsi.lang.MutableString nonWord = new it.unimi.dsi.lang.MutableString();

	protected static final it.unimi.dsi.util.TextPattern BRACKETS_CLOSED = new it.unimi.dsi.util.TextPattern(((java.lang.CharSequence) ("]]")));

	protected static final it.unimi.dsi.util.TextPattern BRACES_CLOSED = new it.unimi.dsi.util.TextPattern(((java.lang.CharSequence) ("}}")));

	protected final java.io.FileWriter writer;

	public ExtractLinks(java.lang.String file) throws java.io.IOException {
		this.writer = new java.io.FileWriter(file);
	}

	public static void main(java.lang.String[] arg) {
		if (arg.length < 2) {
			java.lang.System.err.println(" USAGE java ExtractLinks  <inputFile> <output file> ");
		}
		try {
			com.yahoo.semsearch.fastlinking.utils.ExtractLinks handler = new com.yahoo.semsearch.fastlinking.utils.ExtractLinks(arg[1]);
			info.bliki.wiki.dump.WikiXMLParser wxp = new info.bliki.wiki.dump.WikiXMLParser(arg[0], ((info.bliki.wiki.dump.IArticleFilter) (handler)));
			wxp.parse();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	@java.lang.Override
	public void process(info.bliki.wiki.dump.WikiArticle article, info.bliki.wiki.dump.Siteinfo siteinfo) throws org.xml.sax.SAXException {
		this.title.length(0);
		this.html.length(0);
		try {
			this.title.append(java.net.URLEncoder.encode(article.getTitle().replace(' ', '_'), "UTF-8"));
		} catch (java.io.UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		info.bliki.wiki.model.WikiModel wikiModel = new info.bliki.wiki.model.WikiModel(this.imageBaseURL, this.linkBaseURL);
		java.lang.String plainText = wikiModel.render(((info.bliki.wiki.filter.ITextConverter) (new info.bliki.wiki.filter.PlainTextConverter())), article.getText());
		java.util.Set<java.lang.String> links = wikiModel.getLinks();
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		for (java.lang.String link : links) {
			sb.append(" ").append(this.processLink(link));
		}
		sb.append("\t");
		java.lang.String slinks = sb.toString();
		it.unimi.dsi.lang.MutableString allText = new it.unimi.dsi.lang.MutableString(plainText);
		this.word.length(0);
		this.nonWord.length(0);
		this.wordReader.setReader(((java.io.Reader) (new it.unimi.dsi.io.FastBufferedReader(allText))));
		try {
			this.writer.append(this.title).append("\t");
			this.writer.append(slinks);
			while (this.wordReader.next(this.word, this.nonWord)) {
				this.writer.append(this.word.toLowerCase()).append(" ");
			} 
			this.writer.append("\n");
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	public java.lang.String processLink(java.lang.String input) {
		java.lang.String jj = info.bliki.wiki.model.WikiModel.toHtml(((java.lang.String) (("[[" + input) + "]]")));
		java.util.regex.Matcher matcher = com.yahoo.semsearch.fastlinking.utils.ExtractLinks.pattern.matcher(jj);
		if (!matcher.find()) {
			return "";
		}
		jj = matcher.group(2);
		return jj;
	}
}