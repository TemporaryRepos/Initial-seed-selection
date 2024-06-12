public class TestPlainArrayNotGeneric {
	public java.lang.String[] m1(java.util.List<java.lang.String> p1) {
		return null;
	}

	public java.util.List<java.lang.String> m2(java.lang.String[] p1) {
		return null;
	}

	public void m3(java.util.List<java.lang.String> p1, java.lang.String[] p2) {
	}

	public void m4(java.util.List<java.lang.String[]> p1) {
	}

	public TestPlainArrayNotGeneric(java.util.List<java.lang.String[]> p1) {
	}

	public TestPlainArrayNotGeneric(java.util.List<java.lang.String> p1, java.lang.String[] p2) {
	}

	public <T extends java.util.List<java.lang.String[]>> T m5(T p1) {
		return null;
	}

	public <T extends java.lang.Object> T[] m6(T[] p1, java.util.List<T[]> p2) {
		return null;
	}

	public java.util.List<? extends java.lang.Object[]> m6(java.util.List<? extends java.lang.Object[]> p1) {
		return null;
	}

	public <T extends java.util.List<? extends java.lang.Object[]>> T m7(T[] p1) {
		return null;
	}

	public java.util.List<? super java.lang.Object[]> m8(java.util.List<? super java.lang.Object[]> p1) {
		return null;
	}

	public <T extends java.util.List<? super java.lang.Object[]>> T[] m9(T[] p1) {
		return null;
	}

	public static interface XMap extends java.util.Map<java.util.List<java.lang.String[]>, java.lang.String[]> {}

	public static interface YMap<K extends java.util.List<java.lang.String[]>, V> extends java.util.Map<K[], V[]> {}

	private static java.lang.String lastFailure;

	private static int failureCount;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.checkClass(javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.class);
		if (javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.failureCount == 0) {
			java.lang.System.out.println("TEST PASSED");
		} else {
			throw new java.lang.Exception("TEST FAILED: Last failure: " + javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.lastFailure);
		}
	}

	private static void checkClass(java.lang.Class<?> c) throws java.lang.Exception {
		java.lang.reflect.Method[] methods = c.getMethods();
		for (java.lang.reflect.Method m : methods) {
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.check(m.getGenericReturnType(), "return type of method " + m);
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.check(m.getGenericParameterTypes(), "parameter", "method " + m);
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.check(m.getTypeParameters(), "type parameter", "method " + m);
		}
		java.lang.reflect.Constructor[] constructors = c.getConstructors();
		for (java.lang.reflect.Constructor constr : constructors) {
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.check(constr.getGenericParameterTypes(), "parameter", "constructor " + constr);
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.check(constr.getTypeParameters(), "type parameter", "constructor " + constr);
		}
		java.lang.Class<?>[] inners = c.getDeclaredClasses();
		for (java.lang.Class inner : inners) {
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.checkClass(inner);
		}
	}

	private static void check(java.lang.reflect.Type[] types, java.lang.String elementKind, java.lang.String what) {
		for (int i = 0; i < types.length; i++) {
			java.lang.reflect.Type t = types[i];
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.check(t, (((elementKind + " ") + (i + 1)) + " of ") + what);
		}
	}

	private static final java.util.Set<java.lang.reflect.Type> checking = new java.util.HashSet<>();

	private static void check(java.lang.reflect.Type t, java.lang.String what) {
		if ((t == null) || (!javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.checking.add(t))) {
			return;
		}
		try {
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.check2(t, what);
		} finally {
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.checking.remove(t);
		}
	}

	private static void check2(java.lang.reflect.Type t, java.lang.String what) {
		if (t instanceof java.lang.reflect.ParameterizedType) {
			java.lang.reflect.ParameterizedType pt = ((java.lang.reflect.ParameterizedType) (t));
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.check(pt.getActualTypeArguments(), "type argument", what);
		} else if (t instanceof java.lang.reflect.TypeVariable) {
			java.lang.reflect.TypeVariable<?> tv = ((java.lang.reflect.TypeVariable<?>) (t));
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.check(tv.getBounds(), "bound", what);
			java.lang.reflect.GenericDeclaration gd = tv.getGenericDeclaration();
			if (gd instanceof java.lang.reflect.Type) {
				javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.check(((java.lang.reflect.Type) (gd)), "declaration containing " + what);
			}
		} else if (t instanceof java.lang.reflect.WildcardType) {
			java.lang.reflect.WildcardType wt = ((java.lang.reflect.WildcardType) (t));
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.check(wt.getLowerBounds(), "lower bound", "wildcard type in " + what);
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.check(wt.getUpperBounds(), "upper bound", "wildcard type in " + what);
		} else if (t instanceof java.lang.Class<?>) {
			java.lang.Class<?> c = ((java.lang.Class<?>) (t));
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.check(c.getGenericInterfaces(), "superinterface", c.toString());
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.check(c.getGenericSuperclass(), "superclass of " + c);
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.check(c.getTypeParameters(), "type parameter", c.toString());
		} else if (t instanceof java.lang.reflect.GenericArrayType) {
			java.lang.reflect.GenericArrayType gat = ((java.lang.reflect.GenericArrayType) (t));
			java.lang.reflect.Type comp = gat.getGenericComponentType();
			if (comp instanceof java.lang.Class) {
				javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.fail(((("Type " + t) + " uses GenericArrayType when plain ") + "array would do, in ") + what);
			} else {
				javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.check(comp, "component type of " + what);
			}
		} else {
			javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.fail(((("TEST BUG: mutant Type " + t) + " (a ") + t.getClass().getName()) + ")");
		}
	}

	private static void fail(java.lang.String why) {
		java.lang.System.out.println("FAIL: " + why);
		javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.lastFailure = why;
		javaT.lang.reflect.Generics.TestPlainArrayNotGeneric.failureCount++;
	}
}