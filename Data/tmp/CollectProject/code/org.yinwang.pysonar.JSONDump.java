public class JSONDump {
	private static java.util.logging.Logger log = java.util.logging.Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

	private static java.util.Set<java.lang.String> seenDef = new java.util.HashSet<>();

	private static java.util.Set<java.lang.String> seenRef = new java.util.HashSet<>();

	private static java.util.Set<java.lang.String> seenDocs = new java.util.HashSet<>();

	private static java.lang.String dirname(java.lang.String path) {
		return new java.io.File(path).getParent();
	}

	private static org.yinwang.pysonar.Analyzer newAnalyzer(java.lang.String srcpath, java.lang.String[] inclpaths) throws java.lang.Exception {
		org.yinwang.pysonar.Analyzer idx = new org.yinwang.pysonar.Analyzer();
		for (java.lang.String inclpath : inclpaths) {
			idx.addPath(inclpath);
		}
		idx.analyze(srcpath);
		idx.finish();
		if (idx.semanticErrors.size() > 0) {
			org.yinwang.pysonar.JSONDump.log.info("Analyzer errors:");
			for (java.lang.String file : idx.semanticErrors.keys()) {
				org.yinwang.pysonar.JSONDump.log.info("  File: " + file);
				java.util.Collection<org.yinwang.pysonar.Diagnostic> diagnostics = idx.semanticErrors.get(file);
				for (org.yinwang.pysonar.Diagnostic d : diagnostics) {
					org.yinwang.pysonar.JSONDump.log.info("    " + d);
				}
			}
		}
		return idx;
	}

	private static void writeSymJson(org.yinwang.pysonar.Binding binding, com.fasterxml.jackson.core.JsonGenerator json) throws java.io.IOException {
		if (binding.start < 0) {
			return;
		}
		java.lang.String name = binding.name;
		boolean isExported = !(((((org.yinwang.pysonar.Binding.Kind.VARIABLE == binding.kind) || (org.yinwang.pysonar.Binding.Kind.PARAMETER == binding.kind)) || (org.yinwang.pysonar.Binding.Kind.SCOPE == binding.kind)) || (org.yinwang.pysonar.Binding.Kind.ATTRIBUTE == binding.kind)) || (((name.length() == 0) || (name.charAt(0) == '_')) || name.startsWith("lambda%")));
		java.lang.String path = binding.qname.replace('.', '/').replace("%20", ".");
		if (!org.yinwang.pysonar.JSONDump.seenDef.contains(path)) {
			org.yinwang.pysonar.JSONDump.seenDef.add(path);
			json.writeStartObject();
			json.writeStringField("name", name);
			json.writeStringField("path", path);
			json.writeStringField("file", binding.fileOrUrl);
			json.writeNumberField("identStart", binding.start);
			json.writeNumberField("identEnd", binding.end);
			json.writeNumberField("defStart", binding.bodyStart);
			json.writeNumberField("defEnd", binding.bodyEnd);
			json.writeBooleanField("exported", isExported);
			json.writeStringField("kind", binding.kind.toString());
			if (((org.yinwang.pysonar.Binding.Kind.FUNCTION == binding.kind) || (org.yinwang.pysonar.Binding.Kind.METHOD == binding.kind)) || (org.yinwang.pysonar.Binding.Kind.CONSTRUCTOR == binding.kind)) {
				json.writeObjectFieldStart("funcData");
				java.lang.String argExpr = null;
				org.yinwang.pysonar.types.Type t = binding.type;
				if (t instanceof org.yinwang.pysonar.types.UnionType) {
					t = ((org.yinwang.pysonar.types.UnionType) (t)).firstUseful();
				}
				if ((t != null) && (t instanceof org.yinwang.pysonar.types.FunType)) {
					org.yinwang.pysonar.ast.FunctionDef func = ((org.yinwang.pysonar.types.FunType) (t)).func;
					if (func != null) {
						argExpr = func.getArgumentExpr();
					}
				}
				java.lang.String typeExpr = binding.type.toString();
				json.writeNullField("params");
				java.lang.String signature = (argExpr == null) ? "" : (argExpr + "\n") + typeExpr;
				json.writeStringField("signature", signature);
				json.writeEndObject();
			}
			json.writeEndObject();
		}
	}

	private static void writeRefJson(org.yinwang.pysonar.ast.Node ref, org.yinwang.pysonar.Binding binding, com.fasterxml.jackson.core.JsonGenerator json) throws java.io.IOException {
		if (binding.getFile() != null) {
			java.lang.String path = binding.qname.replace(".", "/").replace("%20", ".");
			java.lang.String key = (ref.file + ":") + ref.start;
			if (!org.yinwang.pysonar.JSONDump.seenRef.contains(key)) {
				org.yinwang.pysonar.JSONDump.seenRef.add(key);
				if (((binding.start >= 0) && (ref.start >= 0)) && (!binding.isBuiltin())) {
					json.writeStartObject();
					json.writeStringField("sym", path);
					json.writeStringField("file", ref.file);
					json.writeNumberField("start", ref.start);
					json.writeNumberField("end", ref.end);
					json.writeBooleanField("builtin", binding.isBuiltin());
					json.writeEndObject();
				}
			}
		}
	}

	private static void writeDocJson(org.yinwang.pysonar.Binding binding, org.yinwang.pysonar.Analyzer idx, com.fasterxml.jackson.core.JsonGenerator json) throws java.lang.Exception {
		java.lang.String path = binding.qname.replace('.', '/').replace("%20", ".");
		if (!org.yinwang.pysonar.JSONDump.seenDocs.contains(path)) {
			org.yinwang.pysonar.JSONDump.seenDocs.add(path);
			org.yinwang.pysonar.ast.Str doc = binding.getDocstring();
			if (doc != null) {
				json.writeStartObject();
				json.writeStringField("sym", path);
				json.writeStringField("file", binding.fileOrUrl);
				json.writeStringField("body", doc.value);
				json.writeNumberField("start", doc.start);
				json.writeNumberField("end", doc.end);
				json.writeEndObject();
			}
		}
	}

	private static void graph(java.lang.String srcpath, java.lang.String[] inclpaths, java.io.OutputStream symOut, java.io.OutputStream refOut, java.io.OutputStream docOut) throws java.lang.Exception {
		java.util.List<java.lang.String> parentDirs = com.google.common.collect.Lists.newArrayList(inclpaths);
		parentDirs.add(org.yinwang.pysonar.JSONDump.dirname(srcpath));
		java.util.Collections.sort(parentDirs, new java.util.Comparator<java.lang.String>() {
			@java.lang.Override
			public int compare(java.lang.String s1, java.lang.String s2) {
				int diff = s1.length() - s2.length();
				if (0 == diff) {
					return s1.compareTo(s2);
				}
				return diff;
			}
		});
		org.yinwang.pysonar.Analyzer idx = org.yinwang.pysonar.JSONDump.newAnalyzer(srcpath, inclpaths);
		idx.multilineFunType = true;
		com.fasterxml.jackson.core.JsonFactory jsonFactory = new com.fasterxml.jackson.core.JsonFactory();
		com.fasterxml.jackson.core.JsonGenerator symJson = jsonFactory.createGenerator(symOut);
		com.fasterxml.jackson.core.JsonGenerator refJson = jsonFactory.createGenerator(refOut);
		com.fasterxml.jackson.core.JsonGenerator docJson = jsonFactory.createGenerator(docOut);
		com.fasterxml.jackson.core.JsonGenerator[] allJson = new com.fasterxml.jackson.core.JsonGenerator[]{ symJson, refJson, docJson };
		for (com.fasterxml.jackson.core.JsonGenerator json : allJson) {
			json.writeStartArray();
		}
		for (org.yinwang.pysonar.Binding b : idx.getAllBindings()) {
			java.lang.String path = b.qname.replace('.', '/').replace("%20", ".");
			if (b.getFile() != null) {
				if (b.getFile().startsWith(srcpath)) {
					org.yinwang.pysonar.JSONDump.writeSymJson(b, symJson);
					org.yinwang.pysonar.JSONDump.writeDocJson(b, idx, docJson);
				}
			}
			for (org.yinwang.pysonar.ast.Node ref : b.refs) {
				if (ref.file != null) {
					if (ref.file.startsWith(srcpath)) {
						org.yinwang.pysonar.JSONDump.writeRefJson(ref, b, refJson);
					}
				}
			}
		}
		for (com.fasterxml.jackson.core.JsonGenerator json : allJson) {
			json.writeEndArray();
			json.close();
		}
	}

	private static void info(java.lang.Object msg) {
		java.lang.System.out.println(msg);
	}

	private static void usage() {
		org.yinwang.pysonar.JSONDump.info("Usage: java org.yinwang.pysonar.dump <source-path> <include-paths> <out-root> [verbose]");
		org.yinwang.pysonar.JSONDump.info("  <source-path> is path to source unit (package directory or module file) that will be graphed");
		org.yinwang.pysonar.JSONDump.info("  <include-paths> are colon-separated paths to included libs");
		org.yinwang.pysonar.JSONDump.info("  <out-root> is the prefix of the output files.  There are 3 output files: <out-root>-doc, <out-root>-sym, <out-root>-ref");
		org.yinwang.pysonar.JSONDump.info("  [verbose] if set, then verbose logging is used (optional)");
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if ((args.length < 3) || (args.length > 4)) {
			org.yinwang.pysonar.JSONDump.usage();
			return;
		}
		org.yinwang.pysonar.JSONDump.log.setLevel(java.util.logging.Level.SEVERE);
		if (args.length >= 4) {
			org.yinwang.pysonar.JSONDump.log.setLevel(java.util.logging.Level.ALL);
			org.yinwang.pysonar.JSONDump.log.info("LOGGING VERBOSE");
			org.yinwang.pysonar.JSONDump.log.info("ARGS: " + java.util.Arrays.toString(args));
		}
		java.lang.String srcpath = args[0];
		java.lang.String[] inclpaths = args[1].split(":");
		java.lang.String outroot = args[2];
		java.lang.String symFilename = outroot + "-sym";
		java.lang.String refFilename = outroot + "-ref";
		java.lang.String docFilename = outroot + "-doc";
		java.io.OutputStream symOut = null;
		java.io.OutputStream refOut = null;
		java.io.OutputStream docOut = null;
		try {
			docOut = new java.io.BufferedOutputStream(new java.io.FileOutputStream(docFilename));
			symOut = new java.io.BufferedOutputStream(new java.io.FileOutputStream(symFilename));
			refOut = new java.io.BufferedOutputStream(new java.io.FileOutputStream(refFilename));
			org.yinwang.pysonar.$.msg("graphing: " + srcpath);
			org.yinwang.pysonar.JSONDump.graph(srcpath, inclpaths, symOut, refOut, docOut);
			docOut.flush();
			symOut.flush();
			refOut.flush();
		} catch (java.io.FileNotFoundException e) {
			java.lang.System.err.println("Could not find file: " + e);
			return;
		} finally {
			if (docOut != null) {
				docOut.close();
			}
			if (symOut != null) {
				symOut.close();
			}
			if (refOut != null) {
				refOut.close();
			}
		}
		org.yinwang.pysonar.JSONDump.log.info("SUCCESS");
	}
}