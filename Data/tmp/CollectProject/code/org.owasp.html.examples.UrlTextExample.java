public class UrlTextExample {
	static class AppendDomainAfterText extends org.owasp.html.HtmlStreamEventReceiverWrapper {
		private final java.util.List<java.lang.String> pendingText = new java.util.ArrayList<java.lang.String>();

		AppendDomainAfterText(org.owasp.html.HtmlStreamEventReceiver underlying) {
			super(underlying);
		}

		@java.lang.Override
		public void openTag(java.lang.String elementName, java.util.List<java.lang.String> attribs) {
			underlying.openTag(elementName, attribs);
			java.lang.String trailingText = null;
			if (!attribs.isEmpty()) {
				java.lang.String urlAttrName = null;
				if ("a".equals(elementName)) {
					urlAttrName = "href";
				} else if ("img".equals(elementName)) {
					urlAttrName = "src";
				}
				if (urlAttrName != null) {
					for (int i = 0, n = attribs.size(); i < n; i += 2) {
						if (urlAttrName.equals(attribs.get(i))) {
							java.lang.String url = attribs.get(i + 1).trim();
							java.lang.String domain = org.owasp.html.examples.UrlTextExample.domainOf(url);
							if (domain != null) {
								trailingText = " - " + domain;
							}
							break;
						}
					}
				}
			}
			if (org.owasp.html.HtmlTextEscapingMode.isVoidElement(elementName)) {
				if (trailingText != null) {
					text(trailingText);
				}
			} else {
				pendingText.add(trailingText);
			}
		}

		@java.lang.Override
		public void closeTag(java.lang.String elementName) {
			underlying.closeTag(elementName);
			int pendingTextSize = pendingText.size();
			if (pendingTextSize != 0) {
				java.lang.String trailingText = pendingText.remove(pendingTextSize - 1);
				if (trailingText != null) {
					text(trailingText);
				}
			}
		}
	}

	public static void run(java.lang.Appendable out, java.lang.String... inputs) throws java.io.IOException {
		org.owasp.html.PolicyFactory policyBuilder = new org.owasp.html.HtmlPolicyBuilder().allowAttributes("src").onElements("img").allowAttributes("href").onElements("a").allowStandardUrlProtocols().allowElements("a", "label", "h1", "h2", "h3", "h4", "h5", "h6", "p", "i", "b", "u", "strong", "em", "small", "big", "pre", "code", "cite", "samp", "sub", "sup", "strike", "center", "blockquote", "hr", "br", "col", "font", "span", "div", "img", "ul", "ol", "li", "dd", "dt", "dl", "tbody", "thead", "tfoot", "table", "td", "th", "tr", "colgroup", "fieldset", "legend").withPostprocessor(new org.owasp.html.HtmlStreamEventProcessor() {
			public org.owasp.html.HtmlStreamEventReceiver wrap(org.owasp.html.HtmlStreamEventReceiver sink) {
				return new org.owasp.html.examples.UrlTextExample.AppendDomainAfterText(sink);
			}
		}).toFactory();
		out.append(policyBuilder.sanitize(com.google.common.base.Joiner.on('\n').join(inputs)));
	}

	public static void main(java.lang.String... argv) throws java.io.IOException {
		org.owasp.html.examples.UrlTextExample.run(java.lang.System.out, argv);
		java.lang.System.out.println();
	}

	static java.lang.String domainOf(java.lang.String url) {
		int start = -1;
		if (url.startsWith("//")) {
			start = 2;
		} else {
			start = url.indexOf("://");
			if (start >= 0) {
				start += 3;
			}
		}
		if (start < 0) {
			return null;
		}
		for (int i = 0; i < (start - 3); ++i) {
			switch (url.charAt(i)) {
				case '/' :
				case '?' :
				case '#' :
					return null;
				default :
					break;
			}
		}
		int end = url.length();
		for (int i = start; i < end; ++i) {
			switch (url.charAt(i)) {
				case '/' :
				case '?' :
				case '#' :
					end = i;
					break;
				default :
					break;
			}
		}
		if (start < end) {
			return url.substring(start, end);
		} else {
			return null;
		}
	}
}