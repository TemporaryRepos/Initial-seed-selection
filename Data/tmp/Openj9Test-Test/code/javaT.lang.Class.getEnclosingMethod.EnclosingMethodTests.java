public class EnclosingMethodTests {
	static java.lang.Class<?> anonymousClass;

	static {
		java.lang.Cloneable c = new java.lang.Cloneable() {};
		anonymousClass = c.getClass();
	}

	EnclosingMethodTests() {
	}

	@javaT.lang.Class.getEnclosingMethod.MethodDescriptor("java.lang.Class EnclosingMethodTests.getLocalClass(Object o)")
	java.lang.Class getLocalClass(java.lang.Object o) {
		class Local {}
		Local l = new Local();
		return l.getClass();
	}

	static int examine(java.lang.Class enclosedClass, java.lang.String methodSig) {
		java.lang.reflect.Method m = enclosedClass.getEnclosingMethod();
		if ((m == null) && (methodSig == null)) {
			return 0;
		}
		if ((m != null) && m.getAnnotation(javaT.lang.Class.getEnclosingMethod.MethodDescriptor.class).value().equals(methodSig)) {
			return 0;
		} else {
			java.lang.System.err.println((("\nUnexpected method value; expected:\t" + methodSig) + "\ngot:\t") + m);
			return 1;
		}
	}

	@javaT.lang.Class.getEnclosingMethod.MethodDescriptor("public static void EnclosingMethodTests.main(java.lang.String[])")
	public static void main(java.lang.String[] argv) {
		int failures = 0;
		class StaticLocal {}
		failures += javaT.lang.Class.getEnclosingMethod.EnclosingMethodTests.examine(StaticLocal.class, "public static void EnclosingMethodTests.main(java.lang.String[])");
		failures += javaT.lang.Class.getEnclosingMethod.EnclosingMethodTests.examine(new javaT.lang.Class.getEnclosingMethod.EnclosingMethodTests().getLocalClass(null), "java.lang.Class EnclosingMethodTests.getLocalClass(Object o)");
		failures += javaT.lang.Class.getEnclosingMethod.EnclosingMethodTests.examine(javaT.lang.Class.getEnclosingMethod.EnclosingMethodTests.class, null);
		failures += javaT.lang.Class.getEnclosingMethod.EnclosingMethodTests.examine(javaT.lang.Class.getEnclosingMethod.EnclosingMethodTests.anonymousClass, null);
		if (failures > 0) {
			throw new java.lang.RuntimeException("Test failed.");
		}
	}
}