public class Example1 {
	static class CustomException extends java.lang.RuntimeException {
		public CustomException(java.lang.String message) {
			super(message);
		}
	}

	private static void helloIntelliJ() {
		java.lang.System.out.println("我来自北方，请不要为难我");
		java.lang.System.out.println("因为我只是一只小猫咪");
		java.lang.Runtime runtime = java.lang.Runtime.getRuntime();
	}

	public static void main(java.lang.String[] args) {
		javatips.debug.Example1.helloIntelliJ();
		java.lang.System.out.println("No 啪不了木.");
	}
}