public class SiteMapTester {
	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(crawlercommons.sitemaps.SiteMapTester.class);

	private static crawlercommons.sitemaps.SiteMapParser saxParser = new crawlercommons.sitemaps.SiteMapParser(false, true);

	public static void main(java.lang.String[] args) throws java.io.IOException, crawlercommons.sitemaps.UnknownFormatException {
		if (args.length < 1) {
			crawlercommons.sitemaps.SiteMapTester.LOG.error("Fetch and process a sitemap (recursively if a sitemap index)");
			crawlercommons.sitemaps.SiteMapTester.LOG.error("Usage: SiteMapTester <URL_TO_TEST> [MIME_TYPE]");
			crawlercommons.sitemaps.SiteMapTester.LOG.error("Options:");
			crawlercommons.sitemaps.SiteMapTester.LOG.error("  URL_TO_TEST  URL of sitemap");
			crawlercommons.sitemaps.SiteMapTester.LOG.error("  MIME_TYPE    force processing sitemap as MIME type,");
			crawlercommons.sitemaps.SiteMapTester.LOG.error("               bypass automatic MIME type detection");
			crawlercommons.sitemaps.SiteMapTester.LOG.error("Java properties:");
			crawlercommons.sitemaps.SiteMapTester.LOG.error("  sitemap.strictNamespace");
			crawlercommons.sitemaps.SiteMapTester.LOG.error("                  if true sitemaps are required to use the standard namespace URI");
			crawlercommons.sitemaps.SiteMapTester.LOG.error("  sitemap.allow.dtd");
			crawlercommons.sitemaps.SiteMapTester.LOG.error("                  if true sitemaps are allowed to include a DTD");
			crawlercommons.sitemaps.SiteMapTester.LOG.error("  sitemap.extensions");
			crawlercommons.sitemaps.SiteMapTester.LOG.error("                  if true enable sitemap extension parsing");
			crawlercommons.sitemaps.SiteMapTester.LOG.error("  sitemap.filter.urls");
			crawlercommons.sitemaps.SiteMapTester.LOG.error("                  if true filter and normalize all URLs found in the sitemap");
			crawlercommons.sitemaps.SiteMapTester.LOG.error("                  using crawlercommons.filters.basic.BasicURLNormalizer");
		} else {
			java.net.URL url = new java.net.URL(args[0]);
			java.lang.String mt = (args.length > 1) ? args[1] : null;
			crawlercommons.sitemaps.SiteMapTester.parse(url, mt);
		}
	}

	private static void parse(java.net.URL url, java.lang.String mt) throws java.io.IOException, crawlercommons.sitemaps.UnknownFormatException {
		byte[] content = org.apache.commons.io.IOUtils.toByteArray(url);
		crawlercommons.sitemaps.SiteMapTester.LOG.info("Parsing {} {}", url, (mt != null) && (!mt.isEmpty()) ? "as MIME type " + mt : "");
		boolean strictNamespace = java.lang.Boolean.getBoolean("sitemap.strictNamespace");
		crawlercommons.sitemaps.SiteMapTester.saxParser.setStrictNamespace(strictNamespace);
		boolean allowDTD = java.lang.Boolean.getBoolean("sitemap.allow.dtd");
		crawlercommons.sitemaps.SiteMapTester.saxParser.setAllowDocTypeDefinitions(allowDTD);
		boolean enableExtensions = java.lang.Boolean.getBoolean("sitemap.extensions");
		if (enableExtensions) {
			crawlercommons.sitemaps.SiteMapTester.saxParser.enableExtensions();
		}
		boolean enableURLFilter = java.lang.Boolean.getBoolean("sitemap.filter.urls");
		if (enableURLFilter) {
			crawlercommons.sitemaps.SiteMapTester.saxParser.setURLFilter(new crawlercommons.filters.basic.BasicURLNormalizer());
		}
		crawlercommons.sitemaps.AbstractSiteMap sm = null;
		if ((mt == null) || mt.equals("")) {
			sm = crawlercommons.sitemaps.SiteMapTester.saxParser.parseSiteMap(content, url);
		} else {
			sm = crawlercommons.sitemaps.SiteMapTester.saxParser.parseSiteMap(mt, content, url);
		}
		if (sm.isIndex()) {
			java.util.Collection<crawlercommons.sitemaps.AbstractSiteMap> links = ((crawlercommons.sitemaps.SiteMapIndex) (sm)).getSitemaps();
			for (crawlercommons.sitemaps.AbstractSiteMap asm : links) {
				crawlercommons.sitemaps.SiteMapTester.parse(asm.getUrl(), mt);
			}
		} else {
			java.util.Collection<crawlercommons.sitemaps.SiteMapURL> links = ((crawlercommons.sitemaps.SiteMap) (sm)).getSiteMapUrls();
			for (crawlercommons.sitemaps.SiteMapURL smu : links) {
				if (enableExtensions) {
					crawlercommons.sitemaps.SiteMapTester.LOG.info(smu.toString());
				} else {
					crawlercommons.sitemaps.SiteMapTester.LOG.info(smu.getUrl().toString());
				}
			}
		}
	}
}