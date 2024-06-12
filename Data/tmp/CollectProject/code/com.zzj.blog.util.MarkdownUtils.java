public class MarkdownUtils {
	public static java.lang.String markdownToHtml(java.lang.String markdown) {
		org.commonmark.parser.Parser parser = org.commonmark.parser.Parser.builder().build();
		org.commonmark.node.Node document = parser.parse(markdown);
		org.commonmark.renderer.html.HtmlRenderer renderer = org.commonmark.renderer.html.HtmlRenderer.builder().build();
		return renderer.render(document);
	}

	public static java.lang.String markdownToHtmlExtensions(java.lang.String markdown) {
		java.util.Set<org.commonmark.Extension> headingAnchorExtensions = java.util.Collections.singleton(org.commonmark.ext.heading.anchor.HeadingAnchorExtension.create());
		java.util.List<org.commonmark.Extension> tableExtension = java.util.Arrays.asList(org.commonmark.ext.gfm.tables.TablesExtension.create());
		org.commonmark.parser.Parser parser = org.commonmark.parser.Parser.builder().extensions(tableExtension).build();
		org.commonmark.node.Node document = parser.parse(markdown);
		org.commonmark.renderer.html.HtmlRenderer renderer = org.commonmark.renderer.html.HtmlRenderer.builder().extensions(headingAnchorExtensions).extensions(tableExtension).attributeProviderFactory(new org.commonmark.renderer.html.AttributeProviderFactory() {
			public org.commonmark.renderer.html.AttributeProvider create(org.commonmark.renderer.html.AttributeProviderContext context) {
				return new com.zzj.blog.util.MarkdownUtils.CustomAttributeProvider();
			}
		}).build();
		return renderer.render(document);
	}

	static class CustomAttributeProvider implements org.commonmark.renderer.html.AttributeProvider {
		@java.lang.Override
		public void setAttributes(org.commonmark.node.Node node, java.lang.String tagName, java.util.Map<java.lang.String, java.lang.String> attributes) {
			if (node instanceof org.commonmark.node.Link) {
				attributes.put("target", "_blank");
			}
			if (node instanceof org.commonmark.ext.gfm.tables.TableBlock) {
				attributes.put("class", "ui celled table");
			}
		}
	}

	public static void main(java.lang.String[] args) {
		java.lang.String table = "| hello | hi   | 哈哈哈   |\n" + ((("| ----- | ---- | ----- |\n" + "| 斯维尔多  | 士大夫  | f啊    |\n") + "| 阿什顿发  | 非固定杆 | 撒阿什顿发 |\n") + "\n");
		java.lang.String a = "[imCoding 爱编程](http://www.lirenmi.cn)";
		java.lang.System.out.println(com.zzj.blog.util.MarkdownUtils.markdownToHtmlExtensions(a));
	}
}