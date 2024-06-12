public class Example3 {
	private static int excludeO(java.lang.String str) {
		str = str.toLowerCase();
		int count = str.replaceAll("[^o]+", "").length();
		java.lang.System.out.println("asdasdad");
		return count;
	}

	static class User {
		java.lang.String username;

		java.lang.String password;

		public User(java.lang.String username, java.lang.String password) {
			this.username = username;
			this.password = password;
		}
	}

	public static void main(java.lang.String[] args) {
		javatips.debug.Example3.User user = new javatips.debug.Example3.User("biezhi", "123456");
		if (user.username.isEmpty()) {
			java.lang.System.out.println("username is empty.");
		}
		java.lang.String name = "Hello W0rld";
		int count = javatips.debug.Example3.excludeO(name);
		java.lang.System.out.println(count);
	}
}