public class JTest {
	public static void main(java.lang.String[] args) {
		java.util.List<com.alibaba.json.test.a.User[]> list = new java.util.ArrayList<com.alibaba.json.test.a.User[]>();
		com.alibaba.json.test.a.User u1 = new com.alibaba.json.test.a.User(1, "111111");
		com.alibaba.json.test.a.User u2 = new com.alibaba.json.test.a.User(2, "222222");
		com.alibaba.json.test.a.User u3 = new com.alibaba.json.test.a.User(3, "33333");
		com.alibaba.json.test.a.User u4 = new com.alibaba.json.test.a.User(4, "4444");
		list.add(new com.alibaba.json.test.a.User[]{ u1, u2 });
		list.add(new com.alibaba.json.test.a.User[]{ u3, u4 });
		com.alibaba.json.test.a.Group clz = new com.alibaba.json.test.a.Group();
		clz.setUulist(list);
		java.lang.String json = com.alibaba.fastjson.JSON.toJSONString(clz);
		java.lang.System.out.println(json);
		com.alibaba.json.test.a.Group clz1 = com.alibaba.fastjson.JSON.parseObject(json, com.alibaba.json.test.a.Group.class);
		java.lang.System.out.println(clz1.getUulist().get(1)[1].getName());
	}
}