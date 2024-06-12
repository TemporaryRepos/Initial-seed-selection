public class Application {
	private static final java.lang.String ZIP = ".zip";

	private static final java.lang.String COMPLETE_OWL_AXIOM_DELTA = "complete-owl-axiom-delta-";

	private static final java.lang.String ARG_HELP = "-help";

	private static final java.lang.String ARG_DEBUG = "-debug";

	private static final java.lang.String ARG_RF2_TO_OWL = "-rf2-to-owl";

	private static final java.lang.String ARG_CLASSIFY = "-classify";

	private static final java.lang.String ARG_RF2_STATED_TO_COMPLETE_OWL = "-rf2-stated-to-complete-owl";

	private static final java.lang.String ARG_RF2_OWL_TO_STATED = "-rf2-owl-to-stated";

	private static final java.lang.String ARG_RF2_SNAPSHOT_ARCHIVES = "-rf2-snapshot-archives";

	private static final java.lang.String ARG_RF2_AUTHORING_DELTA_ARCHIVE = "-rf2-authoring-delta-archive";

	private static final java.lang.String ARG_RF2_STATED_TO_COMPLETE_OWL_RECONCILE = "-rf2-stated-to-complete-owl-reconcile";

	private static final java.lang.String ARG_URI = "-uri";

	private static final java.lang.String ARG_VERSION = "-version";

	private static final java.lang.String ARG_WITHOUT_ANNOTATIONS = "-without-annotations";

	private static final java.text.SimpleDateFormat DATETIME_FORMAT = new java.text.SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

	private static final java.text.SimpleDateFormat DATE_FORMAT = new java.text.SimpleDateFormat("yyyyMMdd");

	private static final java.lang.String STATED_RELATIONSHIP_SNAPSHOT = "sct2_StatedRelationship_Snapshot.txt";

	private boolean deleteOntologyFileOnExit;

	public static void main(java.lang.String[] argsArray) {
		try {
			new org.snomed.otf.owltoolkit.Application().run(argsArray);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			java.lang.System.exit(1);
		}
		java.lang.System.exit(0);
	}

	public void run(java.lang.String[] argsArray) throws java.io.IOException, org.snomed.otf.owltoolkit.conversion.ConversionException, org.snomed.otf.owltoolkit.service.ReasonerServiceException, org.semanticweb.owlapi.model.OWLOntologyCreationException, org.ihtsdo.otf.snomedboot.ReleaseImportException {
		java.util.List<java.lang.String> args = com.google.common.collect.Lists.newArrayList(argsArray);
		boolean modeFound = false;
		if (args.isEmpty() || args.contains(org.snomed.otf.owltoolkit.Application.ARG_HELP)) {
			modeFound = true;
			printHelp();
		} else {
			for (java.lang.String arg : args) {
				assertTrue("When specifying multiple archives please include no whitespace before or after the comma.", (!arg.startsWith(",")) && (!arg.endsWith(",")));
			}
			if (args.contains(org.snomed.otf.owltoolkit.Application.ARG_CLASSIFY)) {
				modeFound = true;
				classify(args);
			} else if (args.contains(org.snomed.otf.owltoolkit.Application.ARG_RF2_STATED_TO_COMPLETE_OWL)) {
				modeFound = true;
				statedRelationshipsToOwlReferenceSet(args);
			} else if (args.contains(org.snomed.otf.owltoolkit.Application.ARG_RF2_OWL_TO_STATED)) {
				modeFound = true;
				owlReferenceSetToStatedRelationships(args);
			} else if (args.contains(org.snomed.otf.owltoolkit.Application.ARG_RF2_STATED_TO_COMPLETE_OWL_RECONCILE)) {
				modeFound = true;
				convertStatedRelationshipsToOwlReferenceSetAndReconcile(args);
			}
			if ((!modeFound) || args.contains(org.snomed.otf.owltoolkit.Application.ARG_RF2_TO_OWL)) {
				rf2ToOwl(args);
			}
		}
	}

	private void classify(java.util.List<java.lang.String> args) throws org.snomed.otf.owltoolkit.service.ReasonerServiceException {
		java.util.Set<java.io.File> snapshotFiles = getSnapshotFiles(args);
		java.io.File deltaFile = getDeltaFiles(args);
		java.io.File resultsFile = new java.io.File(("classification-results-" + org.snomed.otf.owltoolkit.Application.DATETIME_FORMAT.format(new java.util.Date())) + org.snomed.otf.owltoolkit.Application.ZIP);
		new org.snomed.otf.owltoolkit.service.SnomedReasonerService().classify("command-line", snapshotFiles, deltaFile, resultsFile, org.snomed.otf.owltoolkit.service.SnomedReasonerService.ELK_REASONER_FACTORY, false);
		java.lang.System.out.println("Classification results written to " + resultsFile.getAbsolutePath());
	}

	private void rf2ToOwl(java.util.List<java.lang.String> args) throws org.snomed.otf.owltoolkit.conversion.ConversionException, java.io.IOException {
		java.util.Set<java.io.File> snapshotFiles = getSnapshotFiles(args);
		java.io.File deltaFile = getDeltaFiles(args);
		java.lang.String ontologyUri = getParameterValue(org.snomed.otf.owltoolkit.Application.ARG_URI, args);
		if (ontologyUri == null) {
			ontologyUri = org.snomed.otf.owltoolkit.ontology.OntologyService.SNOMED_INTERNATIONAL_EDITION_URI;
		}
		java.lang.String versionDate = getEffectiveDate(args);
		boolean includeDescriptions = !args.contains(org.snomed.otf.owltoolkit.Application.ARG_WITHOUT_ANNOTATIONS);
		java.lang.System.out.println();
		java.lang.System.out.println("Creating Ontology using the following options:");
		java.lang.System.out.println("  Snapshot archives: " + snapshotFiles);
		java.lang.System.out.println("  Delta archive: " + (deltaFile == null ? "-none-" : deltaFile));
		java.lang.System.out.println("  Ontology URI: " + ontologyUri);
		java.lang.System.out.println("  Ontology Version: " + versionDate);
		java.lang.System.out.println("  Include Description Annotations: " + includeDescriptions);
		java.lang.System.out.println();
		java.lang.String fileNameDate = (getParameterValue(org.snomed.otf.owltoolkit.Application.ARG_VERSION, args) != null) ? versionDate : org.snomed.otf.owltoolkit.Application.DATETIME_FORMAT.format(new java.util.Date());
		java.lang.String outputFilePath = ("ontology-" + fileNameDate) + ".owl";
		java.io.File ontologyOutputFile = new java.io.File(outputFilePath);
		if (deleteOntologyFileOnExit) {
			ontologyOutputFile.deleteOnExit();
		}
		try (final org.snomed.otf.owltoolkit.util.InputStreamSet snapshotStreams = new org.snomed.otf.owltoolkit.util.InputStreamSet(snapshotFiles);final org.snomed.otf.owltoolkit.util.OptionalFileInputStream deltaStream = new org.snomed.otf.owltoolkit.util.OptionalFileInputStream(deltaFile);final java.io.FileOutputStream outputStream = new java.io.FileOutputStream(ontologyOutputFile)) {
			new org.snomed.otf.owltoolkit.conversion.RF2ToOWLService().convertRF2ArchiveToOWL(ontologyUri, versionDate, includeDescriptions, snapshotStreams, deltaStream, outputStream);
		} catch (java.io.IOException e) {
			java.lang.System.err.println("Failed to close input or output stream.");
			e.printStackTrace();
			throw e;
		}
		java.lang.System.out.println("OWL Ontology file written to - " + outputFilePath);
	}

	private void statedRelationshipsToOwlReferenceSet(java.util.List<java.lang.String> args) throws java.io.IOException, org.semanticweb.owlapi.model.OWLOntologyCreationException, org.snomed.otf.owltoolkit.conversion.ConversionException {
		java.util.Set<java.io.File> snapshotFiles = getSnapshotFiles(args);
		java.io.File deltaFile = getDeltaFiles(args);
		java.lang.String effectiveDate = getEffectiveDate(args);
		java.lang.String outputFilePath = (org.snomed.otf.owltoolkit.Application.COMPLETE_OWL_AXIOM_DELTA + effectiveDate) + org.snomed.otf.owltoolkit.Application.ZIP;
		java.io.File completeOwlDeltaZip = new java.io.File(outputFilePath);
		org.snomed.otf.owltoolkit.conversion.StatedRelationshipToOwlRefsetService service = new org.snomed.otf.owltoolkit.conversion.StatedRelationshipToOwlRefsetService();
		java.util.Iterator<java.io.File> iterator = snapshotFiles.iterator();
		try (final java.io.FileInputStream snapshotStream = new java.io.FileInputStream(iterator.next());final org.snomed.otf.owltoolkit.util.OptionalFileInputStream deltaStream = new org.snomed.otf.owltoolkit.util.OptionalFileInputStream(deltaFile);final java.io.FileOutputStream archiveOutputStream = new java.io.FileOutputStream(completeOwlDeltaZip)) {
			if (snapshotFiles.size() == 1) {
				service.convertStatedRelationshipsToOwlRefsetAndInactiveRelationshipsArchive(snapshotStream, deltaStream, archiveOutputStream, effectiveDate);
			} else {
				try (final java.io.FileInputStream extensionSnapshotStream = new java.io.FileInputStream(iterator.next())) {
					java.io.File statFile = service.convertExtensionStatedRelationshipsToOwlRefsetAndInactiveRelationshipsArchive(new org.snomed.otf.owltoolkit.util.InputStreamSet(snapshotStream, extensionSnapshotStream), deltaStream, archiveOutputStream, effectiveDate);
					java.lang.System.out.println("Extension stated relationships are not converted into axioms are written to " + statFile.getAbsolutePath());
				}
			}
			java.lang.System.out.println("Delta archive successfully written to " + outputFilePath);
		} catch (org.snomed.otf.owltoolkit.conversion.ConversionException | org.semanticweb.owlapi.model.OWLOntologyCreationException e) {
			java.lang.System.out.println("Failed to convert stated relationships to OWL Axioms");
			e.printStackTrace();
			throw e;
		} catch (java.io.IOException e) {
			java.lang.System.err.println("Failed to read from or write to files.");
			e.printStackTrace();
			throw e;
		}
	}

	private void owlReferenceSetToStatedRelationships(java.util.List<java.lang.String> args) throws java.io.IOException, org.ihtsdo.otf.snomedboot.ReleaseImportException, org.snomed.otf.owltoolkit.conversion.ConversionException {
		java.util.Set<java.io.File> snapshotFiles = getSnapshotFiles(args);
		java.io.File deltaFile = getDeltaFiles(args);
		try (final org.snomed.otf.owltoolkit.util.InputStreamSet snapshotFilesSet = new org.snomed.otf.owltoolkit.util.InputStreamSet(snapshotFiles);final java.io.FileOutputStream statedRelationshipOutputStream = new java.io.FileOutputStream(new java.io.File(org.snomed.otf.owltoolkit.Application.STATED_RELATIONSHIP_SNAPSHOT))) {
			java.io.FileInputStream deltaInputStream = (deltaFile != null) ? new java.io.FileInputStream(deltaFile) : null;
			try {
				new org.snomed.otf.owltoolkit.conversion.OWLAxiomToStatedRelationshipService().convertAxiomsToStatedRelationships(snapshotFilesSet, deltaInputStream, statedRelationshipOutputStream);
			} catch (org.ihtsdo.otf.snomedboot.ReleaseImportException e) {
				e.printStackTrace();
				throw e;
			} finally {
				if (deltaInputStream != null) {
					deltaInputStream.close();
				}
			}
			java.lang.System.out.println("Created " + org.snomed.otf.owltoolkit.Application.STATED_RELATIONSHIP_SNAPSHOT);
		}
	}

	private void convertStatedRelationshipsToOwlReferenceSetAndReconcile(java.util.List<java.lang.String> args) throws java.io.IOException, org.snomed.otf.owltoolkit.conversion.ConversionException, org.semanticweb.owlapi.model.OWLOntologyCreationException {
		java.util.Collection<java.io.File> snapshotFiles = getSnapshotFileAsList(args);
		assertTrue("Expecting two snapshot RF2 file.", snapshotFiles.size() == 2);
		java.io.File deltaFile = getDeltaFiles(args);
		assertTrue("RF2 delta can't be null", deltaFile != null);
		java.lang.String effectiveDate = getEffectiveDate(args);
		java.lang.String outputFilePath = (org.snomed.otf.owltoolkit.Application.COMPLETE_OWL_AXIOM_DELTA + effectiveDate) + org.snomed.otf.owltoolkit.Application.ZIP;
		java.io.File completeOwlDeltaZip = new java.io.File(outputFilePath);
		org.snomed.otf.owltoolkit.conversion.StatedRelationshipToOwlRefsetService service = new org.snomed.otf.owltoolkit.conversion.StatedRelationshipToOwlRefsetService();
		java.util.Iterator<java.io.File> iterator = snapshotFiles.iterator();
		try (final java.io.FileInputStream authroingSnapshotStream = new java.io.FileInputStream(iterator.next());final java.io.FileInputStream midCylceDeltaStream = new java.io.FileInputStream(deltaFile);final java.io.FileInputStream publishedOwlSnapshotStream = new java.io.FileInputStream(iterator.next());final java.io.FileOutputStream archiveOutputStream = new java.io.FileOutputStream(completeOwlDeltaZip)) {
			service.convertStatedRelationshipsToOwlReRefsetAndReconcileWithPublishedArchive(authroingSnapshotStream, midCylceDeltaStream, publishedOwlSnapshotStream, archiveOutputStream, effectiveDate);
			java.lang.System.out.println("Delta archive successfully written to " + outputFilePath);
		} catch (org.snomed.otf.owltoolkit.conversion.ConversionException | org.semanticweb.owlapi.model.OWLOntologyCreationException e) {
			java.lang.System.out.println("Failed to convert stated relationships to OWL Axioms and reconcile");
			e.printStackTrace();
			throw e;
		} catch (java.io.IOException e) {
			java.lang.System.err.println("Failed to read from or write to files.");
			e.printStackTrace();
			throw e;
		}
	}

	private void printHelp() {
		java.lang.System.out.println(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("Usage:\n" + pad(org.snomed.otf.owltoolkit.Application.ARG_HELP)) + "Print this help message.\n") + "\n") + pad(org.snomed.otf.owltoolkit.Application.ARG_CLASSIFY)) + "Run classification process.\n") + pad("")) + "Results are written to an RF2 delta archive.\n") + "\n") + pad(org.snomed.otf.owltoolkit.Application.ARG_RF2_TO_OWL)) + "(Default mode) Convert RF2 to OWL Functional Syntax.\n") + pad("")) + "Results are written to an .owl file.\n") + "\n") + pad(org.snomed.otf.owltoolkit.Application.ARG_RF2_STATED_TO_COMPLETE_OWL)) + "Convert RF2 snapshot stated relationships to complete OWL Axiom reference set preview.\n") + pad("")) + "Stated relationships are converted to OWL Axiom reference set entries.\n") + pad("")) + "Existing stated relationships are marked as inactive.\n") + pad("")) + "Results are written to a zip file containing:\n") + pad("")) + " - OWL Axiom reference set delta of all axioms which were previously stated relationships\n") + pad("")) + " - Stated relationship delta with all relationships which were previously active marked as inactive.\n") + "\n") + pad(org.snomed.otf.owltoolkit.Application.ARG_RF2_STATED_TO_COMPLETE_OWL_RECONCILE)) + "Convert mid authoring cycle RF2 snapshot stated relationships to complete OWL Axiom reference set and reconcile with published version to genereate delta changes.\n") + pad("")) + "Two snapshot archives must be required. The first one should be the mid authoring cycle snapshot and the second one is the published complete owl snapshot archive.\n") + pad("")) + "Stated relationships are converted to OWL Axiom reference set entries.\n") + pad("")) + "These converted OWL Axioms are then reconciled with published version.\n") + pad("")) + "Results are written to a zip file containing:\n") + pad("")) + " - OWL Axiom reference set delta consisting of newly added or modified axioms converted from stated relationships.\n") + pad("")) + " - Published OWL Axiom reference set uuid will be used for an updated axiom.\n") + "\n") + pad(org.snomed.otf.owltoolkit.Application.ARG_RF2_SNAPSHOT_ARCHIVES + " <path>")) + "Comma separated paths of zip files containing RF2 Snapshot files to be loaded. \n") + pad("")) + "At least one Snapshot archive is required.\n") + "\n") + pad(org.snomed.otf.owltoolkit.Application.ARG_RF2_AUTHORING_DELTA_ARCHIVE + " <path>")) + "(Optional) Path to a zip file containing RF2 Delta files to be applied on top \n") + pad("")) + "of the Snapshots. This is helpful during an authoring cycle.\n") + "\n") + pad(org.snomed.otf.owltoolkit.Application.ARG_DEBUG)) + "Additional output for debugging.\n") + "\n") + "\n") + "Optional parameters for OWL conversion:\n") + pad(org.snomed.otf.owltoolkit.Application.ARG_URI + " <uri>")) + "(Optional) URI for the ontology identifier.\n") + pad("")) + "Defaults to the id within the header entry of the OWL Ontology reference set.\n") + pad("")) + "If no entry found defaults to ") + org.snomed.otf.owltoolkit.ontology.OntologyService.SNOMED_INTERNATIONAL_EDITION_URI) + ".\n") + "\n") + pad(org.snomed.otf.owltoolkit.Application.ARG_VERSION + " <version>")) + "(Optional) Date for the ontology version e.g. 20180731.\n") + pad("")) + "Defaults to today\'s date.\n") + "\n") + pad(org.snomed.otf.owltoolkit.Application.ARG_WITHOUT_ANNOTATIONS)) + "(Optional) Flag to omit Fully Specified Name annotations from the ontology \n") + pad("")) + "resulting in a smaller file size.\n") + "\n") + "");
	}

	private java.lang.String getEffectiveDate(java.util.List<java.lang.String> args) {
		java.lang.String versionDate = getParameterValue(org.snomed.otf.owltoolkit.Application.ARG_VERSION, args);
		if (versionDate == null) {
			versionDate = org.snomed.otf.owltoolkit.Application.DATE_FORMAT.format(new java.util.Date());
		}
		return versionDate;
	}

	private java.lang.String getParameterValue(java.lang.String paramName, java.util.List<java.lang.String> args) {
		if (args.indexOf(paramName) > (-1)) {
			return args.get(args.indexOf(paramName) + 1);
		}
		return null;
	}

	private java.lang.String getRequiredParameterValue(java.lang.String paramName, java.util.List<java.lang.String> args) {
		assertTrue("Expecting parameter " + paramName, args.contains(paramName));
		int valueIndex = args.indexOf(paramName) + 1;
		assertTrue("Expecting a value with parameter " + paramName, valueIndex < args.size());
		return args.get(valueIndex);
	}

	private java.io.File getDeltaFiles(java.util.List<java.lang.String> args) {
		java.util.List<java.io.File> deltaFiles = gatherFiles(getParameterValue(org.snomed.otf.owltoolkit.Application.ARG_RF2_AUTHORING_DELTA_ARCHIVE, args));
		if (deltaFiles.isEmpty()) {
			return null;
		}
		assertTrue("Expecting a single delta archive file, got " + deltaFiles.size(), deltaFiles.size() == 1);
		java.io.File delta = deltaFiles.iterator().next();
		assertTrue("Specified delta archive file cannot be read: " + delta, delta.canRead());
		return delta;
	}

	private java.util.List<java.io.File> getSnapshotFileAsList(java.util.List<java.lang.String> args) {
		return gatherFiles(getRequiredParameterValue(org.snomed.otf.owltoolkit.Application.ARG_RF2_SNAPSHOT_ARCHIVES, args));
	}

	private java.util.Set<java.io.File> getSnapshotFiles(java.util.List<java.lang.String> args) {
		return new java.util.HashSet<>(gatherFiles(getRequiredParameterValue(org.snomed.otf.owltoolkit.Application.ARG_RF2_SNAPSHOT_ARCHIVES, args)));
	}

	private java.util.List<java.io.File> gatherFiles(java.lang.String filePaths) {
		java.util.List<java.io.File> rf2ArchiveFiles = new java.util.ArrayList<>();
		if (filePaths != null) {
			java.lang.String[] rf2ArchivePathStrings = filePaths.split("\\,");
			for (java.lang.String rf2ArchivePath : rf2ArchivePathStrings) {
				java.io.File rf2ArchiveFile = new java.io.File(rf2ArchivePath);
				assertTrue(rf2ArchiveFile.getAbsolutePath() + " should be a file.", rf2ArchiveFile.isFile());
				rf2ArchiveFiles.add(rf2ArchiveFile);
			}
		}
		return rf2ArchiveFiles;
	}

	private void assertTrue(java.lang.String message, boolean bool) {
		if (!bool) {
			java.lang.System.out.println();
			java.lang.System.err.println(message);
			java.lang.System.out.println();
			printHelp();
			throw new java.lang.IllegalArgumentException();
		}
	}

	private java.lang.String pad(java.lang.String argHelp) {
		java.lang.StringBuilder argHelpBuilder = new java.lang.StringBuilder(" " + argHelp);
		while (argHelpBuilder.length() < 40) {
			argHelpBuilder.append(" ");
		} 
		return argHelpBuilder.toString();
	}

	protected void deleteOntologyFileOnExit() {
		this.deleteOntologyFileOnExit = true;
	}
}