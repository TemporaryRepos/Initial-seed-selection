public class GoogleTest {
	public static void main(java.lang.String[] args) {
		com.pancm.commons.google.GoogleTest.test();
	}

	private static void test() {
		java.util.List<com.pancm.pojo.User> userList = new java.util.ArrayList<>();
		com.pancm.pojo.User user = new com.pancm.pojo.User();
		user.setId(1);
		user.setName("张三");
		userList.add(user);
		com.pancm.pojo.User user2 = new com.pancm.pojo.User();
		user2.setId(2);
		user2.setName("李四");
		userList.add(user2);
		java.lang.System.out.println("更改之前的数据:" + userList);
		userList = com.google.common.collect.Lists.transform(userList, new com.google.common.base.Function<com.pancm.pojo.User, com.pancm.pojo.User>() {
			@java.lang.Override
			public com.pancm.pojo.User apply(com.pancm.pojo.User user) {
				user.setName("王五");
				return user;
			}
		});
		java.lang.System.out.println("更改之后的数据:" + userList);
	}
}