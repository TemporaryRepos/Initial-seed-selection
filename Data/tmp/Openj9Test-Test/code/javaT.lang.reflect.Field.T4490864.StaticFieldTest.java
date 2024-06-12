public class StaticFieldTest {
	private static byte byteField;

	private static short shortField;

	private static char charField;

	private static int intField;

	private static long longField;

	private static float floatField;

	private static double doubleField;

	private static java.lang.String stringField;

	private static java.lang.reflect.Field getAccessibleField(java.lang.String name) throws java.lang.NoSuchFieldException {
		java.lang.reflect.Field f = javaT.lang.reflect.Field.T4490864.StaticFieldTest.class.getDeclaredField(name);
		f.setAccessible(true);
		return f;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.reflect.Field byteField = javaT.lang.reflect.Field.T4490864.StaticFieldTest.getAccessibleField("byteField");
		java.lang.reflect.Field shortField = javaT.lang.reflect.Field.T4490864.StaticFieldTest.getAccessibleField("shortField");
		java.lang.reflect.Field charField = javaT.lang.reflect.Field.T4490864.StaticFieldTest.getAccessibleField("charField");
		java.lang.reflect.Field intField = javaT.lang.reflect.Field.T4490864.StaticFieldTest.getAccessibleField("intField");
		java.lang.reflect.Field longField = javaT.lang.reflect.Field.T4490864.StaticFieldTest.getAccessibleField("longField");
		java.lang.reflect.Field floatField = javaT.lang.reflect.Field.T4490864.StaticFieldTest.getAccessibleField("floatField");
		java.lang.reflect.Field doubleField = javaT.lang.reflect.Field.T4490864.StaticFieldTest.getAccessibleField("doubleField");
		java.lang.reflect.Field stringField = javaT.lang.reflect.Field.T4490864.StaticFieldTest.getAccessibleField("stringField");
		byteField.setByte(null, ((byte) (77)));
		shortField.setShort(null, ((short) (77)));
		charField.setChar(null, ((char) (77)));
		intField.setInt(null, ((int) (77)));
		longField.setLong(null, ((long) (77)));
		floatField.setFloat(null, ((float) (77)));
		doubleField.setDouble(null, ((double) (77)));
		java.lang.String myString = "Hello, world";
		stringField.set(null, myString);
		if (byteField.getByte(null) != 77) {
			throw new java.lang.RuntimeException("Test failed");
		}
		if (shortField.getShort(null) != 77) {
			throw new java.lang.RuntimeException("Test failed");
		}
		if (charField.getChar(null) != 77) {
			throw new java.lang.RuntimeException("Test failed");
		}
		if (intField.getInt(null) != 77) {
			throw new java.lang.RuntimeException("Test failed");
		}
		if (longField.getLong(null) != 77) {
			throw new java.lang.RuntimeException("Test failed");
		}
		if (floatField.getFloat(null) != 77) {
			throw new java.lang.RuntimeException("Test failed");
		}
		if (doubleField.getDouble(null) != 77) {
			throw new java.lang.RuntimeException("Test failed");
		}
		if (stringField.get(null) != myString) {
			throw new java.lang.RuntimeException("Test failed");
		}
	}
}