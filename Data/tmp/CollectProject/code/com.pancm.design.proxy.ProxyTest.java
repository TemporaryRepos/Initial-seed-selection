public class ProxyTest {
	public static void main(java.lang.String[] args) {
		java.lang.String name = "李四";
		com.pancm.design.proxy.Shopping shopping = new com.pancm.design.proxy.ProxyPerson(new com.pancm.design.proxy.ExecutePerson(name));
		shopping.buyFood();
		com.pancm.design.proxy.Shopping shopping2 = ((com.pancm.design.proxy.Shopping) (java.lang.reflect.Proxy.newProxyInstance(java.lang.ClassLoader.getSystemClassLoader(), new java.lang.Class[]{ com.pancm.design.proxy.Shopping.class }, new com.pancm.design.proxy.ProxyPerson2(new com.pancm.design.proxy.ExecutePerson(name)))));
		shopping2.buyFood();
	}
}