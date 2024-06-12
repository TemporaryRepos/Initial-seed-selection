public class UserServlet {
	public static void main(java.lang.String[] args) {
		learningspring.ioc.version2.User user = learningspring.ioc.version2.UserFactory.getUser();
		user.sayHello();
	}
}