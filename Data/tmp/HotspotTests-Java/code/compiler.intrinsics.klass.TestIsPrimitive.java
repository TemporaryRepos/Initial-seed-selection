public class TestIsPrimitive {
	static final int ITERS = java.lang.Integer.getInteger("iters", 1);

	public static void main(java.lang.String... args) throws java.lang.Exception {
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.InlineConstants::testBoolean);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.InlineConstants::testByte);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.InlineConstants::testShort);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.InlineConstants::testChar);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.InlineConstants::testInt);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.InlineConstants::testFloat);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.InlineConstants::testLong);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.InlineConstants::testDouble);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(false, compiler.intrinsics.klass.TestIsPrimitive.InlineConstants::testObject);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(false, compiler.intrinsics.klass.TestIsPrimitive.InlineConstants::testArray);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.StaticConstants::testBoolean);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.StaticConstants::testByte);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.StaticConstants::testShort);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.StaticConstants::testChar);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.StaticConstants::testInt);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.StaticConstants::testFloat);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.StaticConstants::testLong);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.StaticConstants::testDouble);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(false, compiler.intrinsics.klass.TestIsPrimitive.StaticConstants::testObject);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(false, compiler.intrinsics.klass.TestIsPrimitive.StaticConstants::testArray);
		compiler.intrinsics.klass.TestIsPrimitive.testNPE(compiler.intrinsics.klass.TestIsPrimitive.StaticConstants::testNull);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.NoConstants::testBoolean);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.NoConstants::testByte);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.NoConstants::testShort);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.NoConstants::testChar);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.NoConstants::testInt);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.NoConstants::testFloat);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.NoConstants::testLong);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(true, compiler.intrinsics.klass.TestIsPrimitive.NoConstants::testDouble);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(false, compiler.intrinsics.klass.TestIsPrimitive.NoConstants::testObject);
		compiler.intrinsics.klass.TestIsPrimitive.testOK(false, compiler.intrinsics.klass.TestIsPrimitive.NoConstants::testArray);
		compiler.intrinsics.klass.TestIsPrimitive.testNPE(compiler.intrinsics.klass.TestIsPrimitive.NoConstants::testNull);
	}

	public static void testOK(boolean expected, java.util.concurrent.Callable<java.lang.Object> test) throws java.lang.Exception {
		for (int c = 0; c < compiler.intrinsics.klass.TestIsPrimitive.ITERS; c++) {
			java.lang.Object res = test.call();
			if (!res.equals(expected)) {
				throw new java.lang.IllegalStateException((("Wrong result: expected = " + expected) + ", but got ") + res);
			}
		}
	}

	static volatile java.lang.Object sink;

	public static void testNPE(java.util.concurrent.Callable<java.lang.Object> test) throws java.lang.Exception {
		for (int c = 0; c < compiler.intrinsics.klass.TestIsPrimitive.ITERS; c++) {
			try {
				compiler.intrinsics.klass.TestIsPrimitive.sink = test.call();
				throw new java.lang.IllegalStateException("Expected NPE");
			} catch (java.lang.NullPointerException iae) {
			}
		}
	}

	static volatile java.lang.Class<?> classBoolean = boolean.class;

	static volatile java.lang.Class<?> classByte = byte.class;

	static volatile java.lang.Class<?> classShort = short.class;

	static volatile java.lang.Class<?> classChar = char.class;

	static volatile java.lang.Class<?> classInt = int.class;

	static volatile java.lang.Class<?> classFloat = float.class;

	static volatile java.lang.Class<?> classLong = long.class;

	static volatile java.lang.Class<?> classDouble = double.class;

	static volatile java.lang.Class<?> classObject = java.lang.Object.class;

	static volatile java.lang.Class<?> classArray = java.lang.Object[].class;

	static volatile java.lang.Class<?> classNull = null;

	static final java.lang.Class<?> staticClassBoolean = boolean.class;

	static final java.lang.Class<?> staticClassByte = byte.class;

	static final java.lang.Class<?> staticClassShort = short.class;

	static final java.lang.Class<?> staticClassChar = char.class;

	static final java.lang.Class<?> staticClassInt = int.class;

	static final java.lang.Class<?> staticClassFloat = float.class;

	static final java.lang.Class<?> staticClassLong = long.class;

	static final java.lang.Class<?> staticClassDouble = double.class;

	static final java.lang.Class<?> staticClassObject = java.lang.Object.class;

	static final java.lang.Class<?> staticClassArray = java.lang.Object[].class;

	static final java.lang.Class<?> staticClassNull = null;

	static class InlineConstants {
		static boolean testBoolean() {
			return boolean.class.isPrimitive();
		}

		static boolean testByte() {
			return byte.class.isPrimitive();
		}

		static boolean testShort() {
			return short.class.isPrimitive();
		}

		static boolean testChar() {
			return char.class.isPrimitive();
		}

		static boolean testInt() {
			return int.class.isPrimitive();
		}

		static boolean testFloat() {
			return float.class.isPrimitive();
		}

		static boolean testLong() {
			return long.class.isPrimitive();
		}

		static boolean testDouble() {
			return double.class.isPrimitive();
		}

		static boolean testObject() {
			return java.lang.Object.class.isPrimitive();
		}

		static boolean testArray() {
			return java.lang.Object[].class.isPrimitive();
		}
	}

	static class StaticConstants {
		static boolean testBoolean() {
			return compiler.intrinsics.klass.TestIsPrimitive.staticClassBoolean.isPrimitive();
		}

		static boolean testByte() {
			return compiler.intrinsics.klass.TestIsPrimitive.staticClassByte.isPrimitive();
		}

		static boolean testShort() {
			return compiler.intrinsics.klass.TestIsPrimitive.staticClassShort.isPrimitive();
		}

		static boolean testChar() {
			return compiler.intrinsics.klass.TestIsPrimitive.staticClassChar.isPrimitive();
		}

		static boolean testInt() {
			return compiler.intrinsics.klass.TestIsPrimitive.staticClassInt.isPrimitive();
		}

		static boolean testFloat() {
			return compiler.intrinsics.klass.TestIsPrimitive.staticClassFloat.isPrimitive();
		}

		static boolean testLong() {
			return compiler.intrinsics.klass.TestIsPrimitive.staticClassLong.isPrimitive();
		}

		static boolean testDouble() {
			return compiler.intrinsics.klass.TestIsPrimitive.staticClassDouble.isPrimitive();
		}

		static boolean testObject() {
			return compiler.intrinsics.klass.TestIsPrimitive.staticClassObject.isPrimitive();
		}

		static boolean testArray() {
			return compiler.intrinsics.klass.TestIsPrimitive.staticClassArray.isPrimitive();
		}

		static boolean testNull() {
			return compiler.intrinsics.klass.TestIsPrimitive.staticClassNull.isPrimitive();
		}
	}

	static class NoConstants {
		static boolean testBoolean() {
			return compiler.intrinsics.klass.TestIsPrimitive.classBoolean.isPrimitive();
		}

		static boolean testByte() {
			return compiler.intrinsics.klass.TestIsPrimitive.classByte.isPrimitive();
		}

		static boolean testShort() {
			return compiler.intrinsics.klass.TestIsPrimitive.classShort.isPrimitive();
		}

		static boolean testChar() {
			return compiler.intrinsics.klass.TestIsPrimitive.classChar.isPrimitive();
		}

		static boolean testInt() {
			return compiler.intrinsics.klass.TestIsPrimitive.classInt.isPrimitive();
		}

		static boolean testFloat() {
			return compiler.intrinsics.klass.TestIsPrimitive.classFloat.isPrimitive();
		}

		static boolean testLong() {
			return compiler.intrinsics.klass.TestIsPrimitive.classLong.isPrimitive();
		}

		static boolean testDouble() {
			return compiler.intrinsics.klass.TestIsPrimitive.classDouble.isPrimitive();
		}

		static boolean testObject() {
			return compiler.intrinsics.klass.TestIsPrimitive.classObject.isPrimitive();
		}

		static boolean testArray() {
			return compiler.intrinsics.klass.TestIsPrimitive.classArray.isPrimitive();
		}

		static boolean testNull() {
			return compiler.intrinsics.klass.TestIsPrimitive.classNull.isPrimitive();
		}
	}
}