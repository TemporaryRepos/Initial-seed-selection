public class CheckDefaultGroupName {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("\n\nRegression test for, 4252236\n\n");
		java.rmi.activation.ActivationGroupDesc groupDesc = new java.rmi.activation.ActivationGroupDesc(null, null);
		java.lang.String className = groupDesc.getClassName();
		if (className != null) {
			javaT.rmi.testlibrary.TestLibrary.bomb(("ActivationGroupDesc had incorrect default" + " group implementation class name: ") + className);
		} else {
			java.lang.System.err.println((("test passed, had correct default group" + " implementation class name: ") + className) + "\n\n");
		}
	}
}