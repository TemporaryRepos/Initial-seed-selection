public class TestLargePagesFlags {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (!jdk.test.lib.Platform.isLinux()) {
			java.lang.System.out.println("Skipping. TestLargePagesFlags has only been implemented for Linux.");
			return;
		}
		TestLargePagesFlags.testUseTransparentHugePages();
		TestLargePagesFlags.testUseHugeTLBFS();
		TestLargePagesFlags.testUseSHM();
		TestLargePagesFlags.testCombinations();
	}

	public static void testUseTransparentHugePages() throws java.lang.Exception {
		if (!TestLargePagesFlags.canUse(TestLargePagesFlags.UseTransparentHugePages(true))) {
			java.lang.System.out.println("Skipping testUseTransparentHugePages");
			return;
		}
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(false), TestLargePagesFlags.UseTransparentHugePages(true)).expect(TestLargePagesFlags.UseLargePages(false), TestLargePagesFlags.UseTransparentHugePages(false), TestLargePagesFlags.UseHugeTLBFS(false), TestLargePagesFlags.UseSHM(false));
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseTransparentHugePages(true)).expect(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseTransparentHugePages(true), TestLargePagesFlags.UseHugeTLBFS(false), TestLargePagesFlags.UseSHM(false));
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseTransparentHugePages(true)).expect(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseTransparentHugePages(true), TestLargePagesFlags.UseHugeTLBFS(false), TestLargePagesFlags.UseSHM(false));
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseTransparentHugePages(false)).expect(TestLargePagesFlags.UseLargePages(false), TestLargePagesFlags.UseTransparentHugePages(false), TestLargePagesFlags.UseHugeTLBFS(false), TestLargePagesFlags.UseSHM(false));
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(true)).expect(TestLargePagesFlags.UseTransparentHugePages(false));
	}

	public static void testUseHugeTLBFS() throws java.lang.Exception {
		if (!TestLargePagesFlags.canUse(TestLargePagesFlags.UseHugeTLBFS(true))) {
			java.lang.System.out.println("Skipping testUseHugeTLBFS");
			return;
		}
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(false), TestLargePagesFlags.UseHugeTLBFS(true)).expect(TestLargePagesFlags.UseLargePages(false), TestLargePagesFlags.UseTransparentHugePages(false), TestLargePagesFlags.UseHugeTLBFS(false), TestLargePagesFlags.UseSHM(false));
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseHugeTLBFS(true)).expect(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseTransparentHugePages(false), TestLargePagesFlags.UseHugeTLBFS(true), TestLargePagesFlags.UseSHM(false));
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseHugeTLBFS(true)).expect(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseTransparentHugePages(false), TestLargePagesFlags.UseHugeTLBFS(true), TestLargePagesFlags.UseSHM(false));
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseHugeTLBFS(false)).expect(TestLargePagesFlags.UseLargePages(false), TestLargePagesFlags.UseTransparentHugePages(false), TestLargePagesFlags.UseHugeTLBFS(false), TestLargePagesFlags.UseSHM(false));
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(true)).expect(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseTransparentHugePages(false), TestLargePagesFlags.UseHugeTLBFS(true), TestLargePagesFlags.UseSHM(false));
	}

	public static void testUseSHM() throws java.lang.Exception {
		if (!TestLargePagesFlags.canUse(TestLargePagesFlags.UseSHM(true))) {
			java.lang.System.out.println("Skipping testUseSHM");
			return;
		}
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(false), TestLargePagesFlags.UseSHM(true)).expect(TestLargePagesFlags.UseLargePages(false), TestLargePagesFlags.UseTransparentHugePages(false), TestLargePagesFlags.UseHugeTLBFS(false), TestLargePagesFlags.UseSHM(false));
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseSHM(true)).expect(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseTransparentHugePages(false), TestLargePagesFlags.UseHugeTLBFS(false), TestLargePagesFlags.UseSHM(true));
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseSHM(true)).expect(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseTransparentHugePages(false), TestLargePagesFlags.UseHugeTLBFS(false), TestLargePagesFlags.UseSHM(true));
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseSHM(false)).expect(TestLargePagesFlags.UseLargePages(false), TestLargePagesFlags.UseTransparentHugePages(false), TestLargePagesFlags.UseHugeTLBFS(false), TestLargePagesFlags.UseSHM(false));
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(true)).expect(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseTransparentHugePages(false));
	}

	public static void testCombinations() throws java.lang.Exception {
		if ((!TestLargePagesFlags.canUse(TestLargePagesFlags.UseSHM(true))) || (!TestLargePagesFlags.canUse(TestLargePagesFlags.UseHugeTLBFS(true)))) {
			java.lang.System.out.println("Skipping testUseHugeTLBFSAndUseSHMCombination");
			return;
		}
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseHugeTLBFS(true), TestLargePagesFlags.UseSHM(true)).expect(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseTransparentHugePages(false), TestLargePagesFlags.UseHugeTLBFS(true), TestLargePagesFlags.UseSHM(false));
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseHugeTLBFS(false), TestLargePagesFlags.UseSHM(true)).expect(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseTransparentHugePages(false), TestLargePagesFlags.UseHugeTLBFS(false), TestLargePagesFlags.UseSHM(true));
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseHugeTLBFS(true), TestLargePagesFlags.UseSHM(false)).expect(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseTransparentHugePages(false), TestLargePagesFlags.UseHugeTLBFS(true), TestLargePagesFlags.UseSHM(false));
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseHugeTLBFS(false), TestLargePagesFlags.UseSHM(false)).expect(TestLargePagesFlags.UseLargePages(false), TestLargePagesFlags.UseTransparentHugePages(false), TestLargePagesFlags.UseHugeTLBFS(false), TestLargePagesFlags.UseSHM(false));
		if (!TestLargePagesFlags.canUse(TestLargePagesFlags.UseTransparentHugePages(true))) {
			return;
		}
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseTransparentHugePages(true), TestLargePagesFlags.UseHugeTLBFS(true), TestLargePagesFlags.UseSHM(true)).expect(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseTransparentHugePages(true), TestLargePagesFlags.UseHugeTLBFS(false), TestLargePagesFlags.UseSHM(false));
		new TestLargePagesFlags.FlagTester().use(TestLargePagesFlags.UseTransparentHugePages(true), TestLargePagesFlags.UseHugeTLBFS(true), TestLargePagesFlags.UseSHM(true)).expect(TestLargePagesFlags.UseLargePages(true), TestLargePagesFlags.UseTransparentHugePages(true), TestLargePagesFlags.UseHugeTLBFS(false), TestLargePagesFlags.UseSHM(false));
	}

	private static class FlagTester {
		private TestLargePagesFlags.Flag[] useFlags;

		public TestLargePagesFlags.FlagTester use(TestLargePagesFlags.Flag... useFlags) {
			this.useFlags = useFlags;
			return this;
		}

		public void expect(TestLargePagesFlags.Flag... expectedFlags) throws java.lang.Exception {
			if (useFlags == null) {
				throw new java.lang.IllegalStateException("Must run use() before expect()");
			}
			jdk.test.lib.process.OutputAnalyzer output = TestLargePagesFlags.executeNewJVM(useFlags);
			for (TestLargePagesFlags.Flag flag : expectedFlags) {
				java.lang.System.out.println("Looking for: " + flag.flagString());
				java.lang.String strValue = output.firstMatch((".* " + flag.name()) + " .* :?= (\\S+).*", 1);
				if (strValue == null) {
					throw new java.lang.RuntimeException(("Flag " + flag.name()) + " couldn't be found");
				}
				if (!flag.value().equals(strValue)) {
					throw new java.lang.RuntimeException((((("Wrong value for: " + flag.name()) + " expected: ") + flag.value()) + " got: ") + strValue);
				}
			}
			output.shouldHaveExitValue(0);
		}
	}

	private static jdk.test.lib.process.OutputAnalyzer executeNewJVM(TestLargePagesFlags.Flag... flags) throws java.lang.Exception {
		java.util.ArrayList<java.lang.String> args = new java.util.ArrayList<>();
		for (TestLargePagesFlags.Flag flag : flags) {
			args.add(flag.flagString());
		}
		args.add("-XX:+PrintFlagsFinal");
		args.add("-version");
		java.lang.ProcessBuilder pb = jdk.test.lib.process.ProcessTools.createJavaProcessBuilder(args.toArray(new java.lang.String[args.size()]));
		jdk.test.lib.process.OutputAnalyzer output = new jdk.test.lib.process.OutputAnalyzer(pb.start());
		return output;
	}

	private static boolean canUse(TestLargePagesFlags.Flag flag) {
		try {
			new TestLargePagesFlags.FlagTester().use(flag).expect(flag);
		} catch (java.lang.Exception e) {
			return false;
		}
		return true;
	}

	private static TestLargePagesFlags.Flag UseLargePages(boolean value) {
		return new TestLargePagesFlags.BooleanFlag("UseLargePages", value);
	}

	private static TestLargePagesFlags.Flag UseTransparentHugePages(boolean value) {
		return new TestLargePagesFlags.BooleanFlag("UseTransparentHugePages", value);
	}

	private static TestLargePagesFlags.Flag UseHugeTLBFS(boolean value) {
		return new TestLargePagesFlags.BooleanFlag("UseHugeTLBFS", value);
	}

	private static TestLargePagesFlags.Flag UseSHM(boolean value) {
		return new TestLargePagesFlags.BooleanFlag("UseSHM", value);
	}

	private static class BooleanFlag implements TestLargePagesFlags.Flag {
		private java.lang.String name;

		private boolean value;

		BooleanFlag(java.lang.String name, boolean value) {
			this.name = name;
			this.value = value;
		}

		public java.lang.String flagString() {
			return ("-XX:" + (value ? "+" : "-")) + name;
		}

		public java.lang.String name() {
			return name;
		}

		public java.lang.String value() {
			return java.lang.Boolean.toString(value);
		}
	}

	private static interface Flag {
		public abstract java.lang.String flagString();

		public abstract java.lang.String name();

		public abstract java.lang.String value();
	}
}