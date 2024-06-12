public class UserInfoTest {
	@org.junit.Test
	public void testGetData_1() throws java.lang.Exception {
		org.jinstagram.entity.users.basicinfo.UserInfo fixture = new org.jinstagram.entity.users.basicinfo.UserInfo();
		fixture.setData(new org.jinstagram.entity.users.basicinfo.UserInfoData());
		org.jinstagram.entity.users.basicinfo.UserInfoData result = fixture.getData();
		org.junit.Assert.assertNotNull(result);
		org.junit.Assert.assertEquals(null, result.getFullName());
		org.junit.Assert.assertEquals(null, result.getId());
		org.junit.Assert.assertEquals(null, result.getFirstName());
		org.junit.Assert.assertEquals(null, result.getUsername());
		org.junit.Assert.assertEquals(null, result.getBio());
		org.junit.Assert.assertEquals(null, result.getLastName());
		org.junit.Assert.assertEquals(null, result.getWebsite());
		org.junit.Assert.assertEquals(null, result.getProfilePicture());
		org.junit.Assert.assertEquals(null, result.getCounts());
	}

	@org.junit.Test
	public void testSetData_1() throws java.lang.Exception {
		org.jinstagram.entity.users.basicinfo.UserInfo fixture = new org.jinstagram.entity.users.basicinfo.UserInfo();
		fixture.setData(new org.jinstagram.entity.users.basicinfo.UserInfoData());
		org.jinstagram.entity.users.basicinfo.UserInfoData data = new org.jinstagram.entity.users.basicinfo.UserInfoData();
		fixture.setData(data);
	}

	@org.junit.Before
	public void setUp() throws java.lang.Exception {
	}

	@org.junit.After
	public void tearDown() throws java.lang.Exception {
	}

	public static void main(java.lang.String[] args) {
		new org.junit.runner.JUnitCore().run(org.jinstagram.entity.users.basicinfo.UserInfoTest.class);
	}
}