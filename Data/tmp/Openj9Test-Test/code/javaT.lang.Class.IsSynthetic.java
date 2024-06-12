public class IsSynthetic {
	static class NestedClass {}

	static int test(java.lang.Class<?> clazz, boolean expected) {
		if (clazz.isSynthetic() == expected) {
			return 0;
		} else {
			java.lang.System.err.println((((("Unexpected synthetic status for " + clazz.getName()) + " expected: ") + expected) + " got: ") + (!expected));
			return 1;
		}
	}

	public static void main(java.lang.String[] argv) {
		int failures = 0;
		class LocalClass {}
		java.lang.Cloneable clone = new java.lang.Cloneable() {};
		failures += javaT.lang.Class.IsSynthetic.test(javaT.lang.Class.IsSynthetic.class, false);
		failures += javaT.lang.Class.IsSynthetic.test(java.lang.String.class, false);
		failures += javaT.lang.Class.IsSynthetic.test(LocalClass.class, false);
		failures += javaT.lang.Class.IsSynthetic.test(javaT.lang.Class.IsSynthetic.NestedClass.class, false);
		failures += javaT.lang.Class.IsSynthetic.test(clone.getClass(), false);
		for (java.lang.reflect.Constructor c : javaT.lang.Class.Tricky.class.getDeclaredConstructors()) {
			java.lang.Class<?>[] paramTypes = c.getParameterTypes();
			if (paramTypes.length > 0) {
				java.lang.System.out.println("Testing class that should be synthetic.");
				for (java.lang.Class paramType : paramTypes) {
					failures += javaT.lang.Class.IsSynthetic.test(paramType, true);
				}
			}
		}
		if (failures != 0) {
			throw new java.lang.RuntimeException(("Test failed with " + failures) + " failures.");
		}
	}
}