public class TestParameterizedType {
	public <T> T genericMethod0() {
		return null;
	}

	public <T> java.util.Set<T> genericMethod1() {
		return null;
	}

	public <T> java.util.Set<T> genericMethod2() {
		return null;
	}

	public <S> java.util.List<S> genericMethod3() {
		return null;
	}

	public <X, Y> java.util.Map<X, Y> genericMethod4() {
		return null;
	}

	public <T> T[] genericMethod5() {
		return null;
	}

	public <T> T[] genericMethod6() {
		return null;
	}

	public java.util.Set<? extends java.lang.Cloneable> genericMethod7() {
		return null;
	}

	public java.util.Set<? super java.lang.Number> genericMethod8() {
		return null;
	}

	public java.util.Set<?> genericMethod9() {
		return null;
	}

	static java.util.List<java.lang.reflect.Type> createTypes() throws java.lang.Exception {
		java.util.List<java.lang.reflect.Type> typeList = new java.util.ArrayList<java.lang.reflect.Type>(3);
		java.lang.String[] methodNames = new java.lang.String[]{ "genericMethod0", "genericMethod1", "genericMethod2", "genericMethod3", "genericMethod4", "genericMethod5", "genericMethod6", "genericMethod7", "genericMethod8", "genericMethod9" };
		for (java.lang.String s : methodNames) {
			java.lang.reflect.Type t = javaT.lang.reflect.Generics.TestParameterizedType.class.getDeclaredMethod(s).getGenericReturnType();
			typeList.add(t);
		}
		return typeList;
	}

	static boolean testReflexes(java.util.List<java.lang.reflect.Type> typeList) {
		for (java.lang.reflect.Type t : typeList) {
			if (!t.equals(t)) {
				java.lang.System.err.printf("Bad reflexes for%s %s%n", t, t.getClass());
				return true;
			}
		}
		return false;
	}

	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		boolean failed = false;
		java.util.List<java.lang.reflect.Type> take1 = javaT.lang.reflect.Generics.TestParameterizedType.createTypes();
		java.util.List<java.lang.reflect.Type> take2 = javaT.lang.reflect.Generics.TestParameterizedType.createTypes();
		failed = failed | javaT.lang.reflect.Generics.TestParameterizedType.testReflexes(take1);
		failed = failed | javaT.lang.reflect.Generics.TestParameterizedType.testReflexes(take2);
		for (int i = 0; i < take1.size(); i++) {
			java.lang.reflect.Type type1 = take1.get(i);
			for (int j = 0; j < take2.size(); j++) {
				java.lang.reflect.Type type2 = take2.get(j);
				if (i == j) {
					if (!type1.equals(type2)) {
						failed = true;
						java.lang.System.err.printf("Unexpected inequality: [%d, %d] %n\t%s%n\t%s%n", i, j, type1, type2);
					}
				} else if (type1.equals(type2)) {
					failed = true;
					java.lang.System.err.printf("Unexpected equality: [%d, %d] %n\t%s%n\t%s%n", i, j, type1, type2);
				}
			}
		}
		if (failed) {
			throw new java.lang.RuntimeException("Bad equality on ParameterizedTypes");
		}
	}
}