static class VMShouldNotInheritFileDescriptors {
	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		try {
			java.io.File logFile = new java.io.File(args[0]);
			long parentPid = java.lang.Long.parseLong(args[1]);
			TestInheritFD.fakeLeakyJVM(false);
			if (jdk.test.lib.Platform.isWindows()) {
				TestInheritFD.windows(logFile, parentPid);
			} else {
				java.util.Collection<java.lang.String> output = TestInheritFD.outputContainingFilenames();
				java.lang.System.out.println("(Third VM) Open file descriptors:\n" + output.stream().collect(java.util.stream.Collectors.joining("\n")));
				java.lang.System.out.println(TestInheritFD.findOpenLogFile(output) ? TestInheritFD.LEAKS_FD : TestInheritFD.RETAINS_FD);
			}
		} catch (java.lang.Exception e) {
			java.lang.System.out.println(e.toString());
		} finally {
			java.lang.System.out.println(TestInheritFD.EXIT);
		}
	}
}