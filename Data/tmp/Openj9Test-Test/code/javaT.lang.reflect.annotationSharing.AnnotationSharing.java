public class AnnotationSharing {
	public static void main(java.lang.String... args) throws java.lang.Exception {
	}

	@org.testng.annotations.Test
	public void testMethodSharing() throws java.lang.Exception {
		java.lang.reflect.Method[] m1 = javaT.lang.reflect.annotationSharing.AnnotationSharing.class.getMethods();
		java.lang.reflect.Method[] m2 = javaT.lang.reflect.annotationSharing.AnnotationSharing.class.getMethods();
		javaT.lang.reflect.annotationSharing.AnnotationSharing.validateSharingSafelyObservable(m1, m2);
	}

	@org.testng.annotations.Test
	public void testDeclaredMethodSharing() throws java.lang.Exception {
		java.lang.reflect.Method[] m3 = javaT.lang.reflect.annotationSharing.AnnotationSharing.class.getDeclaredMethods();
		java.lang.reflect.Method[] m4 = javaT.lang.reflect.annotationSharing.AnnotationSharing.class.getDeclaredMethods();
		javaT.lang.reflect.annotationSharing.AnnotationSharing.validateSharingSafelyObservable(m3, m4);
	}

	@org.testng.annotations.Test
	public void testFieldSharing() throws java.lang.Exception {
		java.lang.reflect.Field[] f1 = javaT.lang.reflect.annotationSharing.AnnotationSharing.class.getFields();
		java.lang.reflect.Field[] f2 = javaT.lang.reflect.annotationSharing.AnnotationSharing.class.getFields();
		javaT.lang.reflect.annotationSharing.AnnotationSharing.validateSharingSafelyObservable(f1, f2);
	}

	@org.testng.annotations.Test
	public void testDeclaredFieldsSharing() throws java.lang.Exception {
		java.lang.reflect.Field[] f3 = javaT.lang.reflect.annotationSharing.AnnotationSharing.class.getDeclaredFields();
		java.lang.reflect.Field[] f4 = javaT.lang.reflect.annotationSharing.AnnotationSharing.class.getDeclaredFields();
		javaT.lang.reflect.annotationSharing.AnnotationSharing.validateSharingSafelyObservable(f3, f4);
	}

	@org.testng.annotations.Test
	public void testMethodSharingOccurs() throws java.lang.Exception {
		java.lang.reflect.Method mm1 = javaT.lang.reflect.annotationSharing.AnnotationSharing.class.getDeclaredMethod("m", ((java.lang.Class<?>[]) (null)));
		java.lang.reflect.Method mm2 = javaT.lang.reflect.annotationSharing.AnnotationSharing.class.getDeclaredMethod("m", ((java.lang.Class<?>[]) (null)));
		javaT.lang.reflect.annotationSharing.AnnotationSharing.validateAnnotationSharing(mm1, mm2);
	}

	@org.testng.annotations.Test
	public void testMethodSharingIsSafe() throws java.lang.Exception {
		java.lang.reflect.Method mm1 = javaT.lang.reflect.annotationSharing.AnnotationSharing.class.getDeclaredMethod("m", ((java.lang.Class<?>[]) (null)));
		java.lang.reflect.Method mm2 = javaT.lang.reflect.annotationSharing.AnnotationSharing.class.getDeclaredMethod("m", ((java.lang.Class<?>[]) (null)));
		javaT.lang.reflect.annotationSharing.AnnotationSharing.validateAnnotationSharingIsSafe(mm1, mm2);
		javaT.lang.reflect.annotationSharing.AnnotationSharing.validateArrayValues(mm1.getAnnotation(javaT.lang.reflect.annotationSharing.Baz.class), mm2.getAnnotation(javaT.lang.reflect.annotationSharing.Baz.class));
	}

	@org.testng.annotations.Test
	public void testFieldSharingOccurs() throws java.lang.Exception {
		java.lang.reflect.Field ff1 = javaT.lang.reflect.annotationSharing.AnnotationSharing.class.getDeclaredField("f");
		java.lang.reflect.Field ff2 = javaT.lang.reflect.annotationSharing.AnnotationSharing.class.getDeclaredField("f");
		javaT.lang.reflect.annotationSharing.AnnotationSharing.validateAnnotationSharing(ff1, ff2);
	}

	@org.testng.annotations.Test
	public void testFieldSharingIsSafe() throws java.lang.Exception {
		java.lang.reflect.Field ff1 = javaT.lang.reflect.annotationSharing.AnnotationSharing.class.getDeclaredField("f");
		java.lang.reflect.Field ff2 = javaT.lang.reflect.annotationSharing.AnnotationSharing.class.getDeclaredField("f");
		javaT.lang.reflect.annotationSharing.AnnotationSharing.validateAnnotationSharingIsSafe(ff1, ff2);
		javaT.lang.reflect.annotationSharing.AnnotationSharing.validateArrayValues(ff1.getAnnotation(javaT.lang.reflect.annotationSharing.Baz.class), ff2.getAnnotation(javaT.lang.reflect.annotationSharing.Baz.class));
	}

	private static void validateSharingSafelyObservable(java.lang.reflect.AccessibleObject[] m1, java.lang.reflect.AccessibleObject[] m2) throws java.lang.Exception {
		for (java.lang.reflect.AccessibleObject m : m1) {
			m.setAccessible(false);
		}
		for (java.lang.reflect.AccessibleObject m : m2) {
			m.setAccessible(true);
		}
		for (java.lang.reflect.AccessibleObject m : m1) {
			if (m.isAccessible()) {
				throw new java.lang.RuntimeException(m + " should not be accessible");
			}
		}
		for (java.lang.reflect.AccessibleObject m : m2) {
			if (!m.isAccessible()) {
				throw new java.lang.RuntimeException(m + " should be accessible");
			}
		}
		for (int i = 0; i < m1.length; i++) {
			if (!m1[i].equals(m2[i])) {
				throw new java.lang.RuntimeException(((m1[i] + " and ") + m2[i]) + " should be equal()");
			}
		}
		for (int i = 0; i < m1.length; i++) {
			m1[i] = null;
		}
		for (int i = 0; i < m2.length; i++) {
			if (m2[i] == null) {
				throw new java.lang.RuntimeException("Detected sharing of AccessibleObject arrays");
			}
		}
	}

	private static void validateAnnotationSharing(java.lang.reflect.AccessibleObject m1, java.lang.reflect.AccessibleObject m2) {
		javaT.lang.reflect.annotationSharing.Bar b1 = m1.getAnnotation(javaT.lang.reflect.annotationSharing.Bar.class);
		javaT.lang.reflect.annotationSharing.Bar b2 = m2.getAnnotation(javaT.lang.reflect.annotationSharing.Bar.class);
		if (b1 != b2) {
			throw new java.lang.RuntimeException(((b1 + " and ") + b2) + " should be ==");
		}
	}

	private static void validateAnnotationSharingIsSafe(java.lang.reflect.AccessibleObject m1, java.lang.reflect.AccessibleObject m2) throws java.lang.Exception {
		javaT.lang.reflect.annotationSharing.Bar b1 = m1.getAnnotation(javaT.lang.reflect.annotationSharing.Bar.class);
		javaT.lang.reflect.annotationSharing.Bar b2 = m2.getAnnotation(javaT.lang.reflect.annotationSharing.Bar.class);
		java.lang.reflect.Method mm1 = b1.annotationType().getMethod("value", ((java.lang.Class<?>[]) (null)));
		java.lang.reflect.Method mm2 = b2.annotationType().getMethod("value", ((java.lang.Class<?>[]) (null)));
		javaT.lang.reflect.annotationSharing.AnnotationSharing.inner(mm1, mm2);
		mm1 = b1.getClass().getMethod("value", ((java.lang.Class<?>[]) (null)));
		mm2 = b2.getClass().getMethod("value", ((java.lang.Class<?>[]) (null)));
		javaT.lang.reflect.annotationSharing.AnnotationSharing.inner(mm1, mm2);
	}

	private static void inner(java.lang.reflect.Method mm1, java.lang.reflect.Method mm2) throws java.lang.Exception {
		if (!mm1.equals(mm2)) {
			throw new java.lang.RuntimeException(((mm1 + " and ") + mm2) + " should be equal()");
		}
		mm1.setAccessible(false);
		mm2.setAccessible(true);
		if (mm1.isAccessible()) {
			throw new java.lang.RuntimeException(mm1 + " should not be accessible");
		}
		if (!mm2.isAccessible()) {
			throw new java.lang.RuntimeException(mm2 + " should be accessible");
		}
	}

	private static void validateArrayValues(javaT.lang.reflect.annotationSharing.Baz a, javaT.lang.reflect.annotationSharing.Baz b) {
		java.lang.String[] s1 = a.value();
		java.lang.String[] s2 = b.value();
		s1[0] = "22";
		if (!s2[0].equals("1")) {
			throw new java.lang.RuntimeException("Mutation of array elements should not be detectable");
		}
	}

	@javaT.lang.reflect.annotationSharing.Foo
	@javaT.lang.reflect.annotationSharing.Bar("val")
	@javaT.lang.reflect.annotationSharing.Baz({ "1", "2" })
	public void m() {
		return;
	}

	@javaT.lang.reflect.annotationSharing.Foo
	@javaT.lang.reflect.annotationSharing.Bar("someValue")
	@javaT.lang.reflect.annotationSharing.Baz({ "1", "22", "33" })
	public java.lang.Object f = new java.lang.Object();
}