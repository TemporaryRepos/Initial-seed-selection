public class CommandLineInterface {
	private static final double DEFAULT_ALPHA = 0.5;

	private final java.util.Map<java.lang.String, java.lang.String> opt_with_value = new java.util.HashMap<>();

	private final java.util.Map<java.lang.String, java.lang.String> values = new java.util.HashMap<>();

	private final java.util.Set<java.lang.String> opt_without_value = new java.util.HashSet<>();

	private final java.util.List<java.lang.String> arglist = new java.util.ArrayList<>();

	public static void main(java.lang.String[] args) throws java.io.IOException {
		com.optimaize.langdetect.cybozu.CommandLineInterface cli = new com.optimaize.langdetect.cybozu.CommandLineInterface();
		cli.addOpt("-d", "directory", "./");
		cli.addOpt("-a", "alpha", "" + com.optimaize.langdetect.cybozu.CommandLineInterface.DEFAULT_ALPHA);
		cli.addOpt("-s", "seed", null);
		cli.parse(args);
		if (cli.hasParam("--genprofile")) {
			cli.generateProfile();
		} else if (cli.hasParam("--detectlang")) {
			cli.detectLang();
		} else if (cli.hasParam("--batchtest")) {
			cli.batchTest();
		}
	}

	private void parse(java.lang.String[] args) {
		for (int i = 0; i < args.length; i++) {
			if (opt_with_value.containsKey(args[i])) {
				java.lang.String key = opt_with_value.get(args[i]);
				values.put(key, args[i + 1]);
				i++;
			} else if (args[i].startsWith("-")) {
				opt_without_value.add(args[i]);
			} else {
				arglist.add(args[i]);
			}
		}
	}

	private void addOpt(java.lang.String opt, java.lang.String key, java.lang.String value) {
		opt_with_value.put(opt, key);
		values.put(key, value);
	}

	@org.jetbrains.annotations.NotNull
	private java.lang.String requireParamString(@org.jetbrains.annotations.NotNull
	java.lang.String key) {
		java.lang.String s = values.get(key);
		if ((s == null) || s.isEmpty()) {
			throw new java.lang.RuntimeException("Missing command line param: " + key);
		}
		return s;
	}

	private double getParamDouble(java.lang.String key, double defaultValue) {
		java.lang.String value = values.get(key);
		if ((value == null) || value.isEmpty()) {
			return defaultValue;
		}
		try {
			return java.lang.Double.valueOf(value);
		} catch (java.lang.NumberFormatException e) {
			throw new java.lang.RuntimeException(("Invalid double value: >>>" + value) + "<<<", e);
		}
	}

	@org.jetbrains.annotations.Nullable
	private java.lang.Long getParamLongOrNull(java.lang.String key) {
		java.lang.String value = values.get(key);
		if ((value == null) || value.isEmpty()) {
			return null;
		}
		try {
			return java.lang.Long.valueOf(value);
		} catch (java.lang.NumberFormatException e) {
			throw new java.lang.RuntimeException(("Invalid long value: >>>" + value) + "<<<", e);
		}
	}

	private boolean hasParam(java.lang.String opt) {
		return opt_without_value.contains(opt);
	}

	private java.io.File searchFile(java.io.File directory, java.lang.String pattern) {
		if (!directory.isDirectory()) {
			throw new java.lang.IllegalArgumentException("Not a directly: " + directory);
		}
		java.io.File[] files = directory.listFiles();
		assert files != null;
		for (java.io.File file : files) {
			if (file.getName().matches(pattern)) {
				return file;
			}
		}
		return null;
	}

	public void generateProfile() {
		java.io.File directory = new java.io.File(arglist.get(0));
		java.lang.String lang = arglist.get(1);
		java.io.File file = searchFile(directory, lang + "wiki-.*-abstract\\.xml.*");
		if (file == null) {
			java.lang.System.err.println("Not Found text file : lang = " + lang);
			return;
		}
		try (final java.io.FileOutputStream outputStream = new java.io.FileOutputStream(new java.io.File(lang))) {
			com.optimaize.langdetect.cybozu.util.LangProfile profile = com.optimaize.langdetect.cybozu.GenProfile.load(lang, file);
			profile.omitLessFreq();
			new com.optimaize.langdetect.frma.LangProfileWriter().write(profile, outputStream);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	public void detectLang() throws java.io.IOException {
		com.optimaize.langdetect.LanguageDetector languageDetector = makeDetector();
		com.optimaize.langdetect.text.TextObjectFactory textObjectFactory = com.optimaize.langdetect.text.CommonTextObjectFactories.forDetectingOnLargeText();
		for (java.lang.String filename : arglist) {
			try (final java.io.BufferedReader is = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename), "utf-8"))) {
				com.optimaize.langdetect.text.TextObject textObject = textObjectFactory.create().append(is);
				java.util.List<com.optimaize.langdetect.DetectedLanguage> probabilities = languageDetector.getProbabilities(textObject);
				java.lang.System.out.println((filename + ":") + probabilities);
			}
		}
	}

	public void batchTest() throws java.io.IOException {
		com.optimaize.langdetect.LanguageDetector languageDetector = makeDetector();
		com.optimaize.langdetect.text.TextObjectFactory textObjectFactory = com.optimaize.langdetect.text.CommonTextObjectFactories.forDetectingOnLargeText();
		java.util.Map<java.lang.String, java.util.List<java.lang.String>> result = new java.util.HashMap<>();
		for (java.lang.String filename : arglist) {
			try (final java.io.BufferedReader is = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename), "utf-8"))) {
				while (is.ready()) {
					java.lang.String line = is.readLine();
					int idx = line.indexOf('\t');
					if (idx <= 0) {
						continue;
					}
					java.lang.String correctLang = line.substring(0, idx);
					java.lang.String text = line.substring(idx + 1);
					com.optimaize.langdetect.text.TextObject textObject = textObjectFactory.forText(text);
					com.google.common.base.Optional<com.optimaize.langdetect.i18n.LdLocale> lang = languageDetector.detect(textObject);
					if (!result.containsKey(correctLang)) {
						result.put(correctLang, new java.util.ArrayList<java.lang.String>());
					}
					if (lang.isPresent()) {
						result.get(correctLang).add(lang.toString());
					} else {
						result.get(correctLang).add("unknown");
					}
					if (hasParam("--debug")) {
						java.lang.System.out.println((((correctLang + ",") + lang) + ",") + (text.length() > 100 ? text.substring(0, 100) : text));
					}
				} 
			}
			java.util.List<java.lang.String> langList = new java.util.ArrayList<>(result.keySet());
			java.util.Collections.sort(langList);
			int totalCount = 0;
			int totalCorrect = 0;
			for (java.lang.String lang : langList) {
				java.util.Map<java.lang.String, java.lang.Integer> resultCount = new java.util.HashMap<>();
				int count = 0;
				java.util.List<java.lang.String> list = result.get(lang);
				for (java.lang.String detectedLang : list) {
					++count;
					if (resultCount.containsKey(detectedLang)) {
						resultCount.put(detectedLang, resultCount.get(detectedLang) + 1);
					} else {
						resultCount.put(detectedLang, 1);
					}
				}
				int correct = (resultCount.containsKey(lang)) ? resultCount.get(lang) : 0;
				double rate = correct / ((double) (count));
				java.lang.System.out.println(java.lang.String.format("%s (%d/%d=%.2f): %s", lang, correct, count, rate, resultCount));
				totalCorrect += correct;
				totalCount += count;
			}
			java.lang.System.out.println(java.lang.String.format("total: %d/%d = %.3f", totalCorrect, totalCount, totalCorrect / ((double) (totalCount))));
		}
	}

	private com.optimaize.langdetect.LanguageDetector makeDetector() throws java.io.IOException {
		double alpha = getParamDouble("alpha", com.optimaize.langdetect.cybozu.CommandLineInterface.DEFAULT_ALPHA);
		java.lang.String profileDirectory = requireParamString("directory") + "/";
		com.google.common.base.Optional<java.lang.Long> seed = com.google.common.base.Optional.fromNullable(getParamLongOrNull("seed"));
		java.util.List<com.optimaize.langdetect.profiles.LanguageProfile> languageProfiles = new com.optimaize.langdetect.profiles.LanguageProfileReader().readAll(new java.io.File(profileDirectory));
		return com.optimaize.langdetect.LanguageDetectorBuilder.create(com.optimaize.langdetect.ngram.NgramExtractors.standard()).alpha(alpha).seed(seed).shortTextAlgorithm(50).withProfiles(languageProfiles).build();
	}
}