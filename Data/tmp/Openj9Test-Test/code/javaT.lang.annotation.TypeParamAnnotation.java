public class TypeParamAnnotation {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.lang.annotation.TypeParamAnnotation.testOnClass();
		javaT.lang.annotation.TypeParamAnnotation.testOnMethod();
		javaT.lang.annotation.TypeParamAnnotation.testGetAnno();
		javaT.lang.annotation.TypeParamAnnotation.testGetAnnos();
	}

	private static void check(boolean b) {
		if (!b) {
			throw new java.lang.RuntimeException();
		}
	}

	private static void testOnClass() {
		java.lang.reflect.TypeVariable<?>[] ts = javaT.lang.annotation.TypeParam.class.getTypeParameters();
		javaT.lang.annotation.TypeParamAnnotation.check(ts.length == 3);
		java.lang.annotation.Annotation[] as;
		as = ts[0].getAnnotations();
		javaT.lang.annotation.TypeParamAnnotation.check(as.length == 2);
		javaT.lang.annotation.TypeParamAnnotation.check(((javaT.lang.annotation.ParamAnno) (as[0])).value().equals("t"));
		javaT.lang.annotation.TypeParamAnnotation.check(((javaT.lang.annotation.ParamAnno2) (as[1])).value() == 1);
		as = ts[1].getAnnotations();
		javaT.lang.annotation.TypeParamAnnotation.check(as.length == 0);
		as = ts[2].getAnnotations();
		javaT.lang.annotation.TypeParamAnnotation.check(as.length == 2);
		javaT.lang.annotation.TypeParamAnnotation.check(((javaT.lang.annotation.ParamAnno) (as[0])).value().equals("v"));
		javaT.lang.annotation.TypeParamAnnotation.check(((javaT.lang.annotation.ParamAnno2) (as[1])).value() == 2);
	}

	private static void testOnMethod() throws java.lang.Exception {
		java.lang.reflect.TypeVariable<?>[] ts = javaT.lang.annotation.TypeParam.class.getDeclaredMethod("foo").getTypeParameters();
		javaT.lang.annotation.TypeParamAnnotation.check(ts.length == 3);
		java.lang.annotation.Annotation[] as;
		as = ts[0].getAnnotations();
		javaT.lang.annotation.TypeParamAnnotation.check(as.length == 2);
		javaT.lang.annotation.TypeParamAnnotation.check(((javaT.lang.annotation.ParamAnno) (as[0])).value().equals("x"));
		javaT.lang.annotation.TypeParamAnnotation.check(((javaT.lang.annotation.ParamAnno2) (as[1])).value() == 3);
		as = ts[1].getAnnotations();
		javaT.lang.annotation.TypeParamAnnotation.check(as.length == 0);
		as = ts[2].getAnnotations();
		javaT.lang.annotation.TypeParamAnnotation.check(as.length == 2);
		javaT.lang.annotation.TypeParamAnnotation.check(((javaT.lang.annotation.ParamAnno) (as[0])).value().equals("z"));
		javaT.lang.annotation.TypeParamAnnotation.check(((javaT.lang.annotation.ParamAnno2) (as[1])).value() == 4);
	}

	private static void testGetAnno() {
		java.lang.reflect.TypeVariable<?>[] ts = javaT.lang.annotation.TypeParam.class.getTypeParameters();
		javaT.lang.annotation.ParamAnno a;
		a = ts[0].getAnnotation(javaT.lang.annotation.ParamAnno.class);
		javaT.lang.annotation.TypeParamAnnotation.check(a.value().equals("t"));
	}

	private static void testGetAnnos() throws java.lang.Exception {
		java.lang.reflect.TypeVariable<?>[] ts = javaT.lang.annotation.TypeParam.class.getDeclaredMethod("foo").getTypeParameters();
		javaT.lang.annotation.ParamAnno2[] as;
		as = ts[0].getAnnotationsByType(javaT.lang.annotation.ParamAnno2.class);
		javaT.lang.annotation.TypeParamAnnotation.check(as.length == 1);
		javaT.lang.annotation.TypeParamAnnotation.check(as[0].value() == 3);
	}
}