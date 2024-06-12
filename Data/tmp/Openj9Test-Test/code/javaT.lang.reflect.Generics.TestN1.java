public class TestN1 {
	static java.lang.Class<javaT.lang.reflect.Generics.N1> cls = javaT.lang.reflect.Generics.N1.class;

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		javaT.lang.reflect.Generics.TestN1.testTypeParameters();
		javaT.lang.reflect.Generics.TestN1.testInner1();
		javaT.lang.reflect.Generics.TestN1.testInner2();
		javaT.lang.reflect.Generics.TestN1.testInner3();
	}

	static void testTypeParameters() {
		java.lang.System.out.println("testing type parameters");
		java.lang.reflect.TypeVariable[] tvs = javaT.lang.reflect.Generics.TestN1.cls.getTypeParameters();
		assert tvs.length == 2 : "N1 should have two type parameters";
	}

	static void testInner1() {
		java.lang.System.out.println("testing non-generic inner class");
		java.lang.Class in1 = javaT.lang.reflect.Generics.N1.Inner1.class;
		java.lang.reflect.TypeVariable[] tvs = in1.getTypeParameters();
		assert tvs.length == 0 : "N1.Inner2 should have no type parameters";
	}

	static void testInner2() throws java.lang.NoSuchFieldException {
		java.lang.System.out.println("testing generic inner class 1");
		java.lang.Class in1 = javaT.lang.reflect.Generics.N1.Inner2.class;
		java.lang.reflect.TypeVariable[] tvs = in1.getTypeParameters();
		assert tvs.length == 1 : "N1.Inner2 should have one type parameter";
		assert in1.getField("x").getGenericType() == boolean.class : "Type of Inner2.x should be boolean";
		assert in1.getField("b").getGenericType() == byte.class : "Type of Inner2.b should be byte";
		assert in1.getField("s").getGenericType() == short.class : "Type of Inner2.s should be short";
		assert in1.getField("c").getGenericType() == char.class : "Type of Inner2.x should be char";
		assert in1.getField("i").getGenericType() == int.class : "Type of Inner2.i should be int";
		assert in1.getField("l").getGenericType() == long.class : "Type of Inner2.l should be long";
		assert in1.getField("f").getGenericType() == float.class : "Type of Inner2.f should be float";
		assert in1.getField("d").getGenericType() == double.class : "Type of Inner2.d should be double";
		assert in1.getField("xa").getGenericType() == boolean[].class : "Type of Inner2.xa should be boolean[]";
		assert in1.getField("ba").getGenericType() == byte[].class : "Type of Inner2.ba should be byte[]";
		assert in1.getField("sa").getGenericType() == short[].class : "Type of Inner2.sa should be short[]";
		assert in1.getField("ca").getGenericType() == char[].class : "Type of Inner2.xa should be char[]";
		assert in1.getField("ia").getGenericType() == int[].class : "Type of Inner2.ia should be int[]";
		assert in1.getField("la").getGenericType() == long[].class : "Type of Inner2.la should be long[]";
		assert in1.getField("fa").getGenericType() == float[].class : "Type of Inner2.fa should be float[]";
		assert in1.getField("da").getGenericType() == double[].class : "Type of Inner2.da should be double[]";
	}

	static void testInner3() {
		java.lang.System.out.println("testing generic inner class 3");
		java.lang.Class in1 = javaT.lang.reflect.Generics.N1.Inner3.class;
		java.lang.reflect.TypeVariable[] tvs = in1.getTypeParameters();
		assert tvs.length == 3 : "N1.Inner2 should have three type parameters";
	}
}