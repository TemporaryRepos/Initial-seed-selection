public class BufferForwarding {
	private static final java.lang.String A_STRING_BUFFER_VAL = "aStringBuffer";

	private static final java.lang.String A_STRING_BUILDER_VAL = "aStringBuilder";

	private static final java.lang.String A_STRING_VAL = "aString";

	private static final java.lang.String NON_EMPTY_VAL = "NonEmpty";

	public BufferForwarding() {
		java.lang.System.out.println("Starting BufferForwarding");
	}

	public static void main(java.lang.String... args) {
		new javaT.lang.StringBuffer.BufferForwarding().executeTestMethods();
	}

	public void executeTestMethods() {
		appendCharSequence();
		indexOfString();
		indexOfStringIntNull();
		indexOfStringNull();
		indexOfStringint();
		insertintCharSequence();
		insertintObject();
		insertintboolean();
		insertintchar();
		insertintdouble();
		insertintfloat();
		insertintint();
		insertintlong();
		lastIndexOfString();
		lastIndexOfStringint();
	}

	public void appendCharSequence() {
		java.lang.CharSequence aString = javaT.lang.StringBuffer.BufferForwarding.A_STRING_VAL;
		java.lang.CharSequence aStringBuilder = new java.lang.StringBuilder(javaT.lang.StringBuffer.BufferForwarding.A_STRING_BUILDER_VAL);
		java.lang.CharSequence aStringBuffer = new java.lang.StringBuffer(javaT.lang.StringBuffer.BufferForwarding.A_STRING_BUFFER_VAL);
		assertEquals(new java.lang.StringBuilder().append(aString).toString(), javaT.lang.StringBuffer.BufferForwarding.A_STRING_VAL);
		assertEquals(new java.lang.StringBuilder().append(aStringBuilder).toString(), javaT.lang.StringBuffer.BufferForwarding.A_STRING_BUILDER_VAL);
		assertEquals(new java.lang.StringBuilder().append(aStringBuffer).toString(), javaT.lang.StringBuffer.BufferForwarding.A_STRING_BUFFER_VAL);
		assertEquals(new java.lang.StringBuilder(javaT.lang.StringBuffer.BufferForwarding.NON_EMPTY_VAL).append(aString).toString(), javaT.lang.StringBuffer.BufferForwarding.NON_EMPTY_VAL + javaT.lang.StringBuffer.BufferForwarding.A_STRING_VAL);
		assertEquals(new java.lang.StringBuilder(javaT.lang.StringBuffer.BufferForwarding.NON_EMPTY_VAL).append(aStringBuilder).toString(), javaT.lang.StringBuffer.BufferForwarding.NON_EMPTY_VAL + javaT.lang.StringBuffer.BufferForwarding.A_STRING_BUILDER_VAL);
		assertEquals(new java.lang.StringBuilder(javaT.lang.StringBuffer.BufferForwarding.NON_EMPTY_VAL).append(aStringBuffer).toString(), javaT.lang.StringBuffer.BufferForwarding.NON_EMPTY_VAL + javaT.lang.StringBuffer.BufferForwarding.A_STRING_BUFFER_VAL);
	}

	void indexOfString() {
		java.lang.StringBuffer sb = new java.lang.StringBuffer("xyz");
		assertEquals(sb.indexOf("y"), 1);
		assertEquals(sb.indexOf("not found"), -1);
	}

	public void indexOfStringint() {
		java.lang.StringBuffer sb = new java.lang.StringBuffer("xyyz");
		assertEquals(sb.indexOf("y", 0), 1);
		assertEquals(sb.indexOf("y", 1), 1);
		assertEquals(sb.indexOf("y", 2), 2);
		assertEquals(sb.indexOf("not found"), -1);
	}

	public void indexOfStringIntNull() {
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		try {
			sb.indexOf(null, 1);
			throw new java.lang.RuntimeException("Test failed: should have thrown NPE");
		} catch (java.lang.NullPointerException npe) {
		} catch (java.lang.Throwable t) {
			throw new java.lang.RuntimeException("Test failed: should have thrown NPE. Instead threw " + t);
		}
	}

	public void indexOfStringNull() {
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		try {
			sb.indexOf(null);
			throw new java.lang.RuntimeException("Test failed: should have thrown NPE");
		} catch (java.lang.NullPointerException npe) {
		} catch (java.lang.Throwable t) {
			throw new java.lang.RuntimeException("Test failed: should have thrown NPE. Instead threw " + t);
		}
	}

	public void insertintboolean() {
		boolean b = true;
		java.lang.StringBuffer sb = new java.lang.StringBuffer("012345");
		assertEquals(sb.insert(2, b).toString(), "01true2345");
	}

	public void insertintchar() {
		char c = 'C';
		java.lang.StringBuffer sb = new java.lang.StringBuffer("012345");
		assertEquals(sb.insert(2, c).toString(), "01C2345");
	}

	public void insertintCharSequence() {
		final java.lang.String initString = "012345";
		java.lang.CharSequence aString = javaT.lang.StringBuffer.BufferForwarding.A_STRING_VAL;
		java.lang.CharSequence aStringBuilder = new java.lang.StringBuilder(javaT.lang.StringBuffer.BufferForwarding.A_STRING_BUILDER_VAL);
		java.lang.CharSequence aStringBuffer = new java.lang.StringBuffer(javaT.lang.StringBuffer.BufferForwarding.A_STRING_BUFFER_VAL);
		assertEquals(new java.lang.StringBuffer(initString).insert(2, aString).toString(), ("01" + javaT.lang.StringBuffer.BufferForwarding.A_STRING_VAL) + "2345");
		assertEquals(new java.lang.StringBuffer(initString).insert(2, aStringBuilder).toString(), ("01" + javaT.lang.StringBuffer.BufferForwarding.A_STRING_BUILDER_VAL) + "2345");
		assertEquals(new java.lang.StringBuffer(initString).insert(2, aStringBuffer).toString(), ("01" + javaT.lang.StringBuffer.BufferForwarding.A_STRING_BUFFER_VAL) + "2345");
		try {
			new java.lang.StringBuffer(initString).insert(7, aString);
			throw new java.lang.RuntimeException("Test failed: should have thrown IndexOutOfBoundsException");
		} catch (java.lang.IndexOutOfBoundsException soob) {
		} catch (java.lang.Throwable t) {
			throw new java.lang.RuntimeException("Test failed: should have thrown IndexOutOfBoundsException, but instead threw " + t.getMessage());
		}
	}

	public void insertintdouble() {
		double d = 99.0;
		java.lang.StringBuffer sb = new java.lang.StringBuffer("012345");
		assertEquals(sb.insert(2, d).toString(), "0199.02345");
	}

	public void insertintfloat() {
		float f = 99.0F;
		java.lang.StringBuffer sb = new java.lang.StringBuffer("012345");
		assertEquals(sb.insert(2, f).toString(), "0199.02345");
	}

	public void insertintint() {
		int i = 99;
		java.lang.StringBuffer sb = new java.lang.StringBuffer("012345");
		assertEquals(sb.insert(2, i).toString(), "01992345");
	}

	public void insertintlong() {
		long l = 99;
		java.lang.StringBuffer sb = new java.lang.StringBuffer("012345");
		assertEquals(sb.insert(2, l).toString(), "01992345");
	}

	public void insertintObject() {
		java.lang.StringBuffer sb = new java.lang.StringBuffer("012345");
		java.util.List<java.lang.String> ls = new java.util.ArrayList<java.lang.String>();
		ls.add("A");
		ls.add("B");
		java.lang.String lsString = ls.toString();
		assertEquals(sb.insert(2, ls).toString(), ("01" + lsString) + "2345");
		try {
			sb.insert(sb.length() + 1, ls);
			throw new java.lang.RuntimeException("Test failed: should have thrown StringIndexOutOfBoundsException");
		} catch (java.lang.StringIndexOutOfBoundsException soob) {
		} catch (java.lang.Throwable t) {
			throw new java.lang.RuntimeException("Test failed: should have thrown StringIndexOutOfBoundsException, but instead threw:" + t);
		}
	}

	public void lastIndexOfString() {
		java.lang.String xyz = "xyz";
		java.lang.String xyz3 = "xyzxyzxyz";
		java.lang.StringBuffer sb = new java.lang.StringBuffer(xyz3);
		int pos = sb.lastIndexOf("xyz");
		assertEquals(pos, 2 * xyz.length());
	}

	public void lastIndexOfStringint() {
		java.lang.StringBuffer sb = new java.lang.StringBuffer("xyzxyzxyz");
		int pos = sb.lastIndexOf("xyz", 5);
		assertEquals(pos, 3);
		pos = sb.lastIndexOf("xyz", 6);
		assertEquals(pos, 6);
	}

	public void assertEquals(java.lang.String actual, java.lang.String expected) {
		if (!actual.equals(expected)) {
			throw new java.lang.RuntimeException(((("Test failed: actual = '" + actual) + "', expected = '") + expected) + "'");
		}
	}

	public void assertEquals(int actual, int expected) {
		if (actual != expected) {
			throw new java.lang.RuntimeException(((("Test failed: actual = '" + actual) + "', expected = '") + expected) + "'");
		}
	}
}