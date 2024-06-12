public class HttpStatusTest {
	@org.junit.Test
	public void testGetReasonPhrase_1() throws java.lang.Exception {
		HttpStatus fixture = HttpStatus.ACCEPTED;
		java.lang.String result = fixture.getReasonPhrase();
		org.junit.Assert.assertEquals("Accepted", result);
	}

	@org.junit.Test
	public void testValue_1() throws java.lang.Exception {
		HttpStatus fixture = HttpStatus.ACCEPTED;
		int result = fixture.value();
		org.junit.Assert.assertEquals(202, result);
	}

	@org.junit.Before
	public void setUp() throws java.lang.Exception {
	}

	@org.junit.After
	public void tearDown() throws java.lang.Exception {
	}

	public static void main(java.lang.String[] args) {
		new org.junit.runner.JUnitCore().run(org.jinstagram.http.HttpStatusTest.class);
	}
}