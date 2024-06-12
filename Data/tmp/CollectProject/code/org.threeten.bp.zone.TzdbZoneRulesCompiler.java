final class TzdbZoneRulesCompiler {
	private static final org.threeten.bp.format.DateTimeFormatter TIME_PARSER;

	static {
		TIME_PARSER = new org.threeten.bp.format.DateTimeFormatterBuilder().appendValue(org.threeten.bp.temporal.ChronoField.HOUR_OF_DAY).optionalStart().appendLiteral(':').appendValue(org.threeten.bp.temporal.ChronoField.MINUTE_OF_HOUR, 2).optionalStart().appendLiteral(':').appendValue(org.threeten.bp.temporal.ChronoField.SECOND_OF_MINUTE, 2).toFormatter();
	}

	public static void main(java.lang.String[] args) {
		if (args.length < 2) {
			org.threeten.bp.zone.TzdbZoneRulesCompiler.outputHelp();
			return;
		}
		java.lang.String version = null;
		java.io.File baseSrcDir = null;
		java.io.File dstDir = null;
		boolean unpacked = false;
		boolean verbose = false;
		int i;
		for (i = 0; i < args.length; i++) {
			java.lang.String arg = args[i];
			if (arg.startsWith("-") == false) {
				break;
			}
			if ("-srcdir".equals(arg)) {
				if ((baseSrcDir == null) && ((++i) < args.length)) {
					baseSrcDir = new java.io.File(args[i]);
					continue;
				}
			} else if ("-dstdir".equals(arg)) {
				if ((dstDir == null) && ((++i) < args.length)) {
					dstDir = new java.io.File(args[i]);
					continue;
				}
			} else if ("-version".equals(arg)) {
				if ((version == null) && ((++i) < args.length)) {
					version = args[i];
					continue;
				}
			} else if ("-unpacked".equals(arg)) {
				if (unpacked == false) {
					unpacked = true;
					continue;
				}
			} else if ("-verbose".equals(arg)) {
				if (verbose == false) {
					verbose = true;
					continue;
				}
			} else if ("-help".equals(arg) == false) {
				java.lang.System.out.println("Unrecognised option: " + arg);
			}
			org.threeten.bp.zone.TzdbZoneRulesCompiler.outputHelp();
			return;
		}
		if (baseSrcDir == null) {
			java.lang.System.out.println("Source directory must be specified using -srcdir: " + baseSrcDir);
			return;
		}
		if (baseSrcDir.isDirectory() == false) {
			java.lang.System.out.println("Source does not exist or is not a directory: " + baseSrcDir);
			return;
		}
		dstDir = (dstDir != null) ? dstDir : baseSrcDir;
		java.util.List<java.lang.String> srcFileNames = java.util.Arrays.asList(java.util.Arrays.copyOfRange(args, i, args.length));
		if (srcFileNames.isEmpty()) {
			java.lang.System.out.println("Source filenames not specified, using default set");
			java.lang.System.out.println("(africa antarctica asia australasia backward etcetera europe northamerica southamerica)");
			srcFileNames = java.util.Arrays.asList("africa", "antarctica", "asia", "australasia", "backward", "etcetera", "europe", "northamerica", "southamerica");
		}
		java.util.List<java.io.File> srcDirs = new java.util.ArrayList<java.io.File>();
		if (version != null) {
			java.io.File srcDir = new java.io.File(baseSrcDir, version);
			if (srcDir.isDirectory() == false) {
				java.lang.System.out.println("Version does not represent a valid source directory : " + srcDir);
				return;
			}
			srcDirs.add(srcDir);
		} else {
			java.io.File[] dirs = baseSrcDir.listFiles();
			for (java.io.File dir : dirs) {
				if (dir.isDirectory() && dir.getName().matches("[12][0-9][0-9][0-9][A-Za-z0-9._-]+")) {
					srcDirs.add(dir);
				}
			}
		}
		if (srcDirs.isEmpty()) {
			java.lang.System.out.println("Source directory contains no valid source folders: " + baseSrcDir);
			return;
		}
		if ((dstDir.exists() == false) && (dstDir.mkdirs() == false)) {
			java.lang.System.out.println("Destination directory could not be created: " + dstDir);
			return;
		}
		if (dstDir.isDirectory() == false) {
			java.lang.System.out.println("Destination is not a directory: " + dstDir);
			return;
		}
		org.threeten.bp.zone.TzdbZoneRulesCompiler.process(srcDirs, srcFileNames, dstDir, unpacked, verbose);
	}

	private static void outputHelp() {
		java.lang.System.out.println("Usage: TzdbZoneRulesCompiler <options> <tzdb source filenames>");
		java.lang.System.out.println("where options include:");
		java.lang.System.out.println("   -srcdir <directory>   Where to find source directories (required)");
		java.lang.System.out.println("   -dstdir <directory>   Where to output generated files (default srcdir)");
		java.lang.System.out.println("   -version <version>    Specify the version, such as 2009a (optional)");
		java.lang.System.out.println("   -unpacked             Generate dat files without jar files");
		java.lang.System.out.println("   -help                 Print this usage message");
		java.lang.System.out.println("   -verbose              Output verbose information during compilation");
		java.lang.System.out.println(" There must be one directory for each version in srcdir");
		java.lang.System.out.println(" Each directory must have the name of the version, such as 2009a");
		java.lang.System.out.println(" Each directory must contain the unpacked tzdb files, such as asia or europe");
		java.lang.System.out.println(" Directories must match the regex [12][0-9][0-9][0-9][A-Za-z0-9._-]+");
		java.lang.System.out.println(" There will be one jar file for each version and one combined jar in dstdir");
		java.lang.System.out.println(" If the version is specified, only that version is processed");
	}

	private static void process(java.util.List<java.io.File> srcDirs, java.util.List<java.lang.String> srcFileNames, java.io.File dstDir, boolean unpacked, boolean verbose) {
		java.util.Map<java.lang.Object, java.lang.Object> deduplicateMap = new java.util.HashMap<java.lang.Object, java.lang.Object>();
		java.util.Map<java.lang.String, java.util.SortedMap<java.lang.String, org.threeten.bp.zone.ZoneRules>> allBuiltZones = new java.util.TreeMap<java.lang.String, java.util.SortedMap<java.lang.String, org.threeten.bp.zone.ZoneRules>>();
		java.util.Set<java.lang.String> allRegionIds = new java.util.TreeSet<java.lang.String>();
		java.util.Set<org.threeten.bp.zone.ZoneRules> allRules = new java.util.HashSet<org.threeten.bp.zone.ZoneRules>();
		java.util.SortedMap<org.threeten.bp.LocalDate, java.lang.Byte> bestLeapSeconds = null;
		for (java.io.File srcDir : srcDirs) {
			java.util.List<java.io.File> srcFiles = new java.util.ArrayList<java.io.File>();
			for (java.lang.String srcFileName : srcFileNames) {
				java.io.File file = new java.io.File(srcDir, srcFileName);
				if (file.exists()) {
					srcFiles.add(file);
				}
			}
			if (srcFiles.isEmpty()) {
				continue;
			}
			java.io.File leapSecondsFile = new java.io.File(srcDir, "leapseconds");
			if (!leapSecondsFile.exists()) {
				java.lang.System.out.println(("Version " + srcDir.getName()) + " does not include leap seconds information.");
				leapSecondsFile = null;
			}
			java.lang.String loopVersion = srcDir.getName();
			org.threeten.bp.zone.TzdbZoneRulesCompiler compiler = new org.threeten.bp.zone.TzdbZoneRulesCompiler(loopVersion, srcFiles, leapSecondsFile, verbose);
			compiler.setDeduplicateMap(deduplicateMap);
			try {
				compiler.compile();
				java.util.SortedMap<java.lang.String, org.threeten.bp.zone.ZoneRules> builtZones = compiler.getZones();
				java.util.SortedMap<org.threeten.bp.LocalDate, java.lang.Byte> parsedLeapSeconds = compiler.getLeapSeconds();
				if (unpacked == false) {
					java.io.File dstFile = new java.io.File(dstDir, ("threeten-TZDB-" + loopVersion) + ".jar");
					if (verbose) {
						java.lang.System.out.println("Outputting file: " + dstFile);
					}
					org.threeten.bp.zone.TzdbZoneRulesCompiler.outputFile(dstFile, loopVersion, builtZones, parsedLeapSeconds);
				}
				allBuiltZones.put(loopVersion, builtZones);
				allRegionIds.addAll(builtZones.keySet());
				allRules.addAll(builtZones.values());
				if (compiler.getMostRecentLeapSecond() != null) {
					if ((bestLeapSeconds == null) || (compiler.getMostRecentLeapSecond().compareTo(bestLeapSeconds.lastKey()) > 0)) {
						bestLeapSeconds = parsedLeapSeconds;
					}
				}
			} catch (java.lang.Exception ex) {
				java.lang.System.out.println("Failed: " + ex.toString());
				ex.printStackTrace();
				java.lang.System.exit(1);
			}
		}
		if (unpacked) {
			if (verbose) {
				java.lang.System.out.println("Outputting combined files: " + dstDir);
			}
			org.threeten.bp.zone.TzdbZoneRulesCompiler.outputFilesDat(dstDir, allBuiltZones, allRegionIds, allRules, bestLeapSeconds);
		} else {
			java.io.File dstFile = new java.io.File(dstDir, "threeten-TZDB-all.jar");
			if (verbose) {
				java.lang.System.out.println("Outputting combined file: " + dstFile);
			}
			org.threeten.bp.zone.TzdbZoneRulesCompiler.outputFile(dstFile, allBuiltZones, allRegionIds, allRules, bestLeapSeconds);
		}
	}

	private static void outputFilesDat(java.io.File dstDir, java.util.Map<java.lang.String, java.util.SortedMap<java.lang.String, org.threeten.bp.zone.ZoneRules>> allBuiltZones, java.util.Set<java.lang.String> allRegionIds, java.util.Set<org.threeten.bp.zone.ZoneRules> allRules, java.util.SortedMap<org.threeten.bp.LocalDate, java.lang.Byte> leapSeconds) {
		java.io.File tzdbFile = new java.io.File(dstDir, "TZDB.dat");
		tzdbFile.delete();
		try {
			java.io.FileOutputStream fos = null;
			try {
				fos = new java.io.FileOutputStream(tzdbFile);
				org.threeten.bp.zone.TzdbZoneRulesCompiler.outputTzdbDat(fos, allBuiltZones, allRegionIds, allRules);
			} finally {
				if (fos != null) {
					fos.close();
				}
			}
		} catch (java.lang.Exception ex) {
			java.lang.System.out.println("Failed: " + ex.toString());
			ex.printStackTrace();
			java.lang.System.exit(1);
		}
	}

	private static void outputFile(java.io.File dstFile, java.lang.String version, java.util.SortedMap<java.lang.String, org.threeten.bp.zone.ZoneRules> builtZones, java.util.SortedMap<org.threeten.bp.LocalDate, java.lang.Byte> leapSeconds) {
		java.util.Map<java.lang.String, java.util.SortedMap<java.lang.String, org.threeten.bp.zone.ZoneRules>> loopAllBuiltZones = new java.util.TreeMap<java.lang.String, java.util.SortedMap<java.lang.String, org.threeten.bp.zone.ZoneRules>>();
		loopAllBuiltZones.put(version, builtZones);
		java.util.Set<java.lang.String> loopAllRegionIds = new java.util.TreeSet<java.lang.String>(builtZones.keySet());
		java.util.Set<org.threeten.bp.zone.ZoneRules> loopAllRules = new java.util.HashSet<org.threeten.bp.zone.ZoneRules>(builtZones.values());
		org.threeten.bp.zone.TzdbZoneRulesCompiler.outputFile(dstFile, loopAllBuiltZones, loopAllRegionIds, loopAllRules, leapSeconds);
	}

	private static void outputFile(java.io.File dstFile, java.util.Map<java.lang.String, java.util.SortedMap<java.lang.String, org.threeten.bp.zone.ZoneRules>> allBuiltZones, java.util.Set<java.lang.String> allRegionIds, java.util.Set<org.threeten.bp.zone.ZoneRules> allRules, java.util.SortedMap<org.threeten.bp.LocalDate, java.lang.Byte> leapSeconds) {
		java.util.jar.JarOutputStream jos = null;
		try {
			jos = new java.util.jar.JarOutputStream(new java.io.FileOutputStream(dstFile));
			org.threeten.bp.zone.TzdbZoneRulesCompiler.outputTzdbEntry(jos, allBuiltZones, allRegionIds, allRules);
		} catch (java.lang.Exception ex) {
			java.lang.System.out.println("Failed: " + ex.toString());
			ex.printStackTrace();
			java.lang.System.exit(1);
		} finally {
			if (jos != null) {
				try {
					jos.close();
				} catch (java.io.IOException ex) {
				}
			}
		}
	}

	private static void outputTzdbEntry(java.util.jar.JarOutputStream jos, java.util.Map<java.lang.String, java.util.SortedMap<java.lang.String, org.threeten.bp.zone.ZoneRules>> allBuiltZones, java.util.Set<java.lang.String> allRegionIds, java.util.Set<org.threeten.bp.zone.ZoneRules> allRules) {
		try {
			jos.putNextEntry(new java.util.zip.ZipEntry("org/threeten/bp/TZDB.dat"));
			org.threeten.bp.zone.TzdbZoneRulesCompiler.outputTzdbDat(jos, allBuiltZones, allRegionIds, allRules);
			jos.closeEntry();
		} catch (java.lang.Exception ex) {
			java.lang.System.out.println("Failed: " + ex.toString());
			ex.printStackTrace();
			java.lang.System.exit(1);
		}
	}

	private static void outputTzdbDat(java.io.OutputStream jos, java.util.Map<java.lang.String, java.util.SortedMap<java.lang.String, org.threeten.bp.zone.ZoneRules>> allBuiltZones, java.util.Set<java.lang.String> allRegionIds, java.util.Set<org.threeten.bp.zone.ZoneRules> allRules) throws java.io.IOException {
		java.io.DataOutputStream out = new java.io.DataOutputStream(jos);
		out.writeByte(1);
		out.writeUTF("TZDB");
		java.lang.String[] versionArray = allBuiltZones.keySet().toArray(new java.lang.String[allBuiltZones.size()]);
		out.writeShort(versionArray.length);
		for (java.lang.String version : versionArray) {
			out.writeUTF(version);
		}
		java.lang.String[] regionArray = allRegionIds.toArray(new java.lang.String[allRegionIds.size()]);
		out.writeShort(regionArray.length);
		for (java.lang.String regionId : regionArray) {
			out.writeUTF(regionId);
		}
		java.util.List<org.threeten.bp.zone.ZoneRules> rulesList = new java.util.ArrayList<org.threeten.bp.zone.ZoneRules>(allRules);
		out.writeShort(rulesList.size());
		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream(1024);
		for (org.threeten.bp.zone.ZoneRules rules : rulesList) {
			baos.reset();
			java.io.DataOutputStream dataos = new java.io.DataOutputStream(baos);
			org.threeten.bp.zone.Ser.write(rules, dataos);
			dataos.close();
			byte[] bytes = baos.toByteArray();
			out.writeShort(bytes.length);
			out.write(bytes);
		}
		for (java.lang.String version : allBuiltZones.keySet()) {
			out.writeShort(allBuiltZones.get(version).size());
			for (java.util.Map.Entry<java.lang.String, org.threeten.bp.zone.ZoneRules> entry : allBuiltZones.get(version).entrySet()) {
				int regionIndex = java.util.Arrays.binarySearch(regionArray, entry.getKey());
				int rulesIndex = rulesList.indexOf(entry.getValue());
				out.writeShort(regionIndex);
				out.writeShort(rulesIndex);
			}
		}
		out.flush();
	}

	private final java.util.Map<java.lang.String, java.util.List<org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBRule>> rules = new java.util.HashMap<java.lang.String, java.util.List<org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBRule>>();

	private final java.util.Map<java.lang.String, java.util.List<org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBZone>> zones = new java.util.HashMap<java.lang.String, java.util.List<org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBZone>>();

	private final java.util.Map<java.lang.String, java.lang.String> links = new java.util.HashMap<java.lang.String, java.lang.String>();

	private final java.util.SortedMap<java.lang.String, org.threeten.bp.zone.ZoneRules> builtZones = new java.util.TreeMap<java.lang.String, org.threeten.bp.zone.ZoneRules>();

	private java.util.Map<java.lang.Object, java.lang.Object> deduplicateMap = new java.util.HashMap<java.lang.Object, java.lang.Object>();

	private final java.util.SortedMap<org.threeten.bp.LocalDate, java.lang.Byte> leapSeconds = new java.util.TreeMap<org.threeten.bp.LocalDate, java.lang.Byte>();

	private final java.lang.String version;

	private final java.util.List<java.io.File> sourceFiles;

	private final java.io.File leapSecondsFile;

	private final boolean verbose;

	public TzdbZoneRulesCompiler(java.lang.String version, java.util.List<java.io.File> sourceFiles, java.io.File leapSecondsFile, boolean verbose) {
		this.version = version;
		this.sourceFiles = sourceFiles;
		this.leapSecondsFile = leapSecondsFile;
		this.verbose = verbose;
	}

	public void compile() throws java.lang.Exception {
		printVerbose("Compiling TZDB version " + version);
		parseFiles();
		parseLeapSecondsFile();
		buildZoneRules();
		printVerbose("Compiled TZDB version " + version);
	}

	public java.util.SortedMap<java.lang.String, org.threeten.bp.zone.ZoneRules> getZones() {
		return builtZones;
	}

	public java.util.SortedMap<org.threeten.bp.LocalDate, java.lang.Byte> getLeapSeconds() {
		return leapSeconds;
	}

	private org.threeten.bp.LocalDate getMostRecentLeapSecond() {
		return leapSeconds.isEmpty() ? null : leapSeconds.lastKey();
	}

	void setDeduplicateMap(java.util.Map<java.lang.Object, java.lang.Object> deduplicateMap) {
		this.deduplicateMap = deduplicateMap;
	}

	private void parseFiles() throws java.lang.Exception {
		for (java.io.File file : sourceFiles) {
			printVerbose("Parsing file: " + file);
			parseFile(file);
		}
	}

	private void parseLeapSecondsFile() throws java.lang.Exception {
		printVerbose("Parsing leap second file: " + leapSecondsFile);
		int lineNumber = 1;
		java.lang.String line = null;
		java.io.BufferedReader in = null;
		try {
			in = new java.io.BufferedReader(new java.io.FileReader(leapSecondsFile));
			for (; (line = in.readLine()) != null; lineNumber++) {
				int index = line.indexOf('#');
				if (index >= 0) {
					line = line.substring(0, index);
				}
				if (line.trim().length() == 0) {
					continue;
				}
				org.threeten.bp.zone.TzdbZoneRulesCompiler.LeapSecondRule secondRule = parseLeapSecondRule(line);
				leapSeconds.put(secondRule.leapDate, secondRule.secondAdjustment);
			}
		} catch (java.lang.Exception ex) {
			throw new java.lang.Exception(((((("Failed while processing file '" + leapSecondsFile) + "' on line ") + lineNumber) + " '") + line) + "'", ex);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (java.lang.Exception ex) {
			}
		}
	}

	private org.threeten.bp.zone.TzdbZoneRulesCompiler.LeapSecondRule parseLeapSecondRule(java.lang.String line) {
		java.util.StringTokenizer st = new java.util.StringTokenizer(line, " \t");
		java.lang.String first = st.nextToken();
		if (first.equals("Leap")) {
			if (st.countTokens() < 6) {
				printVerbose((("Invalid leap second line in file: " + leapSecondsFile) + ", line: ") + line);
				throw new java.lang.IllegalArgumentException("Invalid leap second line");
			}
		} else {
			throw new java.lang.IllegalArgumentException("Unknown line");
		}
		int year = java.lang.Integer.parseInt(st.nextToken());
		org.threeten.bp.Month month = parseMonth(st.nextToken());
		int dayOfMonth = java.lang.Integer.parseInt(st.nextToken());
		org.threeten.bp.LocalDate leapDate = org.threeten.bp.LocalDate.of(year, month, dayOfMonth);
		java.lang.String timeOfLeapSecond = st.nextToken();
		byte adjustmentByte = 0;
		java.lang.String adjustment = st.nextToken();
		if (adjustment.equals("+")) {
			if (!"23:59:60".equals(timeOfLeapSecond)) {
				throw new java.lang.IllegalArgumentException("Leap seconds can only be inserted at 23:59:60 - Date:" + leapDate);
			}
			adjustmentByte = +1;
		} else if (adjustment.equals("-")) {
			if (!"23:59:59".equals(timeOfLeapSecond)) {
				throw new java.lang.IllegalArgumentException("Leap seconds can only be removed at 23:59:59 - Date:" + leapDate);
			}
			adjustmentByte = -1;
		} else {
			throw new java.lang.IllegalArgumentException((("Invalid adjustment '" + adjustment) + "' in leap second rule for ") + leapDate);
		}
		java.lang.String rollingOrStationary = st.nextToken();
		if (!"S".equalsIgnoreCase(rollingOrStationary)) {
			throw new java.lang.IllegalArgumentException(("Only stationary ('S') leap seconds are supported, not '" + rollingOrStationary) + "'");
		}
		return new org.threeten.bp.zone.TzdbZoneRulesCompiler.LeapSecondRule(leapDate, adjustmentByte);
	}

	private void parseFile(java.io.File file) throws java.lang.Exception {
		int lineNumber = 1;
		java.lang.String line = null;
		java.io.BufferedReader in = null;
		try {
			in = new java.io.BufferedReader(new java.io.FileReader(file));
			java.util.List<org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBZone> openZone = null;
			for (; (line = in.readLine()) != null; lineNumber++) {
				int index = line.indexOf('#');
				if (index >= 0) {
					line = line.substring(0, index);
				}
				if (line.trim().length() == 0) {
					continue;
				}
				java.util.StringTokenizer st = new java.util.StringTokenizer(line, " \t");
				if (((openZone != null) && java.lang.Character.isWhitespace(line.charAt(0))) && st.hasMoreTokens()) {
					if (parseZoneLine(st, openZone)) {
						openZone = null;
					}
				} else if (st.hasMoreTokens()) {
					java.lang.String first = st.nextToken();
					if (first.equals("Zone")) {
						if (st.countTokens() < 3) {
							printVerbose((("Invalid Zone line in file: " + file) + ", line: ") + line);
							throw new java.lang.IllegalArgumentException("Invalid Zone line");
						}
						openZone = new java.util.ArrayList<org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBZone>();
						zones.put(st.nextToken(), openZone);
						if (parseZoneLine(st, openZone)) {
							openZone = null;
						}
					} else {
						openZone = null;
						if (first.equals("Rule")) {
							if (st.countTokens() < 9) {
								printVerbose((("Invalid Rule line in file: " + file) + ", line: ") + line);
								throw new java.lang.IllegalArgumentException("Invalid Rule line");
							}
							parseRuleLine(st);
						} else if (first.equals("Link")) {
							if (st.countTokens() < 2) {
								printVerbose((("Invalid Link line in file: " + file) + ", line: ") + line);
								throw new java.lang.IllegalArgumentException("Invalid Link line");
							}
							java.lang.String realId = st.nextToken();
							java.lang.String aliasId = st.nextToken();
							links.put(aliasId, realId);
						} else {
							throw new java.lang.IllegalArgumentException("Unknown line");
						}
					}
				}
			}
		} catch (java.lang.Exception ex) {
			throw new java.lang.Exception(((((("Failed while processing file '" + file) + "' on line ") + lineNumber) + " '") + line) + "'", ex);
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	private void parseRuleLine(java.util.StringTokenizer st) {
		org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBRule rule = new org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBRule();
		java.lang.String name = st.nextToken();
		if (rules.containsKey(name) == false) {
			rules.put(name, new java.util.ArrayList<org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBRule>());
		}
		rules.get(name).add(rule);
		rule.startYear = parseYear(st.nextToken(), 0);
		rule.endYear = parseYear(st.nextToken(), rule.startYear);
		if (rule.startYear > rule.endYear) {
			throw new java.lang.IllegalArgumentException((("Year order invalid: " + rule.startYear) + " > ") + rule.endYear);
		}
		parseOptional(st.nextToken());
		parseMonthDayTime(st, rule);
		rule.savingsAmount = parsePeriod(st.nextToken());
		rule.text = parseOptional(st.nextToken());
	}

	private boolean parseZoneLine(java.util.StringTokenizer st, java.util.List<org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBZone> zoneList) {
		org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBZone zone = new org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBZone();
		zoneList.add(zone);
		zone.standardOffset = parseOffset(st.nextToken());
		java.lang.String savingsRule = parseOptional(st.nextToken());
		if (savingsRule == null) {
			zone.fixedSavingsSecs = 0;
			zone.savingsRule = null;
		} else {
			try {
				zone.fixedSavingsSecs = parsePeriod(savingsRule);
				zone.savingsRule = null;
			} catch (java.lang.Exception ex) {
				zone.fixedSavingsSecs = null;
				zone.savingsRule = savingsRule;
			}
		}
		zone.text = st.nextToken();
		if (st.hasMoreTokens()) {
			zone.year = org.threeten.bp.Year.of(java.lang.Integer.parseInt(st.nextToken()));
			if (st.hasMoreTokens()) {
				parseMonthDayTime(st, zone);
			}
			return false;
		} else {
			return true;
		}
	}

	private void parseMonthDayTime(java.util.StringTokenizer st, org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBMonthDayTime mdt) {
		mdt.month = parseMonth(st.nextToken());
		if (st.hasMoreTokens()) {
			java.lang.String dayRule = st.nextToken();
			if (dayRule.startsWith("last")) {
				mdt.dayOfMonth = -1;
				mdt.dayOfWeek = parseDayOfWeek(dayRule.substring(4));
				mdt.adjustForwards = false;
			} else {
				int index = dayRule.indexOf(">=");
				if (index > 0) {
					mdt.dayOfWeek = parseDayOfWeek(dayRule.substring(0, index));
					dayRule = dayRule.substring(index + 2);
				} else {
					index = dayRule.indexOf("<=");
					if (index > 0) {
						mdt.dayOfWeek = parseDayOfWeek(dayRule.substring(0, index));
						mdt.adjustForwards = false;
						dayRule = dayRule.substring(index + 2);
					}
				}
				mdt.dayOfMonth = java.lang.Integer.parseInt(dayRule);
			}
			if (st.hasMoreTokens()) {
				java.lang.String timeStr = st.nextToken();
				int timeOfDaySecs = parseSecs(timeStr);
				org.threeten.bp.LocalTime time = deduplicate(org.threeten.bp.LocalTime.ofSecondOfDay(org.threeten.bp.jdk8.Jdk8Methods.floorMod(timeOfDaySecs, 86400)));
				mdt.time = time;
				mdt.adjustDays = org.threeten.bp.jdk8.Jdk8Methods.floorDiv(timeOfDaySecs, 86400);
				mdt.timeDefinition = parseTimeDefinition(timeStr.charAt(timeStr.length() - 1));
			}
		}
	}

	private int parseYear(java.lang.String str, int defaultYear) {
		str = str.toLowerCase();
		if (matches(str, "minimum")) {
			return org.threeten.bp.Year.MIN_VALUE;
		} else if (matches(str, "maximum")) {
			return org.threeten.bp.Year.MAX_VALUE;
		} else if (str.equals("only")) {
			return defaultYear;
		}
		return java.lang.Integer.parseInt(str);
	}

	private org.threeten.bp.Month parseMonth(java.lang.String str) {
		str = str.toLowerCase();
		for (org.threeten.bp.Month moy : org.threeten.bp.Month.values()) {
			if (matches(str, moy.name().toLowerCase())) {
				return moy;
			}
		}
		throw new java.lang.IllegalArgumentException("Unknown month: " + str);
	}

	private org.threeten.bp.DayOfWeek parseDayOfWeek(java.lang.String str) {
		str = str.toLowerCase();
		for (org.threeten.bp.DayOfWeek dow : org.threeten.bp.DayOfWeek.values()) {
			if (matches(str, dow.name().toLowerCase())) {
				return dow;
			}
		}
		throw new java.lang.IllegalArgumentException("Unknown day-of-week: " + str);
	}

	private boolean matches(java.lang.String str, java.lang.String search) {
		return (str.startsWith(search.substring(0, 3)) && search.startsWith(str)) && (str.length() <= search.length());
	}

	private java.lang.String parseOptional(java.lang.String str) {
		return str.equals("-") ? null : str;
	}

	private int parseSecs(java.lang.String str) {
		if (str.equals("-")) {
			return 0;
		}
		int pos = 0;
		if (str.startsWith("-")) {
			pos = 1;
		}
		java.text.ParsePosition pp = new java.text.ParsePosition(pos);
		org.threeten.bp.temporal.TemporalAccessor parsed = org.threeten.bp.zone.TzdbZoneRulesCompiler.TIME_PARSER.parseUnresolved(str, pp);
		if ((parsed == null) || (pp.getErrorIndex() >= 0)) {
			throw new java.lang.IllegalArgumentException(str);
		}
		long hour = parsed.getLong(org.threeten.bp.temporal.ChronoField.HOUR_OF_DAY);
		java.lang.Long min = (parsed.isSupported(org.threeten.bp.temporal.ChronoField.MINUTE_OF_HOUR)) ? parsed.getLong(org.threeten.bp.temporal.ChronoField.MINUTE_OF_HOUR) : null;
		java.lang.Long sec = (parsed.isSupported(org.threeten.bp.temporal.ChronoField.SECOND_OF_MINUTE)) ? parsed.getLong(org.threeten.bp.temporal.ChronoField.SECOND_OF_MINUTE) : null;
		int secs = ((int) ((((hour * 60) * 60) + ((min != null ? min : 0) * 60)) + (sec != null ? sec : 0)));
		if (pos == 1) {
			secs = -secs;
		}
		return secs;
	}

	private org.threeten.bp.ZoneOffset parseOffset(java.lang.String str) {
		int secs = parseSecs(str);
		return org.threeten.bp.ZoneOffset.ofTotalSeconds(secs);
	}

	private int parsePeriod(java.lang.String str) {
		return parseSecs(str);
	}

	private org.threeten.bp.zone.ZoneOffsetTransitionRule.TimeDefinition parseTimeDefinition(char c) {
		switch (c) {
			case 's' :
			case 'S' :
				return org.threeten.bp.zone.ZoneOffsetTransitionRule.TimeDefinition.STANDARD;
			case 'u' :
			case 'U' :
			case 'g' :
			case 'G' :
			case 'z' :
			case 'Z' :
				return org.threeten.bp.zone.ZoneOffsetTransitionRule.TimeDefinition.UTC;
			case 'w' :
			case 'W' :
			default :
				return org.threeten.bp.zone.ZoneOffsetTransitionRule.TimeDefinition.WALL;
		}
	}

	private void buildZoneRules() throws java.lang.Exception {
		for (java.lang.String zoneId : zones.keySet()) {
			printVerbose("Building zone " + zoneId);
			zoneId = deduplicate(zoneId);
			java.util.List<org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBZone> tzdbZones = zones.get(zoneId);
			org.threeten.bp.zone.ZoneRulesBuilder bld = new org.threeten.bp.zone.ZoneRulesBuilder();
			for (org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBZone tzdbZone : tzdbZones) {
				bld = tzdbZone.addToBuilder(bld, rules);
			}
			org.threeten.bp.zone.ZoneRules buildRules = bld.toRules(zoneId, deduplicateMap);
			builtZones.put(zoneId, deduplicate(buildRules));
		}
		for (java.lang.String aliasId : links.keySet()) {
			aliasId = deduplicate(aliasId);
			java.lang.String realId = links.get(aliasId);
			printVerbose((("Linking alias " + aliasId) + " to ") + realId);
			org.threeten.bp.zone.ZoneRules realRules = builtZones.get(realId);
			if (realRules == null) {
				realId = links.get(realId);
				printVerbose((("Relinking alias " + aliasId) + " to ") + realId);
				realRules = builtZones.get(realId);
				if (realRules == null) {
					throw new java.lang.IllegalArgumentException(((((("Alias '" + aliasId) + "' links to invalid zone '") + realId) + "' for '") + version) + "'");
				}
			}
			builtZones.put(aliasId, realRules);
		}
		builtZones.remove("UTC");
		builtZones.remove("GMT");
		builtZones.remove("GMT0");
		builtZones.remove("GMT+0");
		builtZones.remove("GMT-0");
	}

	@java.lang.SuppressWarnings("unchecked")
	<T> T deduplicate(T object) {
		if (deduplicateMap.containsKey(object) == false) {
			deduplicateMap.put(object, object);
		}
		return ((T) (deduplicateMap.get(object)));
	}

	private void printVerbose(java.lang.String message) {
		if (verbose) {
			java.lang.System.out.println(message);
		}
	}

	abstract class TZDBMonthDayTime {
		org.threeten.bp.Month month = org.threeten.bp.Month.JANUARY;

		int dayOfMonth = 1;

		boolean adjustForwards = true;

		org.threeten.bp.DayOfWeek dayOfWeek;

		org.threeten.bp.LocalTime time = org.threeten.bp.LocalTime.MIDNIGHT;

		int adjustDays;

		org.threeten.bp.zone.ZoneOffsetTransitionRule.TimeDefinition timeDefinition = org.threeten.bp.zone.ZoneOffsetTransitionRule.TimeDefinition.WALL;

		void adjustToFowards(int year) {
			if ((adjustForwards == false) && (dayOfMonth > 0)) {
				org.threeten.bp.LocalDate adjustedDate = org.threeten.bp.LocalDate.of(year, month, dayOfMonth).minusDays(6);
				dayOfMonth = adjustedDate.getDayOfMonth();
				month = adjustedDate.getMonth();
				adjustForwards = true;
			}
		}
	}

	final class TZDBRule extends org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBMonthDayTime {
		int startYear;

		int endYear;

		int savingsAmount;

		java.lang.String text;

		void addToBuilder(org.threeten.bp.zone.ZoneRulesBuilder bld) {
			adjustToFowards(2004);
			bld.addRuleToWindow(startYear, endYear, month, dayOfMonth, dayOfWeek, time, adjustDays, timeDefinition, savingsAmount);
		}
	}

	final class TZDBZone extends org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBMonthDayTime {
		org.threeten.bp.ZoneOffset standardOffset;

		java.lang.Integer fixedSavingsSecs;

		java.lang.String savingsRule;

		java.lang.String text;

		org.threeten.bp.Year year;

		org.threeten.bp.zone.ZoneRulesBuilder addToBuilder(org.threeten.bp.zone.ZoneRulesBuilder bld, java.util.Map<java.lang.String, java.util.List<org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBRule>> rules) {
			if (year != null) {
				bld.addWindow(standardOffset, toDateTime(year.getValue()), timeDefinition);
			} else {
				bld.addWindowForever(standardOffset);
			}
			if (fixedSavingsSecs != null) {
				bld.setFixedSavingsToWindow(fixedSavingsSecs);
			} else {
				java.util.List<org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBRule> tzdbRules = rules.get(savingsRule);
				if (tzdbRules == null) {
					throw new java.lang.IllegalArgumentException("Rule not found: " + savingsRule);
				}
				for (org.threeten.bp.zone.TzdbZoneRulesCompiler.TZDBRule tzdbRule : tzdbRules) {
					tzdbRule.addToBuilder(bld);
				}
			}
			return bld;
		}

		private org.threeten.bp.LocalDateTime toDateTime(int year) {
			adjustToFowards(year);
			org.threeten.bp.LocalDate date;
			if (dayOfMonth == (-1)) {
				dayOfMonth = month.length(org.threeten.bp.Year.isLeap(year));
				date = org.threeten.bp.LocalDate.of(year, month, dayOfMonth);
				if (dayOfWeek != null) {
					date = date.with(org.threeten.bp.temporal.TemporalAdjusters.previousOrSame(dayOfWeek));
				}
			} else {
				date = org.threeten.bp.LocalDate.of(year, month, dayOfMonth);
				if (dayOfWeek != null) {
					date = date.with(org.threeten.bp.temporal.TemporalAdjusters.nextOrSame(dayOfWeek));
				}
			}
			date = deduplicate(date.plusDays(adjustDays));
			return org.threeten.bp.LocalDateTime.of(date, time);
		}
	}

	static final class LeapSecondRule {
		public LeapSecondRule(org.threeten.bp.LocalDate leapDate, byte secondAdjustment) {
			this.leapDate = leapDate;
			this.secondAdjustment = secondAdjustment;
		}

		final org.threeten.bp.LocalDate leapDate;

		byte secondAdjustment;
	}
}