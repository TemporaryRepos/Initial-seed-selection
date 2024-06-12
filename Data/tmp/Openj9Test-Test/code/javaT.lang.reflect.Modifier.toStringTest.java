public class toStringTest {
	static void testString(int test, java.lang.String expected) {
		if (!java.lang.reflect.Modifier.toString(test).equals(expected)) {
			throw new java.lang.RuntimeException(test + " yields incorrect toString result");
		}
	}

	public static void main(java.lang.String[] argv) {
		int allMods = ((((((((((java.lang.reflect.Modifier.PUBLIC | java.lang.reflect.Modifier.PROTECTED) | java.lang.reflect.Modifier.PRIVATE) | java.lang.reflect.Modifier.ABSTRACT) | java.lang.reflect.Modifier.STATIC) | java.lang.reflect.Modifier.FINAL) | java.lang.reflect.Modifier.TRANSIENT) | java.lang.reflect.Modifier.VOLATILE) | java.lang.reflect.Modifier.SYNCHRONIZED) | java.lang.reflect.Modifier.NATIVE) | java.lang.reflect.Modifier.STRICT) | java.lang.reflect.Modifier.INTERFACE;
		java.lang.String allModsString = "public protected private abstract static " + "final transient volatile synchronized native strictfp interface";
		javaT.lang.reflect.Modifier.toStringTest.testString(0, "");
		javaT.lang.reflect.Modifier.toStringTest.testString(allMods, allModsString);
		javaT.lang.reflect.Modifier.toStringTest.testString(~0, allModsString);
	}
}