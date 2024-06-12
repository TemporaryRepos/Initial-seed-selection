public class LocationInfoTest {
	@org.junit.Test
	public void testGetLocationData_1() throws java.lang.Exception {
		LocationInfo fixture = new LocationInfo();
		fixture.setLocationData(new org.jinstagram.entity.common.Location());
		org.jinstagram.entity.common.Location result = fixture.getLocationData();
		org.junit.Assert.assertNotNull(result);
		org.junit.Assert.assertEquals(0.0, result.getLatitude(), 1.0);
		org.junit.Assert.assertEquals(0.0, result.getLongitude(), 1.0);
		org.junit.Assert.assertEquals("Location [id=null, name=null, latitude=0.0, longitude=0.0]", result.toString());
		org.junit.Assert.assertEquals(null, result.getName());
		org.junit.Assert.assertEquals(null, result.getId());
	}

	@org.junit.Test
	public void testSetLocationData_1() throws java.lang.Exception {
		LocationInfo fixture = new LocationInfo();
		fixture.setLocationData(new org.jinstagram.entity.common.Location());
		org.jinstagram.entity.common.Location locationData = new org.jinstagram.entity.common.Location();
		fixture.setLocationData(locationData);
	}

	@org.junit.Test
	public void testToString_1() throws java.lang.Exception {
		LocationInfo fixture = new LocationInfo();
		fixture.setLocationData(new org.jinstagram.entity.common.Location());
		java.lang.String result = fixture.toString();
		org.junit.Assert.assertEquals("LocationInfo [locationData=Location [id=null, name=null, latitude=0.0, longitude=0.0]]", result);
	}

	@org.junit.Before
	public void setUp() throws java.lang.Exception {
	}

	@org.junit.After
	public void tearDown() throws java.lang.Exception {
	}

	public static void main(java.lang.String[] args) {
		new org.junit.runner.JUnitCore().run(org.jinstagram.entity.locations.LocationInfoTest.class);
	}
}