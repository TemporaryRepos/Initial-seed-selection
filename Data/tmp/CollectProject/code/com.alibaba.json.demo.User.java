public class User {
	private java.lang.Long id;

	private java.lang.String name;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public static void main(java.lang.String[] args) {
		com.alibaba.json.demo.User user = new com.alibaba.json.demo.User();
		user.setId(123L);
		user.setName("wenshao");
		java.lang.String text = com.alibaba.fastjson.JSON.toJSONString(user);
		java.lang.System.out.println(text);
		com.alibaba.json.demo.User user1 = com.alibaba.fastjson.JSON.parseObject(text, com.alibaba.json.demo.User.class);
		org.junit.Assert.assertEquals("{\"id\":123,\"name\":\"wenshao\"}", text);
	}
}