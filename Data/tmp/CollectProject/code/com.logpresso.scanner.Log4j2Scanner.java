public class Log4j2Scanner {
	public static final java.lang.String VERSION = "3.0.2";

	public static final java.lang.String RELEASE_DATE = "2022-02-14";

	public static final java.lang.String BANNER = ((("Logpresso CVE-2021-44228 Vulnerability Scanner " + com.logpresso.scanner.Log4j2Scanner.VERSION) + " (") + com.logpresso.scanner.Log4j2Scanner.RELEASE_DATE) + ")";

	private static final boolean isWindows = java.io.File.separatorChar == '\\';

	private com.logpresso.scanner.Configuration config;

	private com.logpresso.scanner.Metrics metrics;

	private com.logpresso.scanner.Detector detector;

	private com.logpresso.scanner.LogGenerator logGenerator;

	public static void main(java.lang.String[] args) {
		try {
			java.lang.System.out.println(com.logpresso.scanner.Log4j2Scanner.BANNER);
			com.logpresso.scanner.Log4j2Scanner scanner = new com.logpresso.scanner.Log4j2Scanner();
			int returnCode = scanner.run(args);
			java.lang.System.exit(returnCode);
		} catch (java.lang.Throwable t) {
			java.lang.System.out.println("Error: " + t.getMessage());
			if (!(t instanceof java.lang.IllegalArgumentException)) {
				t.printStackTrace();
			}
			java.lang.System.exit(-1);
		}
	}

	public int run(java.lang.String[] args) throws java.lang.Exception {
		if (args.length < 1) {
			com.logpresso.scanner.Configuration.pringUsage();
			return 0;
		}
		config = com.logpresso.scanner.Configuration.parseArguments(args);
		metrics = new com.logpresso.scanner.Metrics(config.getThrottle());
		if (config.isFix() && (!config.isForce())) {
			try {
				if (config.isScanForLog4j1()) {
					java.lang.System.out.print("This command will remove JndiLookup.class from log4j2-core binaries and " + ("remove JMSSink.class, JMSAppender.class, SocketServer.class, SMTPAppender.class, SMTPAppender$1.class, JDBCAppender.class, org.apache.log4j.chainsaw package " + "from log4j1-core binaries. Are you sure [y/N]? "));
				} else {
					java.lang.System.out.print("This command will remove JndiLookup.class from log4j2-core binaries. Are you sure [y/N]? ");
				}
				java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.System.in));
				java.lang.String answer = br.readLine();
				if (!answer.equalsIgnoreCase("y")) {
					java.lang.System.out.println("interrupted");
					return 0;
				}
			} catch (java.lang.Throwable t) {
				java.lang.System.out.println("error: " + t.getMessage());
				return -1;
			}
		}
		if (config.getRestorePath() != null) {
			return restore(config.getRestorePath());
		} else {
			return scanAndFix();
		}
	}

	public int restore(java.io.File backupFile) throws java.io.IOException {
		java.lang.System.out.println("");
		java.util.zip.ZipInputStream zis = null;
		try {
			zis = new java.util.zip.ZipInputStream(new java.io.FileInputStream(backupFile));
			while (true) {
				java.util.zip.ZipEntry entry = zis.getNextEntry();
				if (entry == null) {
					break;
				}
				java.lang.String path = entry.getName();
				if (com.logpresso.scanner.Log4j2Scanner.isWindows) {
					path = (path.charAt(0) + ":") + path.substring(1);
				}
				java.io.File targetFile = new java.io.File(path);
				restore(zis, targetFile);
			} 
		} finally {
			com.logpresso.scanner.utils.IoUtils.ensureClose(zis);
		}
		return 0;
	}

	private void restore(java.io.InputStream is, java.io.File targetFile) {
		boolean readonlyFile = false;
		if (!targetFile.canWrite()) {
			readonlyFile = true;
			if (!targetFile.setWritable(true)) {
				reportError(targetFile, "No write permission. Cannot remove read-only attribute");
				return;
			}
		}
		java.io.FileOutputStream fos = null;
		boolean lockError = true;
		boolean truncateError = true;
		try {
			com.logpresso.scanner.utils.FileUtils.checkLock(targetFile);
			lockError = false;
			long originalBytes = targetFile.length();
			com.logpresso.scanner.utils.FileUtils.truncate(targetFile);
			truncateError = false;
			fos = new java.io.FileOutputStream(targetFile);
			long transferBytes = com.logpresso.scanner.utils.FileUtils.transfer(is, fos);
			java.text.DecimalFormat formatter = new java.text.DecimalFormat("###,###");
			java.lang.String before = formatter.format(originalBytes);
			java.lang.String after = formatter.format(transferBytes);
			java.lang.System.out.printf("Restored: %s (%s => %s bytes)%n", targetFile.getAbsolutePath(), before, after);
		} catch (java.lang.Throwable t) {
			if (lockError) {
				java.lang.System.out.println("Cannot lock file " + t.getMessage());
			} else if (truncateError) {
				java.lang.System.out.println("Cannot truncate file " + t.getMessage());
			} else {
				java.lang.System.out.println("Cannot restore file " + t.getMessage());
			}
			if (config.isDebug()) {
				t.printStackTrace();
			}
		} finally {
			com.logpresso.scanner.utils.IoUtils.ensureClose(fos);
			if (readonlyFile) {
				if (!targetFile.setReadOnly()) {
					java.lang.System.out.println("Error: File cannot be set as read only - " + targetFile.getAbsolutePath());
				}
			}
		}
	}

	public int scanAndFix() throws java.io.IOException {
		metrics.setScanStartTime(java.lang.System.currentTimeMillis());
		logGenerator = new com.logpresso.scanner.LogGenerator(config);
		detector = new com.logpresso.scanner.Detector(config);
		detector.addLogListener(logGenerator);
		try {
			java.lang.String userName = java.lang.System.getProperty("user.name");
			if (config.isAllDrives()) {
				java.util.List<java.lang.String> allDrives = new java.util.ArrayList<java.lang.String>();
				for (com.logpresso.scanner.Partition drive : com.logpresso.scanner.PartitionLoader.getPartitions()) {
					if (isExcluded(drive.getPath())) {
						continue;
					}
					if (drive.getType().equals("Network Share")) {
						continue;
					}
					if (drive.getName().contains("Google Drive")) {
						continue;
					}
					allDrives.add(drive.getPath());
				}
				java.lang.System.out.println(((("Scanning drives by user '" + userName) + "': ") + com.logpresso.scanner.utils.StringUtils.join(allDrives, ", ")) + getExcludeDescription());
				java.lang.System.out.println("");
				for (java.lang.String drivePath : allDrives) {
					traverse(new java.io.File(drivePath), 0);
				}
			} else if (!config.getDriveLetters().isEmpty()) {
				java.util.List<java.lang.String> drives = new java.util.ArrayList<java.lang.String>();
				for (java.io.File drive : config.getDriveLetters()) {
					drives.add(drive.getAbsolutePath());
				}
				java.lang.System.out.println(((("Scanning drives by user '" + userName) + "': ") + com.logpresso.scanner.utils.StringUtils.join(drives, ", ")) + getExcludeDescription());
				java.lang.System.out.println("");
				for (java.io.File drive : config.getDriveLetters()) {
					traverse(drive, 0);
				}
			} else if (config.getIncludeFilePath() != null) {
				java.lang.System.out.println(((("Scanning files by user '" + userName) + "' in ") + config.getIncludeFilePath()) + getExcludeDescription());
				java.lang.System.out.println("");
				java.io.BufferedReader br = null;
				try {
					br = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(config.getIncludeFilePath()), "utf-8"));
					while (true) {
						java.lang.String filePath = br.readLine();
						if (filePath == null) {
							break;
						}
						filePath = filePath.trim();
						if (filePath.isEmpty() || filePath.startsWith("#")) {
							continue;
						}
						traverse(new java.io.File(filePath), 0);
					} 
				} finally {
					com.logpresso.scanner.utils.IoUtils.ensureClose(br);
				}
			} else {
				java.lang.String targetMsg = com.logpresso.scanner.utils.StringUtils.join(config.getTargetPaths(), ", ");
				java.lang.System.out.println(((("Scanning directory by user '" + userName) + "': ") + targetMsg) + getExcludeDescription());
				for (java.lang.String targetPath : config.getTargetPaths()) {
					java.io.File f = new java.io.File(targetPath);
					traverse(f, 0);
				}
			}
			if (config.isFix()) {
				fix();
			}
			try {
				com.logpresso.scanner.ReportGenerator.writeReportFile(config, metrics, detector);
				com.logpresso.scanner.ReportGenerator.sendReport(config, metrics, detector);
			} catch (java.lang.IllegalStateException e) {
				java.lang.System.out.println(e.getMessage());
			}
		} finally {
			com.logpresso.scanner.utils.IoUtils.ensureClose(logGenerator);
			long elapsed = java.lang.System.currentTimeMillis() - metrics.getScanStartTime();
			java.lang.System.out.println();
			java.lang.System.out.println(((("Scanned " + metrics.getScanDirCount()) + " directories and ") + metrics.getScanFileCount()) + " files");
			java.lang.System.out.println(("Found " + detector.getVulnerableFileCount()) + " vulnerable files");
			java.lang.System.out.println(("Found " + detector.getPotentiallyVulnerableFileCount()) + " potentially vulnerable files");
			java.lang.System.out.println(("Found " + detector.getMitigatedFileCount()) + " mitigated files");
			if (config.isFix()) {
				java.lang.System.out.println(("Fixed " + metrics.getFixedFileCount()) + " vulnerable log4j2 files and potentially vulnerable log4j1 files");
			}
			java.lang.System.out.printf("Completed in %.2f seconds\n", elapsed / 1000.0);
		}
		if (config.isOldExitCode()) {
			return detector.getVulnerableFileCount() + detector.getPotentiallyVulnerableFileCount();
		} else if (metrics.getErrorCount() > 0) {
			return 2;
		} else if ((detector.getVulnerableFileCount() > 0) || (detector.getPotentiallyVulnerableFileCount() > 0)) {
			return 1;
		} else {
			return 0;
		}
	}

	private java.lang.String getExcludeDescription() {
		java.lang.String excludeMsg = "";
		if (!config.getExcludePathPrefixes().isEmpty()) {
			excludeMsg = (" (without " + com.logpresso.scanner.utils.StringUtils.join(config.getExcludePathPrefixes(), ", ")) + ")";
		}
		return excludeMsg;
	}

	private void fix() {
		if (!detector.getVulnerableFiles().isEmpty()) {
			java.lang.System.out.println("");
		}
		java.util.List<java.io.File> backupFiles = new java.util.ArrayList<java.io.File>();
		for (com.logpresso.scanner.VulnerableFile vf : detector.getVulnerableFiles()) {
			java.io.File f = vf.getFile();
			java.io.File symlinkFile = null;
			java.lang.String symlinkMsg = "";
			if (com.logpresso.scanner.utils.FileUtils.isSymlink(f)) {
				try {
					symlinkFile = f;
					f = symlinkFile.getCanonicalFile();
					symlinkMsg = (" (from symlink " + symlinkFile.getAbsolutePath()) + ")";
				} catch (java.io.IOException e) {
				}
			}
			if (config.isTrace()) {
				java.lang.System.out.printf("Patching %s%s%n", f.getAbsolutePath(), symlinkMsg);
			}
			java.io.File backupFile = new java.io.File(f.getAbsolutePath() + ".bak");
			if (backupFile.exists()) {
				reportError(f, "Cannot create backup file. .bak File already exists");
				continue;
			}
			java.util.Set<java.lang.String> exceptCves = new java.util.HashSet<java.lang.String>();
			boolean needFix = false;
			java.util.List<com.logpresso.scanner.ReportEntry> entries = detector.getReportEntries(vf.getFile());
			for (com.logpresso.scanner.ReportEntry entry : entries) {
				java.lang.String cve = entry.getCve();
				if (cve.equals("CVE-2021-45105") || cve.equals("CVE-2021-44832")) {
					exceptCves.add(cve);
				} else {
					needFix = true;
				}
			}
			java.lang.String except = "";
			if (!exceptCves.isEmpty()) {
				except = (" (except " + com.logpresso.scanner.utils.StringUtils.join(exceptCves, ", ")) + ")";
			}
			if (!needFix) {
				java.lang.System.out.printf(("Cannot fix " + com.logpresso.scanner.utils.StringUtils.join(exceptCves, ", ")) + ", Upgrade it: %s%s%n", f.getAbsolutePath(), symlinkMsg);
				continue;
			}
			boolean readonlyFile = false;
			boolean lockError = true;
			boolean truncateError = true;
			try {
				if (!f.canWrite()) {
					readonlyFile = true;
					if (!f.setWritable(true)) {
						reportError(f, "No write permission. Cannot remove read-only attribute");
						continue;
					}
				}
				com.logpresso.scanner.utils.FileUtils.checkLock(f);
				lockError = false;
				com.logpresso.scanner.utils.FileUtils.copyAsIs(f, backupFile);
				com.logpresso.scanner.utils.FileUtils.truncate(f);
				truncateError = false;
				java.util.Set<java.lang.String> shadePatterns = detector.getShadePatterns();
				try {
					com.logpresso.scanner.utils.ZipUtils.repackage(backupFile, f, detector.getDeleteTargetChecker(), shadePatterns, config.isScanZip(), vf.isNestedJar(), config.isDebug(), vf.getAltCharset());
					for (com.logpresso.scanner.ReportEntry entry : entries) {
						if (!entry.getCve().equals("CVE-2021-45105")) {
							entry.setFixed(true);
						}
					}
					metrics.addFixedFileCount();
					java.lang.System.out.printf("Fixed: %s%s%s%n", f.getAbsolutePath(), symlinkMsg, except);
					backupFiles.add(backupFile);
				} catch (java.lang.Throwable t) {
					reportError(f, ("Cannot fix file (" + t.getMessage()) + ").", t);
					com.logpresso.scanner.utils.FileUtils.copyAsIs(backupFile, f);
				}
			} catch (java.lang.Throwable t) {
				if (lockError) {
					reportError(f, "Cannot lock file " + t.getMessage(), t);
				} else if (truncateError) {
					if (!backupFile.delete()) {
						java.lang.System.out.println("Error: Backup file cannot be deleted - " + backupFile.getAbsolutePath());
					}
					reportError(f, "Cannot truncate file " + t.getMessage(), t);
				} else {
					reportError(f, "Cannot backup file " + t.getMessage(), t);
				}
			} finally {
				if (readonlyFile) {
					if (!f.setReadOnly()) {
						java.lang.System.out.println("Error: File cannot be set as read only - " + f.getAbsolutePath());
					}
				}
			}
		}
		if (backupFiles.isEmpty()) {
			return;
		}
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss");
		java.lang.String timestamp = df.format(new java.util.Date(metrics.getScanStartTime()));
		java.io.File f = new java.io.File((("log4j2_scan_backup_" + timestamp) + ".") + config.getBackupExtension());
		if (config.getBackupPath() != null) {
			f = config.getBackupPath();
		}
		java.util.zip.ZipOutputStream zos = null;
		try {
			zos = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(f));
			for (java.io.File backupFile : backupFiles) {
				java.lang.String entryPath = backupFile.getAbsolutePath();
				if (com.logpresso.scanner.Log4j2Scanner.isWindows) {
					entryPath = entryPath.replaceAll("\\\\", "/");
					entryPath = entryPath.charAt(0) + entryPath.substring(2);
				}
				entryPath = entryPath.substring(0, entryPath.length() - ".bak".length());
				zos.putNextEntry(new java.util.zip.ZipEntry(entryPath));
				java.io.FileInputStream is = null;
				try {
					is = new java.io.FileInputStream(backupFile);
					com.logpresso.scanner.utils.FileUtils.transfer(is, zos);
				} finally {
					com.logpresso.scanner.utils.IoUtils.ensureClose(is);
				}
			}
		} catch (java.io.IOException e) {
			throw new java.lang.IllegalStateException("Cannot archive backup files to " + f.getAbsolutePath(), e);
		} finally {
			com.logpresso.scanner.utils.IoUtils.ensureClose(zos);
		}
		for (java.io.File backupFile : backupFiles) {
			if (!backupFile.delete()) {
				java.lang.System.out.println("Error: Backup file cannot be deleted - " + backupFile.getAbsolutePath());
			}
		}
	}

	private void traverse(java.io.File f, int depth) {
		if ((!config.isSilent()) && metrics.canStatusReporting()) {
			printScanStatus();
		}
		java.lang.String path = f.getAbsolutePath();
		if ((depth == 0) && (!f.exists())) {
			reportError(f, "File not found");
			return;
		}
		if (f.isDirectory()) {
			metrics.setLastVisitDirectory(f);
			if (isExcluded(path)) {
				if (config.isTrace()) {
					java.lang.System.out.println("Skipping excluded directory: " + path);
				}
				return;
			}
			if ((depth > 0) && com.logpresso.scanner.utils.FileUtils.isSymlink(f)) {
				if (config.isTrace()) {
					java.lang.System.out.println("Skipping symlink: " + path);
				}
				return;
			}
			if (isExcludedDirectory(path)) {
				if (config.isTrace()) {
					java.lang.System.out.println("Skipping directory: " + path);
				}
				return;
			}
			if (config.isTrace()) {
				java.lang.System.out.println("Scanning directory: " + path);
			}
			metrics.addScanDirCount();
			java.nio.file.DirectoryStream<java.nio.file.Path> stream = null;
			java.util.Iterator<java.nio.file.Path> it = null;
			try {
				stream = java.nio.file.Files.newDirectoryStream(f.toPath());
				it = stream.iterator();
				while (it.hasNext()) {
					java.nio.file.Path p = it.next();
					traverse(p.toFile(), depth + 1);
				} 
			} catch (java.nio.file.AccessDeniedException e) {
				reportError(f, "Access denied", e);
			} catch (java.io.IOException e) {
				java.lang.String msg = (e.getClass().getSimpleName() + " - ") + e.getMessage();
				reportError(f, msg, e);
			} finally {
				com.logpresso.scanner.utils.IoUtils.ensureClose(stream);
			}
		} else {
			metrics.addScanFileCount();
			if ((!config.getExcludeFilePaths().isEmpty()) && config.getExcludeFilePaths().contains(path.toLowerCase())) {
				if (config.isTrace()) {
					java.lang.System.out.println("Skipping file (excluded file): " + path);
				}
			} else if (config.isNoSymlink() && com.logpresso.scanner.utils.FileUtils.isSymlink(f)) {
				if (config.isTrace()) {
					java.lang.System.out.println("Skipping symlink: " + path);
				}
			} else if (com.logpresso.scanner.utils.ZipUtils.isScanTarget(path, config.isScanZip())) {
				if (isWinRarFile(f)) {
					if (config.isTrace()) {
						java.lang.System.out.println("Skipping file (winrar): " + path);
					}
					return;
				}
				if (config.isTrace()) {
					java.lang.System.out.println("Scanning file: " + path);
				}
				detector.scanJarFile(f, config.isFix());
			} else if (config.isTrace()) {
				java.lang.System.out.println("Skipping file: " + path);
			}
		}
	}

	private boolean isWinRarFile(java.io.File f) {
		try {
			return com.logpresso.scanner.utils.FileUtils.readMagic(f) == 0x52617221;
		} catch (java.lang.Throwable t) {
			return false;
		}
	}

	private void printScanStatus() {
		long now = java.lang.System.currentTimeMillis();
		int elapsed = ((int) ((now - metrics.getScanStartTime()) / 1000));
		java.lang.System.out.printf("Running scan (%ds): scanned %d directories, %d files, last visit: %s%n", elapsed, metrics.getScanDirCount(), metrics.getScanFileCount(), metrics.getLastVisitDirectory().getAbsolutePath());
		metrics.setLastStatusLogging();
	}

	private boolean isExcludedDirectory(java.lang.String path) {
		if (com.logpresso.scanner.Log4j2Scanner.isWindows && (path.toUpperCase().indexOf("$RECYCLE.BIN") == 3)) {
			return true;
		}
		return ((((path.equals("/proc") || path.startsWith("/proc/")) || (path.equals("/sys") || path.startsWith("/sys/"))) || (path.equals("/dev") || path.startsWith("/dev/"))) || (path.equals("/run") || path.startsWith("/run/"))) || (path.equals("/var/run") || path.startsWith("/var/run/"));
	}

	private boolean isExcluded(java.lang.String path) {
		if (com.logpresso.scanner.Log4j2Scanner.isWindows) {
			path = path.toUpperCase();
		}
		for (java.lang.String excludePath : config.getExcludePathPrefixes()) {
			if (path.startsWith(excludePath)) {
				return true;
			}
		}
		for (java.lang.String excludePattern : config.getExcludePatterns()) {
			if (path.contains(excludePattern)) {
				return true;
			}
		}
		return false;
	}

	private void reportError(java.io.File f, java.lang.String msg) {
		reportError(f, msg, null);
	}

	private void reportError(java.io.File f, java.lang.String msg, java.lang.Throwable t) {
		metrics.addErrorCount();
		if (detector != null) {
			detector.addErrorReport(f, msg);
		}
		java.lang.System.out.println((("Error: " + msg) + ". Skipping ") + f.getAbsolutePath());
		if (config.isDebug() && (t != null)) {
			if (!(t instanceof java.nio.file.AccessDeniedException)) {
				t.printStackTrace();
			}
		}
	}
}