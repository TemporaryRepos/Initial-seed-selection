public class IsDefaultTest {
	public static void main(java.lang.String... argv) throws java.lang.Exception {
		int failures = 0;
		int visitationCount = 0;
		java.util.List<java.lang.Class<?>> classList = new java.util.ArrayList<>();
		classList.add(javaT.lang.reflect.Method.TestType1.class);
		classList.add(javaT.lang.reflect.Method.TestType2.class);
		classList.add(javaT.lang.reflect.Method.TestType3.class);
		classList.add(javaT.lang.reflect.Method.TestType4.class);
		classList.add(javaT.lang.reflect.Method.TestType2.nestedTestType2.class);
		classList.add(javaT.lang.reflect.Method.TestType5.class);
		classList.add(javaT.lang.reflect.Method.TestType5.nestedTestType5.class);
		classList.add(javaT.lang.reflect.Method.TestType6.class);
		classList.add(javaT.lang.reflect.Method.TestType6.nestedTestType6.class);
		classList.add(javaT.lang.reflect.Method.TestType7.class);
		for (java.lang.Class<?> clazz : classList) {
			for (java.lang.reflect.Method method : clazz.getDeclaredMethods()) {
				javaT.lang.reflect.Method.ExpectedIsDefault expectedIsDefault = method.getAnnotation(javaT.lang.reflect.Method.ExpectedIsDefault.class);
				if (expectedIsDefault != null) {
					visitationCount++;
					boolean expected = expectedIsDefault.value();
					boolean actual = method.isDefault();
					if (actual != expected) {
						failures++;
						java.lang.System.err.printf("ERROR: On %s expected isDefault of \'\'%s\'\'; got \'\'%s\'\'.\n", method.toString(), expected, actual);
					}
				}
			}
		}
		if (visitationCount == 0) {
			java.lang.System.err.println("Test failed because no methods checked.");
			throw new java.lang.RuntimeException();
		}
		if (failures > 0) {
			java.lang.System.err.println("Test failed.");
			throw new java.lang.RuntimeException();
		}
	}
}