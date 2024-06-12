public class DefaultMethodModeling {
	public static void main(java.lang.String... args) {
		int failures = 0;
		java.lang.Class<?>[] classes = new java.lang.Class<?>[]{ javaT.lang.reflect.Method.defaultMethodModeling.SuperC.class, javaT.lang.reflect.Method.defaultMethodModeling.SuperCchild.class, javaT.lang.reflect.Method.defaultMethodModeling.SuperI.class, javaT.lang.reflect.Method.defaultMethodModeling.SuperIchild.class, javaT.lang.reflect.Method.defaultMethodModeling.SuperIwithDefault.class, javaT.lang.reflect.Method.defaultMethodModeling.SuperIwithDefaultChild.class, javaT.lang.reflect.Method.defaultMethodModeling.Base.class, javaT.lang.reflect.Method.defaultMethodModeling.Combo1.class, javaT.lang.reflect.Method.defaultMethodModeling.Combo2.class, javaT.lang.reflect.Method.defaultMethodModeling.SonSuperIwithDefault.class, javaT.lang.reflect.Method.defaultMethodModeling.DaughterSuperIwithDefault.class, javaT.lang.reflect.Method.defaultMethodModeling.GrandchildSuperIwithDefault.class, javaT.lang.reflect.Method.defaultMethodModeling.D.class, javaT.lang.reflect.Method.defaultMethodModeling.B.class, javaT.lang.reflect.Method.defaultMethodModeling.C.class, javaT.lang.reflect.Method.defaultMethodModeling.B1.class, javaT.lang.reflect.Method.defaultMethodModeling.D1.class };
		for (java.lang.Class<?> clazz : classes) {
			java.lang.System.err.println(clazz.toString());
			for (java.lang.reflect.Method m : clazz.getMethods()) {
				if (m.getDeclaringClass() != java.lang.Object.class) {
					failures += javaT.lang.reflect.Method.defaultMethodModeling.DefaultMethodModeling.testMethod(m);
				}
			}
		}
		if (failures > 0) {
			throw new java.lang.RuntimeException();
		}
	}

	private static int testMethod(java.lang.reflect.Method m) {
		javaT.lang.reflect.Method.defaultMethodModeling.ExpectedModel em = java.util.Objects.requireNonNull(m.getAnnotation(javaT.lang.reflect.Method.defaultMethodModeling.ExpectedModel.class));
		boolean failed = false;
		if (m.getModifiers() != em.modifiers()) {
			failed = true;
			java.lang.System.err.printf("Unexpected modifiers %d; expected %d%n", m.getModifiers(), em.modifiers());
		}
		if (m.isDefault() != em.isDefault()) {
			failed = true;
			java.lang.System.err.printf("Unexpected isDefualt %b; expected b%n", m.isDefault(), em.isDefault());
		}
		if (!m.getDeclaringClass().equals(em.declaringClass())) {
			failed = true;
			java.lang.System.err.printf("Unexpected isDefualt %s; expected %s%n", m.getDeclaringClass().toString(), em.declaringClass().toString());
		}
		return !failed ? 0 : 1;
	}
}