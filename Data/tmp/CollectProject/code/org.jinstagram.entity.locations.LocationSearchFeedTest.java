public class LocationSearchFeedTest {
	@org.junit.Test
	public void testGetLocationList_1() throws java.lang.Exception {
		LocationSearchFeed fixture = new LocationSearchFeed();
		fixture.setLocationList(new java.util.LinkedList());
		java.util.List<org.jinstagram.entity.common.Location> result = fixture.getLocationList();
		org.junit.Assert.assertNotNull(result);
		org.junit.Assert.assertEquals(0, result.size());
	}

	@org.junit.Test
	public void testSetLocationList_1() throws java.lang.Exception {
		LocationSearchFeed fixture = new LocationSearchFeed();
		fixture.setLocationList(new java.util.LinkedList());
		java.util.List<org.jinstagram.entity.common.Location> locationList = new java.util.LinkedList();
		fixture.setLocationList(locationList);
	}

	@org.junit.Test
	public void testToString_1() throws java.lang.Exception {
		LocationSearchFeed fixture = new LocationSearchFeed();
		fixture.setLocationList(new java.util.LinkedList());
		java.lang.String result = fixture.toString();
		org.junit.Assert.assertEquals("LocationSearchFeed [locationList=[]]", result);
	}

	@org.junit.Before
	public void setUp() throws java.lang.Exception {
	}

	@org.junit.After
	public void tearDown() throws java.lang.Exception {
	}

	public static void main(java.lang.String[] args) {
		new org.junit.runner.JUnitCore().run(org.jinstagram.entity.locations.LocationSearchFeedTest.class);
	}
}