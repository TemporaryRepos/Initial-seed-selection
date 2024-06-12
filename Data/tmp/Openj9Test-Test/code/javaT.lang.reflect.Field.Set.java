public class Set {
	public static void main(java.lang.String[] argv) throws java.lang.Throwable {
		boolean failed = false;
		javaT.lang.reflect.Field.Test t = new javaT.lang.reflect.Field.Test();
		if (!t.testPrimitive()) {
			failed = true;
			java.lang.System.out.println("FAILED: testPrimitive()");
		}
		if (!t.testAccessiblePrimitive()) {
			failed = true;
			java.lang.System.out.println("FAILED: testAccessiblePrimitive()");
		}
		if (!t.testVolatilePrimitive()) {
			failed = true;
			java.lang.System.out.println("FAILED: testVolatilePrimitive()");
		}
		if (!t.testStaticPrimitive()) {
			failed = true;
			java.lang.System.out.println("FAILED: testStaticPrimitive()");
		}
		if (!t.testAccessibleStaticPrimitive()) {
			failed = true;
			java.lang.System.out.println("FAILED: testAccessibleStaticPrimitive()");
		}
		if (!t.testObject()) {
			failed = true;
			java.lang.System.out.println("FAILED: testObject()");
		}
		if (!t.testAccessibleObject()) {
			failed = true;
			java.lang.System.out.println("FAILED: testAccessibleObject()");
		}
		if (!t.testVolatileObject()) {
			failed = true;
			java.lang.System.out.println("FAILED: testVolatileObject()");
		}
		if (!t.testStaticObject()) {
			failed = true;
			java.lang.System.out.println("FAILED: testStaticObject()");
		}
		if (!t.testAccessibleStaticObject()) {
			failed = true;
			java.lang.System.out.println("FAILED: testAccessibleStaticObject()");
		}
		if (failed) {
			throw new java.lang.Throwable("Test for Field.set FAILED");
		}
	}
}