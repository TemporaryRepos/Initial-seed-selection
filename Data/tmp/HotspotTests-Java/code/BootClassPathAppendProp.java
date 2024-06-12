public class BootClassPathAppendProp {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (java.lang.System.getProperty("jdk.boot.class.path.append") != null) {
			throw new java.lang.RuntimeException("Test failed, jdk.boot.class.path.append has value: " + java.lang.System.getProperty("jdk.boot.class.path.append"));
		} else {
			java.lang.System.out.println("Test BootClassPathAppendProp passed");
		}
	}
}