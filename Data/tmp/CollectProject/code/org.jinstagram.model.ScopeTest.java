public class ScopeTest {
	@org.junit.Test
	public void testToString_1() throws java.lang.Exception {
		Scope fixture = Scope.BASIC;
		java.lang.String result = fixture.toString();
		org.junit.Assert.assertEquals("basic", result);
	}

	@org.junit.Before
	public void setUp() throws java.lang.Exception {
	}

	@org.junit.After
	public void tearDown() throws java.lang.Exception {
	}

	public static void main(java.lang.String[] args) {
		new org.junit.runner.JUnitCore().run(org.jinstagram.model.ScopeTest.class);
	}
}