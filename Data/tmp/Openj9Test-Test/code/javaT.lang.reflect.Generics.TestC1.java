public class TestC1 {
	static java.lang.Class<javaT.lang.reflect.Generics.C1> cls = javaT.lang.reflect.Generics.C1.class;

	static {
		javaT.lang.reflect.Generics.TestC1.class.getClassLoader().setDefaultAssertionStatus(true);
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		javaT.lang.reflect.Generics.TestC1.testSuperclass();
		javaT.lang.reflect.Generics.TestC1.testSuperInterfaces();
		javaT.lang.reflect.Generics.TestC1.testTypeParameters();
		javaT.lang.reflect.Generics.TestC1.testMethods();
		javaT.lang.reflect.Generics.TestC1.testConstructor();
		javaT.lang.reflect.Generics.TestC1.testFields();
	}

	static void testSuperclass() {
		java.lang.System.out.println("testing superclass");
		java.lang.reflect.Type sc = javaT.lang.reflect.Generics.TestC1.cls.getGenericSuperclass();
		assert sc == java.lang.Object.class : "The generic superclass of C1 should be Object";
	}

	static void testSuperInterfaces() {
		java.lang.System.out.println("testing superinterfaces");
		java.lang.reflect.Type[] sis = javaT.lang.reflect.Generics.TestC1.cls.getGenericInterfaces();
		assert sis.length == 0 : "C1 should have no generic superinterfaces";
	}

	static void testTypeParameters() {
		java.lang.System.out.println("testing type parameters");
		java.lang.reflect.TypeVariable[] tvs = javaT.lang.reflect.Generics.TestC1.cls.getTypeParameters();
		assert tvs.length == 1 : "C1 should have one type parameter";
		java.lang.reflect.TypeVariable tv = tvs[0];
		java.lang.reflect.Type[] bs = tv.getBounds();
		assert bs.length == 1 : "T should have one bound";
		assert bs[0] == java.lang.Object.class : "The default bound of a type variable should be Object";
	}

	static void testMethods() throws java.lang.NoSuchMethodException {
		java.lang.System.out.println("testing methods");
		java.lang.Class[] params1 = new java.lang.Class[3];
		params1[0] = java.lang.Object.class;
		params1[1] = javaT.lang.reflect.Generics.TestC1.cls;
		params1[2] = javaT.lang.reflect.Generics.TestC1.cls;
		java.lang.Class[] params3 = new java.lang.Class[1];
		params3[0] = java.lang.Object.class;
		java.lang.reflect.Method mc1t = javaT.lang.reflect.Generics.TestC1.cls.getMethod("mc1t", params1);
		java.lang.reflect.Method mc1 = javaT.lang.reflect.Generics.TestC1.cls.getMethod("mc1", new java.lang.Class[0]);
		java.lang.reflect.Method mt = javaT.lang.reflect.Generics.TestC1.cls.getMethod("mt", params3);
		java.lang.reflect.Type rt_mc1t = mc1t.getGenericReturnType();
		java.lang.reflect.Type rt_mc1 = mc1.getGenericReturnType();
		java.lang.reflect.Type rt_mt = mt.getGenericReturnType();
		java.lang.reflect.Type[] pt_mc1t = mc1t.getGenericParameterTypes();
		assert pt_mc1t.length == 3 : "C1.mc1t has three parameters";
		java.lang.reflect.Type p1_mc1t = pt_mc1t[0];
		assert p1_mc1t != null;
		assert p1_mc1t instanceof java.lang.reflect.TypeVariable : "Generic type of the 1st parameter of mc1t(T) is a type variable";
		java.lang.reflect.TypeVariable tv = ((java.lang.reflect.TypeVariable) (p1_mc1t));
		assert tv.getName().equals("T") : "Name of 1st type parameter of mc1t is T, not " + tv.getName();
		java.lang.reflect.Type[] bs = tv.getBounds();
		assert bs.length == 1 : "T should have one bound (mc1t)";
		assert bs[0] == java.lang.Object.class : "The bound of T should be Object (mc1t)";
		java.lang.reflect.Type p2_mc1t = pt_mc1t[1];
		assert p2_mc1t instanceof java.lang.reflect.ParameterizedType : "The type of parameter 2 of mc1t is a parameterized type";
		java.lang.reflect.ParameterizedType pt = ((java.lang.reflect.ParameterizedType) (p2_mc1t));
		assert pt.getRawType() == javaT.lang.reflect.Generics.TestC1.cls : "Type of parameter 2 of mc1t is instantiation of C1";
		assert pt.getOwnerType() == null : "Type of parameter 2 of mc1t is has null owner";
		java.lang.reflect.Type[] tas = pt.getActualTypeArguments();
		assert tas.length == 1 : "The type of parameter 2 of mc1t has one type argument";
		java.lang.reflect.Type ta = tas[0];
		assert ta instanceof java.lang.reflect.TypeVariable : "The actual type arg of C1<T> is a type variable (mc1t)";
		tv = ((java.lang.reflect.TypeVariable) (ta));
		assert tv.getName().equals("T") : "mc1t: Name of the type arg of C1<T> is T, not " + tv.getName();
		bs = tv.getBounds();
		assert bs.length == 1 : "mc1t: The type argument of C1<T>  should have one bound";
		assert bs[0] == java.lang.Object.class : "mc1t: The bound of the type arg of C1<T> should be Object";
		java.lang.reflect.Type p3_mc1t = pt_mc1t[2];
		assert p3_mc1t == javaT.lang.reflect.Generics.TestC1.cls : "Type of parameter 3 of mc1t is C1";
		java.lang.reflect.Type[] pt_mc1 = mc1.getGenericParameterTypes();
		assert pt_mc1.length == 0 : "C1.mc1 has zero parameters";
		java.lang.reflect.Type[] pt_mt = mt.getGenericParameterTypes();
		assert pt_mt.length == 1 : "C1.mt has one parameter";
		java.lang.reflect.Type p_mt = pt_mt[0];
		assert p_mt instanceof java.lang.reflect.TypeVariable : "The generic type of the parameter of mt(T) is a type variable";
		tv = ((java.lang.reflect.TypeVariable) (p_mt));
		assert tv.getName().equals("T") : "The name of the type parameter of mt is T, not " + tv.getName();
		bs = tv.getBounds();
		assert bs.length == 1 : "T should have one bound";
		assert bs[0] == java.lang.Object.class : "The bound of T should be Object";
		java.lang.reflect.Type[] et_mc1t = mc1t.getGenericExceptionTypes();
		assert et_mc1t.length == 0 : "Method C1.mc1t should have no generic exception types";
		java.lang.reflect.Type[] et_mc1 = mc1.getGenericExceptionTypes();
		assert et_mc1.length == 0 : "Method C1.mc1 should have no generic exception types";
		java.lang.reflect.Type[] et_mt = mt.getGenericExceptionTypes();
		assert et_mt.length == 0 : "Method C1.mt should have no generic exception types";
		java.lang.reflect.TypeVariable[] tv_mc1t = mc1t.getTypeParameters();
		assert tv_mc1t.length == 0 : "Method C1.mc1t should have no type parameters";
		java.lang.reflect.TypeVariable[] tv_mc1 = mc1.getTypeParameters();
		assert tv_mc1.length == 0 : "Method C1.mc1 should have no type parameters";
		java.lang.reflect.TypeVariable[] tv_mt = mt.getTypeParameters();
		assert tv_mt.length == 0 : "Method C1.mt should have no type parameters";
	}

	static void testFields() throws java.lang.NoSuchFieldException {
		java.lang.System.out.println("testing fields");
		java.lang.reflect.Field ft = javaT.lang.reflect.Generics.TestC1.cls.getField("ft");
		java.lang.reflect.Field fc1t = javaT.lang.reflect.Generics.TestC1.cls.getField("fc1t");
		java.lang.reflect.Field fc1 = javaT.lang.reflect.Generics.TestC1.cls.getField("fc1");
		java.lang.reflect.Type gt_ft = ft.getGenericType();
		assert gt_ft instanceof java.lang.reflect.TypeVariable : "The generic type of C1.ft is a type variable";
		java.lang.reflect.TypeVariable tv = ((java.lang.reflect.TypeVariable) (gt_ft));
		assert tv.getName().equals("T") : "The name of the type of ft is T, not " + tv.getName();
		java.lang.reflect.Type[] bs = tv.getBounds();
		assert bs.length == 1 : "The type of ft should have one bound";
		assert bs[0] == java.lang.Object.class : "The bound of the type of ft should be Object";
		java.lang.reflect.Type gt_fc1t = fc1t.getGenericType();
		assert gt_fc1t instanceof java.lang.reflect.ParameterizedType : "The generic type of C1.fc1t is a parameterized type";
		java.lang.reflect.ParameterizedType pt = ((java.lang.reflect.ParameterizedType) (gt_fc1t));
		assert pt.getRawType() == javaT.lang.reflect.Generics.TestC1.cls : "Type of C1.fc1t is instantiation of C1";
		assert pt.getOwnerType() == null : "Type of C1.fc1t is has null owner";
		java.lang.reflect.Type[] tas = pt.getActualTypeArguments();
		assert tas.length == 1 : "The type of fc1t has one type argument";
		java.lang.reflect.Type ta = tas[0];
		assert ta instanceof java.lang.reflect.TypeVariable : "The actual type arg of C1<T> is a type variable";
		tv = ((java.lang.reflect.TypeVariable) (ta));
		assert tv.getName().equals("T") : "The name of the type arg of C1<T> is T, not " + tv.getName();
		bs = tv.getBounds();
		assert bs.length == 1 : "The type argument of C1<T>  should have one bound";
		assert bs[0] == java.lang.Object.class : "The bound of the type arg of C1<T> should be Object";
		java.lang.reflect.Type gt_fc1 = fc1.getGenericType();
		assert gt_fc1 == javaT.lang.reflect.Generics.TestC1.cls : " Type of C1.fc1 should be C1";
	}

	static void testConstructor() throws java.lang.NoSuchMethodException {
		java.lang.System.out.println("testing constructors");
		java.lang.Class[] params = new java.lang.Class[1];
		params[0] = java.lang.Object.class;
		java.lang.reflect.Constructor<javaT.lang.reflect.Generics.C1> con = javaT.lang.reflect.Generics.TestC1.cls.getDeclaredConstructor(params);
		java.lang.reflect.Type[] pt_con = con.getGenericParameterTypes();
		assert pt_con.length == 1 : "Constructor C1(T) should have one generic parameter type";
		java.lang.reflect.Type pt = pt_con[0];
		assert pt instanceof java.lang.reflect.TypeVariable : "The generic type of the parameter of C1(T) is a type variable";
		java.lang.reflect.TypeVariable tv = ((java.lang.reflect.TypeVariable) (pt));
		assert tv.getName().equals("T") : "The name of the type parameter of C is T, not " + tv.getName();
		java.lang.reflect.Type[] bs = tv.getBounds();
		assert bs.length == 1 : "T should have one bound";
		assert bs[0] == java.lang.Object.class : "The bound of T should be Object";
		java.lang.reflect.Type[] et_con = con.getGenericExceptionTypes();
		assert et_con.length == 0 : "Constructor C1(T) should have no generic exception types";
		java.lang.reflect.TypeVariable[] tv_con = con.getTypeParameters();
		assert tv_con.length == 0 : "Constructor C1(T) should have no type parameters";
	}
}