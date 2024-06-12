@java.lang.SuppressWarnings("ALL")
@org.springframework.stereotype.Controller
@org.springframework.web.bind.annotation.RequestMapping("/document/")
public class DocumentController {
	private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(io.github.mayhewsw.controllers.DocumentController.class);

	private java.util.List<java.lang.String> labels;

	@org.springframework.web.bind.annotation.RequestMapping("/")
	public java.lang.String home(org.springframework.ui.Model model, javax.servlet.http.HttpSession hs) {
		io.github.mayhewsw.controllers.Common.loadConfig();
		model.addAttribute("user", new io.github.mayhewsw.User());
		return "document/home";
	}

	public java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> loadFolder(java.lang.String dataname, java.lang.String username, java.util.HashMap<java.lang.String, io.github.mayhewsw.ConfigFile> datasets) throws java.lang.Exception {
		io.github.mayhewsw.ConfigFile props = datasets.get(dataname);
		java.lang.String folderurl = props.getFolderpath();
		java.lang.String foldertype = props.getFormat();
		if (foldertype == null) {
			foldertype = "tajson";
			props.setProperty("format", "tajson");
		}
		java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> ret = new java.util.TreeMap<>(new io.github.mayhewsw.KeyComparator());
		io.github.mayhewsw.controllers.TextStatisticsController.resetstats();
		io.github.mayhewsw.utils.IO.read(foldertype, folderurl, ret);
		for (edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta : ret.values()) {
			io.github.mayhewsw.controllers.TextStatisticsController.updateCounts(ta.getTokens());
			if (!ta.hasView(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.NER_CONLL)) {
				edu.illinois.cs.cogcomp.core.datastructures.textannotation.View ner = new edu.illinois.cs.cogcomp.core.datastructures.textannotation.View(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.NER_CONLL, "", ta, 1.0);
				ta.addView(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.NER_CONLL, ner);
			}
		}
		java.lang.String outfolder = ((folderurl.replaceAll("/$", "") + "-annotation-") + username) + "/";
		io.github.mayhewsw.controllers.DocumentController.logger.info("Now looking in user annotation folder: " + outfolder);
		if (new java.io.File(outfolder).exists()) {
			io.github.mayhewsw.utils.IO.read(foldertype, outfolder, ret);
		}
		return ret;
	}

	public void updateallpatterns(io.github.mayhewsw.SessionData sd) {
		io.github.mayhewsw.controllers.DocumentController.logger.info("Updating all patterns...");
		sd.patterns.clear();
		java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Double>> labelcounts = new java.util.HashMap<>();
		for (java.lang.String label : labels) {
			labelcounts.put(label, new java.util.HashMap<>());
		}
		java.util.HashMap<edu.illinois.cs.cogcomp.core.datastructures.Pair<java.lang.String, java.lang.String>, java.lang.Double> counts = new java.util.HashMap<>();
		java.util.HashMap<java.lang.String, java.lang.Integer> featcounts = new java.util.HashMap<>();
		for (java.lang.String newtaid : sd.tas.keySet()) {
			edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta = sd.tas.get(newtaid);
			io.github.mayhewsw.FeatureExtractor.extract(ta);
			edu.illinois.cs.cogcomp.core.datastructures.textannotation.View feats = ta.getView("feats");
			edu.illinois.cs.cogcomp.core.datastructures.textannotation.View ner = ta.getView(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.NER_CONLL);
			for (edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent f : feats.getConstituents()) {
				java.util.List<edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent> nercs = ner.getConstituentsCoveringSpan(f.getStartSpan(), f.getEndSpan());
				if (nercs.size() > 0) {
					java.lang.String label = nercs.get(0).getLabel();
					counts.merge(new edu.illinois.cs.cogcomp.core.datastructures.Pair<>(f.getLabel(), label), 1.0, ( oldValue, one) -> oldValue + one);
					featcounts.merge(f.getLabel(), 1, ( oldValue, one) -> oldValue + one);
				}
			}
		}
		int k = labels.size();
		double alpha = 0.1;
		double threshold = 0.95;
		double fullstringthreshold = 0.8;
		for (edu.illinois.cs.cogcomp.core.datastructures.Pair<java.lang.String, java.lang.String> fp : counts.keySet()) {
			java.lang.String feat = fp.getFirst();
			int featoccurrences = featcounts.get(feat);
			double newvalue = (counts.get(fp) + alpha) / (featoccurrences + (k * alpha));
			if (feat.startsWith("full-string") && (newvalue > fullstringthreshold)) {
				sd.patterns.put(fp, newvalue);
			} else if (newvalue > threshold) {
				sd.patterns.put(fp, newvalue);
			}
		}
		io.github.mayhewsw.controllers.DocumentController.logger.info("Done updating patterns.");
	}

	@org.springframework.web.bind.annotation.RequestMapping(value = "/loaddata", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public java.lang.String loaddata(@org.springframework.web.bind.annotation.RequestParam("dataname")
	java.lang.String dataname, javax.servlet.http.HttpSession hs, org.springframework.ui.Model model) throws java.lang.Exception {
		io.github.mayhewsw.SessionData sd = new io.github.mayhewsw.SessionData(hs);
		java.lang.String username = sd.username;
		io.github.mayhewsw.ConfigFile prop = sd.datasets.get(dataname);
		java.lang.String folderpath = prop.getFolderpath();
		java.lang.String labelsproperty = prop.getLabels();
		labels = new java.util.ArrayList<>();
		java.util.List<java.lang.String> csslines = new java.util.ArrayList<java.lang.String>();
		for (java.lang.String label : labelsproperty.split(" ")) {
			label = label.replaceAll(":", "");
			label = label.replaceAll("\\.", "");
			label = label.replaceAll("#", "");
			labels.add(label);
			java.lang.String color = io.github.mayhewsw.utils.Utils.getColorOrRandom(label);
			csslines.add(((("." + label) + "{ background-color: ") + color) + "; }");
		}
		io.github.mayhewsw.controllers.DocumentController.logger.debug("using labels: " + labels.toString());
		edu.illinois.cs.cogcomp.core.io.LineIO.write("src/main/resources/static/css/labels.css", csslines);
		java.lang.String dictpath = prop.getProperty("dict");
		io.github.mayhewsw.Dictionary dict;
		if (dictpath != null) {
			io.github.mayhewsw.controllers.DocumentController.logger.info("Loading dictionary: " + dictpath);
			dict = new io.github.mayhewsw.Dictionary(dataname, dictpath, sd.username);
		} else {
			io.github.mayhewsw.controllers.DocumentController.logger.info("No dictionary specified.");
			dict = new io.github.mayhewsw.Dictionary(dataname, sd.username);
		}
		hs.setAttribute("dict", dict);
		java.util.HashMap<edu.illinois.cs.cogcomp.core.datastructures.Pair<java.lang.String, java.lang.String>, java.lang.Integer> patterns = new java.util.HashMap<>();
		java.lang.String errormsg = null;
		java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> tas;
		try {
			tas = loadFolder(dataname, username, sd.datasets);
			hs.setAttribute("tas", tas);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			errormsg = e.getMessage();
		}
		if (errormsg != null) {
			model.addAttribute("datasets", sd.datasets.keySet());
			model.addAttribute("user", new io.github.mayhewsw.User());
			model.addAttribute("errormsg", errormsg);
			model.addAttribute("config", new io.github.mayhewsw.ConfigFile());
			return "index";
		}
		java.lang.String logpath = "logs/";
		java.lang.String logfile = java.lang.String.format("%s/%s-%s.log", logpath, dataname, username);
		hs.setAttribute("logfile", logfile);
		io.github.mayhewsw.controllers.DocumentController.logger.info("Writing to logfile: " + logfile);
		hs.setAttribute("ramdirectory", new org.apache.lucene.store.RAMDirectory());
		hs.setAttribute("dataname", dataname);
		hs.setAttribute("prop", prop);
		hs.setAttribute("patterns", patterns);
		sd = new io.github.mayhewsw.SessionData(hs);
		buildmemoryindex(sd);
		return "redirect:/document/annotation/";
	}

	public static void logwrite(java.lang.String msg, javax.servlet.http.HttpSession hs) {
		io.github.mayhewsw.SessionData sd = new io.github.mayhewsw.SessionData(hs);
		java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		java.lang.String time = dateFormat.format(date);
		msg = (time + "\t") + msg;
		try {
			edu.illinois.cs.cogcomp.core.io.LineIO.append(sd.logfile, msg);
		} catch (java.io.IOException e) {
			io.github.mayhewsw.controllers.DocumentController.logger.error("Cannot log to: " + sd.logfile);
			e.printStackTrace();
		}
	}

	@org.springframework.web.bind.annotation.RequestMapping(value = "/save", method = org.springframework.web.bind.annotation.RequestMethod.POST)
	@org.springframework.web.bind.annotation.ResponseBody
	public java.util.HashMap<java.lang.String, java.lang.Double> save(@org.springframework.web.bind.annotation.RequestParam(value = "sentids[]", required = true)
	java.lang.String[] sentids, javax.servlet.http.HttpSession hs) throws java.lang.Exception {
		io.github.mayhewsw.SessionData sd = new io.github.mayhewsw.SessionData(hs);
		java.lang.String username = sd.username;
		java.lang.String folder = sd.dataname;
		io.github.mayhewsw.ConfigFile props = sd.datasets.get(folder);
		java.lang.String folderpath = props.getFolderpath();
		java.lang.String foldertype = props.getFormat();
		assert sentids.length == 1;
		java.lang.String taid = sentids[0];
		if ((username != null) && (folderpath != null)) {
			folderpath = folderpath.replaceAll("/$", "");
			java.lang.String outpath = ((folderpath + "-annotation-") + username) + "/";
			io.github.mayhewsw.controllers.DocumentController.logger.info("Writing out to: " + outpath);
			io.github.mayhewsw.controllers.DocumentController.logger.info("id is: " + taid);
			java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> tas = sd.tas;
			edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation taToSave = tas.get(taid);
			io.github.mayhewsw.utils.IO.save(foldertype, outpath, taToSave);
		}
		java.lang.String indexDir = sd.prop.getProperty("indexDir");
		java.util.HashMap<java.lang.String, java.lang.Double> result = new java.util.LinkedHashMap<>();
		if (indexDir != null) {
			org.apache.lucene.index.IndexReader reader = org.apache.lucene.index.DirectoryReader.open(org.apache.lucene.store.FSDirectory.open(java.nio.file.Paths.get(indexDir)));
			org.apache.lucene.search.IndexSearcher searcher = new org.apache.lucene.search.IndexSearcher(reader);
			java.util.HashMap<java.lang.String, java.lang.Double> docstosee = new java.util.HashMap<>();
			for (edu.illinois.cs.cogcomp.core.datastructures.Pair<java.lang.String, java.lang.String> featpair : sd.patterns.keySet()) {
				java.lang.String feat = featpair.getFirst();
				if (!feat.startsWith("full-string")) {
					continue;
				}
				java.lang.String text = feat.split("=")[1];
				java.lang.String label = featpair.getSecond();
				org.apache.lucene.search.Query q = new org.apache.lucene.queryparser.classic.QueryParser("body", io.github.mayhewsw.controllers.DocumentController.analyzer).parse(("\"" + text) + "\"");
				java.lang.System.out.println(q);
				org.apache.lucene.search.TopScoreDocCollector collector = org.apache.lucene.search.TopScoreDocCollector.create(5);
				searcher.search(q, collector);
				org.apache.lucene.search.ScoreDoc[] hits = collector.topDocs().scoreDocs;
				java.lang.System.out.println(("Found " + hits.length) + " hits.");
				for (int i = 0; i < hits.length; ++i) {
					int docId = hits[i].doc;
					org.apache.lucene.document.Document d = searcher.doc(docId);
					java.lang.System.out.println(((((i + 1) + ". ") + d.get("filename")) + " score=") + hits[i].score);
					java.lang.String docid = d.get("filename");
					if (!sd.tas.containsKey(docid)) {
						continue;
					}
					if (docid.equals(taid)) {
						continue;
					}
					edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation docta = sd.tas.get(docid);
					edu.illinois.cs.cogcomp.core.datastructures.textannotation.View ner = docta.getView(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.NER_CONLL);
					boolean add = true;
					for (edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent c : ner.getConstituents()) {
						if (c.getTokenizedSurfaceForm().equals(text)) {
							add = false;
							break;
						}
					}
					if (add) {
						double currscore = docstosee.getOrDefault(docid, 0.0);
						docstosee.put(docid, currscore + hits[i].score);
					}
				}
			}
			java.lang.System.out.println("Check out these docs:");
			docstosee.entrySet().stream().sorted(java.util.Map.Entry.<java.lang.String, java.lang.Double>comparingByValue().reversed()).limit(5).forEachOrdered(( x) -> result.put(x.getKey(), x.getValue()));
			java.lang.System.out.println(result);
			reader.close();
		}
		return result;
	}

	private static org.apache.lucene.analysis.Analyzer analyzer = new org.apache.lucene.analysis.Analyzer() {
		@java.lang.Override
		protected org.apache.lucene.analysis.Analyzer.TokenStreamComponents createComponents(java.lang.String fieldName) {
			org.apache.lucene.analysis.Tokenizer source = new org.apache.lucene.analysis.core.WhitespaceTokenizer();
			org.apache.lucene.analysis.TokenStream filter = new org.apache.lucene.analysis.shingle.ShingleFilter(source);
			return new org.apache.lucene.analysis.Analyzer.TokenStreamComponents(source, filter);
		}
	};

	@org.springframework.web.bind.annotation.RequestMapping("/setname")
	public java.lang.String setname(@org.springframework.web.bind.annotation.ModelAttribute
	io.github.mayhewsw.User user, javax.servlet.http.HttpSession hs) {
		io.github.mayhewsw.controllers.DocumentController.logger.info("Setting name to: " + user.getName());
		io.github.mayhewsw.controllers.DocumentController.logger.info("Logging in!");
		io.github.mayhewsw.controllers.DocumentController.logwrite("Logging in!", hs);
		hs.removeAttribute("username");
		hs.removeAttribute("dataname");
		hs.removeAttribute("tas");
		hs.removeAttribute("dict");
		hs.removeAttribute("suffixes");
		hs.removeAttribute("prop");
		hs.setAttribute("username", user.getName());
		hs.setAttribute("showdefs", false);
		return "redirect:/";
	}

	@org.springframework.web.bind.annotation.RequestMapping(value = "/search", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public java.lang.String search(@org.springframework.web.bind.annotation.RequestParam(value = "query", required = true)
	java.lang.String query, javax.servlet.http.HttpSession hs, org.springframework.ui.Model model) throws java.io.IOException, org.apache.lucene.queryparser.classic.ParseException {
		io.github.mayhewsw.SessionData sd = new io.github.mayhewsw.SessionData(hs);
		java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> tas = sd.tas;
		java.util.List<java.lang.String> annotatedfiles = new java.util.ArrayList<>();
		java.lang.String dataname = sd.dataname;
		java.util.Properties props = sd.datasets.get(dataname);
		java.lang.String folderpath = props.getProperty("folderpath");
		java.lang.String username = sd.username;
		java.lang.String outfolder = ((folderpath.replaceAll("/$", "") + "-annotation-") + username) + "/";
		io.github.mayhewsw.controllers.DocumentController.logger.info("Now looking in user annotation folder: " + outfolder);
		java.io.File f = new java.io.File(outfolder);
		if (f.exists()) {
			annotatedfiles.addAll(java.util.Arrays.asList(f.list()));
		}
		java.lang.System.out.println(annotatedfiles);
		java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> newtas = filterTA(query, sd);
		model.addAttribute("tamap", newtas);
		model.addAttribute("annotatedfiles", annotatedfiles);
		return "document/getstarted";
	}

	public void buildmemoryindex(io.github.mayhewsw.SessionData sd) throws java.io.IOException {
		org.apache.lucene.store.RAMDirectory rd = sd.ramDirectory;
		org.apache.lucene.index.IndexWriterConfig cfg = new org.apache.lucene.index.IndexWriterConfig(io.github.mayhewsw.controllers.DocumentController.analyzer);
		org.apache.lucene.index.IndexWriter writer = new org.apache.lucene.index.IndexWriter(rd, cfg);
		for (java.lang.String taid : sd.tas.keySet()) {
			edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta = sd.tas.get(taid);
			java.io.StringReader sr = new java.io.StringReader(ta.getTokenizedText());
			org.apache.lucene.document.Document d = new org.apache.lucene.document.Document();
			org.apache.lucene.document.TextField tf = new org.apache.lucene.document.TextField("body", sr);
			d.add(tf);
			d.add(new org.apache.lucene.document.StringField("filename", ta.getId(), org.apache.lucene.document.Field.Store.YES));
			writer.addDocument(d);
		}
		writer.close();
	}

	public java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> filterTA(java.lang.String query, io.github.mayhewsw.SessionData sd) throws java.io.IOException, org.apache.lucene.queryparser.classic.ParseException {
		java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> tas = sd.tas;
		java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> ret = new java.util.TreeMap<>(new io.github.mayhewsw.KeyComparator());
		org.apache.lucene.search.IndexSearcher searcher = new org.apache.lucene.search.IndexSearcher(org.apache.lucene.index.DirectoryReader.open(sd.ramDirectory));
		org.apache.lucene.search.Query q = new org.apache.lucene.search.PrefixQuery(new org.apache.lucene.index.Term("body", query));
		org.apache.lucene.search.TopScoreDocCollector collector = org.apache.lucene.search.TopScoreDocCollector.create(20);
		searcher.search(q, collector);
		org.apache.lucene.search.ScoreDoc[] hits = collector.topDocs().scoreDocs;
		for (int i = 0; i < hits.length; ++i) {
			int luceneId = hits[i].doc;
			org.apache.lucene.document.Document d = searcher.doc(luceneId);
			java.lang.String docid = d.get("filename");
			edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation docta = sd.tas.get(docid);
			ret.put(docid, docta);
		}
		return ret;
	}

	@org.springframework.web.bind.annotation.RequestMapping(value = "/trysomeunianno", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public java.lang.String unifiedannotation(@org.springframework.web.bind.annotation.RequestParam(value = "taid", required = false)
	java.lang.String taid, javax.servlet.http.HttpSession hs, org.springframework.ui.Model model) throws java.io.FileNotFoundException {
		io.github.mayhewsw.SessionData sd = new io.github.mayhewsw.SessionData(hs);
		java.util.Map.Entry<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> entry = sd.tas.firstEntry();
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta = entry.getValue();
		java.lang.String html = io.github.mayhewsw.utils.HtmlGenerator.getHTMLfromTA(ta, sd.dict, sd.showdefs, sd.showroman, sd.allowcopy, sd.showgoogle);
		model.addAttribute("html", html);
		model.addAttribute("labels", labels);
		return "unified-annotation";
	}

	@org.springframework.web.bind.annotation.RequestMapping(value = "/annotation", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public java.lang.String annotation(@org.springframework.web.bind.annotation.RequestParam(value = "taid", required = false)
	java.lang.String taid, javax.servlet.http.HttpSession hs, org.springframework.ui.Model model) throws java.io.FileNotFoundException {
		io.github.mayhewsw.SessionData sd = new io.github.mayhewsw.SessionData(hs);
		java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> tas = sd.tas;
		io.github.mayhewsw.Dictionary dict = sd.dict;
		if (tas == null) {
			return "redirect:/document";
		}
		if (taid == null) {
			java.util.List<java.lang.String> annotatedfiles = new java.util.ArrayList<>();
			java.lang.String dataname = sd.dataname;
			java.util.Properties props = sd.datasets.get(dataname);
			java.lang.String folderpath = props.getProperty("folderpath");
			java.lang.String username = sd.username;
			java.lang.String outfolder = ((folderpath.replaceAll("/$", "") + "-annotation-") + username) + "/";
			io.github.mayhewsw.controllers.DocumentController.logger.info("Now looking in user annotation folder: " + outfolder);
			java.io.File f = new java.io.File(outfolder);
			if (f.exists()) {
				annotatedfiles.addAll(java.util.Arrays.asList(f.list()));
			}
			model.addAttribute("tamap", sd.tas);
			model.addAttribute("annotatedfiles", annotatedfiles);
			java.util.List<java.lang.String> stats = new java.util.ArrayList<>();
			stats.add("Numdocs: " + sd.tas.size());
			stats.add("Num annotated: " + annotatedfiles.size());
			java.util.HashSet<java.lang.String> surfaces = new java.util.HashSet<>();
			int totalsurfaces = 0;
			int totaltokens = 0;
			for (edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta : sd.tas.values()) {
				totaltokens += ta.getTokens().length;
				java.util.List<java.lang.String> ret = ta.getView(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.NER_CONLL).getConstituents().stream().map(( c) -> c.getTokenizedSurfaceForm()).collect(java.util.stream.Collectors.toList());
				totalsurfaces += ret.size();
				surfaces.addAll(ret);
			}
			stats.add("Total tokens: " + totaltokens);
			stats.add("Total entity surfaces: " + totalsurfaces);
			stats.add("Unique entity surfaces: " + surfaces.size());
			model.addAttribute("stats", stats);
			return "document/getstarted";
		}
		if (!tas.containsKey(taid)) {
			return "redirect:document/annotation";
		}
		io.github.mayhewsw.controllers.DocumentController.logwrite(java.lang.String.format("Viewing page with taid: %s", taid), hs);
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta = tas.get(taid);
		model.addAttribute("ta", ta);
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.View ner = ta.getView(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.NER_CONLL);
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.View sents = ta.getView(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.SENTENCE);
		java.lang.String out = io.github.mayhewsw.utils.HtmlGenerator.getHTMLfromTA(ta, sd.dict, sd.showdefs, sd.showroman, sd.allowcopy, sd.showgoogle);
		model.addAttribute("html", out);
		if (!tas.firstKey().equals(taid)) {
			model.addAttribute("previd", tas.lowerKey(taid));
		} else {
			model.addAttribute("previd", -1);
		}
		if (!tas.lastKey().equals(taid)) {
			model.addAttribute("nextid", tas.higherKey(taid));
		} else {
			model.addAttribute("nextid", -1);
		}
		model.addAttribute("labels", labels);
		java.util.HashMap<java.lang.String, java.lang.Integer> freqs = new java.util.HashMap<>();
		for (java.lang.String word : ta.getTokens()) {
			if (word.length() <= 1) {
				continue;
			}
			if (!freqs.containsKey(word)) {
				freqs.put(word, 0);
			}
			freqs.put(word, freqs.get(word) + 1);
		}
		java.util.List<java.lang.String> docwords = new java.util.ArrayList<>();
		freqs.entrySet().stream().sorted(java.util.Map.Entry.<java.lang.String, java.lang.Integer>comparingByValue().reversed()).forEachOrdered(( x) -> docwords.add(x.getKey()));
		model.addAttribute("docwords", docwords.subList(0, java.lang.Math.min(50, docwords.size())));
		java.lang.String parallelpath = sd.prop.getProperty("parallelpath");
		if (parallelpath != null) {
			java.lang.String parid = taid.split("-")[1].split("\\.")[0];
			java.lang.String file = edu.illinois.cs.cogcomp.core.io.LineIO.slurp((parallelpath + "/en-") + parid);
			java.lang.System.out.println((("Trying to read: " + parallelpath) + "/en-") + parid);
			model.addAttribute("engtext", file);
		}
		return "document/annotation";
	}

	@org.springframework.web.bind.annotation.RequestMapping(value = "/addspan", method = org.springframework.web.bind.annotation.RequestMethod.POST)
	@org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
	@org.springframework.web.bind.annotation.ResponseBody
	public void addspan(@org.springframework.web.bind.annotation.RequestParam("label")
	java.lang.String label, @org.springframework.web.bind.annotation.RequestParam("starttokid")
	java.lang.String starttokid, @org.springframework.web.bind.annotation.RequestParam("endtokid")
	java.lang.String endtokid, @org.springframework.web.bind.annotation.RequestParam("id")
	java.lang.String idstring, javax.servlet.http.HttpSession hs, org.springframework.ui.Model model) throws java.lang.Exception {
		io.github.mayhewsw.controllers.DocumentController.logger.info(java.lang.String.format("TextAnnotation with id %s: change span %s-%s to label: %s.", idstring, starttokid, endtokid, label));
		int starttokint = java.lang.Integer.parseInt(starttokid);
		int endtokint = java.lang.Integer.parseInt(endtokid);
		io.github.mayhewsw.SessionData sd = new io.github.mayhewsw.SessionData(hs);
		java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> tas = sd.tas;
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta = tas.get(idstring);
		if (ta.hasView(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.SENTENCE)) {
			edu.illinois.cs.cogcomp.core.datastructures.textannotation.View sents = ta.getView(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.SENTENCE);
			java.util.List<edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent> sentlc = sents.getConstituentsCoveringSpan(starttokint, endtokint);
			if (sentlc.size() != 1) {
				java.lang.String out = io.github.mayhewsw.utils.HtmlGenerator.getHTMLfromTA(ta, sd.dict, sd.showdefs, sd.showroman, sd.allowcopy, sd.showgoogle);
				java.lang.System.out.println("Cannot annotate across sentences");
				return;
			}
		}
		java.lang.String text = edu.illinois.cs.cogcomp.core.utilities.StringUtils.join(" ", ta.getTokensInSpan(starttokint, endtokint));
		java.util.List<edu.illinois.cs.cogcomp.core.datastructures.IntPair> spans = new java.util.ArrayList<>();
		boolean propagate = true;
		if (propagate) {
			spans = ta.getSpansMatching(text);
		}
		if ((spans.size() == 0) || (!propagate)) {
			spans = new java.util.ArrayList<>();
			spans.add(new edu.illinois.cs.cogcomp.core.datastructures.IntPair(starttokint, endtokint));
		}
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.View ner = ta.getView(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.NER_CONLL);
		for (edu.illinois.cs.cogcomp.core.datastructures.IntPair span : spans) {
			java.util.List<edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent> lc = ner.getConstituentsCoveringSpan(span.getFirst(), span.getSecond());
			if (lc.size() > 0) {
				boolean removed = false;
				for (edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent oldc : lc) {
					edu.illinois.cs.cogcomp.core.datastructures.IntPair oldspan = oldc.getSpan();
					int a = span.getFirst();
					int b = span.getSecond();
					int c = oldspan.getFirst();
					int d = oldspan.getSecond();
					if ((a == c) && (b >= d)) {
						ner.removeConstituent(oldc);
						removed = true;
					} else if ((a <= c) && (b == d)) {
						ner.removeConstituent(oldc);
						removed = true;
					}
				}
				if (!removed) {
					continue;
				}
			}
			if (label.equals("O")) {
				java.lang.System.err.println("Should never happen: label is O");
			} else {
				edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent newc = new edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent(label, edu.illinois.cs.cogcomp.core.datastructures.ViewNames.NER_CONLL, ta, span.getFirst(), span.getSecond());
				ner.addConstituent(newc);
				io.github.mayhewsw.controllers.DocumentController.logwrite(java.lang.String.format("%s span (%s-%s) to label: %s", idstring, span.getFirst(), span.getSecond(), label), hs);
			}
		}
	}

	@org.springframework.web.bind.annotation.RequestMapping(value = "/removetoken", method = org.springframework.web.bind.annotation.RequestMethod.POST)
	@org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
	@org.springframework.web.bind.annotation.ResponseBody
	public java.lang.String removetoken(@org.springframework.web.bind.annotation.RequestParam("tokid")
	java.lang.String tokid, @org.springframework.web.bind.annotation.RequestParam("sentid")
	java.lang.String idstring, javax.servlet.http.HttpSession hs, org.springframework.ui.Model model) throws java.lang.Exception {
		io.github.mayhewsw.controllers.DocumentController.logger.info(java.lang.String.format("TextAnnotation with id %s: remove token (id:%s).", idstring, tokid));
		io.github.mayhewsw.controllers.DocumentController.logwrite(java.lang.String.format("%s tokenid (%s) remove label", idstring, tokid), hs);
		int tokint = java.lang.Integer.parseInt(tokid);
		edu.illinois.cs.cogcomp.core.datastructures.Pair<java.lang.Integer, java.lang.Integer> tokspan = new edu.illinois.cs.cogcomp.core.datastructures.Pair<>(tokint, tokint + 1);
		io.github.mayhewsw.SessionData sd = new io.github.mayhewsw.SessionData(hs);
		java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> tas = sd.tas;
		io.github.mayhewsw.Dictionary dict = sd.dict;
		java.lang.Boolean showdefs = sd.showdefs;
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta = tas.get(idstring);
		java.lang.String[] spantoks = ta.getTokensInSpan(tokspan.getFirst(), tokspan.getSecond());
		java.lang.String text = edu.illinois.cs.cogcomp.core.utilities.StringUtils.join(" ", spantoks);
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.View ner = ta.getView(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.NER_CONLL);
		java.util.List<edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent> lc = ner.getConstituentsCoveringSpan(tokspan.getFirst(), tokspan.getSecond());
		if (lc.size() > 0) {
			edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent oldc = lc.get(0);
			int origstart = oldc.getStartSpan();
			int origend = oldc.getEndSpan();
			java.lang.String origlabel = oldc.getLabel();
			ner.removeConstituent(oldc);
			if (origstart != tokspan.getFirst()) {
				edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent newc = new edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent(origlabel, edu.illinois.cs.cogcomp.core.datastructures.ViewNames.NER_CONLL, ta, origstart, tokspan.getFirst());
				ner.addConstituent(newc);
			} else if (origend != tokspan.getSecond()) {
				edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent newc = new edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent(origlabel, edu.illinois.cs.cogcomp.core.datastructures.ViewNames.NER_CONLL, ta, tokspan.getSecond(), origend);
				ner.addConstituent(newc);
			}
		}
		java.lang.String out = io.github.mayhewsw.utils.HtmlGenerator.getHTMLfromTA(ta, sd.dict, sd.showdefs, sd.showroman, sd.allowcopy, sd.showgoogle);
		return out;
	}

	@org.springframework.web.bind.annotation.RequestMapping(value = "/removeall", method = org.springframework.web.bind.annotation.RequestMethod.POST)
	@org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
	@org.springframework.web.bind.annotation.ResponseBody
	public java.lang.String removeall(@org.springframework.web.bind.annotation.RequestParam("id")
	java.lang.String idstring, javax.servlet.http.HttpSession hs, org.springframework.ui.Model model) throws java.lang.Exception {
		io.github.mayhewsw.SessionData sd = new io.github.mayhewsw.SessionData(hs);
		java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> tas = sd.tas;
		io.github.mayhewsw.Dictionary dict = sd.dict;
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta = tas.get(idstring);
		java.lang.Boolean showdefs = sd.showdefs;
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.View ner = ta.getView(edu.illinois.cs.cogcomp.core.datastructures.ViewNames.NER_CONLL);
		for (edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent c : ner.getConstituents()) {
			ner.removeConstituent(c);
		}
		java.lang.String out = io.github.mayhewsw.utils.HtmlGenerator.getHTMLfromTA(ta, sd.dict, sd.showdefs, sd.showroman, sd.allowcopy, sd.showgoogle);
		return out;
	}

	@org.springframework.web.bind.annotation.RequestMapping(value = "/toggledefs", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	@org.springframework.web.bind.annotation.ResponseBody
	public java.lang.String toggledefs(@org.springframework.web.bind.annotation.RequestParam("idlist[]")
	java.lang.String[] idlist, javax.servlet.http.HttpSession hs) {
		io.github.mayhewsw.SessionData sd = new io.github.mayhewsw.SessionData(hs);
		java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> tas = sd.tas;
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta = tas.get(idlist[0]);
		java.lang.Boolean showdefs = sd.showdefs;
		showdefs = !showdefs;
		hs.setAttribute("showdefs", showdefs);
		sd.showdefs = showdefs;
		return io.github.mayhewsw.utils.HtmlGenerator.getHTMLfromTA(ta, sd.dict, sd.showdefs, sd.showroman, sd.allowcopy, sd.showgoogle);
	}

	@org.springframework.web.bind.annotation.RequestMapping(value = "/togglerom", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	@org.springframework.web.bind.annotation.ResponseBody
	public java.lang.String toggleroman(@org.springframework.web.bind.annotation.RequestParam("idlist[]")
	java.lang.String[] idlist, javax.servlet.http.HttpSession hs) {
		io.github.mayhewsw.SessionData sd = new io.github.mayhewsw.SessionData(hs);
		java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> tas = sd.tas;
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta = tas.get(idlist[0]);
		java.lang.Boolean showroman = sd.showroman;
		showroman = !showroman;
		hs.setAttribute("showroman", showroman);
		sd.showroman = showroman;
		return io.github.mayhewsw.utils.HtmlGenerator.getHTMLfromTA(ta, sd.dict, sd.showdefs, sd.showroman, sd.allowcopy, sd.showgoogle);
	}

	@org.springframework.web.bind.annotation.RequestMapping(value = "/togglegoogle", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	@org.springframework.web.bind.annotation.ResponseBody
	public java.lang.String togglegoogle(@org.springframework.web.bind.annotation.RequestParam("idlist[]")
	java.lang.String[] idlist, javax.servlet.http.HttpSession hs) {
		io.github.mayhewsw.SessionData sd = new io.github.mayhewsw.SessionData(hs);
		java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> tas = sd.tas;
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta = tas.get(idlist[0]);
		java.lang.Boolean showgoogle = sd.showgoogle;
		showgoogle = !showgoogle;
		hs.setAttribute("showgoogle", showgoogle);
		sd.showgoogle = showgoogle;
		return io.github.mayhewsw.utils.HtmlGenerator.getHTMLfromTA(ta, sd.dict, sd.showdefs, sd.showroman, sd.allowcopy, sd.showgoogle);
	}

	@org.springframework.web.bind.annotation.RequestMapping(value = "/togglecopy", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	@org.springframework.web.bind.annotation.ResponseBody
	public java.lang.String allowcopy(@org.springframework.web.bind.annotation.RequestParam("idlist[]")
	java.lang.String[] idlist, javax.servlet.http.HttpSession hs) {
		io.github.mayhewsw.SessionData sd = new io.github.mayhewsw.SessionData(hs);
		java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> tas = sd.tas;
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta = tas.get(idlist[0]);
		java.lang.Boolean allowcopy = sd.allowcopy;
		allowcopy = !allowcopy;
		hs.setAttribute("allowcopy", allowcopy);
		sd.allowcopy = allowcopy;
		java.lang.String ret;
		if (allowcopy) {
			ret = io.github.mayhewsw.utils.HtmlGenerator.getCopyableHTMLFromTA(ta, sd.dict, sd.showdefs, sd.showroman, sd.showgoogle);
		} else {
			ret = io.github.mayhewsw.utils.HtmlGenerator.getHTMLfromTA(ta, sd.dict, sd.showdefs, sd.showroman, sd.allowcopy, sd.showgoogle);
		}
		return ret;
	}

	@org.springframework.web.bind.annotation.RequestMapping(value = "/addsuffix", method = org.springframework.web.bind.annotation.RequestMethod.GET)
	@org.springframework.web.bind.annotation.ResponseBody
	public java.lang.String addsuffix(@org.springframework.web.bind.annotation.RequestParam("suffix")
	java.lang.String suffix, @org.springframework.web.bind.annotation.RequestParam("taid")
	java.lang.String taid, javax.servlet.http.HttpSession hs) {
		io.github.mayhewsw.SessionData sd = new io.github.mayhewsw.SessionData(hs);
		java.util.Properties prop = sd.datasets.get(sd.dataname);
		java.lang.String folderpath = prop.getProperty("folderpath");
		java.util.TreeMap<java.lang.String, edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation> tas = sd.tas;
		edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta = tas.get(taid);
		io.github.mayhewsw.controllers.DocumentController.logger.info(sd.suffixes.toString());
		io.github.mayhewsw.controllers.DocumentController.logger.info(suffix);
		if (suffix.startsWith("-")) {
			suffix = suffix.substring(1);
		}
		if (!sd.suffixes.contains(suffix)) {
			sd.suffixes.add(suffix);
			sd.suffixes.sort((java.lang.String s1,java.lang.String s2) -> s2.length() - s1.length());
			java.lang.String folderparent = new java.io.File(folderpath).getParent();
			java.io.File suffixfile = new java.io.File(folderparent, ("suffixes-" + sd.username) + ".txt");
			try {
				edu.illinois.cs.cogcomp.core.io.LineIO.write(suffixfile.getAbsolutePath(), java.util.Collections.singletonList(edu.illinois.cs.cogcomp.core.utilities.StringUtils.join(" ", sd.suffixes)));
			} catch (java.io.IOException e) {
				io.github.mayhewsw.controllers.DocumentController.logger.error("Could not save suffix file: " + suffixfile.getAbsolutePath());
			}
		}
		return io.github.mayhewsw.utils.HtmlGenerator.getHTMLfromTA(ta, sd.dict, sd.showdefs, sd.showroman, sd.allowcopy, sd.showgoogle);
	}

	public static java.util.List<io.github.mayhewsw.Suggestion> getdocsuggestions(edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta, io.github.mayhewsw.SessionData sd) {
		java.util.List<io.github.mayhewsw.Suggestion> suggestions = new java.util.ArrayList<>();
		java.util.List<io.github.mayhewsw.Suggestion> contextsuggestions = new java.util.ArrayList<>();
		if (sd.patterns != null) {
			contextsuggestions = io.github.mayhewsw.FeatureExtractor.findfeatfires(ta, sd.patterns);
			suggestions.addAll(contextsuggestions);
		}
		return suggestions;
	}

	@org.springframework.web.bind.annotation.RequestMapping(value = "/gethtml", method = org.springframework.web.bind.annotation.RequestMethod.POST)
	@org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
	@org.springframework.web.bind.annotation.ResponseBody
	public java.lang.String gethtml(@org.springframework.web.bind.annotation.RequestParam(value = "sentids[]", required = true)
	java.lang.String[] sentids, java.lang.String query, org.springframework.ui.Model model, javax.servlet.http.HttpSession hs) throws java.io.FileNotFoundException {
		io.github.mayhewsw.SessionData sd = new io.github.mayhewsw.SessionData(hs);
		java.lang.String ret = "";
		for (java.lang.String sentid : sentids) {
			edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation ta = sd.tas.get(sentid);
			java.lang.String html = io.github.mayhewsw.utils.HtmlGenerator.getHTMLfromTA(ta, sd.dict, sd.showdefs, sd.showroman, sd.allowcopy, sd.showgoogle);
			ret += html + "\n";
		}
		return ret;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		io.github.mayhewsw.controllers.DocumentController c = new io.github.mayhewsw.controllers.DocumentController();
	}
}