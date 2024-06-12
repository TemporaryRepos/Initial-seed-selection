public final class SignTool {
	private static final java.lang.String ZIPALIGN_ALIGNMENT = "4";

	private static final java.lang.String APK_FILE_EXTENSION = "apk";

	private SignTool() {
	}

	public static void main(java.lang.String[] args) {
		at.favre.tools.apksigner.SignTool.Result result = at.favre.tools.apksigner.SignTool.mainExecute(args);
		if ((result != null) && result.error) {
			java.lang.System.exit(1);
		} else if ((result != null) && (result.unsuccessful > 0)) {
			java.lang.System.exit(2);
		}
	}

	static at.favre.tools.apksigner.SignTool.Result mainExecute(java.lang.String[] args) {
		at.favre.tools.apksigner.ui.Arg arguments = at.favre.tools.apksigner.ui.CLIParser.parse(args);
		if (arguments != null) {
			return at.favre.tools.apksigner.SignTool.execute(arguments);
		}
		return null;
	}

	private static at.favre.tools.apksigner.SignTool.Result execute(at.favre.tools.apksigner.ui.Arg args) {
		java.util.List<at.favre.tools.apksigner.util.CmdUtil.Result> executedCommands = new java.util.ArrayList<>();
		at.favre.tools.apksigner.signing.ZipAlignExecutor zipAlignExecutor = null;
		at.favre.tools.apksigner.signing.SigningConfigGen signingConfigGen = null;
		int successCount = 0;
		int errorCount = 0;
		try {
			java.io.File outFolder = null;
			java.util.List<java.io.File> targetApkFiles = new at.favre.tools.apksigner.ui.FileArgParser().parseAndSortUniqueFilesNonRecursive(args.apkFile, at.favre.tools.apksigner.SignTool.APK_FILE_EXTENSION);
			if (targetApkFiles.isEmpty()) {
				throw new java.lang.IllegalStateException("no apk files found in given paths");
			}
			at.favre.tools.apksigner.SignTool.log("source:");
			for (java.lang.String path : at.favre.tools.apksigner.ui.FileArgParser.getDirSummary(targetApkFiles)) {
				at.favre.tools.apksigner.SignTool.log("\t" + path);
			}
			if (args.out != null) {
				outFolder = new java.io.File(args.out);
				if (!outFolder.exists()) {
					outFolder.mkdirs();
				}
				if ((!outFolder.exists()) || (!outFolder.isDirectory())) {
					throw new java.lang.IllegalArgumentException("if out directory is provided it must exist and be a path: " + args.out);
				}
			}
			if (!args.skipZipAlign) {
				zipAlignExecutor = new at.favre.tools.apksigner.signing.ZipAlignExecutor(args);
				at.favre.tools.apksigner.SignTool.log(zipAlignExecutor.toString());
			}
			if (!args.onlyVerify) {
				at.favre.tools.apksigner.SignTool.log("keystore:");
				signingConfigGen = new at.favre.tools.apksigner.signing.SigningConfigGen(args.signArgsList, args.ksIsDebug);
				for (at.favre.tools.apksigner.signing.SigningConfig signingConfig : signingConfigGen.signingConfig) {
					at.favre.tools.apksigner.SignTool.log("\t" + signingConfig.description());
				}
			}
			if (args.lineageFilePath != null) {
				at.favre.tools.apksigner.SignTool.processLineagePath(args);
			}
			long startTime = java.lang.System.currentTimeMillis();
			int iterCount = 0;
			java.util.List<java.io.File> tempFilesToDelete = new java.util.ArrayList<>();
			for (java.io.File targetApkFile : targetApkFiles) {
				iterCount++;
				java.io.File rootTargetFile = targetApkFile;
				at.favre.tools.apksigner.SignTool.log((("\n" + java.lang.String.format("%02d", iterCount)) + ". ") + targetApkFile.getName());
				if (args.dryRun) {
					at.favre.tools.apksigner.SignTool.log("\t- (skip)");
					continue;
				}
				if (!args.onlyVerify) {
					at.favre.tools.apksigner.signing.AndroidApkSignerVerify.Result preCheck = at.favre.tools.apksigner.SignTool.verifySign(targetApkFile, rootTargetFile, args.checkCertSha256, false, true);
					if ((preCheck != null) && args.allowResign) {
						at.favre.tools.apksigner.SignTool.log(("\tWARNING: already signed - will be resigned. Old certificate info: " + preCheck.getCertCountString()) + preCheck.getSchemaVersionInfoString());
						for (at.favre.tools.apksigner.signing.AndroidApkSignerVerify.CertInfo certInfo : preCheck.certInfoList) {
							at.favre.tools.apksigner.SignTool.log("\t\tSubject: " + certInfo.subjectDn);
							at.favre.tools.apksigner.SignTool.log("\t\tSHA256: " + certInfo.certSha256);
						}
					} else if (preCheck != null) {
						at.favre.tools.apksigner.SignTool.logErr("\t- already signed SKIP");
						errorCount++;
						continue;
					}
				}
				if (!args.onlyVerify) {
					at.favre.tools.apksigner.SignTool.log("\n\tSIGN");
					at.favre.tools.apksigner.SignTool.log(((("\tfile: " + rootTargetFile.getCanonicalPath()) + " (") + at.favre.tools.apksigner.util.FileUtil.getFileSizeMb(targetApkFile)) + ")");
					at.favre.tools.apksigner.SignTool.log(("\tchecksum: " + at.favre.tools.apksigner.util.FileUtil.createChecksum(rootTargetFile, "SHA-256")) + " (sha256)");
					targetApkFile = at.favre.tools.apksigner.SignTool.zipAlign(targetApkFile, rootTargetFile, outFolder, zipAlignExecutor, args, executedCommands);
					if (targetApkFile == null) {
						throw new java.lang.IllegalStateException("could not execute zipalign");
					}
					if ((!args.overwrite) && (!args.skipZipAlign)) {
						tempFilesToDelete.add(targetApkFile);
					}
					targetApkFile = at.favre.tools.apksigner.SignTool.sign(targetApkFile, outFolder, signingConfigGen.signingConfig, args);
				}
				at.favre.tools.apksigner.SignTool.log("\n\tVERIFY");
				at.favre.tools.apksigner.SignTool.log(((("\tfile: " + targetApkFile.getCanonicalPath()) + " (") + at.favre.tools.apksigner.util.FileUtil.getFileSizeMb(targetApkFile)) + ")");
				at.favre.tools.apksigner.SignTool.log(("\tchecksum: " + at.favre.tools.apksigner.util.FileUtil.createChecksum(targetApkFile, "SHA-256")) + " (sha256)");
				boolean zipAlignVerified = args.skipZipAlign || at.favre.tools.apksigner.SignTool.verifyZipAlign(targetApkFile, rootTargetFile, zipAlignExecutor, args, executedCommands);
				boolean sigVerified = at.favre.tools.apksigner.SignTool.verifySign(targetApkFile, rootTargetFile, args.checkCertSha256, args.verbose, false) != null;
				if (zipAlignVerified && sigVerified) {
					successCount++;
				} else {
					errorCount++;
				}
			}
			if (iterCount == 0) {
				at.favre.tools.apksigner.SignTool.log("No apks found.");
			}
			at.favre.tools.apksigner.SignTool.deleteTempFiles(args, tempFilesToDelete);
			at.favre.tools.apksigner.SignTool.log(java.lang.String.format(java.util.Locale.US, "\n[%s][v%s]\nSuccessfully processed %d APKs and %d errors in %.2f seconds.", new java.util.Date().toString(), at.favre.tools.apksigner.util.CmdUtil.jarVersion(), successCount, errorCount, ((double) (java.lang.System.currentTimeMillis() - startTime)) / 1000.0));
			if (args.debug) {
				at.favre.tools.apksigner.SignTool.log(at.favre.tools.apksigner.SignTool.getCommandHistory(executedCommands));
			}
		} catch (java.lang.Exception e) {
			at.favre.tools.apksigner.SignTool.logException(args, executedCommands, e);
			return new at.favre.tools.apksigner.SignTool.Result(true, successCount, errorCount);
		} finally {
			at.favre.tools.apksigner.SignTool.cleanup(zipAlignExecutor, signingConfigGen);
		}
		return new at.favre.tools.apksigner.SignTool.Result(false, successCount, errorCount);
	}

	private static void processLineagePath(at.favre.tools.apksigner.ui.Arg args) throws java.io.IOException {
		java.io.File lineageFile = new java.io.File(args.lineageFilePath);
		if ((!lineageFile.exists()) || (!lineageFile.isFile())) {
			throw new java.lang.IllegalArgumentException("lineage file either does not exist or is not a file: " + args.lineageFilePath);
		}
		at.favre.tools.apksigner.SignTool.log("lineage:");
		at.favre.tools.apksigner.SignTool.log((("\t" + at.favre.tools.apksigner.util.FileUtil.createChecksum(lineageFile, "SHA-256").substring(0, 8)) + " ") + lineageFile.getCanonicalPath());
	}

	private static void deleteTempFiles(at.favre.tools.apksigner.ui.Arg args, java.util.List<java.io.File> tempFilesToDelete) {
		for (java.io.File file : tempFilesToDelete) {
			if (args.verbose) {
				at.favre.tools.apksigner.SignTool.log("delete temp file " + file);
			}
			file.delete();
		}
	}

	private static void cleanup(at.favre.tools.apksigner.signing.ZipAlignExecutor zipAlignExecutor, at.favre.tools.apksigner.signing.SigningConfigGen signingConfigGen) {
		if (zipAlignExecutor != null) {
			zipAlignExecutor.cleanUp();
		}
		if (signingConfigGen != null) {
			signingConfigGen.cleanUp();
		}
	}

	private static void logException(at.favre.tools.apksigner.ui.Arg args, java.util.List<at.favre.tools.apksigner.util.CmdUtil.Result> executedCommands, java.lang.Exception e) {
		at.favre.tools.apksigner.SignTool.logErr(e.getMessage());
		if (args.debug) {
			e.printStackTrace();
			at.favre.tools.apksigner.SignTool.logErr(at.favre.tools.apksigner.SignTool.getCommandHistory(executedCommands));
		} else {
			at.favre.tools.apksigner.SignTool.logErr("Run with '--debug' parameter to get additional information.");
		}
	}

	private static java.io.File zipAlign(java.io.File targetApkFile, java.io.File rootTargetFile, java.io.File outFolder, at.favre.tools.apksigner.signing.ZipAlignExecutor executor, at.favre.tools.apksigner.ui.Arg arguments, java.util.List<at.favre.tools.apksigner.util.CmdUtil.Result> cmdList) {
		if (!arguments.skipZipAlign) {
			java.lang.String fileName = at.favre.tools.apksigner.util.FileUtil.getFileNameWithoutExtension(targetApkFile);
			fileName = fileName.replace("-unaligned", "");
			fileName += "-aligned";
			java.io.File outFile = new java.io.File(outFolder != null ? outFolder : targetApkFile.getParentFile(), (fileName + ".") + at.favre.tools.apksigner.util.FileUtil.getFileExtension(targetApkFile));
			if (outFile.exists()) {
				outFile.delete();
			}
			if (executor.isExecutableFound()) {
				java.lang.String logMsg = "\t- ";
				at.favre.tools.apksigner.util.CmdUtil.Result zipAlignResult = at.favre.tools.apksigner.util.CmdUtil.runCmd(at.favre.tools.apksigner.util.CmdUtil.concat(executor.getZipAlignExecutable(), new java.lang.String[]{ "-p", "-v", at.favre.tools.apksigner.SignTool.ZIPALIGN_ALIGNMENT, targetApkFile.getAbsolutePath(), outFile.getAbsolutePath() }));
				cmdList.add(zipAlignResult);
				if (zipAlignResult.success()) {
					logMsg += "zipalign success";
				} else {
					logMsg += "could not align ";
				}
				at.favre.tools.apksigner.SignTool.logConditionally(logMsg, outFile, !rootTargetFile.equals(outFile), false);
				if (arguments.overwrite) {
					targetApkFile.delete();
					outFile.renameTo(targetApkFile);
					outFile = targetApkFile;
				}
				return zipAlignResult.success() ? outFile : null;
			} else {
				throw new java.lang.IllegalArgumentException("could not find zipalign - either skip it or provide a proper location");
			}
		}
		return targetApkFile;
	}

	private static boolean verifyZipAlign(java.io.File targetApkFile, java.io.File rootTargetFile, at.favre.tools.apksigner.signing.ZipAlignExecutor executor, at.favre.tools.apksigner.ui.Arg arguments, java.util.List<at.favre.tools.apksigner.util.CmdUtil.Result> cmdList) {
		if (!arguments.skipZipAlign) {
			if (executor.isExecutableFound()) {
				java.lang.String logMsg = "\t- ";
				at.favre.tools.apksigner.util.CmdUtil.Result zipAlignVerifyResult = at.favre.tools.apksigner.util.CmdUtil.runCmd(at.favre.tools.apksigner.util.CmdUtil.concat(executor.getZipAlignExecutable(), new java.lang.String[]{ "-c", at.favre.tools.apksigner.SignTool.ZIPALIGN_ALIGNMENT, targetApkFile.getAbsolutePath() }));
				cmdList.add(zipAlignVerifyResult);
				boolean success = zipAlignVerifyResult.success();
				if (success) {
					logMsg += "zipalign verified";
				} else {
					logMsg += "zipalign VERIFY FAILED";
				}
				at.favre.tools.apksigner.SignTool.logConditionally(logMsg, targetApkFile, !targetApkFile.equals(rootTargetFile), !success);
				return zipAlignVerifyResult.success();
			} else {
				throw new java.lang.IllegalArgumentException("could not find zipalign - either skip it or provide a proper location");
			}
		}
		return true;
	}

	private static java.io.File sign(java.io.File targetApkFile, java.io.File outFolder, java.util.List<at.favre.tools.apksigner.signing.SigningConfig> signingConfigs, at.favre.tools.apksigner.ui.Arg arguments) {
		try {
			java.io.File outFile = targetApkFile;
			if (!arguments.overwrite) {
				java.lang.String fileName = at.favre.tools.apksigner.util.FileUtil.getFileNameWithoutExtension(targetApkFile);
				fileName = fileName.replace("-unsigned", "");
				if ((signingConfigs.size() == 1) && signingConfigs.get(0).isDebugType) {
					fileName += "-debugSigned";
				} else {
					fileName += "-signed";
				}
				outFile = new java.io.File(outFolder != null ? outFolder : targetApkFile.getParentFile(), (fileName + ".") + at.favre.tools.apksigner.util.FileUtil.getFileExtension(targetApkFile));
				if (outFile.exists()) {
					outFile.delete();
				}
			}
			java.io.ByteArrayOutputStream apkSignerToolStream = new java.io.ByteArrayOutputStream();
			java.io.PrintStream sout = java.lang.System.out;
			java.lang.System.setOut(new java.io.PrintStream(apkSignerToolStream));
			com.android.apksigner.ApkSignerTool.main(at.favre.tools.apksigner.util.AndroidApkSignerUtil.createApkToolArgs(arguments, signingConfigs, targetApkFile, outFile));
			java.lang.String output = apkSignerToolStream.toString("UTF-8").trim();
			java.lang.System.setOut(sout);
			at.favre.tools.apksigner.SignTool.log("\t- sign success");
			if (arguments.verbose && (!output.isEmpty())) {
				at.favre.tools.apksigner.SignTool.log("\t\t" + output);
			}
			return outFile;
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			throw new java.lang.IllegalStateException((("could not sign " + targetApkFile) + ": ") + e.getMessage(), e);
		}
	}

	private static at.favre.tools.apksigner.signing.AndroidApkSignerVerify.Result verifySign(java.io.File targetApkFile, java.io.File rootTargetFile, java.lang.String[] checkHashes, boolean verbose, boolean preCheckVerify) {
		try {
			at.favre.tools.apksigner.signing.AndroidApkSignerVerify verifier = new at.favre.tools.apksigner.signing.AndroidApkSignerVerify();
			at.favre.tools.apksigner.signing.AndroidApkSignerVerify.Result result = verifier.verify(targetApkFile, null, null, null, false);
			if (!preCheckVerify) {
				java.lang.String logMsg;
				if (result.verified) {
					logMsg = ("\t- signature verified " + result.getCertCountString()) + result.getSchemaVersionInfoString();
				} else {
					logMsg = ("\t- signature VERIFY FAILED (" + targetApkFile.getName()) + ")";
				}
				at.favre.tools.apksigner.SignTool.logConditionally(logMsg, targetApkFile, !rootTargetFile.equals(targetApkFile), !result.verified);
				if (!result.errors.isEmpty()) {
					for (java.lang.String e : result.errors) {
						at.favre.tools.apksigner.SignTool.logErr("\t\t" + e);
					}
				}
				if (verbose && (!result.warnings.isEmpty())) {
					for (java.lang.String w : result.warnings) {
						at.favre.tools.apksigner.SignTool.log("\t\t" + w);
					}
				} else if (!result.warnings.isEmpty()) {
					at.favre.tools.apksigner.SignTool.log(("\t\t" + result.warnings.size()) + " warnings");
				}
				if (result.verified) {
					for (int i = 0; i < result.certInfoList.size(); i++) {
						at.favre.tools.apksigner.signing.AndroidApkSignerVerify.CertInfo certInfo = result.certInfoList.get(i);
						at.favre.tools.apksigner.SignTool.log("\t\t" + certInfo.subjectDn);
						at.favre.tools.apksigner.SignTool.log((("\t\tSHA256: " + certInfo.certSha256) + " / ") + certInfo.sigAlgo);
						if (verbose) {
							at.favre.tools.apksigner.SignTool.log("\t\tSHA1: " + certInfo.certSha1);
							at.favre.tools.apksigner.SignTool.log("\t\t" + certInfo.issuerDn);
							at.favre.tools.apksigner.SignTool.log("\t\tPublic Key SHA256: " + certInfo.pubSha256);
							at.favre.tools.apksigner.SignTool.log("\t\tPublic Key SHA1: " + certInfo.pubSha1);
							at.favre.tools.apksigner.SignTool.log((("\t\tPublic Key Algo: " + certInfo.pubAlgo) + " ") + certInfo.pubKeysize);
							at.favre.tools.apksigner.SignTool.log("\t\tIssue Date: " + certInfo.beginValidity);
						}
						at.favre.tools.apksigner.SignTool.log("\t\tExpires: " + certInfo.expiry.toString());
						if (i < (result.certInfoList.size() - 1)) {
							at.favre.tools.apksigner.SignTool.log("");
						}
					}
				}
				at.favre.tools.apksigner.signing.CertHashChecker.Result certHashResult = new at.favre.tools.apksigner.signing.CertHashChecker().check(result, checkHashes);
				if (certHashResult != null) {
					if (!certHashResult.verified) {
						at.favre.tools.apksigner.SignTool.log("\t- verify with provided hash check failed " + certHashResult.hashSummary());
						at.favre.tools.apksigner.SignTool.logErr("\t\tERROR: " + certHashResult.errorString);
					} else {
						at.favre.tools.apksigner.SignTool.log("\t- verify with provided hash successful " + certHashResult.hashSummary());
					}
					return result.verified && certHashResult.verified ? result : null;
				}
			}
			return result.verified ? result : null;
		} catch (java.lang.Exception e) {
			throw new java.lang.IllegalStateException((("could not verify " + targetApkFile) + ": ") + e.getMessage(), e);
		}
	}

	private static java.lang.String getCommandHistory(java.util.List<at.favre.tools.apksigner.util.CmdUtil.Result> executedCommands) {
		java.lang.StringBuilder sb = new java.lang.StringBuilder("\nCmd history for debugging purpose:\n-----------------------\n");
		for (at.favre.tools.apksigner.util.CmdUtil.Result executedCommand : executedCommands) {
			sb.append(executedCommand.toString());
		}
		return sb.toString();
	}

	private static void logErr(java.lang.String msg) {
		java.lang.System.err.println(msg);
	}

	private static void log(java.lang.String msg) {
		java.lang.System.out.println(msg);
	}

	private static void logConditionally(java.lang.String logMsg, java.io.File file, boolean appendFile, boolean error) {
		if (appendFile && error) {
			logMsg += (" (" + file.getName()) + ")";
		}
		if (error) {
			at.favre.tools.apksigner.SignTool.logErr(logMsg);
		} else {
			at.favre.tools.apksigner.SignTool.log(logMsg);
		}
	}

	static class Result {
		final boolean error;

		final int success;

		final int unsuccessful;

		Result(boolean error, int success, int unsuccessful) {
			this.error = error;
			this.success = success;
			this.unsuccessful = unsuccessful;
		}
	}
}