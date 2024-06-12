@java.lang.SuppressWarnings("unused")
public class W3CTests {
	private static final java.lang.String SCXML_IRP_BASE_URL = "http://www.w3.org/Voice/2013/scxml-irp/";

	private static final java.lang.String SCXML_IRP_MANIFEST_URI = "manifest.xml";

	private static final java.lang.String SCXML_IRP_ECMA_XSL_URI = "confEcma.xsl";

	private static final java.lang.String TESTS_SRC_DIR = "src/w3c/scxml-irp/";

	private static final java.lang.String TXML_TESTS_DIR = org.apache.commons.scxml2.w3c.W3CTests.TESTS_SRC_DIR + "txml/";

	private static final java.lang.String PACKAGE_PATH = "/" + org.apache.commons.scxml2.w3c.W3CTests.class.getPackage().getName().replace('.', '/');

	private static final java.lang.String TESTS_FILENAME = org.apache.commons.scxml2.w3c.W3CTests.PACKAGE_PATH + "/tests.xml";

	private static final java.lang.String SCXML_IRP_MINIMAL_XSL_FILENAME = org.apache.commons.scxml2.w3c.W3CTests.PACKAGE_PATH + "/confMinimal.xsl";

	private static final java.lang.String SCXML_IRP_JEXL_XSL_FILENAME = org.apache.commons.scxml2.w3c.W3CTests.PACKAGE_PATH + "/confJexl.xsl";

	private static final java.lang.String SCXML_IRP_GROOVY_XSL_FILENAME = org.apache.commons.scxml2.w3c.W3CTests.PACKAGE_PATH + "/confGroovy.xsl";

	protected enum Datamodel {

		MINIMAL("minimal", "minimal"),
		ECMA("ecma", "ecma   "),
		JEXL("jexl", "jexl   "),
		GROOVY("groovy", "groovy ");
		private final java.lang.String value;

		private final java.lang.String label;

		private final java.lang.String testDir;

		private Datamodel(final java.lang.String value, final java.lang.String label) {
			this.value = value;
			this.label = label;
			this.testDir = (org.apache.commons.scxml2.w3c.W3CTests.TESTS_SRC_DIR + value) + "/";
		}

		public java.lang.String value() {
			return value;
		}

		public java.lang.String label() {
			return label;
		}

		public java.lang.String testDir() {
			return testDir;
		}

		public static org.apache.commons.scxml2.w3c.W3CTests.Datamodel fromValue(final java.lang.String value) {
			for (org.apache.commons.scxml2.w3c.W3CTests.Datamodel datamodel : org.apache.commons.scxml2.w3c.W3CTests.Datamodel.values()) {
				if (datamodel.value().equals(value)) {
					return datamodel;
				}
			}
			return null;
		}
	}

	@javax.xml.bind.annotation.XmlRootElement(name = "tests")
	@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
	protected static class Tests {
		@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
		protected static class Test {
			@javax.xml.bind.annotation.XmlAttribute(required = true)
			private java.lang.String id;

			@javax.xml.bind.annotation.XmlAttribute(required = true)
			private java.lang.Boolean mandatory;

			@javax.xml.bind.annotation.XmlAttribute(required = true)
			private java.lang.Boolean manual;

			@javax.xml.bind.annotation.XmlAttribute
			private java.lang.String finalState;

			@javax.xml.bind.annotation.XmlAttribute
			private java.lang.Boolean implemented;

			@javax.xml.bind.annotation.XmlAttribute(name = "minimal")
			private java.lang.Boolean minimalStatus;

			@javax.xml.bind.annotation.XmlAttribute(name = "ecma")
			private java.lang.Boolean ecmaStatus;

			@javax.xml.bind.annotation.XmlAttribute(name = "jexl")
			private boolean jexlStatus;

			@javax.xml.bind.annotation.XmlAttribute(name = "groovy")
			private boolean groovyStatus;

			@javax.xml.bind.annotation.XmlValue
			private java.lang.String comment;

			public java.lang.String getId() {
				return id;
			}

			public boolean isMandatory() {
				return mandatory;
			}

			public boolean isManual() {
				return (manual == null) || manual;
			}

			public java.lang.String getFinalState() {
				return finalState;
			}

			public boolean isImplemented() {
				return (implemented == null) || implemented;
			}

			public java.lang.Boolean getStatus(final org.apache.commons.scxml2.w3c.W3CTests.Datamodel dm) {
				switch (dm) {
					case ECMA :
						return ecmaStatus;
					case JEXL :
						return jexlStatus;
					case GROOVY :
						return groovyStatus;
					default :
						return minimalStatus;
				}
			}

			public java.lang.String getComment() {
				return comment;
			}

			public java.lang.String toString() {
				return id;
			}
		}

		@javax.xml.bind.annotation.XmlElement(name = "test")
		private java.util.ArrayList<org.apache.commons.scxml2.w3c.W3CTests.Tests.Test> tests;

		private java.util.LinkedHashMap<java.lang.String, org.apache.commons.scxml2.w3c.W3CTests.Tests.Test> testsMap;

		public java.util.LinkedHashMap<java.lang.String, org.apache.commons.scxml2.w3c.W3CTests.Tests.Test> getTests() {
			if (testsMap == null) {
				testsMap = new java.util.LinkedHashMap<>();
				if (tests != null) {
					for (org.apache.commons.scxml2.w3c.W3CTests.Tests.Test t : tests) {
						testsMap.put(t.getId(), t);
					}
				}
			}
			return testsMap;
		}
	}

	protected org.apache.commons.scxml2.w3c.W3CTests.Tests loadTests() throws java.lang.Exception {
		final javax.xml.bind.JAXBContext jaxbContext = javax.xml.bind.JAXBContext.newInstance(org.apache.commons.scxml2.w3c.W3CTests.Tests.class);
		final javax.xml.bind.Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return ((org.apache.commons.scxml2.w3c.W3CTests.Tests) (jaxbUnmarshaller.unmarshal(getClass().getResource(org.apache.commons.scxml2.w3c.W3CTests.TESTS_FILENAME))));
	}

	@javax.xml.bind.annotation.XmlRootElement(name = "assertions")
	@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
	protected static class Assertions {
		@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
		protected static class Assertion {
			@javax.xml.bind.annotation.XmlAttribute
			private java.lang.String id;

			@javax.xml.bind.annotation.XmlAttribute(name = "specnum")
			private java.lang.String specnum;

			@javax.xml.bind.annotation.XmlAttribute(name = "specid")
			private java.lang.String specid;

			@javax.xml.bind.annotation.XmlElement(name = "test")
			private java.util.ArrayList<org.apache.commons.scxml2.w3c.W3CTests.Assertions.TestCase> testCases;

			public java.lang.String getId() {
				return id;
			}

			public java.lang.String getSpecNum() {
				return specnum;
			}

			public java.lang.String getSpecId() {
				return specid;
			}

			public java.util.List<org.apache.commons.scxml2.w3c.W3CTests.Assertions.TestCase> getTestCases() {
				return testCases != null ? testCases : java.util.Collections.emptyList();
			}

			public org.apache.commons.scxml2.w3c.W3CTests.Datamodel getDatamodel() {
				if ("#minimal-profile".equals(specid)) {
					return org.apache.commons.scxml2.w3c.W3CTests.Datamodel.MINIMAL;
				} else if ("#ecma-profile".equals(specid)) {
					return org.apache.commons.scxml2.w3c.W3CTests.Datamodel.ECMA;
				}
				return null;
			}

			public java.lang.String toString() {
				return id;
			}
		}

		@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
		protected static class TestCase {
			@javax.xml.bind.annotation.XmlAttribute
			private java.lang.String id;

			@javax.xml.bind.annotation.XmlAttribute
			private java.lang.String manual;

			@javax.xml.bind.annotation.XmlAttribute
			private java.lang.String conformance;

			@javax.xml.bind.annotation.XmlElement(name = "start")
			private java.util.ArrayList<org.apache.commons.scxml2.w3c.W3CTests.Assertions.Resource> scxmlResources;

			@javax.xml.bind.annotation.XmlElement(name = "dep")
			private java.util.ArrayList<org.apache.commons.scxml2.w3c.W3CTests.Assertions.Resource> depResources;

			private java.util.ArrayList<org.apache.commons.scxml2.w3c.W3CTests.Assertions.Resource> resources;

			public java.lang.String getId() {
				return id;
			}

			public boolean isManual() {
				return java.lang.Boolean.parseBoolean(manual);
			}

			public boolean isOptional() {
				return "mandatory".equals(conformance);
			}

			public java.util.List<org.apache.commons.scxml2.w3c.W3CTests.Assertions.Resource> getScxmlResources() {
				return scxmlResources != null ? scxmlResources : java.util.Collections.emptyList();
			}

			public java.util.List<org.apache.commons.scxml2.w3c.W3CTests.Assertions.Resource> getResources() {
				if (resources == null) {
					resources = new java.util.ArrayList<>();
					if (scxmlResources != null) {
						resources.addAll(scxmlResources);
					}
					if (depResources != null) {
						resources.addAll(depResources);
						depResources = null;
					}
				}
				return resources;
			}
		}

		@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
		protected static class Resource {
			@javax.xml.bind.annotation.XmlAttribute
			private java.lang.String uri;

			public java.lang.String getUri() {
				return uri;
			}

			public java.lang.String getName() {
				return uri.substring(uri.indexOf("/") + 1, uri.indexOf("."));
			}

			public java.lang.String getFilename() {
				return uri.substring(uri.indexOf("/") + 1);
			}
		}

		@javax.xml.bind.annotation.XmlElement(name = "assert")
		private java.util.ArrayList<org.apache.commons.scxml2.w3c.W3CTests.Assertions.Assertion> assertions;

		private java.util.LinkedHashMap<java.lang.String, org.apache.commons.scxml2.w3c.W3CTests.Assertions.Assertion> assertionsMap;

		public java.util.LinkedHashMap<java.lang.String, org.apache.commons.scxml2.w3c.W3CTests.Assertions.Assertion> getAssertions() {
			if (assertionsMap == null) {
				assertionsMap = new java.util.LinkedHashMap<>();
				if (assertions != null) {
					for (org.apache.commons.scxml2.w3c.W3CTests.Assertions.Assertion a : assertions) {
						assertionsMap.put(a.getId(), a);
					}
				}
			}
			return assertionsMap;
		}
	}

	protected org.apache.commons.scxml2.w3c.W3CTests.Assertions loadAssertions() throws java.lang.Exception {
		final javax.xml.bind.JAXBContext jaxbContext = javax.xml.bind.JAXBContext.newInstance(org.apache.commons.scxml2.w3c.W3CTests.Assertions.class);
		final javax.xml.bind.Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return ((org.apache.commons.scxml2.w3c.W3CTests.Assertions) (jaxbUnmarshaller.unmarshal(new java.io.File(org.apache.commons.scxml2.w3c.W3CTests.TESTS_SRC_DIR, org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_MANIFEST_URI))));
	}

	protected static class TestResults {
		final java.util.Map<org.apache.commons.scxml2.w3c.W3CTests.Datamodel, java.lang.Integer> passed = new java.util.HashMap<>();

		final java.util.Map<org.apache.commons.scxml2.w3c.W3CTests.Datamodel, java.lang.Integer> failed = new java.util.HashMap<>();

		final java.util.Map<org.apache.commons.scxml2.w3c.W3CTests.Datamodel, java.lang.Integer> skipped = new java.util.HashMap<>();

		final java.util.ArrayList<java.lang.String> changedStatusTests = new java.util.ArrayList<>();

		public int passed(final org.apache.commons.scxml2.w3c.W3CTests.Datamodel dm) {
			return passed.get(dm) != null ? passed.get(dm) : 0;
		}

		public int failed(final org.apache.commons.scxml2.w3c.W3CTests.Datamodel dm) {
			return failed.get(dm) != null ? failed.get(dm) : 0;
		}

		public int skipped(final org.apache.commons.scxml2.w3c.W3CTests.Datamodel dm) {
			return skipped.get(dm) != null ? skipped.get(dm) : 0;
		}
	}

	public static void main(final java.lang.String[] args) throws java.lang.Exception {
		if (args.length > 0) {
			if ("get".equals(args[0])) {
				new org.apache.commons.scxml2.w3c.W3CTests().getTests();
				return;
			} else if ("make".equals(args[0])) {
				new org.apache.commons.scxml2.w3c.W3CTests().makeTests();
				return;
			} else if ("run".equals(args[0])) {
				org.apache.commons.scxml2.w3c.W3CTests.Datamodel datamodel = org.apache.commons.scxml2.w3c.W3CTests.Datamodel.fromValue(java.lang.System.getProperty("datamodel"));
				java.lang.String testId = java.lang.System.getProperty("test");
				new org.apache.commons.scxml2.w3c.W3CTests().runTests(testId, datamodel);
				return;
			}
		}
		org.apache.commons.scxml2.w3c.W3CTests.usage();
	}

	protected static void usage() {
		java.lang.System.out.println("Usage: W3CTests <get|run>\n" + (((((("  get  - downloads the W3C IRP tests\n" + "  make - make previously downloaded  W3C IRP tests by transforming the .txml templates\n") + "  run  - runs test(s), optionally only for a specific datamodel (default: all)\n") + "         To run a single test, specify -Dtest=<testId>, otherwise all tests will be run.\n") + "         To only run test(s) for a specific datamodel, specify -Ddatamodel=<minimal|ecma|jexl|groovy>.\n") + "         By default only enabled tests (for the specified datamodel, or all) are run,\n") + "         specify -Denabled=false to only run disabled tests.\n"));
	}

	protected void getTests() throws java.lang.Exception {
		final java.io.File testsSrcDir = new java.io.File(org.apache.commons.scxml2.w3c.W3CTests.TESTS_SRC_DIR);
		if (!testsSrcDir.mkdirs()) {
			org.apache.commons.io.FileUtils.cleanDirectory(testsSrcDir);
		}
		new java.io.File(org.apache.commons.scxml2.w3c.W3CTests.TXML_TESTS_DIR).mkdirs();
		for (final org.apache.commons.scxml2.w3c.W3CTests.Datamodel dm : org.apache.commons.scxml2.w3c.W3CTests.Datamodel.values()) {
			new java.io.File(dm.testDir()).mkdirs();
		}
		java.lang.System.out.println(("Downloading IRP manifest: " + org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_BASE_URL) + org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_MANIFEST_URI);
		org.apache.commons.io.FileUtils.copyURLToFile(new java.net.URL(org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_BASE_URL + org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_MANIFEST_URI), new java.io.File(testsSrcDir, org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_MANIFEST_URI));
		java.lang.System.out.println(("Downloading ecma stylesheet: " + org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_BASE_URL) + org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_ECMA_XSL_URI);
		org.apache.commons.io.FileUtils.copyURLToFile(new java.net.URL(org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_BASE_URL + org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_ECMA_XSL_URI), new java.io.File(testsSrcDir, org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_ECMA_XSL_URI));
		org.apache.commons.scxml2.w3c.W3CTests.Assertions assertions = loadAssertions();
		for (org.apache.commons.scxml2.w3c.W3CTests.Assertions.Assertion entry : assertions.getAssertions().values()) {
			for (org.apache.commons.scxml2.w3c.W3CTests.Assertions.TestCase test : entry.getTestCases()) {
				for (org.apache.commons.scxml2.w3c.W3CTests.Assertions.Resource resource : test.getResources()) {
					java.lang.System.out.println(("Downloading IRP test file: " + org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_BASE_URL) + resource.getUri());
					org.apache.commons.io.FileUtils.copyURLToFile(new java.net.URL(org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_BASE_URL + resource.getUri()), new java.io.File(org.apache.commons.scxml2.w3c.W3CTests.TXML_TESTS_DIR + resource.getFilename()));
				}
			}
		}
	}

	protected void makeTests() throws java.lang.Exception {
		final java.io.File testsSrcDir = new java.io.File(org.apache.commons.scxml2.w3c.W3CTests.TESTS_SRC_DIR);
		javax.xml.transform.TransformerFactory factory = javax.xml.transform.TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl", null);
		factory.setFeature("http://saxon.sf.net/feature/suppressXsltNamespaceCheck", true);
		final java.util.Map<org.apache.commons.scxml2.w3c.W3CTests.Datamodel, javax.xml.transform.Transformer> transformers = new java.util.HashMap<>();
		transformers.put(org.apache.commons.scxml2.w3c.W3CTests.Datamodel.ECMA, factory.newTransformer(new javax.xml.transform.stream.StreamSource(new java.io.FileInputStream(new java.io.File(testsSrcDir, org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_ECMA_XSL_URI)))));
		transformers.put(org.apache.commons.scxml2.w3c.W3CTests.Datamodel.MINIMAL, factory.newTransformer(new javax.xml.transform.stream.StreamSource(getClass().getResourceAsStream(org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_MINIMAL_XSL_FILENAME))));
		transformers.put(org.apache.commons.scxml2.w3c.W3CTests.Datamodel.JEXL, factory.newTransformer(new javax.xml.transform.stream.StreamSource(getClass().getResourceAsStream(org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_JEXL_XSL_FILENAME))));
		transformers.put(org.apache.commons.scxml2.w3c.W3CTests.Datamodel.GROOVY, factory.newTransformer(new javax.xml.transform.stream.StreamSource(getClass().getResourceAsStream(org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_GROOVY_XSL_FILENAME))));
		org.apache.commons.scxml2.w3c.W3CTests.Assertions assertions = loadAssertions();
		for (org.apache.commons.scxml2.w3c.W3CTests.Assertions.Assertion entry : assertions.getAssertions().values()) {
			for (org.apache.commons.scxml2.w3c.W3CTests.Assertions.TestCase test : entry.getTestCases()) {
				for (org.apache.commons.scxml2.w3c.W3CTests.Assertions.Resource resource : test.getResources()) {
					processResource(entry.getSpecId(), resource, transformers);
				}
			}
		}
	}

	protected void processResource(final java.lang.String specid, final org.apache.commons.scxml2.w3c.W3CTests.Assertions.Resource resource, final java.util.Map<org.apache.commons.scxml2.w3c.W3CTests.Datamodel, javax.xml.transform.Transformer> transformers) throws java.lang.Exception {
		java.lang.System.out.println("processing IRP test file " + resource.getFilename());
		org.apache.commons.io.FileUtils.copyURLToFile(new java.net.URL(org.apache.commons.scxml2.w3c.W3CTests.SCXML_IRP_BASE_URL + resource.getUri()), new java.io.File(org.apache.commons.scxml2.w3c.W3CTests.TXML_TESTS_DIR + resource.getFilename()));
		switch (specid) {
			case "#minimal-profile" :
				transformResource(resource, transformers.get(org.apache.commons.scxml2.w3c.W3CTests.Datamodel.MINIMAL), org.apache.commons.scxml2.w3c.W3CTests.Datamodel.MINIMAL.testDir());
				break;
			case "#ecma-profile" :
				transformResource(resource, transformers.get(org.apache.commons.scxml2.w3c.W3CTests.Datamodel.ECMA), org.apache.commons.scxml2.w3c.W3CTests.Datamodel.ECMA.testDir());
				break;
			default :
				for (org.apache.commons.scxml2.w3c.W3CTests.Datamodel dm : transformers.keySet()) {
					if (dm != org.apache.commons.scxml2.w3c.W3CTests.Datamodel.MINIMAL) {
						transformResource(resource, transformers.get(dm), dm.testDir());
					}
				}
				break;
		}
	}

	protected void transformResource(final org.apache.commons.scxml2.w3c.W3CTests.Assertions.Resource resource, final javax.xml.transform.Transformer transformer, final java.lang.String targetDir) throws java.lang.Exception {
		if (resource.getFilename().endsWith(".txml")) {
			javax.xml.transform.stream.StreamSource txmlSource = new javax.xml.transform.stream.StreamSource(new java.io.FileInputStream(new java.io.File(org.apache.commons.scxml2.w3c.W3CTests.TXML_TESTS_DIR, resource.getFilename())));
			transformer.transform(txmlSource, new javax.xml.transform.stream.StreamResult(new java.io.FileOutputStream(new java.io.File(targetDir, resource.getName() + ".scxml"))));
		} else {
			org.apache.commons.io.FileUtils.copyFile(new java.io.File(org.apache.commons.scxml2.w3c.W3CTests.TXML_TESTS_DIR, resource.getFilename()), new java.io.File(targetDir, resource.getFilename()));
		}
	}

	protected void createCleanDirectory(final java.lang.String path) throws java.lang.Exception {
		final java.io.File dir = new java.io.File(path);
		if (!dir.mkdirs()) {
			org.apache.commons.io.FileUtils.cleanDirectory(dir);
		}
	}

	protected void runTests(final java.lang.String testId, final org.apache.commons.scxml2.w3c.W3CTests.Datamodel datamodel) throws java.lang.Exception {
		final org.apache.commons.scxml2.w3c.W3CTests.Assertions assertions = loadAssertions();
		final org.apache.commons.scxml2.w3c.W3CTests.Tests tests = loadTests();
		final org.apache.commons.scxml2.w3c.W3CTests.TestResults results = new org.apache.commons.scxml2.w3c.W3CTests.TestResults();
		final boolean enabled = java.lang.Boolean.parseBoolean(java.lang.System.getProperty("enabled", "true"));
		if (testId != null) {
			final org.apache.commons.scxml2.w3c.W3CTests.Assertions.Assertion assertion = assertions.getAssertions().get(testId);
			if (assertion != null) {
				runAssert(assertion, tests, datamodel, enabled, true, results);
			} else {
				throw new java.lang.IllegalArgumentException("Unknown test with id: " + testId);
			}
		} else {
			for (org.apache.commons.scxml2.w3c.W3CTests.Assertions.Assertion entry : assertions.getAssertions().values()) {
				runAssert(entry, tests, datamodel, enabled, false, results);
			}
		}
		java.lang.System.out.println((("\nTest results running " + (testId == null ? "all tests" : "test " + testId)) + (datamodel != null ? (" for the " + datamodel.value) + " datamodel" : "")) + (enabled ? " enabled" : " disabled"));
		for (final org.apache.commons.scxml2.w3c.W3CTests.Datamodel dm : org.apache.commons.scxml2.w3c.W3CTests.Datamodel.values()) {
			if ((datamodel == null) || (datamodel == dm)) {
				java.lang.System.out.println(((((((((("    " + dm.label()) + " datamodel: ") + results.passed(dm)) + " passed,  ") + results.failed(dm)) + " failed, ") + results.skipped(dm)) + " skipped (") + ((results.passed(dm) + results.failed(dm)) + results.skipped(dm))) + " total)");
			}
		}
		java.lang.System.out.print("\n");
		if ((testId == null) && (!results.changedStatusTests.isEmpty())) {
			java.lang.System.out.println(("  " + (enabled ? "failed" : "passed")) + " tests: ");
			for (java.lang.String filename : results.changedStatusTests) {
				java.lang.System.out.println("    " + filename);
			}
			java.lang.System.out.print("\n");
		}
	}

	protected void runAssert(final org.apache.commons.scxml2.w3c.W3CTests.Assertions.Assertion assertion, final org.apache.commons.scxml2.w3c.W3CTests.Tests tests, final org.apache.commons.scxml2.w3c.W3CTests.Datamodel datamodel, final boolean status, final boolean singleTest, org.apache.commons.scxml2.w3c.W3CTests.TestResults results) {
		final org.apache.commons.scxml2.w3c.W3CTests.Tests.Test test = tests.getTests().get(assertion.getId());
		if (test == null) {
			throw new java.lang.IllegalStateException("No test configuration found for W3C IRP test with id: " + assertion.getId());
		}
		if (test.isImplemented()) {
			for (org.apache.commons.scxml2.w3c.W3CTests.Assertions.TestCase testCase : assertion.getTestCases()) {
				for (final org.apache.commons.scxml2.w3c.W3CTests.Datamodel dm : org.apache.commons.scxml2.w3c.W3CTests.Datamodel.values()) {
					if (((assertion.getDatamodel() == null) && (dm != org.apache.commons.scxml2.w3c.W3CTests.Datamodel.MINIMAL)) || (dm == assertion.getDatamodel())) {
						boolean skipped = true;
						if ((datamodel == null) || (datamodel == dm)) {
							if ((singleTest || (test.getStatus(dm) == null)) || (status == test.getStatus(dm))) {
								for (org.apache.commons.scxml2.w3c.W3CTests.Assertions.Resource scxmlResource : testCase.getScxmlResources()) {
									java.io.File scxmlFile = new java.io.File(dm.testDir(), scxmlResource.getName() + ".scxml");
									skipped = false;
									boolean success = runTest(testCase, test, scxmlFile);
									if (!success) {
										results.failed.put(dm, results.failed(dm) + 1);
									} else {
										results.passed.put(dm, results.passed(dm) + 1);
									}
									if (success != status) {
										results.changedStatusTests.add((scxmlFile.getParentFile().getName() + "/") + scxmlFile.getName());
									}
								}
							}
						}
						if (skipped) {
							results.skipped.put(dm, results.skipped(dm) + 1);
						}
					}
				}
			}
		}
	}

	protected boolean runTest(final org.apache.commons.scxml2.w3c.W3CTests.Assertions.TestCase testCase, final org.apache.commons.scxml2.w3c.W3CTests.Tests.Test test, final java.io.File scxmlFile) {
		try {
			java.lang.System.out.println((("Executing test: " + scxmlFile.getParentFile().getName()) + "/") + scxmlFile.getName());
			final org.apache.commons.scxml2.env.Tracer trc = new org.apache.commons.scxml2.env.Tracer();
			final org.apache.commons.scxml2.PathResolver pathResolver = new org.apache.commons.scxml2.env.URLResolver(scxmlFile.getParentFile().toURI().toURL());
			final org.apache.commons.scxml2.io.SCXMLReader.Configuration configuration = new org.apache.commons.scxml2.io.SCXMLReader.Configuration(null, pathResolver);
			final org.apache.commons.scxml2.model.SCXML doc = org.apache.commons.scxml2.io.SCXMLReader.read(new java.io.FileReader(scxmlFile), configuration);
			if (doc == null) {
				java.lang.System.out.println(("                FAIL: the SCXML file " + scxmlFile.getCanonicalPath()) + " can not be parsed!");
				return false;
			}
			final org.apache.commons.scxml2.SCXMLExecutor exec = new org.apache.commons.scxml2.SCXMLExecutor(null, null, trc);
			exec.setSingleContext(true);
			exec.setStateMachine(doc);
			exec.addListener(doc, trc);
			exec.registerInvokerClass("scxml", org.apache.commons.scxml2.invoke.SimpleSCXMLInvoker.class);
			exec.registerInvokerClass("http://www.w3.org/TR/scxml/", org.apache.commons.scxml2.invoke.SimpleSCXMLInvoker.class);
			exec.run().join();
			org.apache.commons.scxml2.model.Final end = exec.getStatus().getFinalState();
			java.lang.System.out.println("                final state: " + end.getId());
			if (!testCase.isManual()) {
				return end.getId().equals("pass");
			} else if (test.getFinalState() != null) {
				return end.getId().equals(test.getFinalState());
			} else {
				return false;
			}
		} catch (java.lang.Exception e) {
			if ((test.isManual() && (e.getMessage() != null)) && e.getMessage().equals(test.getFinalState())) {
				java.lang.System.out.println("                PASS: " + e.getMessage());
				return true;
			}
			java.lang.System.out.println("                FAIL: " + e.getMessage());
			return false;
		}
	}
}