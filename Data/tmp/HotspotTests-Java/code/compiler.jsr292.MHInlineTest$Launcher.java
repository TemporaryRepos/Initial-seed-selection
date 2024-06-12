static class Launcher {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		for (int i = 0; i < 20000; i++) {
			compiler.jsr292.MHInlineTest.testPublicMH();
		}
		for (int i = 0; i < 20000; i++) {
			compiler.jsr292.MHInlineTest.testProtectedMH();
		}
		for (int i = 0; i < 20000; i++) {
			compiler.jsr292.MHInlineTest.testPackageMH();
		}
		for (int i = 0; i < 20000; i++) {
			compiler.jsr292.MHInlineTest.testPackageFinalMH();
		}
		for (int i = 0; i < 20000; i++) {
			compiler.jsr292.MHInlineTest.testPackageStaticMH();
		}
		for (int i = 0; i < 20000; i++) {
			compiler.jsr292.MHInlineTest.testPrivateMH();
		}
		for (int i = 0; i < 20000; i++) {
			compiler.jsr292.MHInlineTest.testPrivateStaticMH();
		}
	}
}