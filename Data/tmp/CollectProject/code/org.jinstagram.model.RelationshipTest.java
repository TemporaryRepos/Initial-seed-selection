public class RelationshipTest {
	@org.junit.Test
	public void testToString_1() throws java.lang.Exception {
		Relationship fixture = Relationship.APPROVE;
		java.lang.String result = fixture.toString();
		org.junit.Assert.assertEquals("approve", result);
	}

	@org.junit.Before
	public void setUp() throws java.lang.Exception {
	}

	@org.junit.After
	public void tearDown() throws java.lang.Exception {
	}

	public static void main(java.lang.String[] args) {
		new org.junit.runner.JUnitCore().run(org.jinstagram.model.RelationshipTest.class);
	}
}