public class EnclosingConstructorTests {
	static java.lang.Class<?> anonymousClass;

	static java.lang.Class<?> localClass;

	static java.lang.Class<?> anotherLocalClass;

	static {
		java.lang.Cloneable c = new java.lang.Cloneable() {};
		anonymousClass = c.getClass();
	}

	@javaT.lang.Class.getEnclosingConstructor.ConstructorDescriptor("EnclosingConstructorTests()")
	EnclosingConstructorTests() {
		class Local {}
		Local l = new Local();
		javaT.lang.Class.getEnclosingConstructor.EnclosingConstructorTests.localClass = l.getClass();
	}

	@javaT.lang.Class.getEnclosingConstructor.ConstructorDescriptor("private EnclosingConstructorTests(int)")
	private EnclosingConstructorTests(int i) {
		class Local {}
		Local l = new Local();
		javaT.lang.Class.getEnclosingConstructor.EnclosingConstructorTests.anotherLocalClass = l.getClass();
	}

	static int examine(java.lang.Class<?> enclosedClass, java.lang.String constructorSig) {
		java.lang.reflect.Constructor<?> c = enclosedClass.getEnclosingConstructor();
		if ((c == null) && (constructorSig == null)) {
			return 0;
		}
		if ((c != null) && c.getAnnotation(javaT.lang.Class.getEnclosingConstructor.ConstructorDescriptor.class).value().equals(constructorSig)) {
			return 0;
		} else {
			java.lang.System.err.println((("\nUnexpected constructor value; expected:\t" + constructorSig) + "\ngot:\t") + c);
			return 1;
		}
	}

	public static void main(java.lang.String[] argv) {
		int failures = 0;
		class StaticLocal {}
		javaT.lang.Class.getEnclosingConstructor.EnclosingConstructorTests ect = new javaT.lang.Class.getEnclosingConstructor.EnclosingConstructorTests();
		ect = new javaT.lang.Class.getEnclosingConstructor.EnclosingConstructorTests(5);
		failures += javaT.lang.Class.getEnclosingConstructor.EnclosingConstructorTests.examine(StaticLocal.class, null);
		failures += javaT.lang.Class.getEnclosingConstructor.EnclosingConstructorTests.examine(javaT.lang.Class.getEnclosingConstructor.EnclosingConstructorTests.localClass, "EnclosingConstructorTests()");
		failures += javaT.lang.Class.getEnclosingConstructor.EnclosingConstructorTests.examine(javaT.lang.Class.getEnclosingConstructor.EnclosingConstructorTests.anotherLocalClass, "private EnclosingConstructorTests(int)");
		failures += javaT.lang.Class.getEnclosingConstructor.EnclosingConstructorTests.examine(javaT.lang.Class.getEnclosingConstructor.EnclosingConstructorTests.anonymousClass, null);
		if (failures > 0) {
			throw new java.lang.RuntimeException("Test failed.");
		}
	}
}